package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private int xDelta = 100, yDelta = 100;
    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

//    Move left and right
    public void changeXDelta(int xDelta) {
        this.xDelta += xDelta;
        repaint();
    }
//    Move up and down
    public void changeYDelta(int yDelta) {
        this.yDelta += yDelta;
        repaint();
    }

    public void setRecPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    protected void paintComponent(Graphics g) {
//        calling its own Classes paint component
        super.paintComponent(g);

        g.fillRect(xDelta,yDelta,200,50);
    }

}
