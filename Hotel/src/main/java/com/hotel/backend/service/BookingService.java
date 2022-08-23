/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hotel.backend.service;

import com.hotel.backend.entity.Booking;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author macos
 */
public interface BookingService {
    List<Booking> booking();
    Optional<Booking> bookingId(int id);
    List<Booking> history(int cus);
    Booking save(Booking booking);
}
