package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class DrawingPanel extends JPanel implements MouseMotionListener{
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D    graphics;
    Stack<Shape>  shapes;
    Stack<Shape> deletedShapes;
    private  boolean first = true;
    private int x,y,x1,y1;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        shapes = new Stack<>();
        deletedShapes = new Stack<>();
        init();
        addMouseMotionListener(this);
    }

    public void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
        repaint();
        deletedShapes = shapes;
    }
    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }
    private void drawShape(int x, int y) {
        int radius = (Integer) frame.configPanel.radius.getValue();
        int sides = (Integer) frame.configPanel.sidesField.getValue() ;
        String color = (String) frame.configPanel.colorCombo.getSelectedItem();
        if(color == "RED"){

            graphics.setColor(Color.RED);
        }
        if(color == "BLUE")
        {
            graphics.setColor(Color.BLUE);
        }
        if(color == "GREEN")
        {
            graphics.setColor(Color.GREEN);
        }
        String shape = (String) frame.configPanel.selectShape.getSelectedItem();
        if(shape.equals("ELLIPSE")) {
            graphics.fill(new Ellipse2D.Double(x, y,(Integer)frame.configPanel.width.getValue(),(Integer)frame.configPanel.height.getValue()));
            this.shapes.push(new Ellipse2D.Double(x,y,(Integer)frame.configPanel.width.getValue(),(Integer)frame.configPanel.height.getValue()));
        }else{
            graphics.fill(new RegularPolygon(x,y,radius,sides));
            this.shapes.push(new RegularPolygon(x,y,radius,sides));
        }
    }
    @Override
    public void update(Graphics g) { }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x =x1; y = y1;
        x1 = e.getX();
        y1 = e.getY();
        if(first){
            x = x1;
            y = y1;
            first  = false;
        }
        repaint();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
          repaint();
    }
    public void paint(Graphics graphics){
        graphics.setColor(Color.BLACK);
        graphics.drawLine(x, y, x1, y1);
        //x1 = MouseInfo.getPointerInfo().getLocation().x;
        //y1 = MouseInfo.getPointerInfo().getLocation().y;
    }
}
