package com.cejv456.jip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * C.R.U.D interface of JIP DAO
 *
 * @author Jianyu Feng
 */
public interface JipDAO {

    public ArrayList<Object> getRecords(String sql) throws SQLException;

    public long updateRecord(Object o) throws SQLException;

    public long insertRecord(Object o) throws SQLException;

    public long deleteRecord(Object o) throws SQLException;
}
