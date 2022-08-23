/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.hotel.backend.controller;

import com.hotel.backend.entity.Customer;
import com.hotel.backend.jwtconfig.MessageResponse;
import com.hotel.backend.reponsitory.CustomerRepo;
import com.hotel.backend.request.UpdateRequest;
import com.hotel.backend.service.CustomerService;
import com.hotel.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author HP
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CustomerController {
    
    @Autowired
    private CustomerRepo customerRepo;
    
    @Autowired
    private CustomerService CusService;
    
    @Autowired
    private EmailService emailSenderService;
    
    @Value("${upload.path}")
    private String path;
    
    @Autowired
    private PasswordEncoder encoder;
    
    //get all customer
    @GetMapping(value = "/customer/getall")
    public ResponseEntity<?> getAllCus(){
        List<Customer> customers = customerRepo.findAll();
        return ResponseEntity.ok(customers);
    }
    
    // delete user
    @DeleteMapping("/customer/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        customerRepo.delete(customer.get().getId());
        return ResponseEntity.ok(new MessageResponse("User deleted successfully!"));
    }
    
    // update user
    @PostMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UpdateRequest UpdateRequest, @PathVariable Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Error: User not found."));
        if (customerRepo.existsByEmail(UpdateRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        customer.setName(UpdateRequest.getName());
        customer.setPhone(UpdateRequest.getPhone());
        customer.setEmail(UpdateRequest.getEmail());
        customer.setBirthday(UpdateRequest.getBirthday());
        customer.setGender(UpdateRequest.isGender());
        customerRepo.save(customer);
        return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
    }

//    //lock customer them status boolean mac dinh true
//    // lock user
//    @PostMapping("/lockUser/{id}")
//    public ResponseEntity<?> lockUser(@PathVariable Long id) {
//        Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Error: User not found."));
//        customer.setStatus(false);
//        customerRepo.save(customer);
//        return ResponseEntity.ok(new MessageResponse("User locked successfully!"));
//    }
//
//    // unlock user
//    @PostMapping("/unlockUser/{id}")
//    public ResponseEntity<?> unlockUser(@PathVariable Long id) {
//        Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Error: User not found."));
//        user.setStatus(true);
//        customerRepo.save(customer);
//        return ResponseEntity.ok(new MessageResponse("User unlocked successfully!"));
//    }
}
