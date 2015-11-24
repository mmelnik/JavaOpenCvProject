package com.statistic;

import java.awt.*;

import javax.swing.*;

/**
 * Created by senich on 7/24/2015.
 */
public class SourceImagesScrollPanel extends JPanel {
    public SourceImagesScrollPanel() {
        super(new GridLayout(1, 1));
        ImageLayout imageLayout = new ImageLayout();
        JScrollPane scrollPane = new SourceImagesScrollPane(imageLayout);
        add(scrollPane, scrollPane);
        JScrollPane scrollPane1 = new SourceImagesScrollPane(imageLayout);
        add(scrollPane1, 1);
    }
}
