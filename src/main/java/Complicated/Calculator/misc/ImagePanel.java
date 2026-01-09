package Complicated.Calculator.misc;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    Image im;
    public ImagePanel(Image im) {
        this.im = im;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);            // paint background first
        if (im == null) {
            System.err.println("ImagePanel: no image to draw");
            return;             // guard
        }
        // draw image scaled to panel size and use this as the ImageObserver
        g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
        System.out.println("ImagePanel: painted image");
    }
}
