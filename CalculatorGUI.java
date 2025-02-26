import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
    Calculator calculator = new Calculator();
    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JLabel resultLabel = new JLabel("Result: ");

    public CalculatorGUI() {
        //Създаваме настройки на прозореца
        JFrame frame = new JFrame("Scientific Calculator");
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        // Създаваме GUI компоненти и ги добавяме към прозореца
        JLabel label1 = new JLabel("Number 1: ");
        frame.add(label1);
        frame.add(text1);
        JLabel label2 = new JLabel("Number 2: ");
        frame.add(label2);

        frame.add(text2);

        //Създаваме бутони за отделните функции.
        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton powerButton = new JButton("^");
        JButton sqrtButton = new JButton("√");
        JButton logButton = new JButton("log");
        JButton sinButton = new JButton("sin");
        JButton cosButton = new JButton("cos");
        JButton tanButton = new JButton("tan");
        JButton cotButton = new JButton("cot");

        //Създаваме, поле за резултат и го добавяме
        frame.add(resultLabel);

        //Добавяме слушатели на бутоните.
        addButton.addActionListener(new OperationListener("+"));
        subtractButton.addActionListener(new OperationListener("-"));
        multiplyButton.addActionListener(new OperationListener("*"));
        divideButton.addActionListener(new OperationListener("/"));
        powerButton.addActionListener(new OperationListener("^"));
        sqrtButton.addActionListener(new OperationListener("√"));
        logButton.addActionListener(new OperationListener("log"));
        sinButton.addActionListener(new OperationListener("sin"));
        cosButton.addActionListener(new OperationListener("cos"));
        tanButton.addActionListener(new OperationListener("tan"));
        cotButton.addActionListener(new OperationListener("cot"));

        //Добавяме бутоните към прозореца.
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(powerButton);
        frame.add(sqrtButton);
        frame.add(logButton);
        frame.add(sinButton);
        frame.add(cosButton);
        frame.add(tanButton);
        frame.add(cotButton);
    }

    private class OperationListener implements ActionListener {
        private String operation;

        public OperationListener(String operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(text1.getText());
                double num2 = text2.getText().isEmpty() ? 0 : Double.parseDouble(text2.getText());
                double result = 0;

                switch (operation) {
                    case "+": result = calculator.add(num1, num2); break;
                    case "-": result = calculator.subtract(num1, num2); break;
                    case "*": result = calculator.multiply(num1, num2); break;
                    case "/": result = calculator.divide(num1, num2); break;
                    case "^": result = calculator.power(num1, num2); break;
                    case "√": result = calculator.sqrt(num1); break;
                    case "log": result = calculator.log(num1); break;
                    case "sin": result = calculator.sin(num1); break;
                    case "cos": result = calculator.cos(num1); break;
                    case "tan": result = calculator.tan(num1); break;
                    case "cot": result = calculator.cot(num1); break;
                }

                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Invalid number.");
            } catch (ArithmeticException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
