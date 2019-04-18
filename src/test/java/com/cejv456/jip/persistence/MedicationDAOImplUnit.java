package com.cejv456.jip.persistence;

import com.cejv456.jip.dao.MedicationDAOImpl;
import com.cejv456.jip.dao.PatientDAOImpl;
import com.cejv456.jip.dao.JipDBConnection;
import com.cejv456.jip.data.PatientBean;
import com.cejv456.jip.data.MedicationBean;
import java.io.IOException;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This junit class will test the following methods on persistence level
 * <br>
 * 1. correct number of DB table records are returned<br>
 * 2. new medication record can be inserted<br>
 * 3. medication record can be updated<br>
 * 4. medication record can be deleted<br>
 *
 *
 * @author Jianyu Feng
 */
public class MedicationDAOImplUnit {

    Connection connection;
    PatientDAOImpl patientDAOImpl;
    MedicationDAOImpl medicationDAOImpl;
    PatientBean pb;
    MedicationBean mb;

    public MedicationDAOImplUnit() {
    }

    @Before
    public void setUp() throws SQLException, IOException {

        //initial dbconnection
        connection = JipDBConnection.getConnection().connection;

        //initial patientDAOImpl
        patientDAOImpl = new PatientDAOImpl(connection);

        //initial medicationDAOImpl
        medicationDAOImpl = new MedicationDAOImpl(connection);

        //initial test patient data
        pb = new PatientBean();
        pb.setLastName("testLastName");
        pb.setFirstName("testFirstName");
        pb.setDiagnosis("everything is good");

        Timestamp ts = new Timestamp(113, 9, 1, 1, 15, 0, 0);
        pb.setAdmissionDate(ts);
        pb.setReleaseDate(ts);

        //initial test medication data
        mb = new MedicationBean();
        mb.setDate(ts);
        mb.setMedication("test medication pill");
        mb.setCostPerUnit(BigDecimal.valueOf(20.02));
        mb.setNumberOfUnits(2);
    }

    /**
     * Test of getRecords method, of class MedicationDAOImpl.
     */
    @Test(timeout = 1000)
    public void correctNumberOfMedicationRecordsAreReturned() throws SQLException {
        String criteria = "";
        ArrayList<Object> al = medicationDAOImpl.getRecords(criteria);

        String sql = "select count(1) from medication";
        long result = -1;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery()) {
            rs.next();
            result = rs.getLong(1);
        }

        assertEquals(result + " medication recores are expects", result, al.size());
    }

    /**
     * Test of insertRecord method, of class MedicationDAOImpl.
     */
    @Test(timeout = 1000)
    public void newMedicationRecordCanBeInserted() throws SQLException {
        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);
        pb.setPatientID(newKey);

        //insert test medication data
        mb.setPatientID(newKey);
        newKey = medicationDAOImpl.insertRecord(mb);

        mb.setMedicationID(newKey);

        String criteria = " where medicationid = " + newKey;
        ArrayList<Object> m = medicationDAOImpl.getRecords(criteria);

        assertEquals("the same medication record is expected", true, mb.equals((MedicationBean) m.get(0)));

        //remove test medication data
        medicationDAOImpl.deleteRecord(mb);

        //remove test patient data
        patientDAOImpl.deleteRecord(pb);

    }

    /**
     * Test of updateRecord method, of class MedicationDAOImpl.
     */
    @Test(timeout = 1000)
    public void medicationRecordCanBeUpdated() throws SQLException {
        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);
        pb.setPatientID(newKey);

        //insert test medication data
        mb.setPatientID(pb.getPatientID());
        newKey = medicationDAOImpl.insertRecord(mb);

        mb.setMedicationID(newKey);

        //update medication bean data
        mb.setDate(new Timestamp(113, 9, 3, 4, 30, 0, 0));
        mb.setMedication("new medication pill");
        mb.setCostPerUnit(BigDecimal.valueOf(19.99));
        mb.setNumberOfUnits(5);

        //update medication in db
        medicationDAOImpl.updateRecord(mb);

        String criteria = " where medicationID = " + newKey;
        ArrayList<Object> m = medicationDAOImpl.getRecords(criteria);

        assertEquals("the same medication record is expected", true, mb.equals((MedicationBean) m.get(0)));

        //remove test medication data
        medicationDAOImpl.deleteRecord(mb);

        //remove test patient data
        patientDAOImpl.deleteRecord(pb);
    }

    /**
     * Test of deleteRecord method, of class MedicationDAOImpl.
     */
    @Test(timeout = 1000)
    public void medicationRecordCanBeDeleted() throws SQLException {
        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);
        pb.setPatientID(newKey);

        //insert the test medication data
        mb.setPatientID(pb.getPatientID());
        newKey = medicationDAOImpl.insertRecord(mb);
        mb.setMedicationID(newKey);

        //try to delete test medication data
        medicationDAOImpl.deleteRecord(mb);

        String criteria = " where medicationID = " + newKey;
        ArrayList<Object> m = medicationDAOImpl.getRecords(criteria);

        assertEquals("medication record has been deleted is expected", 0, m.size());

        //remove test patient data
        patientDAOImpl.deleteRecord(pb);
    }
}