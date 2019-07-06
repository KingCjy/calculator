package xyz.kingcjy.listener;

import xyz.kingcjy.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorButtonListener implements ActionListener {
    private Calculator calculator;

    public CalculatorButtonListener(Calculator calculator) {
        this.calculator = calculator;
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();

        calculator.onRequest(text);
    }
}
