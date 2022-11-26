package main;

public class Game implements Runnable{

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    public Game() {
        System.out.println("Game Class Starting...");
        gamePanel = new GamePanel();
//        Create Game Window
        gameWindow = new GameWindow(gamePanel);
//        gets input focus
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while (true) {

            now = System.nanoTime();
//            now - updateframe more or equal to duration of frame
            if (System.nanoTime() - lastFrame >= timePerFrame) {
//                then repaint
                gamePanel.repaint();
                lastFrame = now;
                frames++;

            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }

        }


    }
}
