package com.cejv456.jip.data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Data bean for surgical that overrides toString
 *
 * @author Jianyu Feng
 */
public class SurgicalBean {

    private long surgicalID;
    private long patientID;
    private Timestamp date;
    private String surgicalProcedure; //size 256
    private BigDecimal operatingRoomFee;
    private BigDecimal surgeonFee;
    private BigDecimal surgicalSuppliesFee;

    /**
     * Default Constructor
     */
    public SurgicalBean() {
        super();
        this.surgicalID = -1;
        this.patientID = -1;
        this.date = null;
        this.surgicalProcedure = "";
        this.operatingRoomFee = null;
        this.surgeonFee = null;
        this.surgicalSuppliesFee = null;
    }

    public long getSurgicalID() {
        return surgicalID;
    }

    public void setSurgicalID(long surgicalID) {
        this.surgicalID = surgicalID;
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

    public String getSurgicalProcedure() {
        return surgicalProcedure;
    }

    public void setSurgicalProcedure(String surgicalProcedure) {
        this.surgicalProcedure = surgicalProcedure;
    }

    public BigDecimal getOperatingRoomFee() {
        return operatingRoomFee;
    }

    public void setOperatingRoomFee(BigDecimal operatingRoomFee) {
        this.operatingRoomFee = operatingRoomFee;
    }

    public BigDecimal getSurgeonFee() {
        return surgeonFee;
    }

    public void setSurgeonFee(BigDecimal surgeonFee) {
        this.surgeonFee = surgeonFee;
    }

    public BigDecimal getSurgicalSuppliesFee() {
        return surgicalSuppliesFee;
    }

    public void setSurgicalSuppliesFee(BigDecimal surgicalSuppliesFee) {
        this.surgicalSuppliesFee = surgicalSuppliesFee;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.surgicalID ^ (this.surgicalID >>> 32));
        hash = 53 * hash + (int) (this.patientID ^ (this.patientID >>> 32));
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + Objects.hashCode(this.surgicalProcedure);
        hash = 53 * hash + Objects.hashCode(this.operatingRoomFee);
        hash = 53 * hash + Objects.hashCode(this.surgeonFee);
        hash = 53 * hash + Objects.hashCode(this.surgicalSuppliesFee);
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
        final SurgicalBean other = (SurgicalBean) obj;
        if (this.surgicalID != other.surgicalID) {
            return false;
        }
        if (this.patientID != other.patientID) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.surgicalProcedure, other.surgicalProcedure)) {
            return false;
        }
        if (this.operatingRoomFee.compareTo(other.operatingRoomFee) != 0) {
            return false;
        }
        if (this.surgeonFee.compareTo(other.surgeonFee) != 0) {
            return false;
        }
        if (this.surgicalSuppliesFee.compareTo(other.surgicalSuppliesFee) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SurgicalBean{" + "surgicalID=" + surgicalID + ", patientID=" + patientID + ", date=" + date + ", surgicalProcedure=" + surgicalProcedure + ", operatingRoomFee=" + operatingRoomFee + ", surgeonFee=" + surgeonFee + ", surgicalSuppliesFee=" + surgicalSuppliesFee + '}';
    }
}
