import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FactorialSquaringApp extends JFrame {
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;

    public FactorialSquaringApp() {
        setTitle("Factorial and Squaring");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultLabel = new JLabel();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addMouseListener(new CustomMouseListener());

        add(new JLabel("Enter number 1: "));
        add(num1Field);
        add(new JLabel("Enter number 2: "));
        add(num2Field);
        add(calculateButton);
        add(resultLabel);

        pack();
        setLocationRelativeTo(null);
    }

    private class CustomMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());
                long factorial1 = calculateFactorial(num1);
                long factorial2 = calculateFactorial(num2);
                resultLabel.setText("Factorial of " + num1 + " is " + factorial1 + ". " +
                                    "Factorial of " + num2 + " is " + factorial2 + ".");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        }

        public void mouseReleased(MouseEvent e) {
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());
                int square1 = num1 * num1;
                int square2 = num2 * num2;
                resultLabel.setText("Square of " + num1 + " is " + square1 + ". " +
                                    "Square of " + num2 + " is " + square2 + ".");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        }
    }

    private long calculateFactorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * calculateFactorial(num - 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FactorialSquaringApp app = new FactorialSquaringApp();
            app.setVisible(true);
        });
    }
}
