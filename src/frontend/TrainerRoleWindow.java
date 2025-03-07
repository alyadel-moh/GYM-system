package frontend;

import backend.TrainerRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TrainerRoleWindow extends JFrame {
    private JPanel Container;
    private JButton logoutButton;
    private JButton viewRegistrationsButton;
    private JButton cancelRegistrationButton;
    private JButton registerMemberForClassButton;
    private JButton viewClassButton;
    private JButton addClassButton;
    private JButton viewMembersButton;
    private JButton addMemberButton;

   public TrainerRoleWindow(){
       setTitle("Trainer Role");
       setBounds(490, 20, 500, 800);
       setContentPane(Container);
       setResizable(false);
       setVisible(true);

       addMemberButton.setFocusable(false);
       viewMembersButton.setFocusable(false);
       addClassButton.setFocusable(false);
       viewClassButton.setFocusable(false);
       registerMemberForClassButton.setFocusable(false);
       cancelRegistrationButton.setFocusable(false);
       viewRegistrationsButton.setFocusable(false);
       logoutButton.setFocusable(false);

       TrainerRole trainerRole = new TrainerRole();

       addMemberButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               AddMemberWindow addMember = new AddMemberWindow(trainerRole);
           }
       });

       viewMembersButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               ViewMembersWindow viewMembers = new ViewMembersWindow(trainerRole);
           }
       });

       addClassButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                AddClassWindow addClass = new AddClassWindow(trainerRole);
           }
       });

       viewClassButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                ViewClassesWindow viewClasses = new ViewClassesWindow(trainerRole);
           }
       });

       registerMemberForClassButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                AddRegistrationWindow addRegistration = new AddRegistrationWindow(trainerRole);
           }
       });

       cancelRegistrationButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                CancelRegistrationWindow cancelRegistration = new CancelRegistrationWindow(trainerRole);
           }
       });

       viewRegistrationsButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                ViewRegistrationWindow viewRegistration = new ViewRegistrationWindow(trainerRole);
           }
       });

       logoutButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                trainerRole.logout();
                dispose();
           }
       });
   }

    public static void main(String[] args){
        TrainerRoleWindow x = new TrainerRoleWindow();
    }
}
