package com.cejv456.jip.data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Data bean for inpatient that overrides toString
 *
 * @author Jianyu Feng
 */
public class InpatientBean {

    private long inpatientID;
    private long patientID;
    private Timestamp date;
    private String roomNumber; //size 45
    private BigDecimal dailyRoomRate;
    private BigDecimal RoomSuppliesFee;
    private BigDecimal RoomServicesFee;

    /**
     * Default Constructor
     */
    public InpatientBean() {
        super();
        this.inpatientID = -1;
        this.patientID = -1;
        this.date = null;
        this.roomNumber = "";
        this.dailyRoomRate = null;
        this.RoomSuppliesFee = null;
        this.RoomServicesFee = null;
    }

    public long getInpatientID() {
        return inpatientID;
    }

    public void setInpatientID(long inpatientID) {
        this.inpatientID = inpatientID;
    }

    public long getPatientID() {
        return patientID;
    }

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public BigDecimal getDailyRoomRate() {
        return dailyRoomRate;
    }

    public void setDailyRoomRate(BigDecimal dailyRoomRate) {
        this.dailyRoomRate = dailyRoomRate;
    }

    public BigDecimal getRoomSuppliesFee() {
        return RoomSuppliesFee;
    }

    public void setRoomSuppliesFee(BigDecimal RoomSuppliesFee) {
        this.RoomSuppliesFee = RoomSuppliesFee;
    }

    public BigDecimal getRoomServicesFee() {
        return RoomServicesFee;
    }

    public void setRoomServicesFee(BigDecimal RoomServicesFee) {
        this.RoomServicesFee = RoomServicesFee;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.inpatientID ^ (this.inpatientID >>> 32));
        hash = 19 * hash + (int) (this.patientID ^ (this.patientID >>> 32));
        hash = 19 * hash + Objects.hashCode(this.date);
        hash = 19 * hash + Objects.hashCode(this.roomNumber);
        hash = 19 * hash + Objects.hashCode(this.dailyRoomRate);
        hash = 19 * hash + Objects.hashCode(this.RoomSuppliesFee);
        hash = 19 * hash + Objects.hashCode(this.RoomServicesFee);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InpatientBean other = (InpatientBean) obj;
        if (this.inpatientID != other.inpatientID) {
            return false;
        }
        if (this.patientID != other.patientID) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.roomNumber, other.roomNumber)) {
            return false;
        }
        if (this.dailyRoomRate.compareTo(other.dailyRoomRate) != 0) {
            return false;
        }
        if (this.RoomSuppliesFee.compareTo(other.RoomSuppliesFee) != 0) {
            return false;
        }
        if (this.RoomServicesFee.compareTo(other.RoomServicesFee) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InpatientBean{" + "inpatientID=" + inpatientID + ", patientID=" + patientID + ", date=" + date + ", roomNumber=" + roomNumber + ", dailyRoomRate=" + dailyRoomRate + ", RoomSuppliesFee=" + RoomSuppliesFee + ", RoomServicesFee=" + RoomServicesFee + '}';
    }
}
