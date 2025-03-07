package backend;

import java.time.LocalDate;

public class MemberClassRegistration {
    private String memberID;
    private String classID;
    private String status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID, LocalDate date ,String status){
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = date;
    }

    // Description: Returns status of Registration
    public String getStatus() {
        return status;
    }

    // Description: set status of registration("active" or "cancelled")
    public void setRegistrationStatus(String status){
        if (status.equalsIgnoreCase("active")) {
            this.status = "active";
            return;
        }

        if (status.equalsIgnoreCase("cancelled")) {
            this.status = "cancelled";
            return;
        }

        System.out.println("Invalid status!Failed to change status.");
    }

   //Description returns the date of registration.
    public LocalDate getRegistrationDate () {
        return registrationDate;
    }

    //Description: Returns a concatenated string (memberID + classID) to uniquely identify the class registration.
    public String getSearchKey(){
        return (memberID + classID).replaceAll("\\s+", "");
    } 

    //Description: Returns the class registration information in a comma-separated format
    public String lineRepresentation(){
        return memberID + "," + classID + "," + registrationDate + "," + status;
    }
    public Object[] toObjectArray() {
        return new Object[]{memberID, classID,registrationDate,status};
    }
}
