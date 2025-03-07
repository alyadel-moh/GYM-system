package backend;

public class TrainerDatabase extends Database {

    public TrainerDatabase(String filename) {
        super(filename);
    }

    @Override
    public Trainer createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new Trainer(parts[2], parts[1], parts[4], parts[3], parts[0]);
    }

    @Override
    protected String getSearchKey(Object record) {
        return ((Trainer) record).getSearchKey(); // Return the search key
    }

    @Override
    protected String lineRepresentation(Object record) {
        return ((Trainer) record).lineRepresentation(); // Return the string representation
    }
    
}
