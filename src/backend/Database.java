package backend;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Database<T> {
    protected ArrayList<T> records;
    protected String filename;
    protected int index = -1;

    public Database(String filename) {
        this.filename = filename;
        records = new ArrayList<>();
    }

    public abstract T createRecordFrom(String line);

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(createRecordFrom(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<T> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (key.replaceAll("\\s+", "").equals(getSearchKey(records.get(i)).replaceAll("\\s+", ""))) {
                index = i;
                return true;
            }
        }
        return false;
    }

    public T getRecord(String key) {
        if (contains(key)) {
            return records.get(index);
        }
        return null;
    }

    public void insertRecord(T record) {
        if (contains(getSearchKey(record))) {
            System.out.println(getSearchKey(record) + " already exists!");
            JOptionPane.showMessageDialog(null," ID = " + getSearchKey(record) + " already exists!");

        } else {
            records.add(record);
            JOptionPane.showMessageDialog(null," ID = " + getSearchKey(record) + " has been successfully added!");
            System.out.println(getSearchKey(record) + " added successfully!");
}}

    public void deleteRecord(String key) {
        if (contains(key)) {
            records.remove(index);
            JOptionPane.showMessageDialog(null," ID = " + key + " has been deleted!");

        } else {
            JOptionPane.showMessageDialog(null," ID = " + key + " doesn't exist!");
            System.out.println(key + " doesn't exist!");
        }
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter(filename)) {
            for (T record : records) {
                writer.write(lineRepresentation(record) + System.lineSeparator());
            }
            System.out.println("Changes have been saved");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract String lineRepresentation(T record);
    protected abstract String getSearchKey(T record);
}
