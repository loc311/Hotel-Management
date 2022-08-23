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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author macos
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findById", query = "SELECT b FROM Booking b WHERE b.id = :id"),
    @NamedQuery(name = "Booking.findByRoomId", query = "SELECT b FROM Booking b WHERE b.roomId = :roomId"),
    @NamedQuery(name = "Booking.findByTimeFrom", query = "SELECT b FROM Booking b WHERE b.timeFrom = :timeFrom"),
    @NamedQuery(name = "Booking.findByTimeTo", query = "SELECT b FROM Booking b WHERE b.timeTo = :timeTo"),
    @NamedQuery(name = "Booking.findByTotal", query = "SELECT b FROM Booking b WHERE b.total = :total"),
    @NamedQuery(name = "Booking.findByPayment", query = "SELECT b FROM Booking b WHERE b.payment = :payment"),
    @NamedQuery(name = "Booking.history", query = "SELECT b FROM Booking b WHERE b.cusId = :cusId"),
    @NamedQuery(name = "Booking.findByQrId", query = "SELECT b FROM Booking b WHERE b.qrId = :qrId"),
    @NamedQuery(name = "Booking.findByStatus", query = "SELECT b FROM Booking b WHERE b.status = :status"),
    @NamedQuery(name = "Booking.findByCreateAt", query = "SELECT b FROM Booking b WHERE b.createAt = :createAt")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "room_id")
    private int roomId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time_from")
    @Temporal(TemporalType.DATE)
    private Date timeFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time_to")
    @Temporal(TemporalType.DATE)
    private Date timeTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private float total;
    @Column(name = "payment")
    private Short payment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cus_id")
    private int cusId;
    @Column(name = "qr_id")
    private Integer qrId;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    public Booking() {
    }

    public Booking(Integer id) {
        this.id = id;
    }

    public Booking(Integer id, int roomId, Date timeFrom, Date timeTo, float total, int cusId) {
        this.id = id;
        this.roomId = roomId;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.total = total;
        this.cusId = cusId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Short getPayment() {
        return payment;
    }

    public void setPayment(Short payment) {
        this.payment = payment;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public Integer getQrId() {
        return qrId;
    }

    public void setQrId(Integer qrId) {
        this.qrId = qrId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hotel.backend.entity.Booking[ id=" + id + " ]";
    }
    
}
