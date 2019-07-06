package xyz.kingcjy.listener;

import xyz.kingcjy.Calculator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CalculatorKeyListener implements KeyListener {
    private Calculator calculator;

    public CalculatorKeyListener(Calculator calculator) {
        this.calculator = calculator;
    }

    public void keyTyped(KeyEvent e) {
        calculator.onRequest(String.valueOf(e.getKeyChar()));
    }

    public void keyPressed(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}
}
