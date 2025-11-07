package Complicated.Calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Container;
import java.util.List;

public class Calculator {
    // Calculator logic will go here
    private JFrame calculator;
    // UI components
    private JButton clearButton = new JButton("Clear");
    private JButton equalButton = new JButton("=");
    private JButton plussButton = new JButton("+");
    private JButton minusButton = new JButton("-"); 
    private JButton timesButton = new JButton("*");     
    private JButton divideButton = new JButton("/");
    private JButton leftParenthesisButton = new JButton("(");
    private JButton rightParenthesisButton = new JButton(")");  
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
    // Store current input and result
    private String currentInput = "";
    private double currentResult = 0;

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
        Helper.addobjects(displayLabel, container, layout, gbc, 0, 0, 1, 1);
        Helper.addobjects(clearButton, container, layout, gbc, 0, 2, 1, 1);
        Helper.addobjects(equalButton, container, layout, gbc, 0, 3, 1, 1);
        Helper.addobjects(plussButton, container, layout, gbc, 2, 0, 1, 1);
        Helper.addobjects(minusButton, container, layout, gbc, 2, 1, 1, 1);
        Helper.addobjects(timesButton, container, layout, gbc, 2, 2, 1, 1);
        Helper.addobjects(divideButton, container, layout, gbc, 2, 3, 1, 1);
        Helper.addobjects(zeroButton, container, layout, gbc, 3, 0, 1, 1);
        Helper.addobjects(oneButton, container, layout, gbc, 3, 1, 1, 1);
        Helper.addobjects(twoButton, container, layout, gbc, 3, 2, 1, 1);
        Helper.addobjects(threeButton, container, layout, gbc, 3, 3, 1, 1);
        Helper.addobjects(fourButton, container, layout, gbc, 4, 0, 1, 1);
        Helper.addobjects(fiveButton, container, layout, gbc, 4, 1, 1, 1);
        Helper.addobjects(sixButton, container, layout, gbc, 4, 2, 1, 1);
        Helper.addobjects(sevenButton, container, layout, gbc, 4, 3, 1, 1);
        Helper.addobjects(eightButton, container, layout, gbc, 5, 0, 1, 1);
        Helper.addobjects(nineButton, container, layout, gbc, 5, 1, 1, 1);
        Helper.addobjects(leftParenthesisButton, container, layout, gbc, 5, 2, 1, 1);
        Helper.addobjects(rightParenthesisButton, container, layout, gbc, 5, 3, 1, 1);
        // add container to frame
        frame.add(container);
        // add button action listener
        clearButton.addActionListener(e -> {
            displayLabel.setText("0");
            currentInput = "";
            currentResult = 0;
        });
        zeroButton.addActionListener(e -> updateInput("0"));
        oneButton.addActionListener(e -> updateInput("1"));
        twoButton.addActionListener(e -> updateInput("2"));
        threeButton.addActionListener(e -> updateInput("3"));
        fourButton.addActionListener(e -> updateInput("4"));
        fiveButton.addActionListener(e -> updateInput("5"));
        sixButton.addActionListener(e -> updateInput("6"));
        sevenButton.addActionListener(e -> updateInput("7"));
        eightButton.addActionListener(e -> updateInput("8"));
        nineButton.addActionListener(e -> updateInput("9"));
        plussButton.addActionListener(e -> {
            if (!displayLabel.getText().endsWith("+ ") && !displayLabel.getText().endsWith("- ") &&
                !displayLabel.getText().endsWith("* ") && !displayLabel.getText().endsWith("/ ")) {
                updateInput(" + ");
            }
        });
        minusButton.addActionListener(e -> {
            if (!displayLabel.getText().endsWith("+ ") && !displayLabel.getText().endsWith("- ") &&
                !displayLabel.getText().endsWith("* ") && !displayLabel.getText().endsWith("/ ")) {
                updateInput(" - ");
            }
        });
        timesButton.addActionListener(e -> {
            if (!displayLabel.getText().endsWith("+ ") && !displayLabel.getText().endsWith("- ") &&
                !displayLabel.getText().endsWith("* ") && !displayLabel.getText().endsWith("/ ")) {
                updateInput(" * ");
            }
        });
        divideButton.addActionListener(e -> {
            if (!displayLabel.getText().endsWith("+ ") && !displayLabel.getText().endsWith("- ") &&
                !displayLabel.getText().endsWith("* ") && !displayLabel.getText().endsWith("/ ")) {
                updateInput(" / ");
            }
        });
        leftParenthesisButton.addActionListener(e -> updateInput(" ( "));
        rightParenthesisButton.addActionListener(e -> updateInput(" ) "));  
        equalButton.addActionListener(e -> {
            String equation = displayLabel.getText();
            double result = Helper.evaluateRpn(equation);
            displayLabel.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            currentResult = result;
        }); 
    }

    private void updateInput(String input) {
        displayLabel.setText(displayLabel.getText() + input);
        currentInput += input;
    }
}
