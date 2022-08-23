/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.request;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HP
 */
@Getter
@Setter
public class HotelBookingRequest {
    private Date checkInDate;
    private Date checkOutDate;
    private int numOfGuest;
    private String paymentMethod;
    private float totalPrice;
    private Long roomId;
    private Long userId;
}
