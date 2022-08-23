
package com.hotel.backend.app.controller;

import com.hotel.backend.entity.Hotelimage;
import com.hotel.backend.entity.Room;
import com.hotel.backend.request.RoomRequestCreate;
import com.hotel.backend.service.ImageService;
import com.hotel.backend.service.RoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macos
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/app")
public class RoomAppController {
    @Autowired
    private RoomService roomService;
    
    @Autowired
    private ImageService imageService;
    
    @Value("${upload.path}")
    private String path;
    
    @GetMapping("/room")
    public ResponseEntity<?> listRoom(){
        List<Room> room = roomService.roomAll();
        return ResponseEntity.ok(room);
    }
    
    @GetMapping("/room/image")
    public ResponseEntity<?> listImage(){
        List<Hotelimage> img = imageService.imageAll();
        return ResponseEntity.ok(img);
    }
    
    @GetMapping("/room/{id}")
    public ResponseEntity<?> roomId(@PathVariable int id){
        List<Room> room = roomService.findById(id);
        return ResponseEntity.ok(room);
    }
    
    @GetMapping("/room/empty")
    public ResponseEntity<?> listRoomEmpty(){
        List<Room> room = roomService.roomEmpty("Empty");
        return ResponseEntity.ok(room);
    }
    
    @PostMapping("/search")
    public ResponseEntity<?> searchRoom(@Validated @RequestBody RoomRequestCreate r){
        return ResponseEntity.ok("ascjn");
    }
}
