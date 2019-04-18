package com.cejv456.jip;

import com.cejv456.jip.presentation.JipFrame;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jianyu Feng
 * @version 1.0
 * @version 1.1: override hashCode, equals, toString for each bean, rename DB
 * name to jip_jianyu, save db connection parameters to jar properties file
 *
 */
public class App {

    public static void main(String[] args) {

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JipFrame frame = new JipFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

    }
}
