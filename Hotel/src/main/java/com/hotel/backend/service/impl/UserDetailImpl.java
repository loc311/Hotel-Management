/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotel.backend.entity.Staff;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author macos
 */
@Service
public class UserDetailImpl implements UserDetails {

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

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the gender
     */
    public boolean isGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    private int id;
    private String name;
    @JsonIgnore
    private String pass;
    private String email;
    private String cccdImg;
    private String codeId;
    private String phone;
    private String avt;
    private String birthday;
    private boolean gender;
    private int roleId;

    public UserDetailImpl() {
    }

    public UserDetailImpl(int id, String name, String pass, String email, String cccdImg, String codeId,String phone, int roleId, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.cccdImg = cccdImg;
        this.codeId = codeId;
        this.roleId = roleId;
        this.phone =phone;
        this.authorities = authorities;
    }
    
    public static UserDetailImpl build(Staff user){
        return new UserDetailImpl(user.getId(),user.getName(),user.getPassword(),user.getEmail(),user.getCccdImg(),user.getCodeId(),user.getPhone(),user.getRoleId(),user.getAvt(),user.getBirthday(),user.getGender());
    }

    private Collection<? extends GrantedAuthority> authorities;

    private UserDetailImpl(Integer id, String name, String password, String email, String cccdImg, String codeId,String phone, int roleId,String avt,String birthday,boolean gender) {
    this.id = id;
        this.name = name;
        this.pass = password;
        this.email = email;
        this.cccdImg = cccdImg;
        this.codeId = codeId;
        this.phone = phone;
        this.roleId = roleId;
        this.avt = avt;
        this.birthday = birthday;
        this.gender = gender;
    }

    @Override
    public String getPassword() {
        return this.getPass();
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
return this.authorities;    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cccdImg
     */
    public String getCccdImg() {
        return cccdImg;
    }

    /**
     * @param cccdImg the cccdImg to set
     */
    public void setCccdImg(String cccdImg) {
        this.cccdImg = cccdImg;
    }

    /**
     * @return the codeId
     */
    public String getCodeId() {
        return codeId;
    }

    /**
     * @param codeId the codeId to set
     */
    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    /**
     * @return the roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * @param authorities the authorities to set
     */
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
