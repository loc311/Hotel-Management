
package com.hotel.backend.service;

import com.hotel.backend.entity.Customer;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author macos
 */
public interface CustomerService {
    List<Customer> findAllCustomer();
    Optional<Customer> findById(int id);
    Optional<Customer> findByName(String name);
    Optional<Customer> findByEmail(String email);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
    Boolean delete(int id);
    int changePassword(String email,String password);
    Customer save(Customer cus);
    Optional<Customer> checkLogin(String email, String password);
}
