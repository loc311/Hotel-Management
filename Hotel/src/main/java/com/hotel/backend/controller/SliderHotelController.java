/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.controller;

import com.hotel.backend.entity.Hotelimage;
import com.hotel.backend.entity.Slider;
import com.hotel.backend.reponsitory.SliderReponsitory;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/admin")
public class SliderHotelController {
    @Value("${upload.path}")
    private String path;
    
    @Autowired
    private SliderReponsitory slider;
    
    @PostMapping(value = "/addslider",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> uploadImg(@RequestBody MultipartFile file,String name) throws IOException {
        MultipartFile multi = file;
        String filename = multi.getOriginalFilename();
        try {
            file.transferTo(new File( path + filename ));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
        Slider image = new Slider(); 
        image.setImage(filename);
        image.setName(name);
        image.setStatus(Short.MIN_VALUE);
        slider.save(image);
        
        return ResponseEntity.ok("Success");
    }
}
