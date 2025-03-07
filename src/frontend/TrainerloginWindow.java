package frontend;

import constants.LoginCredentials;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainerloginWindow extends JFrame implements LoginCredentials {
    private JTextField passwordTextField;
    private JTextField textField4;
    private JTextField usernameTextField;
    private JPanel jpanel;
    private JButton loginButton;
    private JPasswordField passwordField1;

    public TrainerloginWindow()
    {
        setTitle("Trainer Login");
        setBounds(500,200,550,400);
        setContentPane(jpanel);
        setResizable(false);
        setVisible(true);
        loginButton.setFocusable(false);
        usernameTextField.setEditable(false);
        usernameTextField.setBorder(new LineBorder(Color.BLACK));
        passwordTextField.setBorder(new LineBorder(Color.BLACK));
        passwordTextField.setEditable(false);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField4.getText().isBlank())
                    JOptionPane.showMessageDialog(jpanel,"enter you username !");
                else if(passwordField1.getText().isBlank())
                    JOptionPane.showMessageDialog(jpanel,"enter you password !");
                else if(!passwordField1.getText().equals(TRAINER_PASSWORD) || !textField4.getText().equals(TRAINER_USERNAME) )
                {
                    JOptionPane.showMessageDialog(jpanel,"wrong username or password!");
                    setVisible(false);
                }
                else {
                    TrainerRoleWindow trainerRoleWindow = new TrainerRoleWindow();
                    setVisible(false);
                }

            }
        });
    }
    public static void main(String[] args)
    {
       TrainerloginWindow trainerloginWindow = new TrainerloginWindow();
    }
}
