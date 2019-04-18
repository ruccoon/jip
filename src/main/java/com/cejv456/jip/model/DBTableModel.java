package com.cejv456.jip.model;

import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 * interface to load tableModel for JTable
 *
 * @author Jianyu Feng
 */
public interface DBTableModel extends TableModel {

    public void loadColumnNames();

    public int loadData(ArrayList<Object> al);

    @Override
    public int getRowCount();

    @Override
    public int getColumnCount();

    @Override
    public Object getValueAt(int row, int column);

    public Object getData(int row);

    public void deleteRow(int row);
}
