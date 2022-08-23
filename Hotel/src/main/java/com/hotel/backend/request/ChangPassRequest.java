/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author macos
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangPassRequest {

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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the newpassword
     */
    public String getNewpassword() {
        return newpassword;
    }

    /**
     * @param newpassword the newpassword to set
     */
    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
    private String email;
    private String password;
    @NotBlank
    @Size(min = 6, max = 40)
    private String newpassword;
}
