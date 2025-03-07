package frontend;

import backend.Adminrole;
import backend.Trainer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class View extends JFrame{
    private JPanel panel1;
    Trainer trainer;
    public View(Adminrole adminrole)
    {
        setVisible(true);
        String[] columnNames = {"Id", "Name", "Email","speciality","Phone Number"};
        ArrayList<Trainer> trainers = adminrole.getListofTrainers();
        Object[][] data = new Object[trainers.size()][columnNames.length];
        for(int i = 0 ; i < trainers.size() ; i++)
            data[i] = trainers.get(i).toObjectArray();
        DefaultTableModel model = new DefaultTableModel(data,columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel1.add(scrollPane);
        setTitle("View Trainers");
        setBounds(500,200,500,400);
        setContentPane(panel1);
        setResizable(false);
    }
}
