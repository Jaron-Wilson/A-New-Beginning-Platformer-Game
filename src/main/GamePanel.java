package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int animationTick, animationIndex, animationSpeed = 15;
    private int playerAction = IDLE;
    private int playerDirection = -1;
    private boolean moving = false;


    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        setPanelSize();
        importImage();
        loadAnimations();

        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
//        [y][x]
        animations = new BufferedImage[9][6];

        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);

            }
        }
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
                try {
                    is.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }

    public void setDirection(int direction) {
        this.playerDirection = direction;
        moving = true;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void updateAnimationTick() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= GetSpriteAmount(playerAction)){
                animationIndex = 0;
            }
        }
    }

    private void setAnimation() {
        if (moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
    }

    public void updateGame() {
//        ANIMATIONS
        updateAnimationTick();
        setAnimation();
        updatePosition();
    }

    protected void paintComponent(Graphics g) {
//        calling super's Classes paint component
        super.paintComponent(g);


        g.drawImage(animations[playerAction][animationIndex], (int) xDelta, (int) yDelta, 256,160, null);

    }

    private void updatePosition() {
        if (moving) {
            switch (playerDirection) {
//                same as -> case LEFT: xDelta -=5; break;
                case LEFT -> xDelta -= 5;
                case UP -> yDelta -= 5;
                case RIGHT -> xDelta += 5;
                case DOWN -> yDelta += 5;
            }
        }
    }

}
