
package com.hotel.backend.setEntity;

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
public class BookingRequest {
    private int id;
    private int cus_id;
    private int room_id;
}
