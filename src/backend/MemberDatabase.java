package backend;

import java.util.ArrayList;

public class MemberDatabase extends Database {
    private ArrayList<Class> records;
    private String filename;
    
    public MemberDatabase(String filename) {
        super(filename);
    }

    @Override
    public Member createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new Member(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
    }

    @Override
    protected String getSearchKey(Object record) {
        return ((Member) record).getSearchKey(); // Return the search key
    }

    @Override
    protected String lineRepresentation(Object record) {
        return ((Member) record).lineRepresentation(); // Return the string representation
    }
    
}
