package com.cejv456.jip.persistence;

import com.cejv456.jip.dao.PatientDAOImpl;
import com.cejv456.jip.dao.JipDBConnection;
import com.cejv456.jip.data.PatientBean;
import java.io.IOException;

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
 * 2. new patient record can be inserted<br>
 * 3. patient record can be updated<br>
 * 4. patient record can be deleted<br>
 *
 * @author Jianyu Feng
 */
public class PatientDAOImplUnit {

    PatientDAOImpl patientDAOImpl;
    PatientBean pb;
    Connection connection;

    public PatientDAOImplUnit() {
    }

    @Before
    public void setUp() throws SQLException, IOException {

        //initial dbconnection
        connection = JipDBConnection.getConnection().connection;

        //initial DAO Impl
        patientDAOImpl = new PatientDAOImpl(connection);

        //initial test patient data
        pb = new PatientBean();
        pb.setLastName("testLastName");
        pb.setFirstName("testFirstName");
        pb.setDiagnosis("everything is good");

        Timestamp ts = Timestamp.valueOf("2013-11-1 09:00:01");
        pb.setAdmissionDate(ts);
        pb.setReleaseDate(ts);

    }

    /**
     * Test of getRecords method, of class PatientDAOImpl.
     */
    @Test(timeout = 1000)
    public void correctNumberOfPatientRecordsAreReturned() throws SQLException {
        String criteria = "";
        ArrayList<Object> al = patientDAOImpl.getRecords(criteria);

        String sql = "select count(1) from patient";
        long result = -1;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery()) {
            rs.next();
            result = rs.getLong(1);
        }
        assertEquals(result + " patient recores are expects", result, al.size());
    }

    /**
     * Test of insertRecord method, of class PatientDAOImpl.
     */
    @Test(timeout = 1000)
    public void newPatientRecordCanBeInserted() throws SQLException {
        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);
        pb.setPatientID(newKey);

        String criteria = " where patientID = " + newKey;
        ArrayList<Object> p = patientDAOImpl.getRecords(criteria);

        assertEquals("the new patient record saved to database is expected", true, pb.equals((PatientBean) p.get(0)));

        //remove test patient data
        patientDAOImpl.deleteRecord(pb);

    }

    /**
     * Test of updateRecord method, of class PatientDAOImpl.
     */
    @Test(timeout = 1000)
    public void patientRecordCanBeUpdated() throws SQLException {

        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);

        pb.setPatientID(newKey);

        //update patient bean data
        pb.setLastName("newLastName");
        pb.setFirstName("newFirstName");
        pb.setDiagnosis("new diagnosis");
        pb.setAdmissionDate(Timestamp.valueOf("2013-10-1 09:00:01"));
        pb.setReleaseDate(Timestamp.valueOf("2013-10-2 19:00:01"));

        //update patient in db
        patientDAOImpl.updateRecord(pb);

        //get the new patient data from db
        String criteria = " where patientID = " + newKey;
        ArrayList<Object> p = patientDAOImpl.getRecords(criteria);

        assertEquals("the new patient record updated to database is expected", true, pb.equals((PatientBean) p.get(0)));

        //remove test patient data
        patientDAOImpl.deleteRecord(pb);
    }

    /**
     * Test of deleteRecord method, of class PatientDAOImpl.
     */
    @Test(timeout = 1000)
    public void patientRecordCanBeDeleted() throws SQLException {
        //insert test patient data
        long newKey = patientDAOImpl.insertRecord(pb);

        String criteria = " where patientID = " + newKey;
        ArrayList<Object> p = patientDAOImpl.getRecords(criteria);

        pb.setPatientID(((PatientBean) p.get(0)).getPatientID());

        //try to delete patient data
        patientDAOImpl.deleteRecord(pb);

        p = patientDAOImpl.getRecords(criteria);

        assertEquals("patient record has been deleted is expected", 0, p.size());

    }
}