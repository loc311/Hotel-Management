
package com.hotel.backend.reponsitory;

import com.hotel.backend.entity.Customer;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macos
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByName(String name);
    @Query("SELECT c FROM Customer c WHERE c.id = :id")
    Optional<Customer> findById(int id);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
    @Query("DELETE FROM Customer c WHERE c.id = :id")
    Boolean delete(int id);
    @Transactional
    @Modifying
    @Query("UPDATE Customer c SET c.password = :password WHERE c.email = :email")
    int changePassword(String email, String password);
    Optional<Customer> checkLogin(String email, String password);
    
}
