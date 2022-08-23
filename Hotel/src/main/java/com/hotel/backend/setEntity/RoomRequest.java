
package com.hotel.backend.setEntity;

import com.hotel.backend.entity.Hotelimage;
import com.hotel.backend.entity.Room;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author macos
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequest {
    private List<Room> room;
    private List<Hotelimage> img;
}
