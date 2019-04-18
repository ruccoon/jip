package com.cejv456.jip.dao;

import com.cejv456.jip.data.PatientBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides the functionality to: <br>
 * Retrieve, update, insert & delete patient records
 *
 * @author Jianyu Feng
 */
public class PatientDAOImpl implements JipDAO {

    private Logger logger;
    private Connection connection;
    InpatientDAOImpl inpatientDAOImpl;
    SurgicalDAOImpl surgicalDAOImpl;
    MedicationDAOImpl medicationDAOImpl;

    /**
     * default Constructor
     */
    public PatientDAOImpl() {

        super();

        logger = LoggerFactory.getLogger(this.getClass().getName());

    }

    /**
     * @param jdb
     * @throws SQLException
     */
    public PatientDAOImpl(Connection connection) throws SQLException {
        this();
        
        this.connection = connection;

        inpatientDAOImpl = new InpatientDAOImpl(connection);
        surgicalDAOImpl = new SurgicalDAOImpl(connection);
        medicationDAOImpl = new MedicationDAOImpl(connection);

    }

    /**
     * Retrieve the records for a patient table Return the data as an arraylist
     * of PatientBean objects
     *
     * @param criteria
     * @return return ArrayList of PatientBean objects
     * @throws SQLException
     */
    @Override
    public ArrayList<Object> getRecords(String criteria) throws SQLException {

        ArrayList<Object> rows = new ArrayList<>();

        String sql = "select * from patient";

        //append any search criteria
        if (criteria != null) {
            sql += criteria;
        }
        
        logger.info("Search patient: " + sql);
        
        try (PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet resultSet = pStatement.executeQuery();) {
            while (resultSet.next()) {
                PatientBean pb = new PatientBean();
                pb.setPatientID(resultSet.getLong("PatientID"));
                pb.setLastName(resultSet.getString("LastName"));
                pb.setFirstName(resultSet.getString("FirstName"));
                pb.setDiagnosis(resultSet.getString("Diagnosis"));
                pb.setAdmissionDate(resultSet.getTimestamp("AdmissionDate"));
                pb.setReleaseDate(resultSet.getTimestamp("ReleaseDate"));

                ArrayList<Object> ib = inpatientDAOImpl.getRecords(" where patientID = " + pb.getPatientID());
                if (ib != null && ib.size() > 0) {
                    pb.setIb(ib);
                }

                ArrayList<Object> sb = surgicalDAOImpl.getRecords(" where patientID = " + pb.getPatientID());
                if (sb != null && sb.size() > 0) {
                    pb.setSb(sb);
                }

                ArrayList<Object> mb = medicationDAOImpl.getRecords(" where patientID = " + pb.getPatientID());
                if (mb != null && mb.size() > 0) {
                    pb.setMb(mb);
                }

                rows.add(pb);
            }
        }

        logger.info("patient records have been saved to ArrayList, size: " + rows.size());

        return rows;

    }

    /**
     * insert new record to patient table
     *
     * @param o PatientBean object
     * @return return new record key
     * @throws SQLException
     */
    @Override
    public long insertRecord(Object o) throws SQLException {

        String sql = "insert into patient (LastName, FirstName, Diagnosis, AdmissionDate, ReleaseDate) values (?,?,?,?,?)";
        long result = -1;
        PatientBean pb;

        try (PreparedStatement pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            pb = (PatientBean) o;

            pStatement.setString(1, pb.getLastName());
            pStatement.setString(2, pb.getFirstName());
            pStatement.setString(3, pb.getDiagnosis());
            pStatement.setTimestamp(4, pb.getAdmissionDate());
            pStatement.setTimestamp(5, pb.getReleaseDate());

            pStatement.executeUpdate();

            // Retrieve new primary key
            try (ResultSet rs = pStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    result = rs.getLong(1);
                }
            }
        }

        logger.info("New patient record has been added: " + pb.getFirstName() + " " + pb.getLastName() + ", new patient id: " + result);

        return result;
    }

    /**
     * update record on patient table
     *
     * @param o PatientBean object
     * @return return affected row number
     * @throws SQLException
     */
    @Override
    public long updateRecord(Object o) throws SQLException {

        String sql = "update patient set LastName = ?, FirstName = ?, Diagnosis = ?, AdmissionDate = ?, ReleaseDate = ? where PatientID = ?";
        long result = -1;
        PatientBean pb;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);) {

            pb = (PatientBean) o;

            pStatement.setString(1, pb.getLastName());
            pStatement.setString(2, pb.getFirstName());
            pStatement.setString(3, pb.getDiagnosis());
            pStatement.setTimestamp(4, pb.getAdmissionDate());
            pStatement.setTimestamp(5, pb.getReleaseDate());
            pStatement.setLong(6, pb.getPatientID());

            result = pStatement.executeUpdate();
        }

        logger.info("Patient record has been updated, patient id: " + pb.getPatientID() + ", " + pb.getFirstName() + " " + pb.getLastName() + ", " + result + " row(s) affected");

        return result;
    }

    /**
     * delete record from patient table
     *
     * @param o PatientBean object
     * @return return affected rows number
     * @throws SQLException
     */
    @Override
    public long deleteRecord(Object o) throws SQLException {
        String sql = "delete from patient where patientid = ?";
        long result = -1;
        PatientBean pb;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);) {
            pb = (PatientBean) o;
            pStatement.setLong(1, pb.getPatientID());

            result = pStatement.executeUpdate();
        }

        logger.info("Patient record has been deleted: patient id " + pb.getPatientID() + ", " + result + " row(s) affected");

        return result;
    }
}
