package com.statistic.gui.old;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by senich on 7/24/2015.
 */
public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel() {
        try {
            image = ImageIO.read(new File("d:/projects/JavaOpenCvProject/src/main/resouces/counter.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
