
package com.hotel.backend.service.impl;

import com.hotel.backend.entity.Hotelimage;
import com.hotel.backend.reponsitory.ImageRepo;
import com.hotel.backend.service.ImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macos
 */
@Service
public class ImageImpl implements ImageService {

    @Autowired
    private ImageRepo imgRepo;

    @Override
    public List<Hotelimage> imageAll() {
        return imgRepo.findAll();
    }

    @Override
    public Hotelimage save(Hotelimage img) {
        return imgRepo.save(img);
    }

    @Override
    public List<Hotelimage> imageRoom(int roomId) {
        return imgRepo.findByRoomId(roomId);
    }

}
