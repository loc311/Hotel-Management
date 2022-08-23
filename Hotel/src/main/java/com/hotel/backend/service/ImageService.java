
package com.hotel.backend.service;

import com.hotel.backend.entity.Hotelimage;
import java.util.List;

/**
 *
 * @author macos
 */
public interface ImageService {
    List<Hotelimage> imageAll();
    Hotelimage save(Hotelimage img);
    List<Hotelimage> imageRoom(int roomId);
}
