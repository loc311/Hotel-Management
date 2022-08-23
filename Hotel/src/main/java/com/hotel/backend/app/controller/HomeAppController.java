
package com.hotel.backend.app.controller;

import com.hotel.backend.entity.Slider;
import com.hotel.backend.reponsitory.SliderReponsitory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macos
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/app")
public class HomeAppController {
    @Autowired
    private SliderReponsitory slider;
    
    @GetMapping("/slider")
    public ResponseEntity<?> listSlider(){
        List<Slider> room = slider.findAll();
        return ResponseEntity.ok(room);
    }
}
