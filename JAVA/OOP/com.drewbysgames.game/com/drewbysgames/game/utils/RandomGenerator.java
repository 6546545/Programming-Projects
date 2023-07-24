package com.drewbysgames.game.utils;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();

    public static int getRandomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static float getRandomFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    // Add other random generation utility methods as needed
}
