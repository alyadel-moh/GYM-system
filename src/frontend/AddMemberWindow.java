package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMemberWindow extends JFrame{
    private JPanel Jpanel4;
    private JTextField phoneNumberTextField;
    private JTextField membershipTypeTextField;
    private JTextField emailTextField;
    private JTextField IDTextField;
    private JTextField nameTextField;
    private JTextField statusTextField;
    private JButton addButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    public AddMemberWindow(TrainerRole trainerRole)
    {
        setTitle("Add Member");

        addButton.setFocusable(false);
        nameTextField.setEditable(false);
        phoneNumberTextField.setEditable(false);
        membershipTypeTextField.setEditable(false);
        emailTextField.setEditable(false);
        IDTextField.setEditable(false);
        statusTextField.setEditable(false);


        IDTextField.setPreferredSize(new Dimension(200,60));
        nameTextField.setPreferredSize(new Dimension(200,60));
        phoneNumberTextField.setPreferredSize(new Dimension(200,60));
        membershipTypeTextField.setPreferredSize(new Dimension(200,60));
        emailTextField.setPreferredSize(new Dimension(200,60));
        statusTextField.setPreferredSize(new Dimension(200,60));

        setBounds(480,180,550,550);
        addButton.setPreferredSize(new Dimension(150,40));
        setContentPane(Jpanel4);
        setResizable(false);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().isBlank() || textField2.getText().isBlank() || textField3.getText().isBlank() || textField4.getText().isBlank() || textField5.getText().isBlank() || textField6.getText().isBlank())
                    JOptionPane.showMessageDialog(Jpanel4,"some fields are empty ! ");
                else{
                    trainerRole.addMember(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),textField6.getText());
                    setVisible(false);
                }
            }
        });

    }
}
