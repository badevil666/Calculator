import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator
{
    Calculator()
    {
        JFrame frame = new JFrame("Calculator");

        frame.setLayout(new FlowLayout());
        frame.setSize(500, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(10);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 3, 10, 10));

        JButton[] buttons = new JButton[10];
        
        JButton deleteButton = new JButton("*");
        deleteButton.setPreferredSize(new Dimension(60, 60));

        deleteButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
            }
        });

        for(int i = 0; i < 10; i++)
        {
            buttons[i] = createNumberButton(Integer.toString(i), textField);
            buttons[i].setPreferredSize(new Dimension(60, 60));
        }
        for(JButton button : buttons)
            buttonPanel.add(button);

        buttonPanel.add(deleteButton);

        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(mainPanel);

        frame.setVisible(true);


    }

    private JButton createNumberButton(final String num, final JTextField textField)
    {
        JButton button = new JButton(num);

        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                textField.setText(textField.getText() + num);
            }
        });
        return button;
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Calculator();
            }
        });
    }
}