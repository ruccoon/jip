package com.cejv456.jip.data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Data bean for medication that overrides toString
 *
 * @author Jianyu Feng
 */
public class MedicationBean {

    private long medicationID;
    private long patientID;
    private Timestamp date;
    private String medication; //size 256
    private BigDecimal costPerUnit;
    private int numberOfUnits;

    /**
     * Default Constructor
     */
    public MedicationBean() {
        super();
        this.medicationID = -1;
        this.patientID = -1;
        this.date = null;
        this.medication = "";
        this.costPerUnit = null;
        this.numberOfUnits = 0;
    }

    public long getMedicationID() {
        return medicationID;
    }

    public void setMedicationID(long medicationID) {
        this.medicationID = medicationID;
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

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public BigDecimal getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(BigDecimal costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.medicationID ^ (this.medicationID >>> 32));
        hash = 97 * hash + (int) (this.patientID ^ (this.patientID >>> 32));
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + Objects.hashCode(this.medication);
        hash = 97 * hash + Objects.hashCode(this.costPerUnit);
        hash = 97 * hash + this.numberOfUnits;
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
        final MedicationBean other = (MedicationBean) obj;
        if (this.medicationID != other.medicationID) {
            return false;
        }
        if (this.patientID != other.patientID) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.medication, other.medication)) {
            return false;
        }
        if (this.costPerUnit.compareTo(other.costPerUnit) != 0) {
            return false;
        }
        if (this.numberOfUnits != other.numberOfUnits) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MedicationBean{" + "medicationID=" + medicationID + ", patientID=" + patientID + ", date=" + date + ", medication=" + medication + ", costPerUnit=" + costPerUnit + ", numberOfUnits=" + numberOfUnits + '}';
    }
}
