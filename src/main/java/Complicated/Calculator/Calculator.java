package Complicated.Calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Calculator {
    // Calculator logic will go here
    private JFrame calculator;

    public Calculator(int width, int height, String title) {
        // Initialize the JFrame
        this.calculator = new JFrame(title);
        // Set the default close operation (what happens when the user clicks the 'X' button)
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the frame
        calculator.setSize(width, height);

        JPanel panel = new JPanel();

        JButton clearButton = new JButton("Clear");
        JButton equaButton = new JButton("=");
        JButton plButton = new JButton("+");
        JButton zeroButton = new JButton("0");
        JButton oneButton = new JButton("1");
        JButton twoButton = new JButton("2");
        JButton threeButton = new JButton("3");
        JButton fourButton = new JButton("4");
        JButton fiveButton = new JButton("5");
        JButton sixButton = new JButton("6");
        JButton sevenButton = new JButton("7");
        JButton eightButton = new JButton("8");
        JButton nineButton = new JButton("9");
        JLabel displayLabel = new JLabel("0");

        panel.setLayout(new GridLayout(2, 7)); // 2 rows, 7 columns
        panel.add(displayLabel);
        panel.add(clearButton);
        panel.add(equaButton);
        panel.add(plButton);
        panel.add(zeroButton);
        panel.add(oneButton);
        panel.add(twoButton);
        panel.add(threeButton);
        panel.add(fourButton);
        panel.add(fiveButton);
        panel.add(sixButton);
        panel.add(sevenButton);
        panel.add(eightButton);
        panel.add(nineButton);

        calculator.add(panel, BorderLayout.CENTER); // Add the panel to the center of the frame

        // add button action listener
        clearButton.addActionListener(e -> displayLabel.setText("0"));
        zeroButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "0"));
        oneButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "1"));
        twoButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "2"));
        threeButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "3"));
        fourButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "4"));
        fiveButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "5"));
        sixButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "6"));
        sevenButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "7"));
        eightButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "8"));
        nineButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "9"));
        plButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "+"));
        equaButton.addActionListener(e -> {
            String equation = displayLabel.getText();
            String[] parts = equation.split("\\+");
            int sum = 0;
            for (String part : parts) {
                sum += Integer.parseInt(part);
            }
            displayLabel.setText(String.valueOf(sum));
        }); 
    }

    public JFrame getCalculatorFrame() {
        return this.calculator;
    }
    
}
