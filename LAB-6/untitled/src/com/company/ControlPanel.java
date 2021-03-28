package com.company;

import javafx.scene.shape.Ellipse;

import javax.imageio.ImageIO;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn;
    JButton loadBtn;
    JButton resetBtn;
    JButton exitBtn ;
    JButton undo;
    JButton delete;

    ControlPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        setLayout(new GridLayout(1,4));

        saveBtn = new JButton("Save");
        saveBtn.addActionListener(this::save);
        add(saveBtn);
        loadBtn = new JButton("Load");
        loadBtn.addActionListener(this::load);
        add(loadBtn);
        resetBtn = new JButton("Reset");
        resetBtn.addActionListener(this::reset);
        add(resetBtn);
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(this::exit);
        add(exitBtn);

        undo = new JButton("Undo");
        undo.addActionListener(this::undo);
        add(undo);

        delete = new JButton("Delete");
        delete.addActionListener(this::delete);
        add(delete);
        setVisible(true);
    }
    private void undo(ActionEvent a)
    {
        String color = (String) frame.configPanel.colorCombo.getSelectedItem();
        if(color == "RED")
        {
            frame.canvas.graphics.setColor(Color.RED);
        }
        if(color == "BLUE")
        {
            frame.canvas.graphics.setColor(Color.BLUE);
        }
        if(color == "GREEN")
        {
            frame.canvas.graphics.setColor(Color.GREEN);
        }
        if(frame.canvas.deletedShapes.size() > 0) {
            Shape deletedShape = frame.canvas.deletedShapes.pop();
            frame.canvas.graphics.fill(deletedShape);
            frame.canvas.repaint();
        }
    }
    private void delete(ActionEvent a) {
        if (frame.canvas.shapes.size() > 0) {
            Shape shapeToDelete = frame.canvas.shapes.pop();
            frame.canvas.graphics.setColor(Color.WHITE);
            frame.canvas.graphics.fill(shapeToDelete);
            frame.canvas.deletedShapes.push(shapeToDelete);
            frame.canvas.repaint();
        }
    }
    private void exit(ActionEvent a)
    {
        System.exit(0);
    }
    private void reset(ActionEvent a)
    {
        frame.canvas.createOffscreenImage();
    }
    private void load(ActionEvent e)
    {
       JFileChooser loadFileHandler = new JFileChooser();
       loadFileHandler.setDialogTitle("Load the file:");
       int userSelection = loadFileHandler.showSaveDialog(frame);
       if(userSelection == JFileChooser.APPROVE_OPTION)
       {
           File fileToLoad = loadFileHandler.getSelectedFile();
           try {
               frame.canvas.image = ImageIO.read(fileToLoad);
               frame.canvas.validate();
               frame.canvas.repaint();
               //frame.canvas.graphics = frame.canvas.image.createGraphics();
           }catch (IOException a) {
               System.err.println(a);
           }
       }
    }
    private void save(ActionEvent actionEvent) {
        JFileChooser saveFileHandler = new JFileChooser();
        saveFileHandler.setDialogTitle("Saving file");
        int userSelection = saveFileHandler.showSaveDialog(frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = saveFileHandler.getSelectedFile();
             try {
                 ImageIO.write(frame.canvas.image, "PNG", new File(fileToSave.getAbsolutePath()));
             }catch (IOException a) {
                 System.err.println(a);
             }
        }
    }

}

