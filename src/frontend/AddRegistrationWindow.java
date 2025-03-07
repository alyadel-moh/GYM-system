package frontend;

import backend.TrainerRole;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.time.ZoneId;


public class AddRegistrationWindow extends JFrame {
    private JPanel Jpanel4;
    private JTextField DateTextField;
    private JTextField ClassID;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField nameTextField;
    private JTextField textField2;
    private JButton addButton;
    private JPanel datePanel;

    Calendar old = Calendar.getInstance();
    JDateChooser dateChooser = new JDateChooser(old.getTime());


    AddRegistrationWindow(TrainerRole trainerRole){
        setTitle("Register Member");

        addButton.setFocusable(false);
        nameTextField.setEditable(false);
        ClassID.setEditable(false);
        DateTextField.setEditable(false);

        ///Calendar
        dateChooser.setDateFormatString("dd/MM/yyyy");
        datePanel.setPreferredSize(new Dimension(200, 60));
        datePanel.add(dateChooser);

        nameTextField.setPreferredSize(new Dimension(200,60));
        ClassID.setPreferredSize(new Dimension(200,60));
        DateTextField.setPreferredSize(new Dimension(200,60));

        setBounds(500,180,500,400);
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
                    LocalDate selectedDate = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    trainerRole.registerMemberForClass(textField1.getText(), textField2.getText(), selectedDate);
                    setVisible(false);
                }
            }
        });
    }
}
