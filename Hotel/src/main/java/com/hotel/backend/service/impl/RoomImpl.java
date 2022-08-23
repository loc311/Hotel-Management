/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.service.impl;

import com.hotel.backend.entity.Room;
import com.hotel.backend.reponsitory.RoomRepo;
import com.hotel.backend.service.RoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macos
 */
@Service
public class RoomImpl implements RoomService{
    
    @Autowired
    public RoomRepo roomRepo;
    
    @Override
    public List<Room> roomAll() {
        return roomRepo.findAll();
    }

    @Override
    public List<Room> findById(int id) {
        return roomRepo.findDetail(id);
    }

    @Override
    public List<Room> status(String status) {
        return roomRepo.status(status);
    }

    @Override
    public Room save(Room room) {
        return roomRepo.save(room);
    }

    @Override
    public void delete(int id) {
        roomRepo.deleteById(id);
    }

    @Override
    public List<Room> searchNameAndStatus(String name, String status) {
        return roomRepo.searchNameAndStatus(name,status);
    }

    @Override
    public List<Room> searchName(String name) {
        return roomRepo.searchName(name);
    }

    @Override
    public List<Room> roomEmpty(String status) {
        return roomRepo.roomEmpty(status);
    }

    @Override
    public List<Room> room() {
        return roomRepo.room();
    }
    
}
