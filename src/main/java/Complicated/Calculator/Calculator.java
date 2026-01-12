package Complicated.Calculator;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import Complicated.Calculator.misc.Helper;
import Complicated.Calculator.misc.ImagePanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Calculator {
    // Calculator logic will go here
    private JFrame calculator;
    // Basic calculator buttons
    private JButton clearButton = new JButton("Clear");
    private JButton equalButton = new JButton("=");
    private JButton plussButton = new JButton("+");
    private JButton minusButton = new JButton("-"); 
    private JButton timesButton = new JButton("*");     
    private JButton divideButton = new JButton("/");
    private JButton powerButton = new JButton("^");
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
    // Advanced math buttons
    private JButton sinButton = new JButton("sin");
    private JButton cosButton = new JButton("cos");
    private JButton tanButton = new JButton("tan");
    private JButton lnButton = new JButton("ln");
    // Advanced math toggle button with icons
    ImageIcon onIcon = new ImageIcon("/Users/joshuasellers/Dropbox/github/Complicated Calculator/Complicated-Calculator/src/main/java/Complicated/Calculator/icons/advOn.png"); 
    Image onImage = onIcon.getImage();
    Image scaledOnImage = onImage.getScaledInstance(60, 20, Image.SCALE_SMOOTH);
    ImageIcon scaledOnImageIcon = new ImageIcon(scaledOnImage);
    ImageIcon offIcon = new ImageIcon("/Users/joshuasellers/Dropbox/github/Complicated Calculator/Complicated-Calculator/src/main/java/Complicated/Calculator/icons/advOff.png"); 
    Image offImage = offIcon.getImage(); 
    Image scaledOffImage = offImage.getScaledInstance(60, 20, Image.SCALE_SMOOTH);
    ImageIcon scaledOffImageIcon = new ImageIcon(scaledOffImage);
    ImageIcon backgroundIcon = new ImageIcon("/Users/joshuasellers/Dropbox/github/Complicated Calculator/Complicated-Calculator/src/main/java/Complicated/Calculator/icons/background.jpg");
    Image backgroundImage = backgroundIcon.getImage();
    Image scaledBackgroundImage = backgroundImage.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
    private JToggleButton advancedMathButton = new JToggleButton(scaledOffImageIcon);
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
        container = new ImagePanel(backgroundImage);
        gbc = new GridBagConstraints();
        layout = new GridBagLayout();
        container.setLayout(layout);
        container.paintComponents(container.getGraphics());
        // Set colors
        displayLabel.setBackground(Color.WHITE);
        displayLabel.setOpaque(true);
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setForeground(Color.BLACK);
        displayLabel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        displayLabel.setMinimumSize(new Dimension(500, 50));
        displayLabel.setPreferredSize(new Dimension(500, 50));
        // Set font sizes
        displayLabel.setFont(displayLabel.getFont().deriveFont(24f));
        clearButton.setFont(clearButton.getFont().deriveFont(18f));
        equalButton.setFont(equalButton.getFont().deriveFont(18f));
        plussButton.setFont(plussButton.getFont().deriveFont(18f));
        minusButton.setFont(minusButton.getFont().deriveFont(18f));
        timesButton.setFont(timesButton.getFont().deriveFont(18f));
        divideButton.setFont(divideButton.getFont().deriveFont(18f));
        powerButton.setFont(powerButton.getFont().deriveFont(18f));
        leftParenthesisButton.setFont(leftParenthesisButton.getFont().deriveFont(18f));
        rightParenthesisButton.setFont(rightParenthesisButton.getFont().deriveFont(18f));
        zeroButton.setFont(zeroButton.getFont().deriveFont(18f));
        oneButton.setFont(oneButton.getFont().deriveFont(18f));
        twoButton.setFont(twoButton.getFont().deriveFont(18f));
        threeButton.setFont(threeButton.getFont().deriveFont(18f));
        fourButton.setFont(fourButton.getFont().deriveFont(18f));
        fiveButton.setFont(fiveButton.getFont().deriveFont(18f));
        sixButton.setFont(sixButton.getFont().deriveFont(18f));
        sevenButton.setFont(sevenButton.getFont().deriveFont(18f));
        eightButton.setFont(eightButton.getFont().deriveFont(18f));
        nineButton.setFont(nineButton.getFont().deriveFont(18f));
        // add components to the container using GridBagLayout
        // Make the display label take the entire top row (span all columns)
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        Helper.addobjects(displayLabel, container, layout, gbc, 0, 0, 6, 1);
        // Reset fill/weight for the rest of the components so they size normally
        gbc.fill = GridBagConstraints.NONE;
        Helper.addobjects(advancedMathButton, container, layout, gbc, 0, 1, 1, 1);
        Helper.addobjects(clearButton, container, layout, gbc, 0, 2, 1, 1);
        Helper.addobjects(equalButton, container, layout, gbc, 0, 3, 1, 1);
        Helper.addobjects(plussButton, container, layout, gbc, 2, 1, 1, 1);
        Helper.addobjects(minusButton, container, layout, gbc, 2, 2, 1, 1);
        Helper.addobjects(timesButton, container, layout, gbc, 2, 3, 1, 1);
        Helper.addobjects(divideButton, container, layout, gbc, 2, 4, 1, 1);
        Helper.addobjects(powerButton, container, layout, gbc, 1, 1, 1, 1);
        Helper.addobjects(zeroButton, container, layout, gbc, 3, 1, 1, 1);
        Helper.addobjects(oneButton, container, layout, gbc, 3, 2, 1, 1);
        Helper.addobjects(twoButton, container, layout, gbc, 3, 3, 1, 1);
        Helper.addobjects(threeButton, container, layout, gbc, 3, 4, 1, 1);
        Helper.addobjects(fourButton, container, layout, gbc, 4, 1, 1, 1);
        Helper.addobjects(fiveButton, container, layout, gbc, 4, 2, 1, 1);
        Helper.addobjects(sixButton, container, layout, gbc, 4, 3, 1, 1);
        Helper.addobjects(sevenButton, container, layout, gbc, 4, 4, 1, 1);
        Helper.addobjects(eightButton, container, layout, gbc, 5, 1, 1, 1);
        Helper.addobjects(nineButton, container, layout, gbc, 5, 2, 1, 1);
        Helper.addobjects(leftParenthesisButton, container, layout, gbc, 5, 3, 1, 1);
        Helper.addobjects(rightParenthesisButton, container, layout, gbc, 5, 4, 1, 1);
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
        powerButton.addActionListener(e -> {
            if (!displayLabel.getText().endsWith("+ ") && !displayLabel.getText().endsWith("- ") &&
                !displayLabel.getText().endsWith("* ") && !displayLabel.getText().endsWith("/ ")) {
                updateInput(" ^ ");
            }
        });
        // Key listener for keyboard input
        frame.setFocusable(true);
        frame.addKeyListener(
            new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    // Not used
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    char keyChar = e.getKeyChar();
                    switch (keyChar) {
                        case '0':
                            zeroButton.doClick();
                            break;
                        case '1':
                            oneButton.doClick();
                            break;
                        case '2':
                            twoButton.doClick();
                            break;
                        case '3':
                            threeButton.doClick();
                            break;
                        case '4':
                            fourButton.doClick();
                            break;
                        case '5':
                            fiveButton.doClick();
                            break;
                        case '6':
                            sixButton.doClick();
                            break;
                        case '7':
                            sevenButton.doClick();
                            break;
                        case '8':
                            eightButton.doClick();
                            break;
                        case '9':
                            nineButton.doClick();
                            break;
                        case '+':
                            plussButton.doClick();
                            break;
                        case '-':
                            minusButton.doClick();
                            break;
                        case '*':
                            timesButton.doClick();
                            break;
                        case '/':
                            divideButton.doClick();
                            break;
                        case '^':
                            powerButton.doClick();
                            break;
                        case '=':
                        case '\n':
                            equalButton.doClick(); // Enter key
                            break;
                        case 'c':
                        case 'C':
                            clearButton.doClick();
                            break;
                        case '(':
                            leftParenthesisButton.doClick();
                            break;
                        case ')':
                            rightParenthesisButton.doClick();
                            break;
                        case '\u001B': // Escape key
                            frame.dispose();
                            break;
                    }
                    System.out.println("Key Pressed: " + keyChar);
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    // Not used
                }
            }
        );

        sinButton.addActionListener(e -> updateInput(" sin ( "));
        cosButton.addActionListener(e -> updateInput(" cos ( "));
        tanButton.addActionListener(e -> updateInput(" tan ( "));
        lnButton.addActionListener(e -> updateInput(" ln ( "));
        leftParenthesisButton.addActionListener(e -> updateInput(" ( "));
        rightParenthesisButton.addActionListener(e -> updateInput(" ) "));  
        advancedMathButton.addActionListener(e -> {
            if (advancedMathButton.isSelected()) {
                advancedMathButton.setIcon(scaledOnImageIcon);
                // remove basic operations
                System.out.println("Advanced math mode ON");
                container.remove(minusButton);
                container.remove(plussButton);
                container.remove(timesButton);
                container.remove(divideButton);
                Helper.addobjects(sinButton, container, layout, gbc, 2, 1, 1, 1);
                Helper.addobjects(cosButton, container, layout, gbc, 2, 2, 1, 1);
                Helper.addobjects(tanButton, container, layout, gbc, 2, 3, 1, 1);
                Helper.addobjects(lnButton, container, layout, gbc, 2, 4, 1, 1);
                container.revalidate();
                container.repaint();
            } else {
                advancedMathButton.setIcon(scaledOffImageIcon);
                System.out.println("Advanced math mode OFF");
                container.remove(sinButton);
                container.remove(cosButton);
                container.remove(tanButton);
                container.remove(lnButton);
                Helper.addobjects(plussButton, container, layout, gbc, 2, 1, 1, 1);
                Helper.addobjects(minusButton, container, layout, gbc, 2, 2, 1, 1);
                Helper.addobjects(timesButton, container, layout, gbc, 2, 3, 1, 1);
                Helper.addobjects(divideButton, container, layout, gbc, 2, 4, 1, 1);
                container.revalidate();
                container.repaint();
            }
        });
        equalButton.addActionListener(e -> {
            String equation = displayLabel.getText();
            equation = confirmMatchingParentheses(equation);
            double result = Helper.evaluateRpn(equation);
            displayLabel.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            currentResult = result;
        }); 
    }

    private String confirmMatchingParentheses(String equation) {
        int openParens = 0;
        int closeParens = 0;
        for (char c : equation.toCharArray()) {
            if (c == '(') {
                openParens++;
            } else if (c == ')') {
                closeParens++;
            }
        }
        StringBuilder updatedEquation = new StringBuilder(equation);
        while (openParens > closeParens) {
            updatedEquation.append(" )");
            closeParens++;
        }
        return updatedEquation.toString();
    }

    private void updateInput(String input) {
        System.out.println("Current Input: " + currentInput);
        System.out.println("Display Label: " + displayLabel.getText());
        System.out.println("Input: " + input);
        if (displayLabel.getText().equals("0") && !input.equals(" + ") 
                && !input.equals(" * ") && !input.equals(" / ") 
                && !input.equals(" ^ ")) {
            System.out.println("Replacing initial 0 with input: " + input);
            displayLabel.setText(input);
            currentInput = input;
        } else if (currentInput.endsWith(")")) {
            System.out.println("Input ends with closing parenthesis, cannot add more input directly.");
            return; // Prevent adding input directly after a closing parenthesis
        } else if(input.equals("0") && (currentInput.equals("") || currentInput.endsWith(" 0"))){
            System.out.println("Preventing leading zeros.");
            return; // Prevent leading zeros
        } else if(input.equals(" + ") || input.equals(" - ") || input.equals(" * ") 
                || input.equals(" / ") || input.equals(" ^ ")){
            // Prevent adding operator if the last character is also an operator
            if(displayLabel.getText().endsWith(" + ") || displayLabel.getText().endsWith(" - ") 
                || displayLabel.getText().endsWith(" * ") || displayLabel.getText().endsWith(" / ") 
                || displayLabel.getText().endsWith(" ^ ")){
                System.out.println("Preventing consecutive operators.");
                return;
            }else{
                System.out.println("Adding operator: " + input);
                displayLabel.setText(displayLabel.getText() + input);
                currentInput += input;
            }
        }else if((displayLabel.getText().strip().equals("-") || displayLabel.getText().endsWith("( - ")) && (input.equals("1") || input.equals("2")
                || input.equals("3") || input.equals("4") || input.equals("5")
                || input.equals("6") || input.equals("7") || input.equals("8")
                || input.equals("9"))){
            // Prevent adding space after negative sign before a number
            System.out.println("Preventing space after negative sign before number.");
            displayLabel.setText(displayLabel.getText().substring(0, displayLabel.getText().length() - 3) + "-" + input.trim());
            currentInput = currentInput.substring(0, currentInput.length() - 3) + "-" + input.trim();
        } else{
            System.out.println("No formatting needed. Adding input: " + input);
            displayLabel.setText(displayLabel.getText() + input);
            currentInput += input;
        }
    }
}
