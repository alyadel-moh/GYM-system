package frontend;

import backend.Class;
import backend.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewClassesWindow extends JFrame {
    private JPanel panel2;

    public ViewClassesWindow(TrainerRole trainerRole) {
        // Initialize panel2
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS)); // Set a layout manager

        setVisible(true);

        String[] columnNames = { "ClassID", "Class Name", "TrainerID", "Duration", "Max Participants" };
        ArrayList<Class> classes = trainerRole.getListOfClasses();
        Object[][] data = new Object[classes.size()][columnNames.length];

        for (int i = 0; i < classes.size(); i++)
            data[i] = classes.get(i).toObjectArray();

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel2.add(scrollPane);

        setTitle("View Members");
        setBounds(400, 180, 700, 400);
        setContentPane(panel2);
        setResizable(false);
    }
}
