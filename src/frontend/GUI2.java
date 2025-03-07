package frontend;

import constants.LoginCredentials;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI2 extends JFrame implements LoginCredentials {
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JPanel jpanel2;
    private JTextField textField1;
    private JButton loginButton;
    private JPasswordField passwordField1;

    public GUI2()
    {
        setTitle("Admin Login");
        setBounds(500,140,500,400);
        setContentPane(jpanel2);
        setResizable(false);
        usernameTextField.setPreferredSize(new Dimension(100,60));
        usernameTextField.setEditable(false);
        usernameTextField.setBorder(new LineBorder(Color.BLACK));
        passwordTextField.setPreferredSize(new Dimension(100,60));
        passwordTextField.setBorder(new LineBorder(Color.BLACK));
        passwordTextField.setEditable(false);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().isBlank())
                    JOptionPane.showMessageDialog(jpanel2,"enter you username !");
                else if(passwordField1.getText().isBlank())
                    JOptionPane.showMessageDialog(jpanel2,"enter you password !");
                else if(!passwordField1.getText().equals(ADMIN_PASSWORD) || !textField1.getText().equals(ADMIN_USERNAME) )
                {
                    JOptionPane.showMessageDialog(jpanel2,"wrong username or password!");
                    setVisible(false);
                }
                else {
                    AdminRoleWindow adminRoleWindow = new AdminRoleWindow();
                    setVisible(false);
                }
            }
        });
    }
    public static void main(String[] args)
    {
        GUI2 gui2 = new GUI2();
    }
}
