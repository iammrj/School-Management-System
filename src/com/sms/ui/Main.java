/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.ui;

import java.awt.BorderLayout;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author jilanis
 */
public class Main {

    public static void main(String[] args) {
        final JFrame frame = new JFrame("TEST");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JLabel label = new JLabel(new ImageIcon("C:\\Users\\jilanis\\Desktop\\Desktop Content\\flow.png"));
        ImageIcon icon = new ImageIcon("C:\\Users\\jilanis\\AppData\\Local\\Temp\\test1.png");

        JButton button = new JButton("Change");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                final ImageIcon finalIcon = icon;
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (finalIcon != null && finalIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                            label.setIcon(finalIcon);
                        }
                    }
                });

            }
        });

        //        icon = new ImageIcon(ImageIO.read(new File("C:\\Users\\jilanis\\AppData\\Local\\Temp\\test1.png")));
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.setSize(200, 200);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });

//    try {
//        Thread.currentThread().sleep(10000);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
    }
}
