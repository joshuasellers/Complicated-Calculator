package Complicated.Calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Container;

public class Calculator {
    // Calculator logic will go here
    private JFrame calculator;
    // UI components
    private JButton clearButton = new JButton("Clear");
    private JButton equalButton = new JButton("=");
    private JButton plussButton = new JButton("+");
    private JButton zeroButton = new JButton("0");
    private JButton oneButton = new JButton("1");
    private JButton twoButton = new JButton("2");
    private JButton threeButton = new JButton("3");
    private JButton fourButton = new JButton("4");
    private JButton fiveButton = new JButton("5");
    private JButton sixButton = new JButton("6");
    private JButton sevenButton = new JButton("7");
    private JButton eightButton = new JButton("8");
    private JButton nineButton = new JButton("9");
    private JLabel displayLabel = new JLabel("0");
    // Layout components
    private JPanel container;
    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public Calculator(int width, int height, String title) {
        // Initialize the JFrame
        this.calculator = new JFrame(title);
        // Set the default close operation (what happens when the user clicks the 'X' button)
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the frame
        calculator.setSize(width, height);
        // Add components to the frame
        populateCalculator(calculator);
    }

    public JFrame getCalculatorFrame() {
        return this.calculator;
    }

    private void populateCalculator(JFrame frame) {
        container = new JPanel();
        gbc = new GridBagConstraints();
        layout = new GridBagLayout();
        container.setLayout(layout);
        // add components to the container using GridBagLayout
        addobjects(displayLabel, container, layout, gbc, 0, 0, 1, 1);
        addobjects(clearButton, container, layout, gbc, 0, 1, 1, 1);
        addobjects(equalButton, container, layout, gbc, 2, 4, 1, 1);
        addobjects(plussButton, container, layout, gbc, 2, 3, 1, 1);
        addobjects(zeroButton, container, layout, gbc, 0, 4, 1, 1);
        addobjects(oneButton, container, layout, gbc, 0, 3, 1, 1);
        addobjects(twoButton, container, layout, gbc, 1, 3, 1, 1);
        addobjects(threeButton, container, layout, gbc, 2, 2, 1, 1);
        addobjects(fourButton, container, layout, gbc, 0, 2, 1, 1);
        addobjects(fiveButton, container, layout, gbc, 1, 2, 1, 1);
        addobjects(sixButton, container, layout, gbc, 2, 1, 1, 1);
        addobjects(sevenButton, container, layout, gbc, 0, 1, 1, 1);
        addobjects(eightButton, container, layout, gbc, 1, 1, 1, 1);
        addobjects(nineButton, container, layout, gbc, 2, 0, 1, 1);
        // add container to frame
        frame.add(container);
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
        plussButton.addActionListener(e -> displayLabel.setText(displayLabel.getText() + "+"));
        equalButton.addActionListener(e -> {
            String equation = displayLabel.getText();
            String[] parts = equation.split("\\+");
            int sum = 0;
            for (String part : parts) {
                sum += Integer.parseInt(part.trim());
            }
            displayLabel.setText(String.valueOf(sum));
        }); 
    }

    private void addobjects(Component c, Container container, GridBagLayout layout, 
                                GridBagConstraints gbc, int gx, int gy, int gw, int gh){

        gbc.gridx = gx;
        gbc.gridy = gy;

        gbc.gridwidth = gw;
        gbc.gridheight = gh;

        layout.setConstraints(c, gbc);
        container.add(c);
    }
    
}
