package frontend;

import backend.Adminrole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trainerdelete extends JFrame {

    private JPanel jpanel5;
    private JTextField trainerIdTextField;
    private JTextField textField2;
    private JButton removeButton;

    public Trainerdelete(Adminrole adminrole)
    {
        setTitle("Remove trainer");
        setBounds(500,320,500,200);
        setContentPane(jpanel5);
        setResizable(false);
        setVisible(true);
        trainerIdTextField.setEditable(false);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField2.getText().isBlank())
                    JOptionPane.showMessageDialog(jpanel5,"enter Id ! ");
                else
                {
                adminrole.removeTrainer(textField2.getText());
                setVisible(false);
                }
            }
        });
    }
    public static void main(String[] args)
    {
        Trainerdelete trainerdelete = new Trainerdelete(new Adminrole());
    }
}