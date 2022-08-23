/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author macos
 */
@Entity
@Table(name = "food")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f"),
    @NamedQuery(name = "Food.findById", query = "SELECT f FROM Food f WHERE f.id = :id"),
    @NamedQuery(name = "Food.findByPrice", query = "SELECT f FROM Food f WHERE f.price = :price"),
    @NamedQuery(name = "Food.findByPart", query = "SELECT f FROM Food f WHERE f.part = :part"),
    @NamedQuery(name = "Food.findByFood", query = "SELECT f FROM Food f WHERE f.food = :food"),
    @NamedQuery(name = "Food.findByDaytime", query = "SELECT f FROM Food f WHERE f.daytime = :daytime"),
    @NamedQuery(name = "Food.findByStatus", query = "SELECT f FROM Food f WHERE f.status = :status")})
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @Column(name = "part")
    private String part;
    @Basic(optional = false)
    @Column(name = "food")
    private String food;
    @Column(name = "daytime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date daytime;
    @Column(name = "status")
    private Boolean status;

    public Food() {
    }

    public Food(Integer id) {
        this.id = id;
    }

    public Food(Integer id, float price, String food) {
        this.id = id;
        this.price = price;
        this.food = food;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Date getDaytime() {
        return daytime;
    }

    public void setDaytime(Date daytime) {
        this.daytime = daytime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hotel.backend.entity.Food[ id=" + id + " ]";
    }
    
}
