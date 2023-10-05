import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GUI implements ActionListener {

    private String currentValue = "0";
    private int firstOperand = 0;
    private char operator = ' ';
    private JFrame frame;
    private JPanel panel;
    private JLabel results;
    private Border resultsBorder;
    private JButton adding;
    private JButton subtracting;
    private JButton multiplying;
    private JButton dividing;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton zero;
    private JButton equals;
    private JButton clear; 
    public GUI() {
        resultsBorder = BorderFactory.createLineBorder(Color.gray, 1);
        panel = new JPanel();
        frame = new JFrame();
        results = new JLabel("0");
        adding = new JButton("+");
        subtracting = new JButton("-");
        multiplying = new JButton("x");
        dividing = new JButton("÷");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        zero = new JButton("0");
        equals = new JButton("=");
        clear = new JButton("C"); 

        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(400, 400, 400, 400));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(results);
        panel.add(adding);
        panel.add(subtracting);
        panel.add(multiplying);
        panel.add(dividing);
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(zero);
        panel.add(equals);
        panel.add(clear); 

        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(218, 353);
        frame.setVisible(true);

        results.setBorder(resultsBorder);
        results.setBounds(0, 3, 215, 75);
        results.setHorizontalAlignment(JLabel.RIGHT);
        results.setFont(new Font("Arial", Font.BOLD, 50));

        adding.addActionListener(this);
        adding.setBounds(1, 80, 50, 50);
        adding.setFont(new Font("Arial", Font.BOLD, 17));

        subtracting.addActionListener(this);
        subtracting.setBounds(55, 80, 50, 50);
        subtracting.setFont(new Font("Arial", Font.BOLD, 17));

        multiplying.addActionListener(this);
        multiplying.setBounds(110, 80, 50, 50);
        multiplying.setFont(new Font("Arial", Font.BOLD, 17));

        dividing.addActionListener(this);
        dividing.setBounds(165, 80, 50, 50);
        dividing.setFont(new Font("Arial", Font.BOLD, 17));

        one.addActionListener(this);
        one.setBounds(1, 135, 50, 50);
        one.setFont(new Font("Arial", Font.BOLD, 17));

        two.addActionListener(this);
        two.setBounds(55, 135, 50, 50);
        two.setFont(new Font("Arial", Font.BOLD, 17));

        three.addActionListener(this);
        three.setBounds(110, 135, 50, 50);
        three.setFont(new Font("Arial", Font.BOLD, 17));

        four.addActionListener(this);
        four.setBounds(165, 135, 50, 50);
        four.setFont(new Font("Arial", Font.BOLD, 17));

        five.addActionListener(this);
        five.setBounds(1, 190, 50, 50);
        five.setFont(new Font("Arial", Font.BOLD, 17));

        six.addActionListener(this);
        six.setBounds(55, 190, 50, 50);
        six.setFont(new Font("Arial", Font.BOLD, 17));

        seven.addActionListener(this);
        seven.setBounds(110, 190, 50, 50);
        seven.setFont(new Font("Arial", Font.BOLD, 17));

        eight.addActionListener(this);
        eight.setBounds(165, 190, 50, 50);
        eight.setFont(new Font("Arial", Font.BOLD, 17));

        nine.addActionListener(this);
        nine.setBounds(85, 245, 50, 50);
        nine.setFont(new Font("Arial", Font.BOLD, 17));

        zero.addActionListener(this);
        zero.setBounds(1, 300, 215, 50);
        zero.setFont(new Font("Arial", Font.BOLD, 17));

        equals.addActionListener(this);
        equals.setBounds(140, 245, 75, 50);
        equals.setFont(new Font("Arial", Font.BOLD, 17));

        clear.addActionListener(this); 
        clear.setBounds(1, 245, 80, 50); 
        clear.setFont(new Font("Arial", Font.BOLD, 17));
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            String buttonText = clickedButton.getText();

            if (buttonText.matches("[0-9]")) {
                if (currentValue.equals("0")) {
                    currentValue = buttonText;
                } else {
                    currentValue += buttonText;
                }
            } else if (buttonText.matches("[+\\-x÷]")) {
                if (operator != ' ') {
                    int secondOperand = Integer.parseInt(currentValue);
                    int result = performCalculation(firstOperand, secondOperand, operator);
                    currentValue = String.valueOf(result);
                }
                firstOperand = Integer.parseInt(currentValue);
                operator = buttonText.charAt(0);
                currentValue = "";
            } else if (buttonText.equals("=")) {
                if (operator != ' ') {
                    int secondOperand = Integer.parseInt(currentValue);
                    int result = performCalculation(firstOperand, secondOperand, operator);
                    currentValue = String.valueOf(result);
                    operator = ' ';
                }
            } else if (buttonText.equals("C")) { 
                currentValue = "0";
                firstOperand = 0;
                operator = ' ';
            }

            results.setText(currentValue);
        }
    }

    private int performCalculation(int operand1, int operand2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case 'x':
                result = operand1 * operand2;
                break;
            case '÷':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    
                }
                break;
        }
        return result;
    }
}
