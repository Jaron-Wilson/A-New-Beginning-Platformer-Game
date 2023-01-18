package ui;

import gamestates.Gamestate;
import gamestates.Playing;
import main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static utilz.Constants.UI.PauseButtons.*;
import static utilz.Constants.UI.URMButtons.*;

public class PauseOverlay {

    private Playing playing;
    private BufferedImage backgroundImage;
    private int bgX,bgY,bgW,bgH;
    private SoundButton musicButton, sfxButton;
    private UrmButton menuB, replayB, unpauseB;


    public PauseOverlay(Playing playing) {
        this.playing = playing;
        loadBackground();
        createSoundButtons();
        createUrmButtons();
    }

    private void createUrmButtons() {
        int menuX = (int) (313 * Game.SCALE);
        int replayX = (int) (387 * Game.SCALE);
        int unpauseX = (int) (462*Game.SCALE);
        int bY = (int)(325*Game.SCALE);

        menuB = new UrmButton(menuX, bY, URM_SIZE,URM_SIZE, 2);
        replayB = new UrmButton(replayX, bY, URM_SIZE,URM_SIZE, 1);
        unpauseB = new UrmButton(unpauseX, bY, URM_SIZE,URM_SIZE, 0);
    }

    private void createSoundButtons() {
        int soundX = (int) (450 * Game.SCALE);
        int musicY = (int) (140 * Game.SCALE);
        int sfxY = (int) (186 * Game.SCALE);
        musicButton = new SoundButton(soundX, musicY, SOUND_SIZE, SOUND_SIZE);
        sfxButton = new SoundButton(soundX, sfxY, SOUND_SIZE, SOUND_SIZE);
    }

    private void loadBackground() {
        backgroundImage = LoadSave.GetSpriteAtlas(LoadSave.PAUSE_BACKGROUND);
        bgW = (int) (backgroundImage.getWidth() * Game.SCALE);
        bgH = (int) (backgroundImage.getHeight() * Game.SCALE);
        bgX = Game.GAME_WIDTH / 2 - bgW /2;
        bgY = (int) (25 * Game.SCALE);

    }

    public void  update(){
        musicButton.update();
        sfxButton.update();
        menuB.update();
        replayB.update();
        unpauseB.update();

    }

    public void draw(Graphics g) {
//        BackGround
        g.drawImage(backgroundImage, bgX, bgY, bgW, bgH, null);
//        Sound Buttons
        musicButton.draw(g);
        sfxButton.draw(g);
//        Unpause Replay Menu Buttons
        menuB.draw(g);
        replayB.draw(g);
        unpauseB.draw(g);


    }

    public void mouseDragged(MouseEvent e){

    }

    public void mousePressed(MouseEvent e) {
        if (isIn(e, musicButton))
            musicButton.setMousePressed(true);
        else if (isIn(e, sfxButton))
            sfxButton.setMousePressed(true);
        else if (isIn(e, menuB))
            menuB.setMousePressed(true);
        else if (isIn(e, replayB))
            replayB.setMousePressed(true);
        else if (isIn(e, unpauseB))
            unpauseB.setMousePressed(true);

    }


    public void mouseReleased(MouseEvent e) {
        if (isIn(e, musicButton)) {
            if (musicButton.isMousePressed())
                musicButton.setMuted(!musicButton.isMuted());
        }else if (isIn(e, sfxButton)) {
            if (sfxButton.isMousePressed())
                sfxButton.setMuted(!sfxButton.isMuted());
        }else if (isIn(e, menuB)) {
            if (menuB.isMousePressed()) {
                Gamestate.state = Gamestate.MENU;
                playing.unPauseGame();
            }
//            TODO:LEFT OFF HERE: https://youtu.be/y-rvqlMMDIU?t=1219
        }else if (isIn(e, replayB)) {
            if (replayB.isMousePressed())
                System.out.println("Replay level!");
        }else if (isIn(e, unpauseB)) {
            if (unpauseB.isMousePressed())
                playing.unPauseGame();

        }

            musicButton.resetBools();
            sfxButton.resetBools();
            menuB.resetBools();
            replayB.resetBools();
            unpauseB.resetBools();
    }

    public void mouseMoved(MouseEvent e) {
        musicButton.setMouseOver(false);
        sfxButton.setMouseOver(false);
        menuB.setMouseOver(false);
        replayB.setMouseOver(false);
        unpauseB.setMouseOver(false);

        if (isIn(e, musicButton))
            musicButton.setMouseOver(true);
        else if (isIn(e, sfxButton))
            sfxButton.setMouseOver(true);
        else if (isIn(e, menuB))
            menuB.setMouseOver(true);
        else if (isIn(e, replayB))
            replayB.setMouseOver(true);
        else if (isIn(e, unpauseB))
            unpauseB.setMouseOver(true);

    }

    private boolean isIn(MouseEvent e, PauseButton b) {
        return b.getBounds().contains(e.getX(), e.getY());

    }

}
