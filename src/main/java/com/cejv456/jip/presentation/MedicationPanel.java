package com.cejv456.jip.presentation;

import com.cejv456.jip.business.Common;
import com.cejv456.jip.dao.JipDAO;
import com.cejv456.jip.data.MedicationBean;
import com.cejv456.jip.model.DBTableModel;
import com.cejv456.jip.services.JipService;
import com.cejv456.jip.util.SwingValidator;
import static com.cejv456.jip.business.Common.*;
import com.cejv456.jip.util.JTextFieldLimit;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * create Medication Panel
 *
 * @author Jianyu Feng
 */
public class MedicationPanel extends javax.swing.JPanel implements JipPanel {

    //validator
    private SwingValidator sv;
    //search creteria
    private StringBuilder creteria;
    //medication dao, db table model & service
    private JipDAO medicationDAOImpl;
    private DBTableModel medicationTableModel;
    private JipService medicationService;
    //patient service
    private JipService patientService;
    //main frame
    private JipFrame jipFrame;
    //common icon
    private Common common;

    /**
     * Creates new form MedicationPanel
     *
     * @param jipFrame the main jip frame
     * @param patientService patient service
     * @param medicationDAOImpl medication dao
     * @param medicationTableModel medication db table model
     */
    public MedicationPanel(JipService patientService, JipDAO medicationDAOImpl, DBTableModel medicationTableModel, JipFrame jipFrame) {

        sv = new SwingValidator();
        creteria = new StringBuilder();
        this.medicationDAOImpl = medicationDAOImpl;
        this.medicationTableModel = medicationTableModel;
        this.patientService = patientService;
        medicationService = new JipService(medicationDAOImpl, medicationTableModel);
        this.jipFrame = jipFrame;
        common = new Common();

        initComponents();

        initTextFieldLimit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        medicationBeanPanel = new javax.swing.JPanel();
        actionMedicationButton = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        medicationPatientIDTextField = new javax.swing.JTextField();
        medicationTextField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        costPerUnitTextField = new javax.swing.JTextField();
        numberOfUnitsTextField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        medicationDateTextField = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        medicationPatientNameLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        medicationTable = new javax.swing.JTable();

        setName("Medication"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 500));

        medicationBeanPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Medication"));
        medicationBeanPanel.setName("Medication"); // NOI18N
        medicationBeanPanel.setPreferredSize(new java.awt.Dimension(597, 100));

        actionMedicationButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        actionMedicationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        actionMedicationButton.setText("Search");
        actionMedicationButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        actionMedicationButton.setMaximumSize(new java.awt.Dimension(80, 33));
        actionMedicationButton.setMinimumSize(new java.awt.Dimension(80, 33));
        actionMedicationButton.setPreferredSize(new java.awt.Dimension(80, 33));
        actionMedicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionMedicationButtonActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Patient ID");

        medicationPatientIDTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        medicationPatientIDTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                medicationPatientIDTextFieldKeyReleased(evt);
            }
        });

        medicationTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Medication");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Cost Per Unit");

        costPerUnitTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        numberOfUnitsTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Number of Units");

        medicationDateTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        medicationDateTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        medicationDateTextField.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Date");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/medication.png"))); // NOI18N
        jLabel16.setText("Medication");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        medicationPatientNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout medicationBeanPanelLayout = new javax.swing.GroupLayout(medicationBeanPanel);
        medicationBeanPanel.setLayout(medicationBeanPanelLayout);
        medicationBeanPanelLayout.setHorizontalGroup(
            medicationBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medicationBeanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(medicationBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(medicationBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(medicationBeanPanelLayout.createSequentialGroup()
                        .addGroup(medicationBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(actionMedicationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medicationDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(costPerUnitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberOfUnitsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medicationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(medicationBeanPanelLayout.createSequentialGroup()
                        .addComponent(medicationPatientIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(medicationPatientNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(medicationBeanPanelLayout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        medicationBeanPanelLayout.setVerticalGroup(
            medicationBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, medicationBeanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(medicationBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medicationPatientNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(medicationBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(medicationPatientIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(medicationBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medicationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(medicationBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(costPerUnitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(medicationBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(numberOfUnitsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(medicationBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(medicationDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(actionMedicationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16))
        );

        medicationTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        medicationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MedicationID", "PatientID", "Medication", "CostPerUnit", "NumberOfUnits", "Date"
            }
        ));
        medicationTable.setToolTipText("Double click to update the selected the record");
        medicationTable.setRowHeight(20);
        medicationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicationTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(medicationTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(medicationBeanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(medicationBeanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void actionMedicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionMedicationButtonActionPerformed

        MedicationBean mb = new MedicationBean();

        switch (actionMedicationButton.getText()) {
            case "Add":
                if (sv.isLong(medicationPatientIDTextField, "Patient ID")) {
                    mb.setPatientID(Long.valueOf(medicationPatientIDTextField.getText().trim()));
                    mb.setMedication(medicationTextField.getText().trim());

                    if (costPerUnitTextField.getText().trim().length() > 0) {
                        if (sv.isDouble(costPerUnitTextField, "Cost Per Unit")) {
                            mb.setCostPerUnit(new BigDecimal(costPerUnitTextField.getText().trim()));
                        } else {
                            break;
                        }
                    }

                    if (numberOfUnitsTextField.getText().trim().length() > 0) {
                        if (sv.isLong(numberOfUnitsTextField, "Number Of Units")) {
                            mb.setNumberOfUnits(Integer.valueOf(numberOfUnitsTextField.getText().trim()));
                        } else {
                            break;
                        }
                    }

                    mb.setDate(new Timestamp(new Date().getTime()));

                    // insert new record
                    Long newID = medicationService.insertRow(mb);

                    // update search creteria to allow the new record show up in the table
                    creteria.setLength(0);
                    creteria.append(" where patientID = ");
                    creteria.append(medicationPatientIDTextField.getText().trim());

                    // refresh table
                    refreshTable(medicationService, creteria, medicationTable, medicationTableModel);

                    //show message in status bar
                    jipFrame.showNotice(NEW_RECORD + " New Medication ID: " + newID);
                }
                break;
            case "Update":
                if (sv.isLong(medicationPatientIDTextField, "Patient ID") && (medicationDateTextField.getText().trim().length() == 0 || sv.isFullTimestamp(medicationDateTextField, "Date"))) {
                    mb.setMedicationID(((MedicationBean) medicationTableModel.getData(medicationTable.convertRowIndexToModel(medicationTable.getSelectedRow()))).getMedicationID());
                    mb.setPatientID(Long.valueOf(medicationPatientIDTextField.getText().trim()));
                    mb.setMedication(medicationTextField.getText().trim());

                    if (costPerUnitTextField.getText().trim().length() > 0) {
                        if (sv.isDouble(costPerUnitTextField, "Cost Per Unit")) {
                            mb.setCostPerUnit(new BigDecimal(costPerUnitTextField.getText().trim()));
                        } else {
                            break;
                        }
                    }

                    if (numberOfUnitsTextField.getText().trim().length() > 0) {
                        if (sv.isLong(numberOfUnitsTextField, "Number Of Units")) {
                            mb.setNumberOfUnits(Integer.valueOf(numberOfUnitsTextField.getText().trim()));
                        } else {
                            break;
                        }
                    }

                    if (medicationDateTextField.getText().trim().length() > 0) {
                        mb.setDate(Timestamp.valueOf(medicationDateTextField.getText().trim().replaceAll("/", "-")));
                    }

                    // update record
                    medicationService.updateRow(mb);

                    creteria.setLength(0);
                    creteria.append(" where MedicationID = ").append(mb.getMedicationID());

                    // refresh table
                    refreshTable(medicationService, creteria, medicationTable, medicationTableModel);

                    //show message in status bar
                    jipFrame.showNotice(UPDATE_RECORD + " Medication ID: " + mb.getMedicationID());

                    // switch to Search view
                    searchBeanPanel();
                }

                break;
            case "Search":

                // empty search creteria
                creteria.setLength(0);

                if (medicationPatientIDTextField.getText().trim().length() > 0 && sv.isLong(medicationPatientIDTextField, "Patient ID")) {
                    creteria.append(" and patientID = ");
                    creteria.append(medicationPatientIDTextField.getText().trim());
                }

                if (medicationTextField.getText().trim().length() > 0) {
                    creteria.append(" and Medication like '%");
                    creteria.append(medicationTextField.getText().trim().replaceAll("'", "''"));
                    creteria.append("%'");
                }

                if (costPerUnitTextField.getText().trim().length() > 0) {
                    creteria.append(" and CostPerUnit =");
                    creteria.append(costPerUnitTextField.getText().trim());
                }

                if (numberOfUnitsTextField.getText().trim().length() > 0) {
                    creteria.append(" and NumberOfUnits =");
                    creteria.append(numberOfUnitsTextField.getText().trim());
                }

                if (medicationDateTextField.getText().trim().length() > 0 && sv.isTimestamp(medicationDateTextField, "Date")) {
                    creteria.append(" and Date >= '");
                    creteria.append(medicationDateTextField.getText().trim().substring(0, 10));
                    creteria.append(" 00:00:00'");
                    creteria.append(" and Date <= '");
                    creteria.append(medicationDateTextField.getText().trim().substring(0, 10));
                    creteria.append(" 23:59:59'");

                    medicationDateTextField.setText(medicationDateTextField.getText().trim().substring(0, 10));
                }

                if (creteria.toString().length() > 0) {
                    creteria.insert(0, " where 1 = 1 ");
                }

                // refresh table
                refreshTable(medicationService, creteria, medicationTable, medicationTableModel);

                //show message in status bar
                jipFrame.showNotice(medicationTable.getRowCount() + " " + SEARCH_RECORD);

        }
    }//GEN-LAST:event_actionMedicationButtonActionPerformed

    private void medicationPatientIDTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_medicationPatientIDTextFieldKeyReleased
        showPatientName(patientService, medicationPatientIDTextField, medicationPatientNameLabel);
    }//GEN-LAST:event_medicationPatientIDTextFieldKeyReleased

    /**
     * enable or disable date text fields
     *
     * @param b boolean value
     */
    @Override
    public void toggleDateTextFields(boolean b) {
        medicationDateTextField.setEditable(b);
        medicationDateTextField.setEnabled(b);
    }

    /**
     * clear form fields in bean panel
     *
     */
    @Override
    public void clearFormFields() {
        medicationPatientIDTextField.setText("");
        medicationPatientNameLabel.setText("");
        medicationTextField.setText("");
        costPerUnitTextField.setText("");
        numberOfUnitsTextField.setText("");
        medicationDateTextField.setText("");
    }

    @Override
    public void deleteBean() {
        MedicationBean mb = ((MedicationBean) medicationTableModel.getData(medicationTable.convertRowIndexToModel(medicationTable.getSelectedRow())));

        Long result = medicationService.deleteRow(medicationTable.convertRowIndexToModel(medicationTable.getSelectedRow()));

        if (result >= 0) {
            //show message in status bar
            jipFrame.showNotice(DELETE_RECORD + " Medication ID: " + mb.getMedicationID());
        }
    }

    @Override
    public void addBeanPanel() {
        //load bean panel
        loadBeanPanelAction(medicationBeanPanel, actionMedicationButton, "Add", "Medication", common.getIcon("Add"));

        // activate ID Text Fields
        medicationPatientIDTextField.setEditable(true);

        //clear form fields
        clearFormFields();

        // enable date text fields
        toggleDateTextFields(false);
    }

    @Override
    public void searchBeanPanel() {
        //load bean panel
        loadBeanPanelAction(medicationBeanPanel, actionMedicationButton, "Search", "Medication", common.getIcon("Search"));

        // activate ID Text Fields
        medicationPatientIDTextField.setEditable(true);

        //clear form fields
        clearFormFields();

        // enable date text fields
        toggleDateTextFields(true);
    }

    @Override
    public void updateBeanPanel() {
        if (checkSelectedRow(medicationTable)) {
            //load bean panel
            loadBeanPanelAction(medicationBeanPanel, actionMedicationButton, "Update", "Medication", common.getIcon("Update"));

            // load medicationbean to the form fields
            MedicationBean mb = (MedicationBean) medicationTableModel.getData(medicationTable.convertRowIndexToModel(medicationTable.getSelectedRow()));
            medicationPatientIDTextField.setText(mb.getPatientID() + "");
            medicationTextField.setText(mb.getMedication());
            costPerUnitTextField.setText((mb.getCostPerUnit() == null) ? "" : mb.getCostPerUnit().toString());
            numberOfUnitsTextField.setText(mb.getNumberOfUnits() + "");
            medicationDateTextField.setText((mb.getDate() == null) ? "" : mb.getDate().toString().substring(0, 19));

            // enable date text fields
            toggleDateTextFields(true);

            // disable ID text fields
            medicationPatientIDTextField.setEditable(false);

            // show patient name
            showPatientName(patientService, medicationPatientIDTextField, medicationPatientNameLabel);
        }
    }

    /**
     * double click table event to update bean<br>
     * note, single click table just select the row and ready for action button
     * to perform
     *
     * @param evt
     */
    private void medicationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicationTableMouseClicked
        // double click event
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();

            updateBeanPanel();
        }
    }//GEN-LAST:event_medicationTableMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionMedicationButton;
    private javax.swing.JTextField costPerUnitTextField;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel medicationBeanPanel;
    private javax.swing.JTextField medicationDateTextField;
    private javax.swing.JTextField medicationPatientIDTextField;
    private javax.swing.JLabel medicationPatientNameLabel;
    private javax.swing.JTable medicationTable;
    private javax.swing.JTextField medicationTextField;
    private javax.swing.JTextField numberOfUnitsTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadPatientDetails(Long patientID, String patientName) {
        //switch to search view
        searchBeanPanel();

        //show patient id & name
        medicationPatientIDTextField.setText(patientID + "");
        medicationPatientNameLabel.setText(patientName);

        //click search action button
        actionMedicationButtonActionPerformed(null);

        loadBeanPanelAction(medicationBeanPanel, actionMedicationButton, "Add", "Medication", common.getIcon("Add"));

        // disable date text field, as we will use current datetime as input
        toggleDateTextFields(false);
    }

    @Override
    public void print() {
        printTable("Medication List", medicationTable);
    }

    /**
     * set the maximum length of all text fields
     *
     */
    private void initTextFieldLimit() {
        //medication panel
        medicationPatientIDTextField.setDocument(new JTextFieldLimit(11));
        medicationTextField.setDocument(new JTextFieldLimit(256));
        costPerUnitTextField.setDocument(new JTextFieldLimit(16));
        numberOfUnitsTextField.setDocument(new JTextFieldLimit(11));
        medicationDateTextField.setDocument(new JTextFieldLimit(19));
    }
}
