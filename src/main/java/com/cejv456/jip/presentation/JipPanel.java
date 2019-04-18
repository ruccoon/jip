package com.cejv456.jip.presentation;

import com.cejv456.jip.util.JTextFieldLimit;

/**
 * interface of jip panel<br>
 * will be impletemented by patient panel, inpatient panel, surgical panel &
 * mediation panel
 *
 * @author Jianyu Feng
 */
public interface JipPanel {

    /**
     * toggle enable & disable text fields
     * 
     * @param b 
     */
    public void toggleDateTextFields(boolean b);
    
    public void clearFormFields();

    public void deleteBean();

    public void addBeanPanel();

    public void searchBeanPanel();

    public void updateBeanPanel();
    
    public void print();
    
    public void loadPatientDetails(Long patientID, String patientName);
    
}
