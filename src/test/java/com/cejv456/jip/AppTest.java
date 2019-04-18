package com.cejv456.jip;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Jianyu Feng
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.cejv456.jip.persistence.PatientDAOImplUnit.class,
    com.cejv456.jip.persistence.InpatientDAOImplUnit.class,
    com.cejv456.jip.persistence.SurgicalDAOImplUnit.class,
    com.cejv456.jip.persistence.MedicationDAOImplUnit.class})
public class AppTest {
}