/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.request;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HP
 */
@Getter
@Setter
public class SearchRoomRequest {
    private String name;
    private String roomtype;
    private Double priceday;
}
