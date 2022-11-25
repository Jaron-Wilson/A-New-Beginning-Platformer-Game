package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {

    }


    protected void paintComponent(Graphics g) {
//        calling its own Classes paint component
        super.paintComponent(g);

        g.fillRect(100,100,200,50);
    }

}
