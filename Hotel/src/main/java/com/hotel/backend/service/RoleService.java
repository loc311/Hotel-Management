/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hotel.backend.service;

import com.hotel.backend.entity.Role;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author macos
 */
public interface RoleService {
    List<Role> findAll();
    Optional<Role> findById(int id);
    Optional<Role> findByName(String name);
    Role save(Role role);
}
