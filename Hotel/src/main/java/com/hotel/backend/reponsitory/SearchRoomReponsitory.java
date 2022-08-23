
package com.hotel.backend.reponsitory;

import com.hotel.backend.setEntity.RoomBooking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author macos
 */
public interface SearchRoomReponsitory extends JpaRepository<RoomBooking, Integer>{
//    @Query("SELECT r FROM RoomBooking")
//    List<RoomBooking> searchPrice(int min, int max);
}
