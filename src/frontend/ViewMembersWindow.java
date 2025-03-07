package frontend;

import backend.Member;
import backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewMembersWindow extends JFrame{
    private JPanel panel2;

    public ViewMembersWindow(TrainerRole trainerRole)
    {
        // Initialize panel2
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS)); // Set a layout manager

        setVisible(true);

        String[] columnNames = {"Id", "Name", "Email","Membership Type","Phone Number", "Status"};
        ArrayList<Member> members = trainerRole.getListOfMembers();
        Object[][] data = new Object[members.size()][columnNames.length];

        for(int i = 0; i < members.size() ; i++)
            data[i] = members.get(i).toObjectArray();

        DefaultTableModel model = new DefaultTableModel(data,columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel2.add(scrollPane);

        setTitle("View Members");
        setBounds(400,180,700,400);
        setContentPane(panel2);
        setResizable(false);
    }
}
