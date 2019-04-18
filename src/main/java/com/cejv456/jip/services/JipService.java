package com.cejv456.jip.services;

import com.cejv456.jip.dao.JipDAO;
import com.cejv456.jip.model.DBTableModel;
import static com.cejv456.jip.business.Common.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This JipService will use JipDAO to load column & data to TableModel
 *
 * @author Jianyu Feng
 */
public class JipService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private DBTableModel dbTableModel = null;
    private JipDAO jipDAO;

    /**
     * Constructor with JipDAO & DBTableModel arguments
     *
     * @param jipDAO
     * @param dbTableModel
     */
    public JipService(JipDAO jipDAO, DBTableModel dbTableModel) {
        super();

        this.dbTableModel = dbTableModel;
        this.jipDAO = jipDAO;

    }
    
    /**
     * Fill the TableModel
     *
     * @param criteria
     *
     * @return true if data is available
     */
    public ArrayList<Object> getRecord(String criteria) {
        ArrayList<Object> al = null;
        
        try {
            // get records from db
            al = jipDAO.getRecords(criteria);

        } catch (SQLException ex) {
            logger.error(ex.toString());
        }

        return al;
    }

    /**
     * Fill the TableModel
     *
     * @param criteria
     *
     * @return true if data is available
     */
    public boolean fillTableModel(String criteria) {
        Boolean retVal = false;
        try {
            // get records from db
            ArrayList<Object> al = jipDAO.getRecords(criteria);

            dbTableModel.loadColumnNames();
            dbTableModel.loadData(al);

            retVal = true;

        } catch (SQLException ex) {
            logger.error(ex.toString());
        }

        return retVal;
    }

    /**
     * Insert new row to db
     *
     * @param o
     * @return
     */
    public long insertRow(Object o) {
        long result = -1;

        try {
            result = jipDAO.insertRecord(o);
            
            showMessage(null, NEW_RECORD, "info");
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }


        return result;
    }

    /**
     * Update row to db
     * 
     * @param o
     * @return 
     */
    public long updateRow(Object o) {
        long result = -1;

        try {
            // update record on db
            result = jipDAO.updateRecord(o);
            
            showMessage(null, UPDATE_RECORD, "info");            
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }


        return result;
    }

    /**
     * Delete the selected row from the database and call on the table model to
     * remove that row
     *
     * @param selectedRow
     */
    public long deleteRow(int selectedRow) {

        long result = -1;

        Object pb;

        if (selectedRow > -1) {
            if (JOptionPane.showConfirmDialog(null, CONFIRM_DELETE, null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                pb = dbTableModel.getData(selectedRow);

                try {

                    // delete record from db
                    result = jipDAO.deleteRecord(pb);

                    // delete record from jtable
                    dbTableModel.deleteRow(selectedRow);

                    showMessage(null, DELETE_RECORD, "info");
                } catch (SQLException ex) {
                    logger.error("Cannot delete the patient if there any inpatient, surgical or mediation record linked with that.", ex);

                    showMessage(null, CANNOT_DELETE, "error");
                }
            }

        } else {
            showMessage(null, SELECT_DELETE_RECORD, "error");
        }

        return result;
    }

    /**
     * show alert message
     *
     * @param j
     * @param message
     */
    public void showMessage(JComponent j, String message, String type) {
        switch (type) {
            case "error":
                JOptionPane.showMessageDialog(j, message, null, JOptionPane.ERROR_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(j, message, null, JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
