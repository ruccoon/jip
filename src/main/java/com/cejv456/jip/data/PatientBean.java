package com.cejv456.jip.data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * Data bean for patient that overrides toString
 *
 * @author Jianyu Feng
 */
public class PatientBean {

    private long patientID;
    private String lastName; //size 45
    private String firstName; //size 45
    private String diagnosis; //size text
    private Timestamp admissionDate;
    private Timestamp releaseDate;
    private List<Object> ib;
    private List<Object> sb;
    private List<Object> mb;

    /**
     * Default Constructor
     */
    public PatientBean() {
        super();
        this.patientID = -1;
        this.lastName = null;
        this.firstName = null;
        this.diagnosis = null;
        this.admissionDate = null;
        this.releaseDate = null;
        this.ib = null;
        this.sb = null;
        this.mb = null;
    }

    public long getPatientID() {
        return patientID;
    }

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Timestamp getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Timestamp admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Object> getIb() {
        return ib;
    }

    public void setIb(List<Object> ib) {
        this.ib = ib;
    }

    public List<Object> getSb() {
        return sb;
    }

    public void setSb(List<Object> sb) {
        this.sb = sb;
    }

    public List<Object> getMb() {
        return mb;
    }

    public void setMb(List<Object> mb) {
        this.mb = mb;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.patientID ^ (this.patientID >>> 32));
        hash = 79 * hash + Objects.hashCode(this.lastName);
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.diagnosis);
        hash = 79 * hash + Objects.hashCode(this.admissionDate);
        hash = 79 * hash + Objects.hashCode(this.releaseDate);
        hash = 79 * hash + Objects.hashCode(this.ib);
        hash = 79 * hash + Objects.hashCode(this.sb);
        hash = 79 * hash + Objects.hashCode(this.mb);
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
        final PatientBean other = (PatientBean) obj;
        if (this.patientID != other.patientID) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.diagnosis, other.diagnosis)) {
            return false;
        }
        if (!Objects.equals(this.admissionDate, other.admissionDate)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.ib, other.ib)) {
            return false;
        }
        if (!Objects.equals(this.sb, other.sb)) {
            return false;
        }
        if (!Objects.equals(this.mb, other.mb)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PatientBean{" + "patientID=" + patientID + ", lastName=" + lastName + ", firstName=" + firstName + ", diagnosis=" + diagnosis + ", admissionDate=" + admissionDate + ", releaseDate=" + releaseDate + ", ib=" + ib + ", sb=" + sb + ", mb=" + mb + '}';
    }

}
