
package com.hotel.backend.service;

import com.hotel.backend.entity.Staff;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author macos
 */
public interface UserService {
    List<Staff> findAll();
    Optional<Staff> findById(int id);
    Staff staffDetail(int id);
    Optional<Staff> findByName(String name);
    Optional<Staff> findByEmail(String email);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
    Boolean existsByCodeID(String code);
    Staff save(Staff user);
    int changePassword(String email,String password);
    List<Staff> searchEmail(String email);
    List<Staff> searchName(String name);
    List<Staff> searchPhone(String phone);
    List<Staff> searchCode(String codeId);
    List<Staff> searchCodeAndPhone(String codeId, String phone);
    List<Staff> searchCodeAndName(String codeId, String name);
    List<Staff> searchCodeAndEmail(String codeId, String email);
    Long countStaff();
}
