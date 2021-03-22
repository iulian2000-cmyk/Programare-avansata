package com.company;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class ConfigPanel extends JPanel{
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;

    ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init(){
        label = new JLabel("Side length");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        add(label);
        add(sidesField);
        setVisible(true);
    }
}