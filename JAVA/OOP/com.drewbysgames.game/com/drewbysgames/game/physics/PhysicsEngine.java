package com.drewbysgames.game.physics;

import com.drewbysgames.game.graphics.Model3D;
import java.util.List;

public class PhysicsEngine {

    private List<RigidBody> rigidBodies;

    public PhysicsEngine(List<RigidBody> rigidBodies) {
        this.rigidBodies = rigidBodies;
    }

    public void update(float deltaTime) {
        // Implement physics calculations and update rigid bodies' positions
        // Apply forces, integrate velocity, handle collisions, etc.
    }
}
