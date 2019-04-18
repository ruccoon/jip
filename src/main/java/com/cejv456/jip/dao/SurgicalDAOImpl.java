package com.cejv456.jip.dao;

import com.cejv456.jip.data.SurgicalBean;

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
 * Retrieve, update, insert & delete surgical records
 *
 * @author Jianyu Feng
 */
public class SurgicalDAOImpl implements JipDAO {

    private Logger logger;
    private Connection connection;

    /**
     * default Constructor
     */
    public SurgicalDAOImpl() {

        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());

    }

    public SurgicalDAOImpl(Connection connection) throws SQLException {
        this();

        this.connection = connection;

    }

    /**
     * Retrieve the records for a surgical table Return the data as an arraylist
     * of SurgicalBean objects
     *
     * @param criteria where clause
     * @return return Arraylist of SurgicalBean objects
     * @throws SQLException
     */
    @Override
    public ArrayList<Object> getRecords(String criteria) throws SQLException {

        ArrayList<Object> rows = new ArrayList<>();

        String sql = "select * from surgical";

        //append any search criteria
        if (criteria != null) {
            sql += criteria;
        }
        
        logger.info("Search surgical: " + sql);

        try (PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet resultSet = pStatement.executeQuery()) {
            while (resultSet.next()) {
                SurgicalBean sb = new SurgicalBean();
                sb.setSurgicalID(resultSet.getLong("SurgicalID"));
                sb.setPatientID(resultSet.getLong("PatientID"));
                sb.setDate(resultSet.getTimestamp("Date"));
                sb.setSurgicalProcedure(resultSet.getString("SurgicalProcedure"));
                sb.setOperatingRoomFee(resultSet.getBigDecimal("OperatingRoomFee"));
                sb.setSurgeonFee(resultSet.getBigDecimal("SurgeonFee"));
                sb.setSurgicalSuppliesFee(resultSet.getBigDecimal("SurgicalSupplies"));

                rows.add(sb);
            }

            logger.info("Surgical records added to ArrayList, size: " + rows.size());

        }

        return rows;

    }

    /**
     * insert new record to surgical table
     *
     * @param o SurgicalBean object
     * @return return new record key
     * @throws SQLException
     */
    @Override
    public long insertRecord(Object o) throws SQLException {

        String sql = "insert into surgical (PatientID, Date, SurgicalProcedure, OperatingRoomFee, SurgeonFee, SurgicalSupplies) values (?,?,?,?,?,?)";
        long result = -1;
        SurgicalBean sb;

        try (PreparedStatement pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            sb = (SurgicalBean) o;

            pStatement.setLong(1, sb.getPatientID());
            pStatement.setTimestamp(2, sb.getDate());
            pStatement.setString(3, sb.getSurgicalProcedure());
            pStatement.setBigDecimal(4, sb.getOperatingRoomFee());
            pStatement.setBigDecimal(5, sb.getSurgeonFee());
            pStatement.setBigDecimal(6, sb.getSurgicalSuppliesFee());

            pStatement.executeUpdate();

            // Retrieve new primary key
            try (ResultSet rs = pStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    result = rs.getLong(1);
                }
            }
        }

        logger.info("New surgical record has been added, patient id: " + sb.getPatientID() + ", new surgical id: " + result);

        return result;
    }

    /**
     * update record on surgical table
     *
     * @param o SurgicalBean object
     * @return return affected rows number
     * @throws SQLException
     */
    @Override
    public long updateRecord(Object o) throws SQLException {

        String sql = "update surgical set Date = ?, SurgicalProcedure = ?, OperatingRoomFee = ?, SurgeonFee = ?, SurgicalSupplies = ?, PatientID = ? where SurgicalID = ?";
        long result = -1;
        SurgicalBean sb = (SurgicalBean) o;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);) {

            pStatement.setTimestamp(1, sb.getDate());
            pStatement.setString(2, sb.getSurgicalProcedure());
            pStatement.setBigDecimal(3, sb.getOperatingRoomFee());
            pStatement.setBigDecimal(4, sb.getSurgeonFee());
            pStatement.setBigDecimal(5, sb.getSurgicalSuppliesFee());
            pStatement.setLong(6, sb.getPatientID());
            pStatement.setLong(7, sb.getSurgicalID());

            result = pStatement.executeUpdate();
        }

        logger.info("Surgical record has been updated: surgical id " + sb.getSurgicalID() + ", " + result + " row(s) affected");

        return result;
    }

    /**
     * delete record from surgical table
     *
     * @param o SurgicalBean object
     * @return return affected rows number
     * @throws SQLException
     */
    @Override
    public long deleteRecord(Object o) throws SQLException {
        String sql = "delete from surgical where SurgicalID = ?";
        long result = -1;
        SurgicalBean sb = (SurgicalBean) o;

        try (PreparedStatement pStatement = connection.prepareStatement(sql);) {

            pStatement.setLong(1, sb.getSurgicalID());

            result = pStatement.executeUpdate();
        }

        logger.info("Surgical record has been deleted: surgical id " + sb.getSurgicalID() + ", " + result + " row(s) affected");

        return result;
    }
}
