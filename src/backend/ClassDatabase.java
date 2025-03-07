package backend;

public class ClassDatabase extends Database {
    //private ArrayList<Class> records;
    //private String filename;
    
    public ClassDatabase(String filename) {
        super(filename);
    }

    @Override
    public Class createRecordFrom(String line) {
        String[] parts = line.split(",");
        int duration = Integer.parseInt(parts[3]);
        int availableSeats = Integer.parseInt(parts[4]);
        return new Class(parts[0], parts[1], parts[2], duration, availableSeats);
    }

    @Override
    protected String getSearchKey(Object record) {
        return ((Class) record).getSearchKey(); // Return the search key
    }

    @Override
    protected String lineRepresentation(Object record) {
        return ((Class) record).lineRepresentation(); // Return the string representation
    }

}
