package com.cejv456.jip.model;

import com.cejv456.jip.data.MedicationBean;
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
public class MedicationDBTableModel extends AbstractTableModel implements DBTableModel {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private ArrayList<String> columnNames = new ArrayList<>();
    private ArrayList<MedicationBean> data = new ArrayList<>();
    private DateFormat df;

    /**
     * Constructor
     */
    public MedicationDBTableModel() {
        super();

        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

        logger.info("MedicationDBTableModel instantiated");

    }

    /**
     * Load the column names data structure
     *
     * @return
     */
    @Override
    public void loadColumnNames() {

        columnNames.add("MedicationID");
        columnNames.add("PatientID");
        columnNames.add("Medication");
        columnNames.add("CostPerUnit");
        columnNames.add("NumberOfUnits");
        columnNames.add("Date");

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

        MedicationBean mb = new MedicationBean();

        // clear all data firstly
        data.clear();

        for (int i = 0; i < al.size(); i++) {
            mb = (MedicationBean) al.get(i);
            rowCount++;
            data.add(mb);
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
                return data.get(row).getMedicationID();
            case 1:
                return data.get(row).getPatientID();
            case 2:
                return data.get(row).getMedication();
            case 3:
                return data.get(row).getCostPerUnit();
            case 4:
                return data.get(row).getNumberOfUnits();
            case 5:
                if (data.get(row).getDate() != null) {
                    return df.format(data.get(row).getDate());
                }
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
     * Return the bean from a specific row
     *
     * @param row
     * @return
     */
    @Override
    public Object getData(int row) {
        return data.get(row);
    }
}
