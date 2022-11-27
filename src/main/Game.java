package main;

import entities.Player;

import java.awt.*;

public class Game implements Runnable{

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    private Player player;
    public Game() {
        initClasses();

        System.out.println("Game Class Starting...");
        gamePanel = new GamePanel(this);
//        Create Game Window
        gameWindow = new GameWindow(gamePanel);
//        gets input focus
        gamePanel.requestFocus();

        startGameLoop();

    }

    private void initClasses() {
        player = new Player(200, 200);
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update(){
        player.update();
    }

    public void render(Graphics g) {
        player.render(g);
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long previousTime = System.nanoTime();

        int frames = 0, updates = 0;

        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
//        FRAMES
        double deltaF = 0;

        while (true) {

            long currentTime = System.nanoTime();

            deltaU += (currentTime-previousTime)/ timePerUpdate;
            deltaF += (currentTime-previousTime)/ timePerFrame;
            previousTime = currentTime;
            if (deltaU >= 1) {
//                UPDATE
                update();
                updates++;
                deltaU--;
            }


            if (deltaF >= 1) {
//               then repaint
                gamePanel.repaint();
                frames++;
                deltaF--;

            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }

        }
    }


    public void windowFocusLost() {
        player.resetDirBooleans();
    }

    public Player getPlayer() {
        return player;
    }
}
