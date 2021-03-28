package com.company;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class ConfigPanel extends JPanel{
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JLabel labelColor;
    JLabel labelRadius;
    JLabel ShapeSelector;
    JComboBox colorCombo;
    JSpinner radius;
    JComboBox selectShape;
    JSpinner width;
    JSpinner height;

    ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init()
    {
        label = new JLabel("Side length");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        labelColor = new JLabel("Color");
        labelRadius = new JLabel("Radius");
        ShapeSelector = new JLabel("Shape");

        radius = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        sidesField.setValue(6);
        String [] colors = {"RED","BLUE","GREEN"};
        colorCombo = new JComboBox(colors);


        String [] shapes = {"ELLIPSE","REGULAR POLYGON"};
        selectShape = new JComboBox(shapes);
        width = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        height = new JSpinner(new SpinnerNumberModel(0,0,100,1));

        add(label);
        add(sidesField);
        add(labelRadius);
        add(radius);
        add(labelColor);
        add(colorCombo);
        add(ShapeSelector);
        add(selectShape);
        add(new JLabel("width"));
        add(width);
        add(new JLabel("height"));
        add(height);

        setVisible(true);
    }
}