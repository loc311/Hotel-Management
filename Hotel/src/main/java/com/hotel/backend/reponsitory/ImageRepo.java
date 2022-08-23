
package com.hotel.backend.reponsitory;

import com.hotel.backend.entity.Hotelimage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macos
 */
@Repository
public interface ImageRepo extends JpaRepository<Hotelimage, Integer>{
    List<Hotelimage> findByRoomId(int roomId);
}
