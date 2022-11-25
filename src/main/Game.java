package main;

public class Game {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    public Game() {
        System.out.println("Game Class Starting...");
        gamePanel = new GamePanel();
//        Create Game Window
        gameWindow = new GameWindow(gamePanel);
//        gets input focus
        gamePanel.requestFocus();
    }
}
