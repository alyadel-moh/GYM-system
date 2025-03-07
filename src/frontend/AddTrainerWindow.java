package frontend;

import backend.Adminrole;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTrainerWindow extends JFrame{
    public JPanel jpanel4;
    private JTextField nameTextField;
    private JTextField phoneNumberTextField;
    private JTextField specialityTextField;
    private JTextField emailTextField;
    private JTextField idTextField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton addButton;
    public AddTrainerWindow(Adminrole adminrole)
    {
        setTitle("Add Trainer");
         addButton.setFocusable(false);
         nameTextField.setEditable(false);
         phoneNumberTextField.setEditable(false);
         specialityTextField.setEditable(false);
         emailTextField.setEditable(false);
         idTextField.setEditable(false);
         idTextField.setPreferredSize(new Dimension(200,60));
         nameTextField.setPreferredSize(new Dimension(200,60));
         phoneNumberTextField.setPreferredSize(new Dimension(200,60));
         specialityTextField.setPreferredSize(new Dimension(200,60));
         emailTextField.setPreferredSize(new Dimension(200,60));
         setBounds(500,180,550,500);
        addButton.setPreferredSize(new Dimension(150,40));
        setContentPane(jpanel4);
        setResizable(false);
        setVisible(true);
        idTextField.setPreferredSize(new Dimension(200,60));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().isBlank() || textField2.getText().isBlank() || textField3.getText().isBlank() || textField4.getText().isBlank() || textField5.getText().isBlank())
                    JOptionPane.showMessageDialog(jpanel4,"some fields are empty !");
                else
                {
                    adminrole.addTrainer(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText());
                    setVisible(false);
                }
            }
        });
    }
    public static void main(String[] args)
    {
        AddTrainerWindow addTrainerWindow = new AddTrainerWindow(new Adminrole());
    }

}
