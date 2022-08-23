
package com.hotel.backend.controller;

import com.hotel.backend.entity.Hotelimage;
import com.hotel.backend.entity.Room;
import com.hotel.backend.request.RoomRequestCreate;
import com.hotel.backend.service.ImageService;
import com.hotel.backend.service.RoomService;
import com.hotel.backend.setEntity.RoomRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author macos
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    
    @Autowired
    private ImageService imageService;
    
    @Value("${upload.path}")
    private String path;
    
    @GetMapping()
    public ResponseEntity<?> listRoom(){
        List<Room> room = roomService.roomAll();
        return ResponseEntity.ok(room);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> roomId(@PathVariable int id){
        List<Room> room = roomService.findById(id);
        List<Hotelimage> img = imageService.imageRoom(id);
        RoomRequest roomDetail = new RoomRequest();
        roomDetail.setRoom(room);
        roomDetail.setImg(img);
        return ResponseEntity.ok(roomDetail);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@Validated @RequestBody @ModelAttribute RoomRequestCreate r){
        float pDay = Float.parseFloat(r.getPriceday());
        Room room = new Room();
        room.setName(r.getName());
        room.setPriceday(pDay);
        room.setStatus(r.getStatus());
        room.setRoomtype(r.getRoomtype());
        room.setDescription(r.getDescription());
        roomService.save(room);
        return ResponseEntity.ok("Success");
    }
    
   @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteId(@PathVariable int id){
        roomService.delete(id);
        return ResponseEntity.ok("Success");
    } 
    
    @PostMapping("/search")
    public ResponseEntity<?> searchName(@Validated @RequestBody RoomRequestCreate r){
        String name = r.getName();
        String status = r.getStatus();
        List<Room> room;
        if(name.isBlank() && status.isBlank()){
            room = roomService.roomAll();
        }else if(name != null && status.isBlank()){
            room = roomService.searchName(name);
        }else if(status != null && name.isBlank()){
            room = roomService.status(status);
        }else{
            room = roomService.searchNameAndStatus(name, status);
        }
        return ResponseEntity.ok(room);
    }   
    
    @PostMapping("/update")
    private ResponseEntity<?> updateRoom(@Validated @RequestBody RoomRequestCreate r){
        float pDay = Float.parseFloat(r.getPriceday());
        Room room = new Room();
        room.setId(r.getId());
        room.setName(r.getName());
        room.setPriceday(pDay);
        room.setRoomtype(r.getRoomtype());
        room.setDescription(r.getDescription());
        room.setStatus(r.getStatus());
        roomService.save(room);
        return ResponseEntity.ok("Success!!!!!");
    }
    
//    image hotel
    @PostMapping(value = "/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> uploadImg(@RequestBody MultipartFile file,int id) throws IOException {
        MultipartFile multi = file;
        String filename = multi.getOriginalFilename();
        try {
            file.transferTo(new File( path + filename ));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
        Hotelimage image = new Hotelimage(); 
        image.setImage(filename);
        image.setRoomId(id);
        imageService.save(image);
        
        return ResponseEntity.ok("Success");
    }
}
