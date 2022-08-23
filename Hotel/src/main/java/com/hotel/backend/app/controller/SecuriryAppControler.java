package com.hotel.backend.app.controller;

import com.hotel.backend.entity.Customer;
import com.hotel.backend.jwtconfig.LoginRequest;
import com.hotel.backend.jwtconfig.MessageResponse;
import com.hotel.backend.service.CustomerService;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/app")
public class SecuriryAppControler {

    @Autowired
    private CustomerService serviceCus;
    @Value("${upload.path}")
    private String path;

    @PostMapping("/login")
    public ResponseEntity<?> checkLogin(@Validated @RequestBody LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        Optional<Customer> cus = serviceCus.checkLogin(email, password);
        return ResponseEntity.ok(cus);
    }

    @PostMapping(value = "/register",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> cusRegister(@Validated @RequestBody MultipartFile avatar,
            MultipartFile cccd,
            String name,
            String email,
            String pass,
            String phone,
            String birthday,
            boolean gender
    ) throws IOException{
        if (serviceCus.existsByEmail(email)) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }

        MultipartFile multi = avatar;
        String avt = multi.getOriginalFilename();
        try {
            avatar.transferTo(new File(path + avt));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        MultipartFile cccdImg = cccd;
        String fileCccd = cccdImg.getOriginalFilename();
        try {
            cccd.transferTo(new File(path + fileCccd));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(pass);
        customer.setPhone(phone);
        customer.setAvt(avt);
        customer.setGender(gender);
        customer.setBirthday(birthday);
        customer.setCccdImg(fileCccd);
        serviceCus.save(customer);
        return ResponseEntity.ok(new MessageResponse("Register success!!!"));
    }
}
