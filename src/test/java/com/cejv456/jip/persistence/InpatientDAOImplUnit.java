package com.cejv456.jip.persistence;

import com.cejv456.jip.dao.PatientDAOImpl;
import com.cejv456.jip.dao.InpatientDAOImpl;
import com.cejv456.jip.dao.JipDBConnection;
import com.cejv456.jip.data.InpatientBean;
import com.cejv456.jip.data.PatientBean;
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
 * 2. new inpatient record can be inserted<br>
 * 3. inpatient record can be updated<br>
 * 4. inpatient record can be deleted<br>
 *
 * @author Jianyu Feng
 */
public class InpatientDAOImplUnit {

    Connection connection;
    PatientDAOImpl patientDAOImpl;
    InpatientDAOImpl inpatientDAOImpl;
    PatientBean pb;
    InpatientBean ib;

    public InpatientDAOImplUnit() {
    }

    @Before
    public void setUp() throws SQLException, IOException {

        //initial dbconnection
        connection = JipDBConnection.getConnection().connection;

        //initial patientDAOImpl
        patientDAOImpl = new PatientDAOImpl(connection);

        //initial inpatientDAOImpl
        inpatientDAOImpl = new InpatientDAOImpl(connection);

        //initial test patient data
        pb = new PatientBean();
        pb.setLastName("testLastName");
        pb.setFirstName("testFirstName");
        pb.setDiagnosis("everything is good");

        Timestamp ts = new Timestamp(113, 9, 1, 1, 15, 0, 0);
        pb.setAdmissionDate(ts);
        pb.setReleaseDate(ts);

        //initial test inpation data
        ib = new InpatientBean();
        ib.setDate(ts);
        ib.setRoomNumber("room808");
        ib.setDailyRoomRate(BigDecimal.valueOf(100.1));
        ib.setRoomServicesFee(BigDecimal.valueOf(60.20));
        ib.setRoomSuppliesFee(BigDecimal.valueOf(80.99));
    }

    /**
     * Test of getRecords method, of class InpatientDAOImpl.
     */
    @Test(timeout = 1000)
    public void correctNumberOfInpatientRecordsAreReturned() throws SQLException {
        String criteria = "";
        ArrayList<Object> al = inpatientDAOImpl.getRecords(criteria);

        String sql = "select count(1) from inpatient";
        long result = -1;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery()) {
            rs.next();
            result = rs.getLong(1);
        }

        assertEquals(result + " inpatient recores are expects", result, al.size());
    }

    /**
     * Test of insertRecord method, of class InpatientDAOImpl.
     */
    @Test(timeout = 1000)
    public void newInpatientRecordCanBeInserted() throws SQLException {
        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);
        pb.setPatientID(newKey);

        //insert test inpatient data
        ib.setPatientID(newKey);
        newKey = inpatientDAOImpl.insertRecord(ib);

        ib.setInpatientID(newKey);

        String criteria = " where inpatientid = " + newKey;
        ArrayList<Object> i = inpatientDAOImpl.getRecords(criteria);

        assertEquals("the same inpatient record is expected", true, ib.equals((InpatientBean) i.get(0)));

        //remove test inpatient data
        inpatientDAOImpl.deleteRecord(ib);

        //remove test patient data
        patientDAOImpl.deleteRecord(pb);

    }

    /**
     * Test of updateRecord method, of class InpatientDAOImpl.
     */
    @Test(timeout = 1000)
    public void inpatientRecordCanBeUpdated() throws SQLException {
        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);
        pb.setPatientID(newKey);

        //insert test inpatient data
        ib.setPatientID(pb.getPatientID());
        newKey = inpatientDAOImpl.insertRecord(ib);

        ib.setInpatientID(newKey);

        //update inpatient bean data
        ib.setDate(new Timestamp(113, 9, 3, 2, 30, 0, 0));
        ib.setRoomNumber("room909");
        ib.setDailyRoomRate(BigDecimal.valueOf(250));
        ib.setRoomServicesFee(BigDecimal.valueOf(160));
        ib.setRoomSuppliesFee(BigDecimal.valueOf(180));

        //update inpatient in db
        inpatientDAOImpl.updateRecord(ib);

        String criteria = " where inpatientID = " + newKey;
        ArrayList<Object> i = inpatientDAOImpl.getRecords(criteria);

        assertEquals("the same inpatient record is expected", true, ib.equals((InpatientBean) i.get(0)));

        //remove test inpatient data
        inpatientDAOImpl.deleteRecord(ib);

        //remove test patient data
        patientDAOImpl.deleteRecord(pb);
    }

    /**
     * Test of deleteRecord method, of class InpatientDAOImpl.
     */
    @Test(timeout = 1000)
    public void inpatientRecordCanBeDeleted() throws SQLException {
        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);
        pb.setPatientID(newKey);

        //insert the test inpatient data
        ib.setPatientID(pb.getPatientID());
        newKey = inpatientDAOImpl.insertRecord(ib);
        ib.setInpatientID(newKey);

        //try to delete test inpatient data
        inpatientDAOImpl.deleteRecord(ib);

        String criteria = " where inpatientID = " + newKey;
        ArrayList<Object> i = inpatientDAOImpl.getRecords(criteria);

        assertEquals("inpatient record has been deleted is expected", 0, i.size());

        //remove test patient data
        patientDAOImpl.deleteRecord(pb);
    }
}