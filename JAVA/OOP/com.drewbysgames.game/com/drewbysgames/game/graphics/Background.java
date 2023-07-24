package com.drewbysgames.game.graphics;

import java.awt.Graphics;
import java.awt.Image;

public class Background {

    private Image image;
    // Other 3D-specific properties like position, rotation, etc.

    public Background(Image image) {
        this.image = image;
    }

    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
