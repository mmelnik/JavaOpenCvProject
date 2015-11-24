package com.statistic;

import javax.swing.*;

/**
 * Created by senich on 7/24/2015.
 */
public class ImageLayout extends JPanel {

    public ImageLayout() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        for (int i = 0; i < 100; i++) {
            add(new JButton("Hello-" + i));
        }
        /*ImagePanel imagePanel = new ImagePanel();
        add(imagePanel);
        ImagePanel imagePanel1 = new ImagePanel();
        add(imagePanel1);
        ImagePanel imagePanel2 = new ImagePanel();
        add(imagePanel2);*/
    }
}
