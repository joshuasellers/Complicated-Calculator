# Complicated Calculator

A Java-based desktop calculator application built with Swing, designed to practice organized code structure and advanced mathematical computations. This project implements a user-friendly GUI for performing arithmetic operations, trigonometric functions, logarithms, and complex expressions with proper operator precedence and parentheses handling.

## Features

- **Basic Arithmetic**: Addition, subtraction, multiplication, division, and exponentiation.
- **Advanced Math**: Trigonometric functions (sin, cos, tan) and natural logarithm (ln) using custom Taylor series approximations.
- **Expression Evaluation**: Converts infix expressions to Reverse Polish Notation (RPN) for accurate evaluation, supporting parentheses and operator precedence.
- **GUI Interface**: Interactive display with buttons for inputs, toggle for advanced mode, and keyboard support. Includes custom icons and background image.
- **Input Validation**: Prevents invalid inputs like consecutive operators and auto-corrects missing parentheses.
- **Error Handling**: User-friendly dialogs for issues like divide-by-zero or malformed expressions.
- **Testing**: JUnit tests for core functionality.

## Diagrams

### GUI Layout
```
+-----------------------------+
|          Display            |
+-----------------------------+
| 7 | 8 | 9 | / | ( | ) | C |
+-----------------------------+
| 4 | 5 | 6 | * | ^ | ln|   |
+-----------------------------+
| 1 | 2 | 3 | - | sin|cos|tan|
+-----------------------------+
| 0 | . | = | + | Adv|       |
+-----------------------------+
```
*Figure 1: Basic calculator layout with number buttons, operators, and advanced mode toggle.*

### Shunting Yard Algorithm Flow
```
Input: 3 + 4 * 2
Stack: [ ]    Output: [ ]
Read 3:       Output: [3]
Read +:       Stack: [+]
Read 4:       Output: [3, 4]
Read *:       Stack: [+, *]  (higher precedence)
Read 2:       Output: [3, 4, 2]
End:          Pop * to output: [3, 4, 2, *]
             Pop + to output: [3, 4, 2, *, +]
Result: 3 4 2 * +
```
*Figure 2: Shunting Yard converts infix to RPN for evaluation.*

## Build Instructions

### Prerequisites
- Java Development Kit (JDK) 8 or later.
- Gradle (or use the included Gradle Wrapper).

### Commands
- **Build the project**: `./gradlew build` (compiles code, runs tests, generates JARs).
- **Run the application**: `./gradlew run` (launches the calculator GUI).
- **Run tests**: `./gradlew test` (executes JUnit tests).
- **Clean build**: `./gradlew clean` (removes build artifacts).

The Gradle Wrapper ensures consistent builds. Output JARs are in `build/libs/`.

## Key Concepts

- **Shunting Yard Algorithm**: Converts infix expressions (e.g., "3 + 4 * 2") to Reverse Polish Notation (RPN) for easier evaluation. Handles operator precedence and associativity using stacks. See [Helper.java](src/main/java/Complicated/Calculator/misc/Helper.java) for implementation.
- **Reverse Polish Notation (RPN) Evaluation**: Processes RPN expressions with a stack: operands are pushed, operators pop and apply operations. Supports unary (sin, cos, tan, ln) and binary (+, -, *, /, ^) operators. Implemented in [Helper.java](src/main/java/Complicated/Calculator/misc/Helper.java).
- **Taylor Series Approximations**: Approximates functions like sin(x) using series expansions (e.g., sin(x) ≈ x - x³/6 + x⁵/120). Includes error bounds. See [AdvancedMath.java](src/main/java/Complicated/Calculator/misc/AdvancedMath.java).
- **GridBagLayout**: Swing layout manager for flexible grid-based UI arrangement. Used in [Calculator.java](src/main/java/Complicated/Calculator/Calculator.java) for button positioning.
- **Swing GUI Components**: JFrame for the main window, JPanel for containers, JButton for inputs, JLabel for display. Includes custom ImagePanel for background. See [Calculator.java](src/main/java/Complicated/Calculator/Calculator.java) and [ImagePanel.java](src/main/java/Complicated/Calculator/misc/ImagePanel.java).

## TODOs
- Add advanced math features
	- Trigonometric functions (sin, cos, tan) with degree/radian toggle
	- Log / ln, factorial, square root, nth root
	- Implement history of calculations and recall previous results
- Improve expression handling
	- Improve parentheses handling and show mismatched-parenthesis warnings
	- handle general warnings too
- Reliability & validation
	- Add input validation and user-friendly error messages for divide-by-zero and malformed expressions
	- Add unit tests for the expression parser/evaluator (Helper class)
- Developer tooling
	- Add CI (GitHub Actions) to run tests on push and PRs
	- Add code style/linting (Spotless / Checkstyle) and configure Gradle tasks
- Packaging & distribution
	- Provide a runnable JAR with a proper main class and a small launcher script
	- Create native installers using jpackage for macOS/Windows/Linux
- Accessibility & Internationalization
	- Add support for high-contrast mode and larger fonts
	- Externalize strings for i18n and add translations (en + one other)
- Nice-to-haves
	- Add theme support (light/dark) and persistent user preferences