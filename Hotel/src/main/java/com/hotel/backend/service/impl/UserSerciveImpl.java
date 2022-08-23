package com.hotel.backend.service.impl;

import com.hotel.backend.entity.Staff;
import com.hotel.backend.reponsitory.UserRepository;
import com.hotel.backend.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author macos
 */
@Service
public class UserSerciveImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Staff user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return UserDetailImpl.build(user);
    }

    @Override
    public List<Staff> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Staff> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<Staff> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Boolean existsByName(String name) {
        return userRepository.existsByName(name);

    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Staff save(Staff user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean existsByCodeID(String code) {
        return userRepository.existsByCodeId(code);
    }

    @Override
    public Optional<Staff> findByEmail(String email) {
        return userRepository.findEmail(email);
    }

    @Override
    public int changePassword(String email, String password) {
        return userRepository.changePassword(email, password);
    }

    @Override
    public List<Staff> searchEmail(String email) {
        return userRepository.searchEmail(email);
    }

    @Override
    public List<Staff> searchName(String name) {
        return userRepository.searchName(name);
    }

    @Override
    public List<Staff> searchPhone(String phone) {
        return userRepository.searchPhone(phone);
    }

    @Override
    public List<Staff> searchCode(String codeId) {
        return userRepository.searchCode(codeId);
    }

    @Override
    public List<Staff> searchCodeAndPhone(String codeId, String phone) {
        return userRepository.searchCodeAndPhone(codeId, phone);
    }

    @Override
    public List<Staff> searchCodeAndName(String codeId, String name) {
        return userRepository.searchCodeAndName(codeId, name);
    }

    @Override
    public List<Staff> searchCodeAndEmail(String codeId, String email) {
        return userRepository.searchCodeAndEmail(codeId, email);
    }

    @Override
    public Staff staffDetail(int id) {
        return userRepository.staffDetail(id);
    }

    @Override
    public Long countStaff() {
        return userRepository.countStaff();
    }
}
