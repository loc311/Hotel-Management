
package com.hotel.backend.controller;

import com.hotel.backend.entity.Staff;
import com.hotel.backend.jwtconfig.MessageResponse;
import com.hotel.backend.service.UserService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api")
public class StaffController {
    
    @Autowired    
    private UserService serviceUser;
    
    @Value("${upload.path}")
    private String path;

    
    @GetMapping("/staff")
    public ResponseEntity<?> staffAll(){
        List<Staff> staff = serviceUser.findAll();
        return ResponseEntity.ok(staff);
    }
    
    @GetMapping("/staff/{id}")
    public ResponseEntity<?> staffDetail(@PathVariable int id){
        Optional<Staff> staff = serviceUser.findById(id);
        return ResponseEntity.ok(staff);
    }
    
    @PostMapping("/staff/search")
    public ResponseEntity<?> searchName(@Validated @RequestBody Staff s){
        String name = s.getName();
        String code = s.getCodeId();
        String regexEmail = "^(.+)@gmail.com";
        String regexPhone = "\\d{4,12}";
        
        boolean phone = name.matches(regexPhone);
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher email = pattern.matcher(name);
        boolean checkEmail = email.matches();
        List<Staff> staff;
        if(name.isBlank() && code.isBlank()){
            staff = serviceUser.findAll();
        }else if(code.isBlank() && name != null){
            if(checkEmail == true){
                 staff = serviceUser.searchEmail(name);
            }else if(phone == true){
                staff = serviceUser.searchPhone(name);
            }else{
                staff = serviceUser.searchName(name);
            }
        }else if(name.isBlank() && code != null){
            staff = serviceUser.searchCode(code);
        }else{
            if(checkEmail == true){
                 staff = serviceUser.searchCodeAndEmail(code, name);
            }else if(phone == true){
                staff = serviceUser.searchCodeAndPhone(code, code);
            }else{
                staff = serviceUser.searchCodeAndName(code, name);
            }
        }
        return ResponseEntity.ok(staff);
    }   
    
    @PostMapping("/staff/update")
    private ResponseEntity<?> updateStaff(@Validated @RequestBody MultipartFile cccd,
            MultipartFile avt,
            int id,
            String name,
            String phone,
            String birthday,
            boolean gender,
            String roleId
    ) throws IOException{
        Staff s = serviceUser.staffDetail(id);
        if(name.isBlank()){
            name = s.getName();
        }
        if(phone.isBlank()){
            phone = s.getPhone();
        }
        if(birthday.isBlank()){
            birthday = s.getBirthday();
        }
        String filename = "";
        if (cccd == null) {
            filename = s.getCccdImg();
        }else{
            filename = cccd.getOriginalFilename();
            cccd.transferTo(new File(path + filename));
        }
        
        String avtfile = "";
        if(avtfile.isBlank()){
            avtfile = s.getAvt();
        }else{
            avtfile = avt.getOriginalFilename();
            avt.transferTo(new File(path + avtfile));
        }
        if(name.isBlank()){
            name = s.getName();
        }
        if(phone.isBlank()){
            phone = s.getPhone();
        }
        if(birthday.isBlank()){
            birthday = s.getBirthday();
        }
        int role = 0;
        if(roleId.isBlank()) {
            role = s.getRoleId();
        }else{
            role = Integer.parseInt(roleId);
        }
        Staff user = new Staff();
        user.setId(id);
        user.setName(name);
        user.setEmail(s.getEmail());
        user.setPassword(s.getPassword());
        user.setPhone(phone);
        user.setCccdImg(filename);
        user.setBirthday(birthday);
        user.setGender(gender);
        user.setCodeId(s.getCodeId());
        user.setRoleId(role);
        user.setAvt(avtfile);
        serviceUser.save(user);
        return ResponseEntity.ok(new MessageResponse("User update successfully."));
    }
}
