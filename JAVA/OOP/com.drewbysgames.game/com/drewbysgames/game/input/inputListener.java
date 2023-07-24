package com.drewbysgames.game.input;

public interface InputListener {
    void onKeyPress(int keyCode);
    void onKeyRelease(int keyCode);
    void onMousePress(int button, int x, int y);
    void onMouseRelease(int button, int x, int y);
    void onMouseMove(int x, int y);
}
