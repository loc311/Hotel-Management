/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hotel.backend.reponsitory;

import com.hotel.backend.entity.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macos
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
}
