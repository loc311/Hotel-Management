/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.entity;

import java.io.Serializable;
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
@Table(name = "hotelimage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotelimage.findAll", query = "SELECT h FROM Hotelimage h"),
    @NamedQuery(name = "Hotelimage.findById", query = "SELECT h FROM Hotelimage h WHERE h.id = :id"),
    @NamedQuery(name = "Hotelimage.findByImage", query = "SELECT h FROM Hotelimage h WHERE h.image = :image"),
    @NamedQuery(name = "Hotelimage.findByRoomId", query = "SELECT h FROM Hotelimage h WHERE h.roomId = :roomId")})
public class Hotelimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "room_id")
    private int roomId;

    public Hotelimage() {
    }

    public Hotelimage(Integer id) {
        this.id = id;
    }

    public Hotelimage(Integer id, String image, int roomId) {
        this.id = id;
        this.image = image;
        this.roomId = roomId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
        if (!(object instanceof Hotelimage)) {
            return false;
        }
        Hotelimage other = (Hotelimage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hotel.backend.entity.Hotelimage[ id=" + id + " ]";
    }
    
}
