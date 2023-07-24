package com.drewbysgames.game.physics;

import com.drewbysgames.game.graphics.Model3D;

public class Collider {

    private Model3D model3D;
    // Other 3D-specific collider properties like bounding boxes, collision shapes, etc.

    public Collider(Model3D model3D) {
        this.model3D = model3D;
    }

    public boolean checkCollision(Collider otherCollider) {
        // Implement collision detection logic between two colliders
        // For example, check if the bounding boxes or collision shapes overlap
        return false;
    }
}
