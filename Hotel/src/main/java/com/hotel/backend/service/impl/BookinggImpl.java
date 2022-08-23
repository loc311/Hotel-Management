/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.service.impl;

import com.hotel.backend.entity.Booking;
import com.hotel.backend.reponsitory.BookingReponsitory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.backend.service.BookingService;
import java.util.Optional;

/**
 *
 * @author macos
 */
@Service
public class BookinggImpl implements BookingService{
    @Autowired
    private BookingReponsitory repo;
    @Override
    public List<Booking> booking() {
        return repo.findAll();
    }

    @Override
    public Optional<Booking> bookingId(int id) {
        return repo.findById(id);
    }

    @Override
    public Booking save(Booking booking) {
        return repo.save(booking);
    }

    @Override
    public List<Booking> history(int cus) {
        return repo.history(cus);
    }
    
}
