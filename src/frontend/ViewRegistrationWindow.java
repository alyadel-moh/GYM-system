package frontend;

import backend.MemberClassRegistration;
import backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewRegistrationWindow extends JFrame{
        private JPanel panel2;

        public ViewRegistrationWindow(TrainerRole trainerRole)
        {
            // Initialize panel2
            panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS)); // Set a layout manager

            setVisible(true);

            String[] columnNames = {"Member Id", "Class ID", "Registration Date", "Status"};
            ArrayList<MemberClassRegistration> registrations = trainerRole.getListOfRegistrations();
            Object[][] data = new Object[registrations.size()][columnNames.length];

            for(int i = 0; i < registrations.size() ; i++)
                data[i] = registrations.get(i).toObjectArray();

            DefaultTableModel model = new DefaultTableModel(data,columnNames);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            panel2.add(scrollPane);

            setTitle("View Registrations");
            setBounds(400,180,700,400);
            setContentPane(panel2);
            setResizable(false);
    }
}
