/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.controller;

import com.hotel.backend.entity.Booking;
import com.hotel.backend.entity.Customer;
import com.hotel.backend.entity.Room;
import com.hotel.backend.service.BookingService;
import com.hotel.backend.service.CustomerService;
import com.hotel.backend.service.RoomService;
import com.hotel.backend.setEntity.UserBooking;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macos
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class BookingController {
    @Autowired
    private BookingService bookService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private CustomerService cusService;
    
    @GetMapping("/booking")
    public ResponseEntity<?> bookingAll(){
        List<Booking> book = bookService.booking();
        return ResponseEntity.ok(book);
    }
    
    @GetMapping("/booking/{id}")
    public ResponseEntity<?> bookingDetail(@PathVariable int id){
        Optional<Booking> book = bookService.bookingId(id);
        List<Room> room = roomService.findById(book.get().getRoomId());
        Optional<Customer> cus = cusService.findById(book.get().getCusId());
        UserBooking booking = new UserBooking();
        booking.setBook(book);
        booking.setRoom(room);
        booking.setCus(cus);
        return ResponseEntity.ok(booking);
    }
}
