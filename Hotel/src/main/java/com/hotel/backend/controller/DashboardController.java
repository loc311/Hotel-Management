
package com.hotel.backend.controller;

import com.hotel.backend.request.Count;
import com.hotel.backend.service.DashBoardService;
import com.hotel.backend.service.UserService;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/admin")
public class DashboardController {
    @Autowired    
    private UserService serviceUser;
    
    @Autowired    
    private DashBoardService serviceBooking;
    
    @GetMapping("/statistical")
    public ResponseEntity<?> countData(){
        Date lastmonth = new Date(System.currentTimeMillis());
        int nowMonth = lastmonth.getMonth() + 1;
        Count count = new Count();
        count.setStaff(serviceUser.countStaff());
        count.setLastMonth(serviceBooking.lastMonth(lastmonth.getMonth()));
        count.setCurrenMonth(serviceBooking.currentMonth(nowMonth));
        long a = count.getLastMonth();
        long b = count.getCurrenMonth();
        float percent = 0;
        if (a >= 0 && b >= 0){
            percent = (float)(b-a)/a*100;   
        }
        count.setPercent(String.format("%.2f", percent));
        return ResponseEntity.ok(count);
    } 
}
