package inputs;

import gamestates.Gamestate;
import main.GamePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInputs extends MouseAdapter {// implements MouseListener, MouseMotionListener {

    private GamePanel gamePanel;
    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Gamestate.state) {

            case PLAYING -> {
                gamePanel.getGame().getPlaying().mouseClicked(e);
            }
            case MENU -> {
                gamePanel.getGame().getMenu().mouseClicked(e);
            }
        }
    }


}
