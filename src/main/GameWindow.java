package main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

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
        jFrame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                System.out.println("IM BACK");
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("Lost focus");
                gamePanel.getGame().windowFocusLost();
            }
        });
    }
}
