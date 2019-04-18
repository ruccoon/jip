package com.cejv456.jip.dao;

import com.cejv456.jip.data.MedicationBean;

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
 * Retrieve, update, insert & delete medication records
 *
 * @author Jianyu Feng
 */
public class MedicationDAOImpl implements JipDAO {

    private Logger logger;
    private Connection connection;

    /**
     * default Constructor
     */
    public MedicationDAOImpl() {

        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());

    }

    public MedicationDAOImpl(Connection connection) throws SQLException {
        this();

        this.connection = connection;

    }

    /**
     * Retrieve the records for a medication table Return the data as an arraylist
     * of MedicationBean objects
     *
     * @param criteria where clause
     * @return return Arraylist of MedicationBean objects
     * @throws SQLException
     */
    @Override
    public ArrayList<Object> getRecords(String criteria) throws SQLException {

        ArrayList<Object> rows = new ArrayList<>();

        String sql = "select * from medication";

        //append any search criteria
        if (criteria != null) {
            sql += criteria;
        }
        
        logger.info("Search medication: " + sql);

        try (PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet resultSet = pStatement.executeQuery()) {
            while (resultSet.next()) {
                MedicationBean mb = new MedicationBean();
                mb.setMedicationID(resultSet.getLong("MedicationID"));
                mb.setPatientID(resultSet.getLong("PatientID"));
                mb.setDate(resultSet.getTimestamp("Date"));
                mb.setMedication(resultSet.getString("Medication"));
                mb.setCostPerUnit(resultSet.getBigDecimal("CostPerUnit"));
                mb.setNumberOfUnits(resultSet.getInt("NumberOfUnits"));

                rows.add(mb);
            }

            logger.info("Medication records added to ArrayList, size: " + rows.size());

        }

        return rows;

    }

    /**
     * insert new record to medication table
     *
     * @param o MedicationBean object
     * @return return new record key
     * @throws SQLException
     */
    @Override
    public long insertRecord(Object o) throws SQLException {

        String sql = "insert into medication (PatientID, Date, Medication, CostPerUnit, NumberOfUnits) values (?,?,?,?,?)";
        long result = -1;
        MedicationBean mb;

        try (PreparedStatement pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            mb = (MedicationBean) o;

            pStatement.setLong(1, mb.getPatientID());
            pStatement.setTimestamp(2, mb.getDate());
            pStatement.setString(3, mb.getMedication());
            pStatement.setBigDecimal(4, mb.getCostPerUnit());
            pStatement.setLong(5, mb.getNumberOfUnits());

            pStatement.executeUpdate();

            // Retrieve new primary key
            try (ResultSet rs = pStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    result = rs.getLong(1);
                }
            }
        }

        logger.info("New medication record has been added, patient id: " + mb.getPatientID() + ", new medication id: " + result);

        return result;
    }

    /**
     * update record on medication table
     *
     * @param o MedicationBean object
     * @return return affected rows number
     * @throws SQLException
     */
    @Override
    public long updateRecord(Object o) throws SQLException {

        String sql = "update medication set Date = ?, Medication = ?, CostPerUnit = ?, NumberOfUnits = ?, PatientID = ? where MedicationID = ?";
        long result = -1;
        MedicationBean mb = (MedicationBean) o;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);) {

            pStatement.setTimestamp(1, mb.getDate());
            pStatement.setString(2, mb.getMedication());
            pStatement.setBigDecimal(3, mb.getCostPerUnit());
            pStatement.setInt(4, mb.getNumberOfUnits());
            pStatement.setLong(5, mb.getPatientID());
            pStatement.setLong(6, mb.getMedicationID());

            result = pStatement.executeUpdate();
        }

        logger.info("Medication record has been updated: medication id " + mb.getMedicationID() + ", " + result + " row(s) affected");

        return result;
    }

    /**
     * delete record from medication table
     *
     * @param o MedicationBean object
     * @return return affected rows number
     * @throws SQLException
     */
    @Override
    public long deleteRecord(Object o) throws SQLException {
        String sql = "delete from medication where MedicationID = ?";
        long result = -1;
        MedicationBean mb = (MedicationBean) o;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);) {

            pStatement.setLong(1, mb.getMedicationID());

            result = pStatement.executeUpdate();
        }

        logger.info("Medication record has been deleted: medication id " + mb.getMedicationID() + ", " + result + " row(s) affected");

        return result;
    }
}
