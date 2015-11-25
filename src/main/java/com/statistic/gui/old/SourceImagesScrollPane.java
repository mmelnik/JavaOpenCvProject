package com.statistic.gui.old;

import javax.swing.*;
import java.awt.*;

/**
 * Created by senich on 7/24/2015.
 */
public class SourceImagesScrollPane extends JScrollPane {
    public SourceImagesScrollPane(Component view) {
        super(view);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);

//        setBounds(0, 0, 500, 500);
//        invalidate();
    }
}
