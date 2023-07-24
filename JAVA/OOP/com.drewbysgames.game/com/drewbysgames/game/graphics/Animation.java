package com.drewbysgames.game.graphics;

import java.util.ArrayList;
import java.util.List;

public class Animation {

    private List<Sprite> frames;
    private int currentFrameIndex;
    private long lastFrameTime;
    private long frameDuration;

    public Animation(long frameDuration) {
        this.frameDuration = frameDuration;
        frames = new ArrayList<>();
        currentFrameIndex = 0;
        lastFrameTime = System.currentTimeMillis();
    }

    public void addFrame(Sprite frame) {
        frames.add(frame);
    }

    public Sprite getCurrentFrame() {
        return frames.get(currentFrameIndex);
    }

    public void update() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastFrameTime >= frameDuration) {
            currentFrameIndex = (currentFrameIndex + 1) % frames.size();
            lastFrameTime = currentTime;
        }
    }
}
