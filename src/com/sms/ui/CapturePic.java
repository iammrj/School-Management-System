/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.ui;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.sms.utils.Utilities;

/**
 *
 * @author jilanis
 */
public class CapturePic {

    public void startStream() {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);

        JButton btn_capturePic = new JButton();
        btn_capturePic.setText("Capture Pic");
       
        JPanel jPanel5 = new JPanel();
        jPanel5.add(panel);
        jPanel5.setVisible(true);
        jPanel5.revalidate();
        jPanel5.repaint();

        JPanel jPanel6 = new JPanel();
        jPanel6.add(btn_capturePic);
        jPanel6.setVisible(true);
        jPanel6.revalidate();
        jPanel6.repaint();
        
        JFrame window = new JFrame("Test webcam panel");
        Container container = new Container();
        container = window.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(jPanel5);
        container.add(jPanel6);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.pack();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
         btn_capturePic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                WebcamUtils.capture(webcam, new Utilities().getTempPath() + "test1", ImageUtils.FORMAT_PNG);
                webcam.close();
                new Admissions_Screen().setStudentPic();
//                new Admissions_Screen().show();
                window.dispose();
                
            }
        });
    }

    public static void main(String[] args) {
//        Webcam webcam = Webcam.getDefault();
//        webcam.setViewSize(WebcamResolution.VGA.getSize());
//
//        WebcamPanel panel = new WebcamPanel(webcam);
//        panel.setFPSDisplayed(true);
//        panel.setDisplayDebugInfo(true);
//        panel.setImageSizeDisplayed(true);
//        panel.setMirrored(true);
//
//        JButton btn_capturePic = new JButton();
//        btn_capturePic.setText("Capture Pic");
//        btn_capturePic.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //To change body of generated methods, choose Tools | Templates.
//                WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_PNG);
//            }
//        });
//
//        JFrame window = new JFrame("Test webcam panel");
//        window.add(panel);
//        window.add(btn_capturePic);
//        window.setResizable(true);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.pack();
//        window.setVisible(true);

CapturePic cap = new CapturePic();
cap.startStream();
    }
}
