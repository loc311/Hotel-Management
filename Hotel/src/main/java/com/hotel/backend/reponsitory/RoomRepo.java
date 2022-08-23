
package com.hotel.backend.reponsitory;

import com.hotel.backend.entity.Booking;
import com.hotel.backend.entity.Room;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macos
 */
@Repository
public interface RoomRepo extends JpaRepository<Room, Integer>{
    List<Room> status(String status);
    List<Room> findDetail(int id);
    @Query("SELECT r FROM Room r WHERE r.name LIKE CONCAT( '%',:name,'%') AND r.status = :status")
    List<Room> searchNameAndStatus(String name, String status);
    @Query("SELECT r FROM Room r WHERE r.name LIKE CONCAT( '%',:name,'%')")
    public List<Room> searchName(String name);
    
    //web customer
    @Query("SELECT r FROM Room r JOIN r.imgs h ON r.id = h.roomId WHERE r.status = :status")
    List<Room> roomEmpty(String status);
    @Query("SELECT r FROM Room r JOIN r.imgs h ON r.id = h.roomId")
    List<Room> room();
    //Search
    @Query("SELECT r FROM Room r WHERE r.roomtype = :roomtype")
    List<Room> searchType(String roomtype);
    @Query("SELECT r FROM Room r WHERE r.priceday > :min AND r.priceday < :max")
    List<Room> searchPrice(int min, int max);
    
    //List room by room name
    List<Room> existsByName(String name);
    public List<Booking> findAllById(Long id);
    public Object findById(Long roomId);
    
}
