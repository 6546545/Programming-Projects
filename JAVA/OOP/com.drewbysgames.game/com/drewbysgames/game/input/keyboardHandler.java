package com.drewbysgames.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class keyboardHandler implements KeyListener {

    private Map<Integer, Boolean> keyMap; // Map to track the status of each key

    public keyboardHandler() {
        keyMap = new HashMap<>();
    }

    public boolean isKeyPressed(int keyCode) {
        return keyMap.getOrDefault(keyCode, false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyMap.put(keyCode, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyMap.put(keyCode, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used in this example
    }
}
