package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelRegistrationWindow extends JFrame {
    private JPanel Jpanel4;
    private JTextField ClassID;
    private JTextField textField1;
    private JTextField nameTextField;
    private JTextField textField2;
    private JButton addButton;

    CancelRegistrationWindow(TrainerRole trainerRole){
        setTitle("Cancel Registration");

        addButton.setFocusable(false);
        nameTextField.setEditable(false);
        ClassID.setEditable(false);

        nameTextField.setPreferredSize(new Dimension(200,60));
        ClassID.setPreferredSize(new Dimension(200,60));

        setBounds(480,180,550,400);
        addButton.setPreferredSize(new Dimension(150,40));
        setContentPane(Jpanel4);
        setResizable(false);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().isBlank() || textField2.getText().isBlank())
                    JOptionPane.showMessageDialog(Jpanel4,"some fields are empty ! ");
                else{
                    trainerRole.cancelRegistration(textField1.getText(),textField2.getText());
                    setVisible(false);
                }
            }
        });
    }
}
