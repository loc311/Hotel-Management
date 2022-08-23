
package com.hotel.backend.request;
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
public class Count {

    /**
     * @return the percent
     */
    public String getPercent() {
        return percent;
    }

    /**
     * @param percent the percent to set
     */
    public void setPercent(String percent) {
        this.percent = percent;
    }

    /**
     * @return the lastMonth
     */
    public long getLastMonth() {
        return lastMonth;
    }

    /**
     * @param lastMonth the lastMonth to set
     */
    public void setLastMonth(long lastMonth) {
        this.lastMonth = lastMonth;
    }

    /**
     * @return the currenMonth
     */
    public long getCurrenMonth() {
        return currenMonth;
    }

    /**
     * @param currenMonth the currenMonth to set
     */
    public void setCurrenMonth(long currenMonth) {
        this.currenMonth = currenMonth;
    }

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
     * @return the staff
     */
    public long getStaff() {
        return staff;
    }

    /**
     * @param staff the staff to set
     */
    public void setStaff(long staff) {
        this.staff = staff;
    }
    private int id;
    private long staff;
    private long lastMonth;
    private long currenMonth;
    private String percent;
}
