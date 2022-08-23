/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.service.impl;

import com.hotel.backend.entity.Customer;
import com.hotel.backend.reponsitory.CustomerRepo;
import com.hotel.backend.service.CustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macos
 */
@Service
public class CustomerImpl implements CustomerService {

    @Autowired
    private CustomerRepo cusRepo;

    @Override
    public List<Customer> findAllCustomer() {
        return cusRepo.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return cusRepo.findById(id);
    }

    @Override
    public Optional<Customer> findByName(String name) {
        return cusRepo.findByName(name);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return cusRepo.findByEmail(email);
    }

    @Override
    public Boolean existsByName(String name) {
        return cusRepo.existsByName(name);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return cusRepo.existsByEmail(email);
    }

    

    @Override
    public int changePassword(String email, String password) {
        return cusRepo.changePassword(email, password);
    }

    @Override
    public Customer save(Customer cus) {
        return cusRepo.save(cus);
    }

    @Override
    public Optional<Customer> checkLogin(String email, String password) {
        return cusRepo.checkLogin(email,password);
    }

    @Override
    public Boolean delete(int id) {
        return cusRepo.delete(id);
    }

}
