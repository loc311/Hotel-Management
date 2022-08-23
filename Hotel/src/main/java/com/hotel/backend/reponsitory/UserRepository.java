
package com.hotel.backend.reponsitory;

import com.hotel.backend.entity.Staff;
import java.util.List;
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
public interface UserRepository extends JpaRepository<Staff, Integer>{
    Staff findByEmail(String email);
    Optional<Staff> findByName(String name);
    Optional<Staff> findById(int id);
    Staff staffDetail(int id);
    Optional<Staff> findEmail(String email);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
    Boolean existsByCodeId(String code);
    @Transactional
    @Modifying
    @Query("UPDATE Staff s SET s.password = :password WHERE s.email = :email")
    int changePassword(String email, String password);
    @Query("SELECT s FROM Staff s WHERE s.email LIKE CONCAT( '%',:email,'%')")
    List<Staff> searchEmail(String email);
    @Query("SELECT s FROM Staff s WHERE s.name LIKE CONCAT( '%',:name,'%')")
    List<Staff> searchName(String name);
    @Query("SELECT s FROM Staff s WHERE s.phone LIKE CONCAT( '%',:phone,'%')")
    List<Staff> searchPhone(String phone);
    @Query("SELECT s FROM Staff s WHERE s.codeId LIKE CONCAT( '%',:codeId,'%')")
    List<Staff> searchCode(String codeId);
    
    @Query("SELECT s FROM Staff s WHERE s.codeId LIKE CONCAT( '%',:codeId,'%') AND s.phone LIKE CONCAT( '%',:phone,'%')")
    List<Staff> searchCodeAndPhone(String codeId, String phone);
    @Query("SELECT s FROM Staff s WHERE s.codeId LIKE CONCAT( '%',:codeId,'%') AND s.name LIKE CONCAT( '%',:name,'%')")
    List<Staff> searchCodeAndName(String codeId, String name);
    @Query("SELECT s FROM Staff s WHERE s.codeId LIKE CONCAT( '%',:codeId,'%') AND s.email LIKE CONCAT( '%',:email,'%')")
    List<Staff> searchCodeAndEmail(String codeId, String email);
    
    @Query("SELECT count(s.id) FROM Staff s")
    Long countStaff();
}
