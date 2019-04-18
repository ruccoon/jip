package com.cejv456.jip.presentation;

import com.cejv456.jip.business.Common;
import com.cejv456.jip.dao.JipDAO;
import com.cejv456.jip.data.PatientBean;
import com.cejv456.jip.model.DBTableModel;
import com.cejv456.jip.services.JipService;
import com.cejv456.jip.util.SwingValidator;
import static com.cejv456.jip.business.Common.*;
import com.cejv456.jip.util.JTextFieldLimit;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jianyu Feng
 */
public class PatientPanel extends javax.swing.JPanel implements JipPanel {

    //validator
    private SwingValidator sv;
    //search creteria
    private StringBuilder creteria;
    //patient dao, db table model & service
    private JipDAO patientDAOImpl;
    private DBTableModel patientTableModel;
    private JipService patientService;
    //sub panel
    private InpatientPanel inpatientPanel;
    private SurgicalPanel surgicalPanel;
    private MedicationPanel medicationPanel;
    //main frame
    private JipFrame jipFrame;
    //common icon
    private Common common;
// report panel
    //private ReportDialog reportDialog;
    //private PatientReport patientReport;

    /**
     * Creates new form PatientPanel
     */
    public PatientPanel(JipDAO patientDAOImpl, DBTableModel patientTableModel, InpatientPanel inpatientPanel, SurgicalPanel surgicalPanel, MedicationPanel medicationPanel, JipFrame jipFrame) {
        sv = new SwingValidator();
        creteria = new StringBuilder();
        this.patientDAOImpl = patientDAOImpl;
        this.patientTableModel = patientTableModel;
        this.patientService = new JipService(patientDAOImpl, patientTableModel);
        this.inpatientPanel = inpatientPanel;
        this.surgicalPanel = surgicalPanel;
        this.medicationPanel = medicationPanel;
        this.jipFrame = jipFrame;
        common = new Common();

        //reportDialog = new ReportDialog(this, true);

        //patientReport = new PatientReport();

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

        patientBeanPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        admissionDateTextField = new javax.swing.JTextField();
        releaseDateTextField = new javax.swing.JTextField();
        actionPatientButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        diagnosisTextField = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        patientIDTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        patientButtonPanel = new javax.swing.JPanel();
        patientInpatientButton = new javax.swing.JButton();
        patientSurgicalButton = new javax.swing.JButton();
        patientMedicationButton = new javax.swing.JButton();
        patientReleaseButton = new javax.swing.JButton();
        patientReportButton = new javax.swing.JButton();

        setName("Patient"); // NOI18N

        patientBeanPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Patient"));
        patientBeanPanel.setToolTipText("");
        patientBeanPanel.setName("Patient"); // NOI18N
        patientBeanPanel.setPreferredSize(new java.awt.Dimension(597, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("First Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Last Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Diagnosis");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Admission Date");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Release Date");

        lastNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lastNameTextField.setToolTipText("");
        lastNameTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        lastNameTextField.setPreferredSize(new java.awt.Dimension(100, 20));

        firstNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        firstNameTextField.setToolTipText("");
        firstNameTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        firstNameTextField.setPreferredSize(new java.awt.Dimension(100, 20));

        admissionDateTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        admissionDateTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        admissionDateTextField.setPreferredSize(new java.awt.Dimension(100, 20));

        releaseDateTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        releaseDateTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        releaseDateTextField.setPreferredSize(new java.awt.Dimension(100, 20));

        actionPatientButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        actionPatientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        actionPatientButton.setText("Search");
        actionPatientButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        actionPatientButton.setMaximumSize(new java.awt.Dimension(80, 33));
        actionPatientButton.setMinimumSize(new java.awt.Dimension(80, 33));
        actionPatientButton.setPreferredSize(new java.awt.Dimension(80, 33));
        actionPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPatientButtonActionPerformed(evt);
            }
        });

        diagnosisTextField.setColumns(20);
        diagnosisTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        diagnosisTextField.setRows(5);
        jScrollPane5.setViewportView(diagnosisTextField);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Patient ID");

        patientIDTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patient.png"))); // NOI18N
        jLabel4.setText("Patient");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout patientBeanPanelLayout = new javax.swing.GroupLayout(patientBeanPanel);
        patientBeanPanel.setLayout(patientBeanPanelLayout);
        patientBeanPanelLayout.setHorizontalGroup(
            patientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientBeanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patientBeanPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(patientBeanPanelLayout.createSequentialGroup()
                        .addGroup(patientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(actionPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lastNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(admissionDateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(releaseDateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(patientIDTextField))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(patientBeanPanelLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        patientBeanPanelLayout.setVerticalGroup(
            patientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientBeanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(patientIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(admissionDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientBeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(releaseDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(actionPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        patientTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PatientID", "LastName", "FirstName", "Diagnosis", "AdmissionDate", "ReleaseDate"
            }
        ));
        patientTable.setToolTipText("Double click to update the selected the record");
        patientTable.setRowHeight(20);
        patientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patientTable);

        patientInpatientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/patientInpatient.png"))); // NOI18N
        patientInpatientButton.setToolTipText("Edit the selected patient's inpatient record");
        patientInpatientButton.setFocusable(false);
        patientInpatientButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientInpatientButton.setMaximumSize(new java.awt.Dimension(83, 40));
        patientInpatientButton.setMinimumSize(new java.awt.Dimension(83, 40));
        patientInpatientButton.setPreferredSize(new java.awt.Dimension(83, 40));
        patientInpatientButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        patientInpatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientInpatientButtonActionPerformed(evt);
            }
        });

        patientSurgicalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/patientSurgical.png"))); // NOI18N
        patientSurgicalButton.setToolTipText("Edit the selected patient's surgical record");
        patientSurgicalButton.setFocusable(false);
        patientSurgicalButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientSurgicalButton.setMaximumSize(new java.awt.Dimension(83, 40));
        patientSurgicalButton.setMinimumSize(new java.awt.Dimension(83, 40));
        patientSurgicalButton.setPreferredSize(new java.awt.Dimension(83, 40));
        patientSurgicalButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        patientSurgicalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientSurgicalButtonActionPerformed(evt);
            }
        });

        patientMedicationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/patientMedication.png"))); // NOI18N
        patientMedicationButton.setToolTipText("Edit the selected patient's medication record");
        patientMedicationButton.setFocusable(false);
        patientMedicationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientMedicationButton.setMaximumSize(new java.awt.Dimension(83, 40));
        patientMedicationButton.setMinimumSize(new java.awt.Dimension(83, 40));
        patientMedicationButton.setPreferredSize(new java.awt.Dimension(83, 40));
        patientMedicationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        patientMedicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientMedicationButtonActionPerformed(evt);
            }
        });

        patientReleaseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/replease.png"))); // NOI18N
        patientReleaseButton.setText("Release");
        patientReleaseButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        patientReleaseButton.setMaximumSize(new java.awt.Dimension(83, 40));
        patientReleaseButton.setMinimumSize(new java.awt.Dimension(83, 40));
        patientReleaseButton.setPreferredSize(new java.awt.Dimension(83, 40));
        patientReleaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientReleaseButtonActionPerformed(evt);
            }
        });

        patientReportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/jipReport.png"))); // NOI18N
        patientReportButton.setText("Report");
        patientReportButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        patientReportButton.setMaximumSize(new java.awt.Dimension(83, 40));
        patientReportButton.setMinimumSize(new java.awt.Dimension(83, 40));
        patientReportButton.setPreferredSize(new java.awt.Dimension(83, 40));
        patientReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientReportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientButtonPanelLayout = new javax.swing.GroupLayout(patientButtonPanel);
        patientButtonPanel.setLayout(patientButtonPanelLayout);
        patientButtonPanelLayout.setHorizontalGroup(
            patientButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientButtonPanelLayout.createSequentialGroup()
                .addComponent(patientInpatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(patientSurgicalButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(patientMedicationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(patientReleaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(patientReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        patientButtonPanelLayout.setVerticalGroup(
            patientButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientButtonPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(patientButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientSurgicalButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientMedicationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientInpatientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(patientButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(patientReleaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(patientReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(patientBeanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(patientButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(patientBeanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void actionPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionPatientButtonActionPerformed

        PatientBean pb = new PatientBean();

        switch (actionPatientButton.getText()) {
            case "Add":
                pb.setFirstName(firstNameTextField.getText().trim());
                pb.setLastName(lastNameTextField.getText().trim());
                pb.setDiagnosis(diagnosisTextField.getText().trim());
                pb.setAdmissionDate(new Timestamp(new Date().getTime()));

                //insert new record
                Long newID = patientService.insertRow(pb);

                // update search creteria to allow the new record show up in the table
                creteria.setLength(0);
                creteria.append(" where FirstName = '");
                creteria.append(firstNameTextField.getText().trim().replaceAll("'", "''"));
                creteria.append("'");
                creteria.append(" and LastName = '");
                creteria.append(lastNameTextField.getText().trim().replaceAll("'", "''"));
                creteria.append("'");
                creteria.append(" and Diagnosis = '");
                creteria.append(diagnosisTextField.getText().trim().replaceAll("'", "''"));
                creteria.append("'");

                // refresh table
                refreshTable(patientService, creteria, patientTable, patientTableModel);

                //show message in status bar
                jipFrame.showNotice(NEW_RECORD + " New Patient ID: " + newID);

                break;
            case "Update":
                pb.setPatientID(Long.valueOf(patientIDTextField.getText().trim()));
                pb.setFirstName(firstNameTextField.getText().trim());
                pb.setLastName(lastNameTextField.getText().trim());
                pb.setDiagnosis(diagnosisTextField.getText().trim());
                if (admissionDateTextField.getText().trim().length() > 0) {
                    if (sv.isFullTimestamp(admissionDateTextField, "Admission Date")) {
                        pb.setAdmissionDate(Timestamp.valueOf(admissionDateTextField.getText().trim().replaceAll("/", "-")));
                    } else {
                        break;
                    }
                }
                if (releaseDateTextField.getText().trim().length() > 0) {
                    if (sv.isFullTimestamp(releaseDateTextField, "Release Date")) {
                        pb.setReleaseDate(Timestamp.valueOf(releaseDateTextField.getText().trim().replaceAll("/", "-")));
                    } else {
                        break;
                    }
                }
                // update patient bean
                patientService.updateRow(pb);

                creteria.setLength(0);
                creteria.append(" where PatientID = ").append(pb.getPatientID());

                // refresh table
                refreshTable(patientService, creteria, patientTable, patientTableModel);

                //show message in status bar
                jipFrame.showNotice(UPDATE_RECORD + " Patient: " + pb.getFirstName() + " " + pb.getLastName());

                // switch to Search view
                searchBeanPanel();

                break;

            case "Search":

                // empty search creteria
                creteria.setLength(0);

                if (patientIDTextField.getText().trim().length() > 0) {
                    if (sv.isLong(patientIDTextField, "Patient ID")) {
                        creteria.append(" and patientID = ");
                        creteria.append(patientIDTextField.getText().trim());
                    } else {
                        break;
                    }
                }

                if (firstNameTextField.getText().trim().length() > 0) {
                    creteria.append(" and FirstName like '%");
                    creteria.append(firstNameTextField.getText().trim().replaceAll("'", "''"));
                    creteria.append("%'");
                }

                if (lastNameTextField.getText().trim().length() > 0) {
                    creteria.append(" and LastName like '%");
                    creteria.append(lastNameTextField.getText().trim().replaceAll("'", "''"));
                    creteria.append("%'");
                }

                if (diagnosisTextField.getText().trim().length() > 0) {
                    creteria.append(" and Diagnosis like '%");
                    creteria.append(diagnosisTextField.getText().trim().replaceAll("'", "''"));
                    creteria.append("%'");
                }

                if (admissionDateTextField.getText().trim().length() > 0 && sv.isTimestamp(admissionDateTextField, "Admission Date")) {
                    creteria.append(" and AdmissionDate >= '");
                    creteria.append(admissionDateTextField.getText().trim().substring(0, 10));
                    creteria.append(" 00:00:00'");
                    creteria.append(" and AdmissionDate <= '");
                    creteria.append(admissionDateTextField.getText().trim().substring(0, 10));
                    creteria.append(" 23:59:59'");

                    admissionDateTextField.setText(admissionDateTextField.getText().trim().substring(0, 10));
                }

                if (releaseDateTextField.getText().trim().length() > 0 && sv.isTimestamp(releaseDateTextField, "Release Date")) {
                    creteria.append(" and ReleaseDate >= '");
                    creteria.append(releaseDateTextField.getText().trim().substring(0, 10));
                    creteria.append(" 00:00:00'");
                    creteria.append(" and ReleaseDate <= '");
                    creteria.append(releaseDateTextField.getText().trim().substring(0, 10));
                    creteria.append(" 23:59:59'");

                    releaseDateTextField.setText(releaseDateTextField.getText().trim().substring(0, 10));
                }

                if (creteria.toString().length() > 0) {
                    creteria.insert(0, " where 1 = 1 ");
                }

                refreshTable(patientService, creteria, patientTable, patientTableModel);

                //show message in status bar
                jipFrame.showNotice(patientTable.getRowCount() + " " + SEARCH_RECORD);

                break; // end search
        }
    }//GEN-LAST:event_actionPatientButtonActionPerformed

    private void patientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientTableMouseClicked
        // double click event
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();

            updateBeanPanel();
        }
    }//GEN-LAST:event_patientTableMouseClicked

    private void patientInpatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientInpatientButtonActionPerformed
        // load inpatient panel & set patient id
        patientRecordActionPerformed(inpatientPanel, inpatientPanel);
    }//GEN-LAST:event_patientInpatientButtonActionPerformed

    private void patientSurgicalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientSurgicalButtonActionPerformed
        // load surgical panel & set patient id
        patientRecordActionPerformed(surgicalPanel, surgicalPanel);
    }//GEN-LAST:event_patientSurgicalButtonActionPerformed

    private void patientMedicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientMedicationButtonActionPerformed
        // load medication panel & set patient id
        patientRecordActionPerformed(medicationPanel, medicationPanel);
    }//GEN-LAST:event_patientMedicationButtonActionPerformed

    private void patientReleaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientReleaseButtonActionPerformed
        if (checkSelectedRow(patientTable)) {
            // load patient bean to the form field
            PatientBean pb = (PatientBean) patientTableModel.getData(patientTable.getSelectedRow());

            if (pb.getReleaseDate() == null) {
                // release patient
                pb.setReleaseDate(new Timestamp(new Date().getTime()));

                // update patient bean
                patientService.updateRow(pb);

                // refresh table
                refreshTable(patientService, creteria, patientTable, patientTableModel);
            } else {
                JOptionPane.showMessageDialog(this, ALREADY_RELEASE, null, JOptionPane.ERROR_MESSAGE);
                
            }
        }
    }//GEN-LAST:event_patientReleaseButtonActionPerformed

    private void patientReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientReportButtonActionPerformed
        if (checkSelectedRow(patientTable)) {

            // load patientID to the form field
            PatientBean pb = (PatientBean) patientTableModel.getData(patientTable.getSelectedRow());

            // generate report
            jipFrame.patientReport.setPb(pb);

            jipFrame.reportDialog.showReport(jipFrame.patientReport.generatePatientReport());
            jipFrame.reportDialog.setVisible(true);
        }
    }//GEN-LAST:event_patientReportButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionPatientButton;
    private javax.swing.JTextField admissionDateTextField;
    private javax.swing.JTextArea diagnosisTextField;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JPanel patientBeanPanel;
    private javax.swing.JPanel patientButtonPanel;
    private javax.swing.JTextField patientIDTextField;
    private javax.swing.JButton patientInpatientButton;
    private javax.swing.JButton patientMedicationButton;
    private javax.swing.JButton patientReleaseButton;
    private javax.swing.JButton patientReportButton;
    private javax.swing.JButton patientSurgicalButton;
    private javax.swing.JTable patientTable;
    private javax.swing.JTextField releaseDateTextField;
    // End of variables declaration//GEN-END:variables

    /**
     * perform the different actions after selected the patient record<br>
     * e.g.<br>
     * edit inpatient info for the selected patient<br>
     * edit surgical info for the selected patient<br>
     * edit medication info for the selected patient<br>
     *
     * @param jPanel inpatient, surgical or medication
     * @param jTextField for patientID
     */
    private void patientRecordActionPerformed(JPanel jPanel, JipPanel jipPanel) {
        if (checkSelectedRow(patientTable)) {
            // load specific view
            jipFrame.loadPanel(jPanel, false);
            // click search button from main toolbar
            PatientBean pb = (PatientBean) patientTableModel.getData(patientTable.convertRowIndexToModel(patientTable.getSelectedRow()));

            jipPanel.loadPatientDetails(pb.getPatientID(), pb.getFirstName() + " " + pb.getLastName());

        }
    }

    @Override
    public void toggleDateTextFields(boolean b) {
        patientIDTextField.setEditable(b);

        admissionDateTextField.setEditable(b);
        admissionDateTextField.setEnabled(b);
        releaseDateTextField.setEditable(b);
        releaseDateTextField.setEnabled(b);
    }

    @Override
    public void clearFormFields() {
        patientIDTextField.setText("");
        lastNameTextField.setText("");
        firstNameTextField.setText("");
        diagnosisTextField.setText("");
        admissionDateTextField.setText("");
        releaseDateTextField.setText("");
    }

    @Override
    public void deleteBean() {
        PatientBean pb = ((PatientBean) patientTableModel.getData(patientTable.convertRowIndexToModel(patientTable.getSelectedRow())));

        Long result = patientService.deleteRow(patientTable.convertRowIndexToModel(patientTable.getSelectedRow()));

        if (result >= 0) {
            //show message in status bar
            jipFrame.showNotice(DELETE_RECORD + " Patient ID: " + pb.getPatientID());
        }

    }

    @Override
    public void addBeanPanel() {
        //load bean panel
        loadBeanPanelAction(patientBeanPanel, actionPatientButton, "Add", "Patient", common.getIcon("Add"));

        // activate ID Text Fields
        patientIDTextField.setEditable(true);

        //clear form fields
        clearFormFields();

        // enable date text fields
        toggleDateTextFields(false);
    }

    @Override
    public void searchBeanPanel() {
        //load bean panel
        loadBeanPanelAction(patientBeanPanel, actionPatientButton, "Search", "Patient", common.getIcon("Search"));

        // activate ID Text Fields
        patientIDTextField.setEditable(true);

        //clear form fields
        clearFormFields();

        // enable date text fields
        toggleDateTextFields(true);
    }

    @Override
    public void updateBeanPanel() {
        if (checkSelectedRow(patientTable)) {
            loadBeanPanelAction(patientBeanPanel, actionPatientButton, "Update", "Patient", common.getIcon("Update"));

            // load patientbean to the form fields
            PatientBean pb = (PatientBean) patientTableModel.getData(patientTable.getSelectedRow());
            patientIDTextField.setText(pb.getPatientID() + "");
            lastNameTextField.setText(pb.getLastName());
            firstNameTextField.setText(pb.getFirstName());
            diagnosisTextField.setText(pb.getDiagnosis());
            admissionDateTextField.setText((pb.getAdmissionDate() == null) ? "" : pb.getAdmissionDate().toString().substring(0, 19));
            releaseDateTextField.setText((pb.getReleaseDate() == null) ? "" : pb.getReleaseDate().toString().substring(0, 19));

            // enable date text fields
            toggleDateTextFields(true);

            // disable ID text fields
            patientIDTextField.setEditable(false);
        }
    }

    @Override
    public void print() {
        printTable("Patients List", patientTable);
    }

    /**
     * set the maximum length of all text fields
     *
     */
    private void initTextFieldLimit() {
        //patient panel
        patientIDTextField.setDocument(new JTextFieldLimit(11));
        firstNameTextField.setDocument(new JTextFieldLimit(45));
        lastNameTextField.setDocument(new JTextFieldLimit(45));
        admissionDateTextField.setDocument(new JTextFieldLimit(19));
        releaseDateTextField.setDocument(new JTextFieldLimit(19));
    }

    @Override
    public void loadPatientDetails(Long patientID, String patientName) {
    }
}
