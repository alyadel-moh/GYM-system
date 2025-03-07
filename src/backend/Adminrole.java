package backend;

import frontend.AddTrainerWindow;
import frontend.AdminRoleWindow;

import javax.swing.*;
import java.util.ArrayList;

public class Adminrole{
    private TrainerDatabase base;
    public Adminrole() {
        base = new TrainerDatabase("Trainers.txt");
        base.readFromFile();
    }
    public void addTrainer(String trainerid, String name, String email, String speciality, String phoneno) {
        if (base.contains(trainerid))
        {
            System.out.println("trainer already exists !");
            JOptionPane.showMessageDialog(null,"the trainer with id = " + trainerid + " already exists !");
        }
        else
        {
            base.insertRecord(new Trainer(email, name, phoneno, speciality, trainerid));
        }

    }

    public ArrayList getListofTrainers() {
        return base.returnAllRecords();
    }

    public void removeTrainer(String key) {
        if (!base.contains(key))
        {
            System.out.println("trainer doesn't exists !");
            JOptionPane.showMessageDialog(null,"the trainer with id = " + key + " doesnot exist !");
        }
        else {
            base.deleteRecord(key);
        }
    }

    public void logout() {
        base.saveToFile();
    }

}