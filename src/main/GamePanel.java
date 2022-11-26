package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private float xDir = 1f, yDir = 1f;
    private Color color = new Color(23, 144, 186);
    private Random random;


    public GamePanel() {
        random = new Random();
        mouseInputs = new MouseInputs(this);

        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

//    Move left and right
    public void changeXDelta(int xDelta) {
        this.xDelta += xDelta;

    }
//    Move up and down
    public void changeYDelta(int yDelta) {
        this.yDelta += yDelta;

    }

    public void setRecPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;

    }

    protected void paintComponent(Graphics g) {
//        calling its own Classes paint component
        super.paintComponent(g);

        g.setColor(color);

        updateRectangle();

        g.fillRect((int) xDelta, (int) yDelta,200,50);
    }

    private void updateRectangle() {
        xDelta+=xDir;
        if (xDelta > 400 || xDelta < 0){
//            Reverse direction
            xDir*=-1;
            color = getRandomColor();
        }

        yDelta+=yDir;
        if (yDelta > 400 || yDelta < 0){
//            Reverse direction
            yDir*=-1;
            color = getRandomColor();
        }
    }

    private Color getRandomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r,g,b);
    }


}
