package com.drewbysgames.game.graphics;

import java.awt.Graphics;
import java.util.List;

public class Model3D {

    private List<Sprite> textures;
    // Other 3D-specific properties like vertices, faces, etc.

    public Model3D(List<Sprite> textures) {
        this.textures = textures;
    }

    public void draw(Graphics g) {
        // Implement how to draw the 3D model using textures
    }
}
