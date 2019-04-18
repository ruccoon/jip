package com.cejv456.jip.presentation;

import com.cejv456.jip.business.Common;
import com.cejv456.jip.dao.JipDAO;
import com.cejv456.jip.data.InpatientBean;
import com.cejv456.jip.model.DBTableModel;
import com.cejv456.jip.services.JipService;
import com.cejv456.jip.util.SwingValidator;
import static com.cejv456.jip.business.Common.*;
import com.cejv456.jip.util.JTextFieldLimit;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * create Inpatient panel
 *
 * @author Jianyu Feng
 */
public class InpatientPanel extends javax.swing.JPanel implements JipPanel {

    //validator
    private SwingValidator sv;
    //search creteria
    private StringBuilder creteria;
    //inpatient dao, db table model & service
    private JipDAO inpatientDAOImpl;
    private DBTableModel inpatientTableModel;
    private JipService inpatientService;
    //patient service
    private JipService patientService;
    //main frame
    private JipFrame jipFrame;
    //common icon
    private Common common;

    /**
     * Creates new form InpatientPanel
     */
    public InpatientPanel(JipService patientService, JipDAO inpatientDAOImpl, DBTableModel inpatientTableModel, JipFrame jipFrame) {
        sv = new SwingValidator();
        creteria = new StringBuilder();
        this.inpatientDAOImpl = inpatientDAOImpl;
        this.inpatientTableModel = inpatientTableModel;
        this.patientService = patientService;
        inpatientService = new JipService(inpatientDAOImpl, inpatientTableModel);
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

        inpatientBeanPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        roomNumberTextField = new javax.swing.JTextField();
        inpatientDateTextField = new javax.swing.JTextField();
        actionInpatientButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        dailyRoomRateTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        roomSuppliesTextField = new javax.swing.JTextField();
        roomServicesTextField = new javax.swing.JTextField();
        inpatientPatientIDTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        inpatientPatientNameLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inpatientTable = new javax.swing.JTable();

        setName("Inpatient"); // NOI18N

        inpatientBeanPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Inpatient"));
        inpatientBeanPanel.setName("Inpatient"); // NOI18N
        inpatientBeanPanel.setPreferredSize(new java.awt.Dimension(597, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Patient ID");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Room Number");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Date");

        roomNumberTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        roomNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberTextFieldActionPerformed(evt);
            }
        });

        inpatientDateTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inpatientDateTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        inpatientDateTextField.setPreferredSize(new java.awt.Dimension(100, 20));

        actionInpatientButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        actionInpatientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        actionInpatientButton.setText("Search");
        actionInpatientButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        actionInpatientButton.setMaximumSize(new java.awt.Dimension(80, 33));
        actionInpatientButton.setMinimumSize(new java.awt.Dimension(80, 33));
        actionInpatientButton.setPreferredSize(new java.awt.Dimension(80, 33));
        actionInpatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionInpatientButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Daily Room Rate");

        dailyRoomRateTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Room Supplies Fee");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Room Services Fee");

        roomSuppliesTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        roomServicesTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        inpatientPatientIDTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inpatientPatientIDTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inpatientPatientIDTextFieldKeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inpatient.png"))); // NOI18N
        jLabel27.setText("Inpatient");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        inpatientPatientNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout inpatientBeanPanelLayout = new javax.swing.GroupLayout(inpatientBeanPanel);
        inpatientBeanPanel.setLayout(inpatientBeanPanelLayout);
        inpatientBeanPanelLayout.setHorizontalGroup(
            inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inpatientBeanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel18)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inpatientBeanPanelLayout.createSequentialGroup()
                        .addGroup(inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(actionInpatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inpatientDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomServicesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dailyRoomRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomSuppliesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(inpatientBeanPanelLayout.createSequentialGroup()
                        .addComponent(inpatientPatientIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inpatientPatientNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(inpatientBeanPanelLayout.createSequentialGroup()
                .addComponent(jLabel27)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        inpatientBeanPanelLayout.setVerticalGroup(
            inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inpatientBeanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(inpatientPatientIDTextField))
                    .addComponent(inpatientPatientNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dailyRoomRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(roomSuppliesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(roomServicesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inpatientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(inpatientDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(actionInpatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jLabel27))
        );

        inpatientTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inpatientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "InpatientID", "PatientID", "RoomNumber", "DailyRoomRate", "RoomSupplies", "RoomServices", "Date"
            }
        ));
        inpatientTable.setToolTipText("Double click to update the selected the record");
        inpatientTable.setRowHeight(20);
        inpatientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inpatientTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(inpatientTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(inpatientBeanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
            .addComponent(inpatientBeanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void roomNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumberTextFieldActionPerformed

    private void actionInpatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionInpatientButtonActionPerformed

        InpatientBean ib = new InpatientBean();

        switch (actionInpatientButton.getText()) {
            case "Add":
                if (sv.isLong(inpatientPatientIDTextField, "Patient ID")) {
                    ib.setPatientID(Long.valueOf(inpatientPatientIDTextField.getText().trim()));
                    ib.setRoomNumber(roomNumberTextField.getText().trim());

                    if (dailyRoomRateTextField.getText().trim().length() > 0) {
                        if (sv.isDouble(dailyRoomRateTextField, "Daily Room Rate")) {
                            ib.setDailyRoomRate(new BigDecimal(dailyRoomRateTextField.getText().trim()));
                        } else {
                            break;
                        }
                    }

                    if (roomServicesTextField.getText().trim().length() > 0) {
                        if (sv.isDouble(roomServicesTextField, "Room Services")) {
                            ib.setRoomServicesFee(new BigDecimal(roomServicesTextField.getText().trim()));
                        } else {
                            break;
                        }
                    }

                    if (roomSuppliesTextField.getText().trim().length() > 0) {
                        if (sv.isDouble(roomSuppliesTextField, "Room Supplies")) {
                            ib.setRoomSuppliesFee(new BigDecimal(roomSuppliesTextField.getText().trim()));
                        } else {
                            break;
                        }
                    }

                    ib.setDate(new Timestamp(new Date().getTime()));

                    // insert new record
                    Long newID = inpatientService.insertRow(ib);

                    // update search creteria to allow the new record show up in the table
                    creteria.setLength(0);
                    creteria.append(" where patientID = ");
                    creteria.append(inpatientPatientIDTextField.getText().trim());

                    // refresh table
                    refreshTable(inpatientService, creteria, inpatientTable, inpatientTableModel);

                    //show message in status bar
                    jipFrame.showNotice(NEW_RECORD + " New Inpatient ID: " + newID);
                }
                break;
            case "Update":
                if (sv.isLong(inpatientPatientIDTextField, "Patient ID") && (inpatientDateTextField.getText().trim().length() == 0 || sv.isFullTimestamp(inpatientDateTextField, "Date"))) {

                    ib.setInpatientID(((InpatientBean) inpatientTableModel.getData(inpatientTable.convertRowIndexToModel(inpatientTable.getSelectedRow()))).getInpatientID());
                    ib.setPatientID(Long.valueOf(inpatientPatientIDTextField.getText().trim()));
                    ib.setRoomNumber(roomNumberTextField.getText().trim());

                    if (dailyRoomRateTextField.getText().trim().length() > 0) {
                        if (sv.isDouble(dailyRoomRateTextField, "Daily Room Rate")) {
                            ib.setDailyRoomRate(new BigDecimal(dailyRoomRateTextField.getText().trim()));
                        } else {
                            break;
                        }
                    }

                    if (roomServicesTextField.getText().trim().length() > 0) {
                        if (sv.isDouble(roomServicesTextField, "Room Services")) {
                            ib.setRoomServicesFee(new BigDecimal(roomServicesTextField.getText().trim()));
                        } else {
                            break;
                        }
                    }

                    if (roomSuppliesTextField.getText().trim().length() > 0) {
                        if (sv.isDouble(roomSuppliesTextField, "Room Supplies")) {
                            ib.setRoomSuppliesFee(new BigDecimal(roomSuppliesTextField.getText().trim()));
                        } else {
                            break;
                        }
                    }

                    if (inpatientDateTextField.getText().trim().length() > 0) {
                        ib.setDate(Timestamp.valueOf(inpatientDateTextField.getText().trim().replaceAll("/", "-")));
                    }

                    // update record
                    inpatientService.updateRow(ib);

                    creteria.setLength(0);
                    creteria.append(" where InpatientID = ").append(ib.getInpatientID());

                    // refresh table
                    refreshTable(inpatientService, creteria, inpatientTable, inpatientTableModel);

                    //show message in status bar
                    jipFrame.showNotice(UPDATE_RECORD + " Inpatient ID: " + ib.getInpatientID());

                    // switch to Search view
                    searchBeanPanel();
                }

                break;
            case "Search":

                // empty search creteria
                creteria.setLength(0);

                if (inpatientPatientIDTextField.getText().trim().length() > 0 && sv.isLong(inpatientPatientIDTextField, "Patient ID")) {
                    creteria.append(" and patientID = ");
                    creteria.append(inpatientPatientIDTextField.getText().trim());
                }

                if (roomNumberTextField.getText().trim().length() > 0) {
                    creteria.append(" and RoomNumber like '%");
                    creteria.append(roomNumberTextField.getText().trim().replaceAll("'", "''"));
                    creteria.append("%'");
                }

                if (dailyRoomRateTextField.getText().trim().length() > 0) {
                    creteria.append(" and DailyRoomRate =");
                    creteria.append(dailyRoomRateTextField.getText().trim());
                }

                if (roomSuppliesTextField.getText().trim().length() > 0) {
                    creteria.append(" and RoomSupplies =");
                    creteria.append(roomSuppliesTextField.getText().trim());
                }

                if (roomServicesTextField.getText().trim().length() > 0) {
                    creteria.append(" and RoomServices =");
                    creteria.append(roomServicesTextField.getText().trim());
                }

                if (inpatientDateTextField.getText().trim().length() > 0 && sv.isTimestamp(inpatientDateTextField, "Date")) {
                    creteria.append(" and Date >= '");
                    creteria.append(inpatientDateTextField.getText().trim().substring(0, 10));
                    creteria.append(" 00:00:00'");
                    creteria.append(" and Date <= '");
                    creteria.append(inpatientDateTextField.getText().trim().substring(0, 10));
                    creteria.append(" 23:59:59'");

                    inpatientDateTextField.setText(inpatientDateTextField.getText().trim().substring(0, 10));
                }

                if (creteria.toString().length() > 0) {
                    creteria.insert(0, " where 1 = 1 ");
                }

                // refresh table
                refreshTable(inpatientService, creteria, inpatientTable, inpatientTableModel);

                //show message in status bar
                jipFrame.showNotice(inpatientTable.getRowCount() + " " + SEARCH_RECORD);

        }
    }//GEN-LAST:event_actionInpatientButtonActionPerformed

    private void inpatientPatientIDTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inpatientPatientIDTextFieldKeyReleased
        showPatientName(patientService, inpatientPatientIDTextField, inpatientPatientNameLabel);
    }//GEN-LAST:event_inpatientPatientIDTextFieldKeyReleased

    private void inpatientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inpatientTableMouseClicked
        // double click event
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();

            updateBeanPanel();
        }
    }//GEN-LAST:event_inpatientTableMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionInpatientButton;
    private javax.swing.JTextField dailyRoomRateTextField;
    private javax.swing.JPanel inpatientBeanPanel;
    private javax.swing.JTextField inpatientDateTextField;
    private javax.swing.JTextField inpatientPatientIDTextField;
    private javax.swing.JLabel inpatientPatientNameLabel;
    private javax.swing.JTable inpatientTable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField roomNumberTextField;
    private javax.swing.JTextField roomServicesTextField;
    private javax.swing.JTextField roomSuppliesTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void toggleDateTextFields(boolean b) {
        inpatientDateTextField.setEditable(b);
        inpatientDateTextField.setEnabled(b);
    }

    @Override
    public void clearFormFields() {
        inpatientPatientIDTextField.setText("");
        inpatientPatientNameLabel.setText("");
        roomNumberTextField.setText("");
        dailyRoomRateTextField.setText("");
        roomSuppliesTextField.setText("");
        roomServicesTextField.setText("");
        inpatientDateTextField.setText("");
    }

    @Override
    public void deleteBean() {
        InpatientBean ib = ((InpatientBean) inpatientTableModel.getData(inpatientTable.convertRowIndexToModel(inpatientTable.getSelectedRow())));

        Long result = inpatientService.deleteRow(inpatientTable.convertRowIndexToModel(inpatientTable.getSelectedRow()));

        if (result >= 0) {
            //show message in status bar
            jipFrame.showNotice(DELETE_RECORD + " Inpatient ID: " + ib.getInpatientID());
        }
    }

    @Override
    public void addBeanPanel() {
        //load bean panel
        loadBeanPanelAction(inpatientBeanPanel, actionInpatientButton, "Add", "Inpatient", common.getIcon("Add"));

        // activate ID Text Fields
        inpatientPatientIDTextField.setEditable(true);

        //clear form fields
        clearFormFields();

        // enable date text fields
        toggleDateTextFields(false);
    }

    @Override
    public void searchBeanPanel() {
        //load bean panel
        loadBeanPanelAction(inpatientBeanPanel, actionInpatientButton, "Search", "Inpatient", common.getIcon("Search"));

        // activate ID Text Fields
        inpatientPatientIDTextField.setEditable(true);

        //clear form fields
        clearFormFields();

        // enable date text fields
        toggleDateTextFields(true);
    }

    @Override
    public void updateBeanPanel() {
        if (checkSelectedRow(inpatientTable)) {
            loadBeanPanelAction(inpatientBeanPanel, actionInpatientButton, "Update", "Inpatient", common.getIcon("Update"));

            // load inpatientbean to the form fields
            InpatientBean ib = (InpatientBean) inpatientTableModel.getData(inpatientTable.convertRowIndexToModel(inpatientTable.getSelectedRow()));
            inpatientPatientIDTextField.setText(ib.getPatientID() + "");
            roomNumberTextField.setText(ib.getRoomNumber());

            dailyRoomRateTextField.setText((ib.getDailyRoomRate() == null) ? "" : ib.getDailyRoomRate().toString());
            roomSuppliesTextField.setText((ib.getRoomSuppliesFee() == null) ? "" : ib.getRoomSuppliesFee().toString());
            roomServicesTextField.setText((ib.getRoomServicesFee() == null) ? "" : ib.getRoomServicesFee().toString());

            inpatientDateTextField.setText((ib.getDate() == null) ? "" : ib.getDate().toString().substring(0, 19));

            // enable date text fields
            toggleDateTextFields(true);

            // disable ID text fields
            inpatientPatientIDTextField.setEditable(false);

            // show patient name
            showPatientName(patientService, inpatientPatientIDTextField, inpatientPatientNameLabel);
        }
    }

    @Override
    public void loadPatientDetails(Long patientID, String patientName) {
        //switch to search view
        searchBeanPanel();

        //show patient id & name
        inpatientPatientIDTextField.setText(patientID + "");
        inpatientPatientNameLabel.setText(patientName);

        //click search action button
        actionInpatientButtonActionPerformed(null);

        loadBeanPanelAction(inpatientBeanPanel, actionInpatientButton, "Add", "Inpatient", common.getIcon("Add"));

        // disable date text field, as we will use current datetime as input
        toggleDateTextFields(false);
    }

    @Override
    public void print() {
        printTable("Inpatient List", inpatientTable);
    }

    /**
     * set the maximum length of all text fields
     *
     */
    private void initTextFieldLimit() {
        //inpatient panel
        inpatientPatientIDTextField.setDocument(new JTextFieldLimit(11));
        roomNumberTextField.setDocument(new JTextFieldLimit(45));
        dailyRoomRateTextField.setDocument(new JTextFieldLimit(16));
        roomSuppliesTextField.setDocument(new JTextFieldLimit(16));
        roomServicesTextField.setDocument(new JTextFieldLimit(16));
        inpatientDateTextField.setDocument(new JTextFieldLimit(19));
    }
}