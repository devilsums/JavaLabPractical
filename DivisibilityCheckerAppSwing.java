import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DivisibilityCheckerAppSwing extends JFrame {

    private JTextField inputField;
    private JLabel resultLabel;

    public DivisibilityCheckerAppSwing() {
        setTitle("Divisibility Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        inputField = new JTextField(10);
        resultLabel = new JLabel("");

        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    checkDivisibility();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        JButton checkButton = new JButton("Check");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkDivisibility();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(inputField);
        panel.add(checkButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(resultLabel, BorderLayout.CENTER);
    }

    private void checkDivisibility() {
        try {
            int number = Integer.parseInt(inputField.getText());
            if (number % 5 == 0) {
                resultLabel.setText(number + " is divisible by 5.");
            } else {
                resultLabel.setText(number + " is not divisible by 5.");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DivisibilityCheckerAppSwing app = new DivisibilityCheckerAppSwing();
                app.setVisible(true);
            }
        });
    }
}
