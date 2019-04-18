package com.cejv456.jip.business;

import com.cejv456.jip.data.PatientBean;
import com.cejv456.jip.model.DBTableModel;
import com.cejv456.jip.services.JipService;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Jianyu Feng
 */
public class Common {

    private String imgLocation;
    private URL imageURL;
    private ImageIcon addIcon;
    private ImageIcon searchIcon;
    private ImageIcon updateIcon;
    public static String NEW_RECORD;
    public static String UPDATE_RECORD;
    public static String DELETE_RECORD;
    public static String SELECT_DELETE_RECORD;
    public static String CANNOT_DELETE;
    public static String CONFIRM_DELETE;
    public static String SEARCH_RECORD;
    public static String SELECT_ONE;
    public static String ALREADY_RELEASE;

    public Common() {
        super();

        imgLocation = "/icon/add.png";
        imageURL = this.getClass().getResource(imgLocation);
        addIcon = new ImageIcon(imageURL, "Add medication record");

        imgLocation = "/icon/search.png";
        imageURL = this.getClass().getResource(imgLocation);
        searchIcon = new ImageIcon(imageURL, "Search medication record");

        imgLocation = "/icon/edit.png";
        imageURL = this.getClass().getResource(imgLocation);
        updateIcon = new ImageIcon(imageURL, "Update medication record");
    }

    public static void loadConstants(Locale locale) {
        //get message bundle based on locale
        ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", locale);

        NEW_RECORD = messages.getString("daoNew");
        UPDATE_RECORD = messages.getString("daoUpdate");
        DELETE_RECORD = messages.getString("daoDelete");
        SELECT_DELETE_RECORD = messages.getString("daoSelectDelete");
        CANNOT_DELETE = messages.getString("daoCannotDelete");
        SEARCH_RECORD = messages.getString("daoSearch");
        CONFIRM_DELETE = messages.getString("daoDeleteConfirm");
        SELECT_ONE = messages.getString("daoSelectOne");
        ALREADY_RELEASE = messages.getString("daoAlreadyRelease");

    }

    public ImageIcon getIcon(String icon) {
        switch (icon) {
            case "Add":
                return addIcon;
            case "Search":
                return searchIcon;
            case "Update":
                return updateIcon;
            default:
                return searchIcon;
        }

    }

    public static void refreshTable(JipService jipService, StringBuilder creteria, JTable jtable, DBTableModel dbTableModel) {
        // refresh tableModel
        jipService.fillTableModel(creteria.toString());

        // fill JTable
        jtable.setModel(dbTableModel);
        jtable.repaint();
        jtable.revalidate();

        // set jtable as SINGLE_SELECTION mode
        jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    /**
     * get the patient id from jTextField, and query patient name, then put to
     * jLabel
     *
     * @param jTextField patient id
     * @param jLabel patient name
     */
    public static void showPatientName(JipService patientService, JTextField jTextField, JLabel jLabel) {
        if (jTextField.getText().trim().length() > 0) {
            String creteria = " where patientID = " + jTextField.getText();

            ArrayList<Object> al = patientService.getRecord(creteria);
            if (al.size() > 0) {
                PatientBean pb = (PatientBean) al.get(0);
                jLabel.setText(pb.getFirstName() + " " + pb.getLastName());
                jLabel.setForeground(Color.black);
            } else {
                jLabel.setText("No patient found!");
                jLabel.setForeground(Color.red);
            }
        } else {
            jLabel.setText("");
        }
    }

    /**
     * check if there is row selected in the table
     *
     * @param table
     * @return
     */
    public static boolean checkSelectedRow(JTable table) {
        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, SELECT_ONE, null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }

    }

    public static void loadBeanPanelAction(JPanel panel, JButton button, String iconName, String panelName, ImageIcon imageIcon) {
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(iconName + " " + panelName));
        button.setText(iconName);
        button.setIcon(imageIcon);
    }

    public URL getIconImage(String image) {
        imgLocation = "/icon/" + image + ".png";
        imageURL = this.getClass().getResource(imgLocation);
        return imageURL;
    }

    /**
     * Print the table with header and footer
     */
    public static void printTable(String title, JTable table) {
        MessageFormat header = new MessageFormat(title);
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try {

            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            System.err.format("Cannot print %s%n", ex.getMessage());
        }
    }

    /**
     * open web page url in default browser
     *
     * @param uri
     */
    public static void sendEmail(URI uri) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {

            desktop.mail(uri);

        }
    }

    /**
     * open web page url in default browser
     *
     * @param url
     */
    public static void openWebpage(URL url) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {

            desktop.browse(url.toURI());

        }
    }

    public static void openHtmlHelp(String pageName) throws IOException {

        String path = Toolkit.getDefaultToolkit().getClass().getResource("/htmlHelp/Jip.chm").getPath();
        String path1 = path.substring(1).replace("/", "\\").replace("%20", " ");
        if (pageName != null && !"".equals(pageName)) {
            path1 = path1 + "::" + pageName;
        }
        Runtime.getRuntime().exec("hh.exe " + path1);

    }
}
