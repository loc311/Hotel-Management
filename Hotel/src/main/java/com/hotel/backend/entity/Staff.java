
package com.hotel.backend.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author macos
 */
@Entity
@Table(name = "staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findById", query = "SELECT s FROM Staff s WHERE s.id = :id"),
    @NamedQuery(name = "Staff.staffDetail", query = "SELECT s FROM Staff s WHERE s.id = :id"),
    @NamedQuery(name = "Staff.findByName", query = "SELECT s FROM Staff s WHERE s.name = :name"),
    @NamedQuery(name = "Staff.findByPassword", query = "SELECT s FROM Staff s WHERE s.password = :password"),
    @NamedQuery(name = "Staff.findByPhone", query = "SELECT s FROM Staff s WHERE s.phone = :phone"),
    @NamedQuery(name = "Staff.findByEmail", query = "SELECT s FROM Staff s WHERE s.email = :email"),
    @NamedQuery(name = "Staff.findEmail", query = "SELECT s FROM Staff s WHERE s.email = :email"),
    @NamedQuery(name = "Staff.findByCccdImg", query = "SELECT s FROM Staff s WHERE s.cccdImg = :cccdImg"),
    @NamedQuery(name = "Staff.findByGender", query = "SELECT s FROM Staff s WHERE s.gender = :gender"),
    @NamedQuery(name = "Staff.findByBirthday", query = "SELECT s FROM Staff s WHERE s.birthday = :birthday"),
    @NamedQuery(name = "Staff.findByCodeId", query = "SELECT s FROM Staff s WHERE s.codeId = :codeId"),
    @NamedQuery(name = "Staff.findByRoleId", query = "SELECT s FROM Staff s WHERE s.roleId = :roleId")})
public class Staff implements Serializable {

    /**
     * @return the avt
     */
    public String getAvt() {
        return avt;
    }

    /**
     * @param avt the avt to set
     */
    public void setAvt(String avt) {
        this.avt = avt;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "cccd_img")
    private String cccdImg;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "birthday")
    private String birthday;
    @Basic(optional = false)
    @Column(name = "code_id")
    private String codeId;
    @Basic(optional = false)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "avt")
    private String avt;
    @Column(name = "create_at")
    private Date create_at;
    public Staff() {
    }

    public Staff(Integer id) {
        this.id = id;
    }

    public Staff(Integer id, String name, String password, String phone, String email, String cccdImg, boolean gender, String birthday, String codeId, int roleId, String avt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.cccdImg = cccdImg;
        this.gender = gender;
        this.birthday = birthday;
        this.codeId = codeId;
        this.roleId = roleId;
        this.avt = avt;
    }

   

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCccdImg() {
        return cccdImg;
    }

    public void setCccdImg(String cccdImg) {
        this.cccdImg = cccdImg;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hotel.backend.entity.Staff[ id=" + id + " ]";
    }

    /**
     * @return the create_at
     */
    public Date getCreate_at() {
        return create_at;
    }

    /**
     * @param create_at the create_at to set
     */
    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
    
}
