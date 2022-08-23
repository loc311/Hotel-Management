
package com.hotel.backend.app.controller;

import com.hotel.backend.entity.Booking;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.backend.service.BookingService;

/**
 *
 * @author macos
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/app")
public class BookingAppController {
    @Autowired
    private BookingService book;
    
    @PostMapping("/book")
    public ResponseEntity<?> booking(@Validated @RequestBody @ModelAttribute Booking b){
        Short payment = b.getPayment();
        Date createAt = new Date(System.currentTimeMillis());
        Booking booking = new Booking();
        booking.setCusId(b.getCusId());
        booking.setRoomId(b.getRoomId());
        booking.setTimeTo(b.getTimeTo());
        booking.setTimeFrom(b.getTimeFrom());
        booking.setTotal(b.getTotal());
        booking.setPayment(payment);
        booking.setStatus("NO");
        booking.setCreateAt(createAt);
        book.save(booking);
        return ResponseEntity.ok("Success");
    }
    @GetMapping("history/{id}")
     public ResponseEntity<?> history(@PathVariable int id){
         List<Booking> b = book.history(id);
         return ResponseEntity.ok(b);
     }
}
