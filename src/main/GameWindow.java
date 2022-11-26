package main;

import javax.swing.*;

public class GameWindow {
    private JFrame jFrame;

    public GameWindow(GamePanel gamePanel) {
        System.out.println("Game Window Starting...");
        jFrame = new JFrame();


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        add the panel into frame
        jFrame.add(gamePanel);

//        set Location to middle
        jFrame.setLocationRelativeTo(null);

        jFrame.pack();

//        SetVisible HAS TO BE LAST!
        jFrame.setVisible(true);
    }
}
