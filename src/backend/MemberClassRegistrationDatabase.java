package backend;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberClassRegistrationDatabase extends Database {
    public MemberClassRegistrationDatabase(String filename){
        super(filename);
    }

    // Description: Takes a comma-separated string (line) and returns a Registration object created from the data in the string.
    public MemberClassRegistration createRecordFrom (String line){
        String[] parts = line.split(",");
        return new MemberClassRegistration(parts[0],parts[1],LocalDate.parse(parts[2].replaceAll("\\s+", "")),parts[3]);
    }


    protected void insertRecord(MemberClassRegistration registration){
        if (contains(getSearchKey(registration))) {
            System.out.println(getSearchKey(registration) + " already exists!");

    } else {
        records.add(registration);
        System.out.println(getSearchKey(registration) + " added successfully!");
    }}

    @Override
    protected String getSearchKey(Object record) {
        return ((MemberClassRegistration) record).getSearchKey(); // Return the search key
    }

    @Override
    protected String lineRepresentation(Object record) {
        return ((MemberClassRegistration) record).lineRepresentation(); // Return the string representation
    }
    

}

