package inputs;

import gamestates.Gamestate;
import main.GamePanel;

import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs extends MouseAdapter {//implements MouseListener, MouseMotionListener {

    private GamePanel gamePanel;
    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (Gamestate.state) {
            case PLAYING -> {
                gamePanel.getGame().getPlaying().mouseDragged(e);
            }
            case MENU -> {
                gamePanel.getGame().getMenu().mousePressed(e);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (Gamestate.state) {

            case PLAYING -> {
                gamePanel.getGame().getPlaying().mouseMoved(e);
            }
            case MENU -> {
                gamePanel.getGame().getMenu().mouseMoved(e);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Gamestate.state) {

            case PLAYING -> {
                gamePanel.getGame().getPlaying().mouseClicked(e);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (Gamestate.state) {

            case PLAYING -> {
                gamePanel.getGame().getPlaying().mousePressed(e);
            }
            case MENU -> {
                gamePanel.getGame().getMenu().mousePressed(e);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Gamestate.state) {

            case PLAYING -> {
                gamePanel.getGame().getPlaying().mouseReleased(e);
            }
            case MENU -> {
                gamePanel.getGame().getMenu().mouseReleased(e);
            }
        }
    }
}
