package xyz.kingcjy.view;

import xyz.kingcjy.listener.CalculatorKeyListener;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CalculatorFrame {
    private JFrame jFrame;
    private JLabel jLabel;

    private final int WIDTH = 280;
    private final int HEIGHT = 380;

    private final int BUTTON_WIDTH = 70;
    private final int BUTTON_HEIGHT = 60;

    private ActionListener actionListener;

    public CalculatorFrame(CalculatorKeyListener calculatorKeyListener, ActionListener actionListener) {
        this.actionListener = actionListener;

        jFrame = new JFrame();
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.addKeyListener(calculatorKeyListener);

        this.initializeView();
    }

    public void updateLabelValue(int number) {
        jLabel.setText(String.valueOf(number));
    }

    private void initializeView() {
        jFrame.setLayout(null);

        jLabel = new JLabel();
        jLabel.setLocation(0, 0);
        jLabel.setSize(WIDTH-10, 70);
        jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jFrame.add(jLabel);

        String[] arr = {"C", "", "", "/", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+"};

        for(int i = 0; i < arr.length; i++) {
            jFrame.add(createButton(arr[i], (i%4) * BUTTON_WIDTH, (i/4) * BUTTON_HEIGHT + BUTTON_HEIGHT));
        }

        jFrame.add(createButton("0", 0, 300, 210));
        jFrame.add(createButton("=", 210, 300));

        jFrame.setVisible(true);
    }

    private CalculatorButton createButton(String text, int x, int y) {
        return createButton(text, x, y, BUTTON_WIDTH);
    }
    private CalculatorButton createButton(String text, int x, int y, int width) {
        CalculatorButton calculatorButton = new CalculatorButton();
        calculatorButton.setText(text);
        calculatorButton.setSize(width, BUTTON_HEIGHT);
        calculatorButton.setLocation(x, y);
        calculatorButton.addActionListener(this.actionListener);
        calculatorButton.setFocusable(false);
        return calculatorButton;
    }
}
