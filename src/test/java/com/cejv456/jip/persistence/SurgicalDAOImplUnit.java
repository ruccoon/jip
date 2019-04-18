package com.cejv456.jip.persistence;

import com.cejv456.jip.dao.SurgicalDAOImpl;
import com.cejv456.jip.dao.PatientDAOImpl;
import com.cejv456.jip.dao.JipDBConnection;
import com.cejv456.jip.data.PatientBean;
import com.cejv456.jip.data.SurgicalBean;
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
 * 2. new surgical record can be inserted<br>
 * 3. surgical record can be updated<br>
 * 4. surgical record can be deleted<br>
 *
 *
 * @author Jianyu Feng
 */
public class SurgicalDAOImplUnit {

    Connection connection;
    PatientDAOImpl patientDAOImpl;
    SurgicalDAOImpl surgicalDAOImpl;
    PatientBean pb;
    SurgicalBean sb;

    public SurgicalDAOImplUnit() {
    }

    @Before
    public void setUp() throws SQLException, IOException {

        //initial dbconnection
        connection = JipDBConnection.getConnection().connection;

        //initial patientDAOImpl
        patientDAOImpl = new PatientDAOImpl(connection);

        //initial surgicalDAOImpl
        surgicalDAOImpl = new SurgicalDAOImpl(connection);

        //initial test patient data
        pb = new PatientBean();
        pb.setLastName("testLastName");
        pb.setFirstName("testFirstName");
        pb.setDiagnosis("everything is good");

        Timestamp ts = new Timestamp(113, 9, 1, 1, 15, 0, 0);
        pb.setAdmissionDate(ts);
        pb.setReleaseDate(ts);

        //initial test surgical data
        sb = new SurgicalBean();
        sb.setDate(ts);
        sb.setSurgicalProcedure("test surgical procedure");
        sb.setOperatingRoomFee(BigDecimal.valueOf(100.00));
        sb.setSurgeonFee(BigDecimal.valueOf(200.00));
        sb.setSurgicalSuppliesFee(BigDecimal.valueOf(80.00));
    }

    /**
     * Test of getRecords method, of class SurgicalDAOImpl.
     */
    @Test(timeout = 1000)
    public void correctNumberOfSurgicalRecordsAreReturned() throws SQLException {
        String criteria = "";
        ArrayList<Object> al = surgicalDAOImpl.getRecords(criteria);

        String sql = "select count(1) from surgical";
        long result = -1;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery()) {
            rs.next();
            result = rs.getLong(1);
        }

        assertEquals(result + " surgical recores are expects", result, al.size());
    }

    /**
     * Test of insertRecord method, of class SurgicalDAOImpl.
     */
    @Test(timeout = 1000)
    public void newSurgicalRecordCanBeInserted() throws SQLException {
        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);
        pb.setPatientID(newKey);

        //insert test surgical data
        sb.setPatientID(newKey);
        newKey = surgicalDAOImpl.insertRecord(sb);

        sb.setSurgicalID(newKey);

        String criteria = " where surgicalid = " + newKey;
        ArrayList<Object> s = surgicalDAOImpl.getRecords(criteria);

        assertEquals("the same surgical record is expected", true, sb.equals((SurgicalBean) s.get(0)));

        //remove test surgical data
        surgicalDAOImpl.deleteRecord(sb);

        //remove test patient data
        patientDAOImpl.deleteRecord(pb);

    }

    /**
     * Test of updateRecord method, of class SurgicalDAOImpl.
     */
    @Test(timeout = 1000)
    public void surgicalRecordCanBeUpdated() throws SQLException {
        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);
        pb.setPatientID(newKey);

        //insert test surgical data
        sb.setPatientID(pb.getPatientID());
        newKey = surgicalDAOImpl.insertRecord(sb);

        sb.setSurgicalID(newKey);

        //update surgical bean data
        sb.setDate(new Timestamp(113, 9, 3, 3, 30, 0, 0));
        sb.setSurgicalProcedure("new surgical procedure");
        sb.setOperatingRoomFee(BigDecimal.valueOf(222.22));
        sb.setSurgeonFee(BigDecimal.valueOf(111.1));
        sb.setSurgicalSuppliesFee(BigDecimal.valueOf(88.00));

        //update surgical in db
        surgicalDAOImpl.updateRecord(sb);

        String criteria = " where surgicalID = " + newKey;
        ArrayList<Object> s = surgicalDAOImpl.getRecords(criteria);

        assertEquals("the same surgical record is expected", true, sb.equals((SurgicalBean) s.get(0)));

        //remove test surgical data
        surgicalDAOImpl.deleteRecord(sb);

        //remove test patient data
        patientDAOImpl.deleteRecord(pb);
    }

    /**
     * Test of deleteRecord method, of class SurgicalDAOImpl.
     */
    @Test(timeout = 1000)
    public void surgicalRecordCanBeDeleted() throws SQLException {
        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);
        pb.setPatientID(newKey);

        //insert the test surgical data
        sb.setPatientID(pb.getPatientID());
        newKey = surgicalDAOImpl.insertRecord(sb);
        sb.setSurgicalID(newKey);

        //try to delete test surgical data
        surgicalDAOImpl.deleteRecord(sb);

        String criteria = " where surgicalID = " + newKey;
        ArrayList<Object> s = surgicalDAOImpl.getRecords(criteria);

        assertEquals("surgical record has been deleted is expected", 0, s.size());

        //remove test patient data
        patientDAOImpl.deleteRecord(pb);
    }
}