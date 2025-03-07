package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

public class AddClassWindow extends JFrame {
    private JPanel Jpanel4;
    private JTextField maxParticipantsText;
    private JTextField duration;
    private JTextField trainerTextField;
    private JTextField ClassID;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField nameTextField;
    private JTextField textField2;
    private JButton addButton;

    AddClassWindow(TrainerRole trainerRole){
        setTitle("Add Class");

        addButton.setFocusable(false);
        nameTextField.setEditable(false);
        ClassID.setEditable(false);
        trainerTextField.setEditable(false);
        duration.setEditable(false);
        maxParticipantsText.setEditable(false);

        nameTextField.setPreferredSize(new Dimension(200,60));
        ClassID.setPreferredSize(new Dimension(200,60));
        trainerTextField.setPreferredSize(new Dimension(200,60));
        duration.setPreferredSize(new Dimension(200,60));
        maxParticipantsText.setPreferredSize(new Dimension(200,60));

        setBounds(480,180,550,550);
        addButton.setPreferredSize(new Dimension(150,40));
        setContentPane(Jpanel4);
        setResizable(false);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().isBlank() || textField2.getText().isBlank() || textField3.getText().isBlank() || textField4.getText().isBlank() || textField5.getText().isBlank())
                    JOptionPane.showMessageDialog(Jpanel4,"some fields are empty ! ");
                else{
                    trainerRole.addClass(textField1.getText(),textField2.getText(),textField3.getText(),Integer.parseInt(textField4.getText()),Integer.parseInt(textField5.getText()));
                    setVisible(false);
                }
            }
        });
    }
}
