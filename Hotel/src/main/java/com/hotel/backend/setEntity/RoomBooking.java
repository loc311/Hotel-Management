
package com.hotel.backend.setEntity;

import com.hotel.backend.entity.Booking;
import com.hotel.backend.entity.Room;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author macos
 */
@Entity
public class RoomBooking {

    /**
     * @return the room
     */
    public List<Room> getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(List<Room> room) {
        this.room = room;
    }

    /**
     * @return the book
     */
    public List<Booking> getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(List<Booking> book) {
        this.book = book;
    }
    @Id
    private int conId;
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)  @JoinColumn(name = "id") 
    private List<Room> room = new ArrayList();
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)  @JoinColumn(name = "room_id") 
    private List<Booking> book = new ArrayList();

    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
    }
}
