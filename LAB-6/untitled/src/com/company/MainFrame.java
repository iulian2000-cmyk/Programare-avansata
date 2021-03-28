package com.company;


import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class MainFrame extends JFrame{
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    MainFrame(){
        super("Compulsory");
        init();
    }
    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.configPanel = new ConfigPanel(this);
        this.canvas = new DrawingPanel(this);
        this.controlPanel = new ControlPanel(this);

        add(configPanel,BorderLayout.NORTH);
        add(canvas,BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    public static void main(String []args)
    {
        MainFrame frame = new MainFrame();
    }
}