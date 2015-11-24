package com.statistic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by senich on 7/24/2015.
 */
public class MainFrame extends JFrame {
    public MainFrame(String title) throws HeadlessException {
        super(title);
        JPanel sourceImagesScrollPanel = new SourceImagesScrollPanel();
        sourceImagesScrollPanel.setSize(1000, 1000);
        setContentPane(sourceImagesScrollPanel);
    }
}
