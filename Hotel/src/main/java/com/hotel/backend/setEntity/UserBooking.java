
package com.hotel.backend.setEntity;

import com.hotel.backend.entity.Booking;
import com.hotel.backend.entity.Customer;
import com.hotel.backend.entity.Room;
import java.util.List;
import java.util.Optional;
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
public class UserBooking {
    private List<Room> room;
    private Optional<Booking> book;
    private Optional<Customer> cus;
}
