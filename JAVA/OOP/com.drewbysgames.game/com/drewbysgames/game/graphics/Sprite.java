package com.drewbysgames.game.graphics;

import java.awt.Image;

public class Sprite {

    private Image image;
    // Other 3D-specific properties like texture coordinates, normals, etc.

    public Sprite(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
}
