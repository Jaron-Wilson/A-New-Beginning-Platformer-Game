package main;

import javax.swing.*;

public class GameWindow {
    private JFrame jFrame;

    public GameWindow(GamePanel gamePanel) {
        System.out.println("Game Window Starting...");
        jFrame = new JFrame();

//        Make Window
        jFrame.setSize(400,400);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        add the panel into frame
        jFrame.add(gamePanel);

//        set Location to middle
        jFrame.setLocationRelativeTo(null);
//        SetVisible HAS TO BE LAST!
        jFrame.setVisible(true);
    }
}
