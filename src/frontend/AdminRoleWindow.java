package frontend;

import backend.Adminrole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRoleWindow extends JFrame{
    private JButton addTrainerButton;
    private JButton logoutButton;
    private JButton viewTrainersButton;
    private JButton removeTrainerButton;
    private JPanel jpanel3;

    public AdminRoleWindow() {
        setTitle("Admin Role");
        setBounds(500, 200, 500, 400);
        setContentPane(jpanel3);
        setResizable(false);
        setVisible(true);

        addTrainerButton.setFocusable(false);
        removeTrainerButton.setFocusable(false);
        viewTrainersButton.setFocusable(false);
        logoutButton.setFocusable(false);

        Adminrole adminrole = new Adminrole();

       addTrainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTrainerWindow addTrainerWindow = new AddTrainerWindow(adminrole);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminrole.logout();
                dispose();
            }
        });
        removeTrainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Trainerdelete trainerdelete = new Trainerdelete(adminrole);
            }
        });
        viewTrainersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View view = new View(adminrole);

            }
        });
    }
    public static void main(String[] args)
    {
        AdminRoleWindow adminRoleWindow = new AdminRoleWindow();
    }
}
