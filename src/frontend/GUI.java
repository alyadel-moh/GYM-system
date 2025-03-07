package frontend;

import backend.Adminrole;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JPanel jpanel;
    private JButton adminRoleButton;
    private JButton trainerRoleButton;
    public GUI()
    {
        setVisible(true);
        setBounds(500,200,500,300);
        setContentPane(jpanel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminRoleButton.setFocusable(false);
        trainerRoleButton.setFocusable(false);


        adminRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI2 gui2 = new GUI2();
                setVisible(false);
            }
        });

        trainerRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainerloginWindow trainer_home = new TrainerloginWindow();
                setVisible(false);
            }
        });
    }
    public static void main(String[] args){
        GUI gui = new GUI();
    }

}
