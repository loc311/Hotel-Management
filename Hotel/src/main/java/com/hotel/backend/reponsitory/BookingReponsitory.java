/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hotel.backend.reponsitory;

import com.hotel.backend.entity.Booking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface BookingReponsitory extends JpaRepository<Booking, Integer>{
    //check customer booking
    Boolean existsByCusId(Integer cusId);
    
    //get list booking
    List<Booking> findByCusId(Integer cusId);
    
    //get list booking by room
    List<Booking> findByRoomId(Integer roomId);
    
    List<Booking> history(int cusId);
}
