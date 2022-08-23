package com.hotel.backend.controller;

import com.hotel.backend.entity.Staff;
import com.hotel.backend.jwtconfig.JwtResponse;
import com.hotel.backend.jwtconfig.JwtTokenProvider;
import com.hotel.backend.jwtconfig.LoginRequest;
import com.hotel.backend.jwtconfig.MessageResponse;
import com.hotel.backend.request.ChangPassRequest;
import com.hotel.backend.service.UserService;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author macos
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class SecurityControler {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService serviceUser;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtTokenProvider jwtutils;
    @Autowired
    public JavaMailSender emailSender;
    @Value("${upload.path}")
    private String path;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtutils.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Validated @RequestBody MultipartFile cccd,
            MultipartFile avt,
            String name,
            String email,
            String password,
            String phone,
            String birthday,
            boolean gender,
            String codeId,
            int roleId
    ) throws IOException {

        //save file image
        String filename = cccd.getOriginalFilename();
        if (cccd.isEmpty()) {
            cccd.transferTo(new File(path + filename));
        }
        try {
            cccd.transferTo(new File(path + filename));
        } catch (IOException e) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error: Image empty!"));
        }

        String avtfile = avt.getOriginalFilename();
        avt.transferTo(new File(path + avtfile));

        if (serviceUser.existsByCodeID(codeId)) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error: Code is already taken!"));
        }

        if (serviceUser.existsByEmail(email)) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }
        Date create_at = new Date(System.currentTimeMillis());
        Staff user = new Staff();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setPhone(phone);
        user.setCccdImg(filename);
        user.setBirthday(birthday);
        user.setGender(gender);
        user.setCodeId(codeId);
        user.setRoleId(roleId);
        user.setAvt(avtfile);
        user.setCreate_at(create_at);
        serviceUser.save(user);
        boolean result = sendMail(email);
        if (result == false) {
            return ResponseEntity.ok(new MessageResponse("Send email faild!!!"));
        }
        return ResponseEntity.ok(new MessageResponse("User registered successfully."));
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@Validated @RequestBody ChangPassRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        String newpassword = encoder.encode(request.getNewpassword());
        serviceUser.changePassword(request.getEmail(), newpassword);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/me")
    public ResponseEntity<?> prifile(Authentication authentication) {
        return ResponseEntity.ok(authentication.getPrincipal());
    }

    //register success , send to email
    public boolean sendMail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setTo(toEmail);
            message.setSubject("Test Simple Email");
            message.setText("Hello, Đăng ký thành công!!!");
            // Send Message!
            this.emailSender.send(message);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
