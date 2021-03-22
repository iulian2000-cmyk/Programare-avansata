package com.company;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel{
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JLabel labelColor;
    JLabel labelRadius;
    JComboBox colorCombo;
    JSpinner radius;

    ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init(){
        label = new JLabel("Side length");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        labelColor = new JLabel("Color");
        labelRadius = new JLabel("Radius");
        radius = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        sidesField.setValue(6);
        String [] colors = {"RED","BLUE","GREEN"};
        colorCombo = new JComboBox(colors);

        add(label);
        add(sidesField);
        add(labelRadius);
        add(radius);
        add(labelColor);
        add(colorCombo);
        setVisible(true);
    }
}