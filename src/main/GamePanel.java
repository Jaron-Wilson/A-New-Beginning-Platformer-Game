package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img,subImg;


    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        setPanelSize();
        importImage();

        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }

    public void setRecPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;

    }

    //    Move left and right
    public void changeXDelta(int xDelta) {
        this.xDelta += xDelta;

    }
    //    Move up and down
    public void changeYDelta(int yDelta) {
        this.yDelta += yDelta;

    }

    protected void paintComponent(Graphics g) {
//        calling its own Classes paint component
        super.paintComponent(g);

        subImg = img.getSubimage(1*64,8*40,64,40);

        g.drawImage(subImg, (int) xDelta, (int) yDelta, 128,80, null);

    }



}
