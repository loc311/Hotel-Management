
package com.hotel.backend.service;

import com.hotel.backend.entity.Room;
import java.util.List;

/**
 *
 * @author macos
 */
public interface RoomService {
    List<Room> roomAll();
    List<Room> findById(int id);
    List<Room> status(String status);
    Room save(Room room);
    void delete(int id);
    List<Room> searchNameAndStatus(String name, String status);
    List<Room> searchName(String name);
    List<Room> roomEmpty(String status);
    List<Room> room();
}
