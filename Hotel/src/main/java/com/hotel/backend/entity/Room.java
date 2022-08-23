/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author macos
 */
@Entity
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findDetail", query = "SELECT r FROM Room r WHERE r.id = :id"),
    @NamedQuery(name = "Room.findById", query = "SELECT r FROM Room r WHERE r.id = :id"),
    @NamedQuery(name = "Room.findByName", query = "SELECT r FROM Room r WHERE r.name = :name"),
    @NamedQuery(name = "Room.findByPriceday", query = "SELECT r FROM Room r WHERE r.priceday = :priceday"),
    @NamedQuery(name = "Room.findByStatus", query = "SELECT r FROM Room r WHERE r.status = :status"),
    @NamedQuery(name = "Room.status", query = "SELECT r FROM Room r WHERE r.status = :status"),
    @NamedQuery(name = "Room.findByDescription", query = "SELECT r FROM Room r WHERE r.description = :description"),
    @NamedQuery(name = "Room.findByRoomtype", query = "SELECT r FROM Room r WHERE r.roomtype = :roomtype")})
public class Room implements Serializable {

    /**
     * @return the imgs
     */
    public List<Hotelimage> getImgs() {
        return imgs;
    }

    /**
     * @param imgs the imgs to set
     */
    public void setImgs(List<Hotelimage> imgs) {
        this.imgs = imgs;
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
    @Column(name = "priceday")
    private float priceday;
    @Column(name = "status")
    private String status;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "roomtype")
    private String roomtype;
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)  @JoinColumn(name = "room_id") 
    private List<Hotelimage> imgs = new ArrayList();
    
    public Room() {
    }

    public Room(Integer id) {
        this.id = id;
    }

    public Room(Integer id, String name, float priceday, String status, String description, String roomtype) {
        this.id = id;
        this.name = name;
        this.priceday = priceday;
        this.status = status;
        this.description = description;
        this.roomtype = roomtype;
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

    public float getPriceday() {
        return priceday;
    }

    public void setPriceday(float priceday) {
        this.priceday = priceday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
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
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hotel.backend.entity.Room[ id=" + id + " ]";
    }

    }
