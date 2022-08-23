
package com.hotel.backend.service.impl;

import com.hotel.backend.reponsitory.DashBoardReponsitory;
import com.hotel.backend.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macos
 */
@Service
public class DashBoardImpl implements DashBoardService{
    
    @Autowired
    private DashBoardReponsitory repo;
    
    @Override
    public Long lastMonth(int month) {
        return repo.lastMonth(month);
    }

    @Override
    public Long currentMonth(int month) {
        return repo.currentMonth(month);
    }
    
}
