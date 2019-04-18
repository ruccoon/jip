package com.cejv456.jip.model;

import com.cejv456.jip.data.PatientBean;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this dbTableModel is used for JTable
 *
 * @author Jianyu Feng
 */
public class PatientDBTableModel extends AbstractTableModel implements DBTableModel {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private ArrayList<String> columnNames = new ArrayList<>();
    private ArrayList<PatientBean> data = new ArrayList<>();
    private DateFormat df;

    /**
     * Constructor
     */
    public PatientDBTableModel() {
        super();

        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

        logger.info("PatientDBTableModel instantiated");

    }

    /**
     * Load the column names data structure
     *
     * @return
     */
    @Override
    public void loadColumnNames() {

        columnNames.add("PatientID");
        columnNames.add("LastName");
        columnNames.add("FirstName");
        columnNames.add("Diagnosis");
        columnNames.add("AdmissionDate");
        columnNames.add("ReleaseDate");

    }

    /**
     * Given an arraylist load the model's data structure
     *
     * @param al
     * @return
     */
    @Override
    public int loadData(ArrayList<Object> al) {
        int rowCount = 0;

        PatientBean pb = new PatientBean();

        // clear all data firstly
        data.clear();

        for (int i = 0; i < al.size(); i++) {
            pb = (PatientBean) al.get(i);
            rowCount++;
            data.add(pb);
        }

        return rowCount;
    }

    /*
     * return jtable column count
     * 
     * @see javax.swing.table.TableModel#getColumnCount()
     */
    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    /*
     * return jtable column name
     * 
     * @see javax.swing.table.AbstractTableModel#getColumnName(int)
     */
    @Override
    public String getColumnName(int col) {
        return columnNames.get(col);
    }

    /*
     * return jtable row count
     * 
     * @see javax.swing.table.TableModel#getRowCount()
     */
    @Override
    public int getRowCount() {
        return data.size();
    }

    /*
     * return the cell at row & column 
     * 
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     */
    @Override
    public Object getValueAt(int row, int col) {

        switch (col) {
            case 0:
                return data.get(row).getPatientID();
            case 1:
                return data.get(row).getLastName();
            case 2:
                return data.get(row).getFirstName();
            case 3:
                return data.get(row).getDiagnosis();
            case 4:
                if (data.get(row).getAdmissionDate() != null) {
                    return df.format(data.get(row).getAdmissionDate());
                }
                break;
            case 5:
                if (data.get(row).getReleaseDate() != null) {
                    return df.format(data.get(row).getReleaseDate());
                }
                break;
        }
        // Should throw exception since this must never happen
        return null;
    }

    /**
     * Remove a selected row from the data structure and then tell the table
     * that the data has changed
     *
     * @param selectedRow
     */
    @Override
    public void deleteRow(int selectedRow) {
        data.remove(selectedRow);
        this.fireTableDataChanged();
    }

    /**
     * Return the bean object from a specific row
     *
     * @param row
     * @return
     */
    @Override
    public Object getData(int row) {
        return data.get(row);
    }
}
