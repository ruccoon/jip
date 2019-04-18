package com.cejv456.jip.presentation;

import com.cejv456.jip.business.Common;
import com.cejv456.jip.business.PatientReport;
import com.cejv456.jip.dao.InpatientDAOImpl;
import com.cejv456.jip.dao.JipDAO;
import com.cejv456.jip.dao.JipDBConnection;
import com.cejv456.jip.dao.MedicationDAOImpl;
import com.cejv456.jip.dao.PatientDAOImpl;
import com.cejv456.jip.dao.SurgicalDAOImpl;
import com.cejv456.jip.model.DBTableModel;
import com.cejv456.jip.model.InpatientDBTableModel;
import com.cejv456.jip.model.MedicationDBTableModel;
import com.cejv456.jip.model.PatientDBTableModel;
import com.cejv456.jip.model.SurgicalDBTableModel;
import com.cejv456.jip.services.JipService;
import static com.cejv456.jip.business.Common.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * main frame of the application
 *
 * @author Jianyu Feng
 */
public final class JipFrame extends javax.swing.JFrame implements ActionListener {

    //localization
    private Locale currentLocale;
    private ButtonGroup buttonGroup;
    //db connection
    private Connection connection;
    //daoimpl
    private JipDAO patientDAOImpl;
    private JipDAO inpatientDAOImpl;
    private JipDAO surgicalDAOImpl;
    private JipDAO medicationDAOImpl;
    //dbTableModel
    private DBTableModel patientTableModel;
    private DBTableModel inpatientTableModel;
    private DBTableModel surgicalTableModel;
    private DBTableModel medicationTableModel;
    //service
    private JipService patientService;
    // logging
    private Logger logger;
    public String currentMode = "";
    // timer
    private Timer timer;
    // report dialog
    public ReportDialog reportDialog;
    public PatientReport patientReport;
    //about dialog
    private AboutDialog aboutDialog;
    //sub panel
    private PatientPanel patientPanel;
    private InpatientPanel inpatientPanel;
    private SurgicalPanel surgicalPanel;
    private MedicationPanel medicationPanel;
    //login
    private boolean loggedIn;

    /**
     * Creates new form JipFrame
     */
    public JipFrame() {

        super();
        changeLookAndFeel("System");

        logger = LoggerFactory.getLogger(this.getClass().getName());

        try {
            //instantiate dbconnection
            connection = JipDBConnection.getConnection().connection;

            //instantiate DAO Impl
            patientDAOImpl = new PatientDAOImpl(connection);
            inpatientDAOImpl = new InpatientDAOImpl(connection);
            surgicalDAOImpl = new SurgicalDAOImpl(connection);
            medicationDAOImpl = new MedicationDAOImpl(connection);

            //instantiate dbtablemodel & service
            patientTableModel = new PatientDBTableModel();
            patientService = new JipService(patientDAOImpl, patientTableModel);

            inpatientTableModel = new InpatientDBTableModel();
            //inpatientService = new JipService(inpatientDAOImpl, inpatientTableModel);

            surgicalTableModel = new SurgicalDBTableModel();
            //surgicalService = new JipService(surgicalDAOImpl, surgicalTableModel);

            medicationTableModel = new MedicationDBTableModel();
            //medicationService = new JipService(medicationDAOImpl, medicationTableModel);

        } catch (IOException | SQLException ex) {
            logger.error("Faild to instantiate DB connection." + ex.toString());
        }

        buttonGroup = new ButtonGroup();
        reportDialog = new ReportDialog(this, true);
        aboutDialog = new AboutDialog(this, true);

        patientReport = new PatientReport();

        inpatientPanel = new InpatientPanel(patientService, inpatientDAOImpl, inpatientTableModel, this);
        surgicalPanel = new SurgicalPanel(patientService, surgicalDAOImpl, surgicalTableModel, this);
        medicationPanel = new MedicationPanel(patientService, medicationDAOImpl, medicationTableModel, this);

        patientPanel = new PatientPanel(patientDAOImpl, patientTableModel, inpatientPanel, surgicalPanel, medicationPanel, this);

        // load message bundle by default locale        
        currentLocale = Locale.getDefault();

        // load constants
        loadConstants(currentLocale);

        initComponents();

        loadPanel(homePanel, true);

        setLocationRelativeTo(null);
        setVisible(true);

        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        // show clock in status bar
        showClock();

        // show notice in status bar
        showNotice("Welcome to Jip");

        loggedIn = false;

        toggleLogin(loggedIn);
        
        //set login button as default
        getRootPane().setDefaultButton(loginButton);
    }

    /**
     * Set up Timer thread
     */
    private void showClock() {
        timer = new Timer(1000, this);
        timer.setInitialDelay(0);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == timer) {
            Date t = new Date();
            DateFormat df = DateFormat.getDateTimeInstance();
            String time = df.format(t);
            timeLabel.setText(time);
        }
    }

    public void showNotice(String s) {
        noticeLabel.setText(s);
    }

    private void toggleLogin(boolean login) {
        patientMenu.setEnabled(login);
        inpatientMenu.setEnabled(login);
        surgicalMenu.setEnabled(login);
        medicationMenu.setEnabled(login);

        patientButton.setEnabled(login);
        inpatientButton.setEnabled(login);
        surgicalButton.setEnabled(login);
        medicationButton.setEnabled(login);

        loginButton.setText(login ? "Logout" : "Submit");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainToolBar = new javax.swing.JToolBar();
        homeButton = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        patientButton = new javax.swing.JButton();
        inpatientButton = new javax.swing.JButton();
        surgicalButton = new javax.swing.JButton();
        medicationButton = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        helpButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        actionPanel = new javax.swing.JPanel();
        actionToolBar = new javax.swing.JToolBar();
        addButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        printButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jipPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        statusBarPanel = new javax.swing.JPanel();
        timeToolBar = new javax.swing.JToolBar();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        timeLabel = new javax.swing.JLabel();
        noticeToolBar = new javax.swing.JToolBar();
        noticeLabel = new javax.swing.JLabel();
        jipMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        homeMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        patientMenu = new javax.swing.JMenu();
        newPatientMenuItem = new javax.swing.JMenuItem();
        searchPatientMenuItem = new javax.swing.JMenuItem();
        inpatientMenu = new javax.swing.JMenu();
        newInpatientMenuItem = new javax.swing.JMenuItem();
        searchInpatientMenuItem = new javax.swing.JMenuItem();
        surgicalMenu = new javax.swing.JMenu();
        newSurgicalMenuItem = new javax.swing.JMenuItem();
        searchSurgicalMenuItem = new javax.swing.JMenuItem();
        medicationMenu = new javax.swing.JMenu();
        newMedicationMenuItem = new javax.swing.JMenuItem();
        searchMedicationMenuItem = new javax.swing.JMenuItem();
        languageMenu = new javax.swing.JMenu();
        defaultRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        englishRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        frenchRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        chineseRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpContentsMenuItem = new javax.swing.JMenuItem();
        reportIssueMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JIP 1.0");
        setMinimumSize(new java.awt.Dimension(1024, 728));

        mainToolBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(240, 240, 240), new java.awt.Color(204, 204, 204), new java.awt.Color(240, 240, 240)));
        mainToolBar.setFloatable(false);
        mainToolBar.setRollover(true);

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home32.png"))); // NOI18N
        homeButton.setToolTipText("Show home page");
        homeButton.setFocusable(false);
        homeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        homeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        mainToolBar.add(homeButton);
        mainToolBar.add(jSeparator5);

        patientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Patient.png"))); // NOI18N
        patientButton.setToolTipText("Show patient view");
        patientButton.setFocusable(false);
        patientButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        patientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientButtonActionPerformed(evt);
            }
        });
        mainToolBar.add(patientButton);

        inpatientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/inpatient.png"))); // NOI18N
        inpatientButton.setToolTipText("Show inpatient view");
        inpatientButton.setFocusable(false);
        inpatientButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inpatientButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        inpatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpatientButtonActionPerformed(evt);
            }
        });
        mainToolBar.add(inpatientButton);

        surgicalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/surgical.png"))); // NOI18N
        surgicalButton.setToolTipText("Show surgical view");
        surgicalButton.setFocusable(false);
        surgicalButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        surgicalButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        surgicalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surgicalButtonActionPerformed(evt);
            }
        });
        mainToolBar.add(surgicalButton);

        medicationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/medication.png"))); // NOI18N
        medicationButton.setToolTipText("Show medication view");
        medicationButton.setFocusable(false);
        medicationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        medicationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        medicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicationButtonActionPerformed(evt);
            }
        });
        mainToolBar.add(medicationButton);
        mainToolBar.add(jSeparator6);

        helpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/help32.png"))); // NOI18N
        helpButton.setToolTipText("Help");
        helpButton.setFocusable(false);
        helpButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        helpButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });
        mainToolBar.add(helpButton);

        mainPanel.setPreferredSize(new java.awt.Dimension(1024, 768));
        mainPanel.setLayout(new java.awt.CardLayout());

        actionToolBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(240, 240, 240), new java.awt.Color(204, 204, 204), new java.awt.Color(240, 240, 240)));
        actionToolBar.setFloatable(false);
        actionToolBar.setRollover(true);
        actionToolBar.setPreferredSize(new java.awt.Dimension(100, 30));

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("MessageBundle",currentLocale); // NOI18N
        addButton.setText(bundle.getString("toolBarAdd")); // NOI18N
        addButton.setToolTipText("Add new record");
        addButton.setBorderPainted(false);
        addButton.setFocusable(false);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        addButton.setMaximumSize(new java.awt.Dimension(70, 36));
        addButton.setMinimumSize(new java.awt.Dimension(70, 36));
        addButton.setPreferredSize(new java.awt.Dimension(70, 36));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        actionToolBar.add(addButton);

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        searchButton.setText(bundle.getString("toolBarSearch")); // NOI18N
        searchButton.setToolTipText("Search records");
        searchButton.setFocusable(false);
        searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        searchButton.setMaximumSize(new java.awt.Dimension(70, 36));
        searchButton.setMinimumSize(new java.awt.Dimension(70, 36));
        searchButton.setPreferredSize(new java.awt.Dimension(70, 36));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        actionToolBar.add(searchButton);

        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        updateButton.setText(bundle.getString("toolBarUpdate")); // NOI18N
        updateButton.setToolTipText("Update the selected record");
        updateButton.setBorderPainted(false);
        updateButton.setFocusable(false);
        updateButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        updateButton.setMaximumSize(new java.awt.Dimension(70, 36));
        updateButton.setMinimumSize(new java.awt.Dimension(70, 36));
        updateButton.setPreferredSize(new java.awt.Dimension(70, 36));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        actionToolBar.add(updateButton);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        deleteButton.setText(bundle.getString("toolBarDelete")); // NOI18N
        deleteButton.setToolTipText("Delete the selected record");
        deleteButton.setBorderPainted(false);
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        deleteButton.setMaximumSize(new java.awt.Dimension(70, 36));
        deleteButton.setMinimumSize(new java.awt.Dimension(70, 36));
        deleteButton.setPreferredSize(new java.awt.Dimension(70, 36));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        actionToolBar.add(deleteButton);
        actionToolBar.add(jSeparator4);

        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        printButton.setText(bundle.getString("toolBarPrint")); // NOI18N
        printButton.setToolTipText("Print the table");
        printButton.setBorderPainted(false);
        printButton.setFocusable(false);
        printButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        printButton.setMaximumSize(new java.awt.Dimension(70, 36));
        printButton.setMinimumSize(new java.awt.Dimension(70, 36));
        printButton.setPreferredSize(new java.awt.Dimension(70, 36));
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        actionToolBar.add(printButton);

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/stop.png"))); // NOI18N
        closeButton.setText(bundle.getString("toolBarClose")); // NOI18N
        closeButton.setToolTipText("Back to home page");
        closeButton.setBorderPainted(false);
        closeButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        closeButton.setMaximumSize(new java.awt.Dimension(70, 36));
        closeButton.setMinimumSize(new java.awt.Dimension(70, 36));
        closeButton.setPreferredSize(new java.awt.Dimension(70, 36));
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        actionToolBar.add(closeButton);

        jipPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(actionToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jipPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addComponent(actionToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jipPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
        );

        mainPanel.add(actionPanel, "card2");

        homePanel.setName("Home"); // NOI18N

        jPanel1.setMinimumSize(new java.awt.Dimension(680, 320));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 320));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setText("Welcome to JIP");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N

        usernameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Password");

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loginButton.setText("Submit");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loginButton)
                            .addComponent(usernameTextField)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel5)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(loginButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        mainPanel.add(homePanel, "card2");

        statusBarPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 255, 255), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204)));
        statusBarPanel.setPreferredSize(new java.awt.Dimension(4, 25));

        timeToolBar.setFloatable(false);
        timeToolBar.add(jSeparator3);

        timeLabel.setText("clock");
        timeToolBar.add(timeLabel);

        noticeToolBar.setFloatable(false);

        noticeLabel.setText("notice");
        noticeToolBar.add(noticeLabel);

        javax.swing.GroupLayout statusBarPanelLayout = new javax.swing.GroupLayout(statusBarPanel);
        statusBarPanel.setLayout(statusBarPanelLayout);
        statusBarPanelLayout.setHorizontalGroup(
            statusBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusBarPanelLayout.createSequentialGroup()
                .addComponent(noticeToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(timeToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        statusBarPanelLayout.setVerticalGroup(
            statusBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timeToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(noticeToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jipMenuBar.setFocusable(false);
        jipMenuBar.setPreferredSize(new java.awt.Dimension(384, 28));

        fileMenu.setMnemonic('F');
        fileMenu.setText(bundle.getString("file")); // NOI18N
        fileMenu.setToolTipText("the File menu");

        homeMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        homeMenuItem.setMnemonic('o');
        homeMenuItem.setText(bundle.getString("home")); // NOI18N
        homeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(homeMenuItem);
        fileMenu.add(jSeparator1);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText(bundle.getString("exit")); // NOI18N
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jipMenuBar.add(fileMenu);

        patientMenu.setMnemonic('P');
        patientMenu.setText(bundle.getString("patient")); // NOI18N
        patientMenu.setToolTipText("the Patient menu");

        newPatientMenuItem.setMnemonic('N');
        newPatientMenuItem.setText(bundle.getString("newPatient")); // NOI18N
        newPatientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPatientMenuItemActionPerformed(evt);
            }
        });
        patientMenu.add(newPatientMenuItem);

        searchPatientMenuItem.setMnemonic('S');
        searchPatientMenuItem.setText(bundle.getString("searchPatient")); // NOI18N
        searchPatientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPatientMenuItemActionPerformed(evt);
            }
        });
        patientMenu.add(searchPatientMenuItem);

        jipMenuBar.add(patientMenu);

        inpatientMenu.setMnemonic('I');
        inpatientMenu.setText(bundle.getString("inpatient")); // NOI18N
        inpatientMenu.setToolTipText("the Inpatient menu");

        newInpatientMenuItem.setMnemonic('N');
        newInpatientMenuItem.setText(bundle.getString("newInpatient")); // NOI18N
        newInpatientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newInpatientMenuItemActionPerformed(evt);
            }
        });
        inpatientMenu.add(newInpatientMenuItem);

        searchInpatientMenuItem.setMnemonic('S');
        searchInpatientMenuItem.setText(bundle.getString("searchInpatient")); // NOI18N
        searchInpatientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInpatientMenuItemActionPerformed(evt);
            }
        });
        inpatientMenu.add(searchInpatientMenuItem);

        jipMenuBar.add(inpatientMenu);

        surgicalMenu.setMnemonic('S');
        surgicalMenu.setText(bundle.getString("surgical")); // NOI18N
        surgicalMenu.setToolTipText("the Surgical menu");

        newSurgicalMenuItem.setMnemonic('N');
        newSurgicalMenuItem.setText(bundle.getString("newSurgical")); // NOI18N
        newSurgicalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSurgicalMenuItemActionPerformed(evt);
            }
        });
        surgicalMenu.add(newSurgicalMenuItem);

        searchSurgicalMenuItem.setMnemonic('S');
        searchSurgicalMenuItem.setText(bundle.getString("searchSurgical")); // NOI18N
        searchSurgicalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSurgicalMenuItemActionPerformed(evt);
            }
        });
        surgicalMenu.add(searchSurgicalMenuItem);

        jipMenuBar.add(surgicalMenu);

        medicationMenu.setMnemonic('M');
        medicationMenu.setText(bundle.getString("medication")); // NOI18N
        medicationMenu.setToolTipText("the Medication menu");

        newMedicationMenuItem.setMnemonic('N');
        newMedicationMenuItem.setText(bundle.getString("newMedication")); // NOI18N
        newMedicationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMedicationMenuItemActionPerformed(evt);
            }
        });
        medicationMenu.add(newMedicationMenuItem);

        searchMedicationMenuItem.setMnemonic('S');
        searchMedicationMenuItem.setText(bundle.getString("searchMedication")); // NOI18N
        searchMedicationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMedicationMenuItemActionPerformed(evt);
            }
        });
        medicationMenu.add(searchMedicationMenuItem);

        jipMenuBar.add(medicationMenu);

        languageMenu.setMnemonic('L');
        languageMenu.setText(bundle.getString("language")); // NOI18N
        languageMenu.setToolTipText("the Language Menu");

        buttonGroup.add(defaultRadioButtonMenuItem);
        defaultRadioButtonMenuItem.setSelected(true);
        defaultRadioButtonMenuItem.setText(bundle.getString("default")); // NOI18N
        defaultRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultRadioButtonMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(defaultRadioButtonMenuItem);

        buttonGroup.add(englishRadioButtonMenuItem);
        englishRadioButtonMenuItem.setText(bundle.getString("english")); // NOI18N
        englishRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                englishRadioButtonMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(englishRadioButtonMenuItem);

        buttonGroup.add(frenchRadioButtonMenuItem);
        frenchRadioButtonMenuItem.setText(bundle.getString("french")); // NOI18N
        frenchRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frenchRadioButtonMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(frenchRadioButtonMenuItem);

        buttonGroup.add(chineseRadioButtonMenuItem);
        chineseRadioButtonMenuItem.setText(bundle.getString("chinese")); // NOI18N
        chineseRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chineseRadioButtonMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(chineseRadioButtonMenuItem);

        jipMenuBar.add(languageMenu);

        helpMenu.setMnemonic('H');
        helpMenu.setText(bundle.getString("help")); // NOI18N
        helpMenu.setToolTipText("the Help menu");

        helpContentsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/help.png"))); // NOI18N
        helpContentsMenuItem.setMnemonic('C');
        helpContentsMenuItem.setText(bundle.getString("helpContents")); // NOI18N
        helpContentsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpContentsMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpContentsMenuItem);

        reportIssueMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/report.png"))); // NOI18N
        reportIssueMenuItem.setMnemonic('I');
        reportIssueMenuItem.setText(bundle.getString("reportIssue")); // NOI18N
        reportIssueMenuItem.setToolTipText("Report any issue by email");
        reportIssueMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportIssueMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(reportIssueMenuItem);
        helpMenu.add(jSeparator2);

        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.setText(bundle.getString("about")); // NOI18N
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        jipMenuBar.add(helpMenu);

        setJMenuBar(jipMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statusBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /**
     * load different panel in the main panel
     *
     * @param panel
     * @param isHomePanel
     */
    public void loadPanel(JPanel panel, boolean isHomePanel) {
        // clear main panel firstly
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // show specific panel now
        if (!isHomePanel) {

            jipPanel.removeAll();
            jipPanel.repaint();
            jipPanel.revalidate();

            jipPanel.add(panel);

            jipPanel.repaint();
            jipPanel.revalidate();

            mainPanel.add(actionPanel);
        } else {
            mainPanel.add(homePanel);

            showNotice("Welcome to Jip");
        }

        mainPanel.repaint();
        mainPanel.revalidate();

        // set the current mode
        currentMode = panel.getName();

    }

    private void searchPatientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPatientMenuItemActionPerformed
        loadPanel(patientPanel, false);
        searchButtonActionPerformed(null);
    }//GEN-LAST:event_searchPatientMenuItemActionPerformed

    private void searchInpatientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInpatientMenuItemActionPerformed
        loadPanel(inpatientPanel, false);
        searchButtonActionPerformed(null);
    }//GEN-LAST:event_searchInpatientMenuItemActionPerformed

    private void searchSurgicalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSurgicalMenuItemActionPerformed
        loadPanel(surgicalPanel, false);
        searchButtonActionPerformed(null);
    }//GEN-LAST:event_searchSurgicalMenuItemActionPerformed

    private void searchMedicationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMedicationMenuItemActionPerformed
        loadPanel(medicationPanel, false);
        searchButtonActionPerformed(null);
    }//GEN-LAST:event_searchMedicationMenuItemActionPerformed

    private void homeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeMenuItemActionPerformed
        loadPanel(homePanel, true);
    }//GEN-LAST:event_homeMenuItemActionPerformed

    private void newPatientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPatientMenuItemActionPerformed
        loadPanel(patientPanel, false);
        addButtonActionPerformed(null);
    }//GEN-LAST:event_newPatientMenuItemActionPerformed

    private void newInpatientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newInpatientMenuItemActionPerformed
        loadPanel(inpatientPanel, false);
        addButtonActionPerformed(null);
    }//GEN-LAST:event_newInpatientMenuItemActionPerformed

    private void newSurgicalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSurgicalMenuItemActionPerformed
        loadPanel(surgicalPanel, false);
        addButtonActionPerformed(null);
    }//GEN-LAST:event_newSurgicalMenuItemActionPerformed

    private void newMedicationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMedicationMenuItemActionPerformed
        loadPanel(medicationPanel, false);
        addButtonActionPerformed(null);
    }//GEN-LAST:event_newMedicationMenuItemActionPerformed

    private void defaultRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultRadioButtonMenuItemActionPerformed
        currentLocale = Locale.getDefault();
        loadMessageBundle(currentLocale);
    }//GEN-LAST:event_defaultRadioButtonMenuItemActionPerformed

    private void englishRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_englishRadioButtonMenuItemActionPerformed
        currentLocale = new Locale("en", "US");
        loadMessageBundle(currentLocale);
    }//GEN-LAST:event_englishRadioButtonMenuItemActionPerformed

    private void frenchRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frenchRadioButtonMenuItemActionPerformed
        currentLocale = new Locale("fr", "CA");
        loadMessageBundle(currentLocale);
    }//GEN-LAST:event_frenchRadioButtonMenuItemActionPerformed

    private void chineseRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chineseRadioButtonMenuItemActionPerformed
        currentLocale = new Locale("zh", "CN");
        loadMessageBundle(currentLocale);
    }//GEN-LAST:event_chineseRadioButtonMenuItemActionPerformed

    private void patientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientButtonActionPerformed
        loadPanel(patientPanel, false);
    }//GEN-LAST:event_patientButtonActionPerformed

    private void inpatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpatientButtonActionPerformed
        loadPanel(inpatientPanel, false);
    }//GEN-LAST:event_inpatientButtonActionPerformed

    private void surgicalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surgicalButtonActionPerformed
        loadPanel(surgicalPanel, false);
    }//GEN-LAST:event_surgicalButtonActionPerformed

    private void medicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicationButtonActionPerformed
        loadPanel(medicationPanel, false);
    }//GEN-LAST:event_medicationButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        loadPanel(homePanel, true);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        switch (currentMode) {
            case "Patient":
                patientPanel.print();
                break;
            case "Inpatient":
                inpatientPanel.print();
                break;
            case "Surgical":
                surgicalPanel.print();
                break;
            case "Medication":
                medicationPanel.print();
                break;
        }
    }//GEN-LAST:event_printButtonActionPerformed

    /**
     * Delete button action from the main toolbar
     *
     * @param evt
     */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // delete record
        switch (currentMode) {
            case "Patient":
                patientPanel.deleteBean();
                break;
            case "Inpatient":
                inpatientPanel.deleteBean();
                break;
            case "Surgical":
                surgicalPanel.deleteBean();
                break;
            case "Medication":
                medicationPanel.deleteBean();
                break;
        }

        // switch to Search action
        searchButtonActionPerformed(null);
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * Update button action from the main toolbar
     *
     * @param evt
     */
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        switch (currentMode) {
            case "Patient":
                patientPanel.updateBeanPanel();
                break;
            case "Inpatient":
                inpatientPanel.updateBeanPanel();
                break;
            case "Surgical":
                surgicalPanel.updateBeanPanel();
                break;
            case "Medication":
                medicationPanel.updateBeanPanel();
                break;
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    /**
     * Search button action from the main toolbar
     *
     * @param evt
     */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        switch (currentMode) {
            case "Patient":
                patientPanel.searchBeanPanel();
                break;
            case "Inpatient":
                inpatientPanel.searchBeanPanel();
                break;
            case "Surgical":
                surgicalPanel.searchBeanPanel();
                break;
            case "Medication":
                medicationPanel.searchBeanPanel();
                break;
        }

    }//GEN-LAST:event_searchButtonActionPerformed

    /**
     * Add button action from the main toolbar
     *
     * @param evt
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        switch (currentMode) {
            case "Patient":
                patientPanel.addBeanPanel();
                break;
            case "Inpatient":
                inpatientPanel.addBeanPanel();
                break;
            case "Surgical":
                surgicalPanel.addBeanPanel();
                break;
            case "Medication":
                medicationPanel.addBeanPanel();
                break;
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        loadPanel(homePanel, true);
    }//GEN-LAST:event_homeButtonActionPerformed

    /**
     * report issue by email
     *
     * @param evt
     */
    private void reportIssueMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportIssueMenuItemActionPerformed
        try {
            sendEmail(new URI("mailto:ruccoon@hotmail.com?subject=Questions/Comments%20about%20JIP"));
        } catch (URISyntaxException | IOException ex) {
            logger.error("Cannot send email. " + ex.toString());
        }
    }//GEN-LAST:event_reportIssueMenuItemActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        //simple login for demo
        switch (loginButton.getText()) {
            case "Submit":
                if (usernameTextField.getText().trim().equals("fish") && String.valueOf(passwordField.getPassword()).equals("fish")) {
                    loggedIn = true;
                    
                    // show patient panel
                    loadPanel(patientPanel, false);

                } else {
                    JOptionPane.showMessageDialog(this, "Wrong username/password.\nYou can use fish/fish to demo the system.", null, JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Logout":
                usernameTextField.setText("");
                passwordField.setText("");
                loggedIn = false;

                break;
        }

        toggleLogin(loggedIn);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void helpContentsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpContentsMenuItemActionPerformed
        try {
            Common.openHtmlHelp("");
        } catch (IOException ex) {
            logger.error(ex.toString());
        }
    }//GEN-LAST:event_helpContentsMenuItemActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        try {
            switch (currentMode) {
                case "Home":
                    Common.openHtmlHelp("homePage.html");
                    break;
                case "Patient":
                    Common.openHtmlHelp("patientPage.html");
                    break;
                case "Inpatient":
                    Common.openHtmlHelp("inpatientPage.html");
                    break;
                case "Surgical":
                    Common.openHtmlHelp("surgicalPage.html");
                    break;
                case "Medication":
                    Common.openHtmlHelp("medicationPage.html");
                    break;
            }

        } catch (IOException ex) {
            logger.error(ex.toString());
        }
    }//GEN-LAST:event_helpButtonActionPerformed

    private void loadMessageBundle(Locale locale) {
        //get message bundle based on locale
        ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", locale);

        //redo menu UI
        fileMenu.setText(messages.getString("file"));
        homeMenuItem.setText(messages.getString("home"));
        exitMenuItem.setText(messages.getString("exit"));

        patientMenu.setText(messages.getString("patient"));
        newPatientMenuItem.setText(messages.getString("newPatient"));
        searchPatientMenuItem.setText(messages.getString("searchPatient"));

        inpatientMenu.setText(messages.getString("inpatient"));
        newInpatientMenuItem.setText(messages.getString("newInpatient"));
        searchInpatientMenuItem.setText(messages.getString("searchInpatient"));

        surgicalMenu.setText(messages.getString("surgical"));
        newSurgicalMenuItem.setText(messages.getString("newSurgical"));
        searchSurgicalMenuItem.setText(messages.getString("searchSurgical"));

        medicationMenu.setText(messages.getString("medication"));
        newMedicationMenuItem.setText(messages.getString("newMedication"));
        searchMedicationMenuItem.setText(messages.getString("searchMedication"));

        languageMenu.setText(messages.getString("language"));
        defaultRadioButtonMenuItem.setText(messages.getString("default"));
        englishRadioButtonMenuItem.setText(messages.getString("english"));
        frenchRadioButtonMenuItem.setText(messages.getString("french"));
        chineseRadioButtonMenuItem.setText(messages.getString("chinese"));

        helpMenu.setText(messages.getString("help"));
        helpContentsMenuItem.setText(messages.getString("helpContents"));
        reportIssueMenuItem.setText(messages.getString("reportIssue"));
        aboutMenuItem.setText(messages.getString("about"));

        // ......

        // stop here, this just for demo
    }

    /**
     * Change the look and feel
     *
     */
    private void changeLookAndFeel(String str) {

        try {
            switch (str) {
                case "Metal":
                    UIManager
                            .setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    break;
                case "Motif":
                    UIManager
                            .setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;
                case "Windows":
                    UIManager
                            .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                case "Aqua":
                    UIManager.setLookAndFeel("javax.swing.plaf.mac.MacLookAndFeel");
                    break;
                case "System":
                    UIManager.setLookAndFeel(UIManager
                            .getSystemLookAndFeelClassName());
                    break;
                case "Cross Platform":
                    UIManager.setLookAndFeel(UIManager
                            .getSystemLookAndFeelClassName());
                    break;
                case "Windows Classic":
                    UIManager
                            .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                    break;
                case "Nimbus":
                    UIManager
                            .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;
            }

            // Update all the GUI elements to the new look and feel
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create and set up the window.
                JipFrame frame = new JipFrame();

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JPanel actionPanel;
    private javax.swing.JToolBar actionToolBar;
    private javax.swing.JButton addButton;
    private javax.swing.JRadioButtonMenuItem chineseRadioButtonMenuItem;
    private javax.swing.JButton closeButton;
    private javax.swing.JRadioButtonMenuItem defaultRadioButtonMenuItem;
    private javax.swing.JButton deleteButton;
    private javax.swing.JRadioButtonMenuItem englishRadioButtonMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JRadioButtonMenuItem frenchRadioButtonMenuItem;
    private javax.swing.JButton helpButton;
    private javax.swing.JMenuItem helpContentsMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton homeButton;
    private javax.swing.JMenuItem homeMenuItem;
    private javax.swing.JPanel homePanel;
    private javax.swing.JButton inpatientButton;
    private javax.swing.JMenu inpatientMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JMenuBar jipMenuBar;
    private javax.swing.JPanel jipPanel;
    private javax.swing.JMenu languageMenu;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JToolBar mainToolBar;
    private javax.swing.JButton medicationButton;
    private javax.swing.JMenu medicationMenu;
    private javax.swing.JMenuItem newInpatientMenuItem;
    private javax.swing.JMenuItem newMedicationMenuItem;
    private javax.swing.JMenuItem newPatientMenuItem;
    private javax.swing.JMenuItem newSurgicalMenuItem;
    private javax.swing.JLabel noticeLabel;
    private javax.swing.JToolBar noticeToolBar;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton patientButton;
    private javax.swing.JMenu patientMenu;
    private javax.swing.JButton printButton;
    private javax.swing.JMenuItem reportIssueMenuItem;
    private javax.swing.JButton searchButton;
    private javax.swing.JMenuItem searchInpatientMenuItem;
    private javax.swing.JMenuItem searchMedicationMenuItem;
    private javax.swing.JMenuItem searchPatientMenuItem;
    private javax.swing.JMenuItem searchSurgicalMenuItem;
    private javax.swing.JPanel statusBarPanel;
    private javax.swing.JButton surgicalButton;
    private javax.swing.JMenu surgicalMenu;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JToolBar timeToolBar;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
