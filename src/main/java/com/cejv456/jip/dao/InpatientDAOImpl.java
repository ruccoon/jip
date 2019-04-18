package com.cejv456.jip.dao;

import com.cejv456.jip.data.InpatientBean;

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
 * Retrieve, update, insert & delete inpatient records
 *
 * @author Jianyu Feng
 */
public class InpatientDAOImpl implements JipDAO {

    private Logger logger;
    private Connection connection;

    /**
     * default Constructor
     */
    public InpatientDAOImpl() {

        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());

    }

    public InpatientDAOImpl(Connection connection) throws SQLException {
        this();

        this.connection = connection;

    }

    /**
     * Retrieve the records for a inpatient table Return the data as an
     * arraylist of InpatientBean objects
     *
     * @param criteria where clause
     * @return return ArrayList of InpatientBean objects
     * @throws SQLException
     */
    @Override
    public ArrayList<Object> getRecords(String criteria) throws SQLException {

        ArrayList<Object> rows = new ArrayList<>();

        String sql = "select * from inpatient";

        //append any search criteria
        if (criteria != null) {
            sql += criteria;
        }
        
        logger.info("Search inpatient: " + sql);

        try (PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet resultSet = pStatement.executeQuery()) {
            while (resultSet.next()) {
                InpatientBean ib = new InpatientBean();
                ib.setInpatientID(resultSet.getLong("InpatientID"));
                ib.setPatientID(resultSet.getLong("PatientID"));
                ib.setDate(resultSet.getTimestamp("Date"));
                ib.setRoomNumber(resultSet.getString("RoomNumber"));
                ib.setDailyRoomRate(resultSet.getBigDecimal("DailyRoomRate"));
                ib.setRoomSuppliesFee(resultSet.getBigDecimal("RoomSupplies"));
                ib.setRoomServicesFee(resultSet.getBigDecimal("RoomServices"));

                rows.add(ib);
            }

            logger.info("Inpatient records added to ArrayList, size: " + rows.size());

        } catch (Exception e) {
            logger.error(e.toString());
        }

        return rows;

    }

    /**
     * insert new record to inpatient table
     *
     * @param o InpatientBean object
     * @return return new record key
     * @throws SQLException
     */
    @Override
    public long insertRecord(Object o) throws SQLException {

        String sql = "insert into inpatient (PatientID, Date, RoomNumber, DailyRoomRate, RoomSupplies, RoomServices) values (?,?,?,?,?,?)";
        long result = -1;
        InpatientBean ib;

        try (PreparedStatement pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ib = (InpatientBean) o;

            pStatement.setLong(1, ib.getPatientID());
            pStatement.setTimestamp(2, ib.getDate());
            pStatement.setString(3, ib.getRoomNumber());
            pStatement.setBigDecimal(4, ib.getDailyRoomRate());
            pStatement.setBigDecimal(5, ib.getRoomSuppliesFee());
            pStatement.setBigDecimal(6, ib.getRoomServicesFee());

            pStatement.executeUpdate();

            // Retrieve new primary key
            try (ResultSet rs = pStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    result = rs.getLong(1);
                }
            }
        }

        logger.info("New inpatient record has been added, patient id: " + ib.getPatientID() + ", new inpatient id: " + result);

        return result;
    }

    /**
     * update record on inpatient table
     *
     * @param o InpatientBean object
     * @return return affected rows number
     * @throws SQLException
     */
    @Override
    public long updateRecord(Object o) throws SQLException {

        String sql = "update inpatient set Date = ?, RoomNumber = ?, DailyRoomRate = ?, RoomSupplies = ?, RoomServices = ?, PatientID = ? where InpatientID = ?";
        long result = -1;
        InpatientBean ib = (InpatientBean) o;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);) {

            pStatement.setTimestamp(1, ib.getDate());
            pStatement.setString(2, ib.getRoomNumber());
            pStatement.setBigDecimal(3, ib.getDailyRoomRate());
            pStatement.setBigDecimal(4, ib.getRoomSuppliesFee());
            pStatement.setBigDecimal(5, ib.getRoomServicesFee());
            pStatement.setLong(6, ib.getPatientID());
            pStatement.setLong(7, ib.getInpatientID());

            result = pStatement.executeUpdate();
        }

        logger.info("Inpatient record has been updated: inpatient id " + ib.getInpatientID() + ", " + result + " row(s) affected");

        return result;
    }

    /**
     * delete record from inpatient table
     *
     * @param o InpatientBean object
     * @return return affected rows number
     * @throws SQLException
     */
    @Override
    public long deleteRecord(Object o) throws SQLException {
        String sql = "delete from inpatient where InpatientID = ?";
        long result = -1;
        InpatientBean ib = (InpatientBean) o;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);) {

            pStatement.setLong(1, ib.getInpatientID());

            result = pStatement.executeUpdate();
        }

        logger.info("Inpatient record has been deleted: inpatient id " + ib.getInpatientID() + ", " + result + " row(s) affected");

        return result;
    }
}
