package Complicated.Calculator;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public final class Helper {
    private Helper() {
        // private constructor to prevent instantiation
    }

    public static void addobjects(Component c, Container container, GridBagLayout layout, 
                                GridBagConstraints gbc, int gx, int gy, int gw, int gh){

        gbc.gridx = gx;
        gbc.gridy = gy;

        gbc.gridwidth = gw;
        gbc.gridheight = gh;

        layout.setConstraints(c, gbc);
        container.add(c);
    }
}
