package com.statistic;

import org.opencv.core.Core;

import javax.swing.*;
import java.awt.*;

/**
 * Created by senich on 7/24/2015.
 */
public class JavaOpenCvProject {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static JFrame createUi() {
        JFrame imageLayout = new MainFrame("Images");
        imageLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageLayout.setExtendedState(JFrame.MAXIMIZED_BOTH);
        return imageLayout;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                createUi().setVisible(true);
            }
        });
       /* JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        for (int i = 0; i < 10; i++) {
            panel.add(new JButton("Hello-" + i));
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 30, 300, 50);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500, 400));
        contentPane.add(scrollPane);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);*/
    }
}
