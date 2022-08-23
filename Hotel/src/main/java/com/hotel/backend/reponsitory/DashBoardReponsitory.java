
package com.hotel.backend.reponsitory;

import com.hotel.backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macos
 */
@Repository
public interface DashBoardReponsitory extends JpaRepository<Booking, Integer>{
    @Query("SELECT SUM(b.total) FROM Booking b WHERE MONTH(b.timeTo) = :month")
    Long lastMonth(int month);
    @Query("SELECT SUM(b.total) FROM Booking b WHERE MONTH(b.timeTo) = :month")
    Long currentMonth(int month);
}
