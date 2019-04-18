package com.cejv456.jip.util;

import java.sql.Timestamp;
import javax.swing.text.JTextComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author jfeng
 *
 * the validate methods for swing ui
 */
public class SwingValidator {

    /**
     * validate if the field has value
     *
     * @param j
     * @param fieldName
     * @return
     */
    public boolean isPresent(JTextComponent j, String fieldName) {
        if (j.getText().trim().length() == 0) {
            showMessage(j, fieldName + " is required field.");
            j.requestFocusInWindow();
            return false;
        }

        return true;
    }

    /**
     * validate if the field is valid double
     *
     * @param j
     * @param fieldName
     * @return
     */
    public boolean isDouble(JTextComponent j, String fieldName) {
        try {
            Double d = Double.parseDouble(j.getText().trim());
            return true;
        } catch (NumberFormatException ex) {
            showMessage(null, fieldName + " is not valid double.");
            j.requestFocusInWindow();
            return false;
        }
    }

    /**
     * validate if the field is valid long
     *
     * @param j
     * @param fieldName
     * @return
     */
    public boolean isLong(JTextComponent j, String fieldName) {
        try {
            Long l = Long.parseLong(j.getText().trim());
            return true;
        } catch (NumberFormatException ex) {
            showMessage(null, fieldName + " is not valid long number.");
            j.requestFocusInWindow();
            return false;
        }
    }

    /**
     * validate if the field is valid timestamp
     *
     * @param j
     * @param fieldName
     * @return
     */
    public boolean isTimestamp(JTextComponent j, String fieldName) {
        try {
            String string = j.getText().trim();
            Timestamp ts;
            if (string.length() == 19) {
                ts = Timestamp.valueOf(string.replaceAll("/", "-"));
            } else {
                ts = Timestamp.valueOf(string.substring(0, 10).replaceAll("/", "-") + " 00:00:00");
            }
            return true;
        } catch (Exception ex) {
            showMessage(null, fieldName + " is not valid time value, the correct format is yyyy/mm/dd hh:mm:ss or yyyy/mm/dd");
            j.requestFocusInWindow();
            return false;
        }
    }

    /**
     * validate if the field is valid full timestamp, yyyy-mm-dd hh:mm:ss
     *
     * @param j
     * @param fieldName
     * @return
     */
    public boolean isFullTimestamp(JTextComponent j, String fieldName) {
        try {
            String string = j.getText().trim();
            Timestamp ts = Timestamp.valueOf(string.replaceAll("/", "-"));

            return true;
        } catch (Exception ex) {
            showMessage(null, fieldName + " is not valid time value, the correct format is yyyy/mm/dd hh:mm:ss");
            j.requestFocusInWindow();
            return false;
        }
    }

    /**
     * limit textField length
     *
     * @param jTextField
     * @param i the maximun length
     */
    public void limitTextField(JTextField jTextField, int i) {
        if (jTextField.getText().length() > i) {
            jTextField.setText(jTextField.getText().substring(0, i));
        }
    }

    /**
     * show alert message
     *
     * @param j
     * @param message
     */
    public void showMessage(JTextComponent j, String message) {
        JOptionPane.showMessageDialog(j, message, null, JOptionPane.ERROR_MESSAGE);
    }
}
