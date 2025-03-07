package backend;

public class Trainer {
    private String trainerId;
    private String name;
    private String email;
    private String speciality;
    private String phoneno;

    public Trainer(String email, String name, String phoneno, String speciality, String trainerId) {
        this.email = email;
        this.name = name;
        this.phoneno = phoneno;
        this.speciality = speciality;
        this.trainerId = trainerId;
    }
    public Trainer()
    {}
    public String lineRepresentation()
    {
            return trainerId + "," + name + "," + email + "," + speciality + "," + phoneno;
    }
    public  String getSearchKey()
    {
        return trainerId;
    }
    public Object[] toObjectArray() {
        return new Object[]{trainerId, name, email,speciality,phoneno};
    }
}
