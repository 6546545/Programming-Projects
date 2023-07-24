package com.drewbysgames.game.physics;

import com.drewbysgames.game.graphics.Model3D;
import com.drewbysgames.game.graphics.Sprite;

public class RigidBody {

    private Model3D model3D;
    private Collider collider;
    private float mass;
    private float[] position;
    private float[] velocity;
    private float[] acceleration;
    private float[] forces;

    public RigidBody(Model3D model3D, float mass, float[] position) {
        this.model3D = model3D;
        this.collider = new Collider(model3D);
        this.mass = mass;
        this.position = position;
        this.velocity = new float[3]; // x, y, z velocity components
        this.acceleration = new float[3]; // x, y, z acceleration components
        this.forces = new float[3]; // x, y, z forces components
    }

    public void applyForce(float forceX, float forceY, float forceZ) {
        forces[0] += forceX;
        forces[1] += forceY;
        forces[2] += forceZ;
    }

    public void update(float deltaTime) {
        // Implement physics calculations for rigid body
        // Update position, velocity, and apply forces
    }
}
