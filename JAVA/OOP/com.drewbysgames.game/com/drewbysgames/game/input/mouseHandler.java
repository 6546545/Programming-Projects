package com.drewbysgames.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mouseHandler implements MouseListener, MouseMotionListener {

    private boolean[] mouseButtons; // Array to track the status of each mouse button
    private int mouseX; // Current X-coordinate of the mouse
    private int mouseY; // Current Y-coordinate of the mouse

    public mouseHandler() {
        mouseButtons = new boolean[5];
    }

    public boolean isMouseButtonPressed(int button) {
        return mouseButtons[button];
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Not used in this example
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int button = e.getButton();
        if (button >= 0 && button < mouseButtons.length) {
            mouseButtons[button] = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int button = e.getButton();
        if (button >= 0 && button < mouseButtons.length) {
            mouseButtons[button] = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Not used in this example
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Not used in this example
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
}
