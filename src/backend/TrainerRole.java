package backend;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import javax.swing.*;


public class TrainerRole {
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;
    private TrainerDatabase trainerDatabase;

    public TrainerRole(){
        memberDatabase = new MemberDatabase("Members.txt");
        classDatabase = new ClassDatabase("Classes.txt");
        registrationDatabase = new MemberClassRegistrationDatabase("Registration.txt");
        trainerDatabase = new TrainerDatabase("Trainers.txt");

        memberDatabase.readFromFile();
        classDatabase.readFromFile();
        registrationDatabase.readFromFile();
        trainerDatabase.readFromFile();
    }

    // Description: Adds a new member to the system by inserting a member object into the MemberDatabase. It checks if the member already exists before adding.
    public void addMember (String memberID, String name, String membershipType, String email, String phoneNumber, String status){
        memberDatabase.insertRecord(new Member(memberID, name, membershipType, email, phoneNumber, status));
    }
    
    //Description: Returns a list of all members stored in the MemberDatabase.
    public ArrayList<Member> getListOfMembers(){
        return memberDatabase.returnAllRecords();
    } 

    //Description: Adds a new class to the system by inserting a Class object into the ClassDatabase.
    public void addClass (String classID, String className, String trainerID, int duration, int maxParticipants){
        if(!trainerDatabase.contains(trainerID)){
            JOptionPane.showMessageDialog(null," Trainer " + trainerID + " doesn't exist!");
            return;
        }

        classDatabase.insertRecord(new Class(classID, className, trainerID, duration, maxParticipants));
    }

    // Description: Returns a list of all classes stored in the ClassDatabase
    public ArrayList<Class> getListOfClasses(){
        return classDatabase.returnAllRecords();
    }

    //Description: Make sure there are available seats in this class, then register a member by adding a MemberClassRegistration
    // object to the MemberClassRegistrationDatabase. The registration status is set to "active". And decrease the number of available seats by 1. 
    //Then returns true if the member registered successfully in the class and false otherwise.
    public boolean registerMemberForClass (String memberID, String classID, LocalDate registrationDate){
        Class gymClass = (Class) classDatabase.getRecord(classID);
        MemberClassRegistration registration = new MemberClassRegistration(memberID, classID, registrationDate, "active");
        MemberClassRegistration temp = (MemberClassRegistration) registrationDatabase.getRecord(registration.getSearchKey());

        if (!memberDatabase.contains(memberID)) {
            System.out.println("Member Doesn't Exist");
            JOptionPane.showMessageDialog(null," Member " + memberID + " doesn't exist!");
            return false;
        }

        if (gymClass == null) {
            System.out.println("Class Doesn't Exist");
            JOptionPane.showMessageDialog(null," Class " + classID + " doesn't exist!");
            return false;
        }
    
        if (gymClass.getAvailableSeats() <= 0) {
            System.out.println("No Available Seats");
            JOptionPane.showMessageDialog(null,"Class " + classID + " has no available seats!");
            return false;
        }
    
        if (registrationDatabase.contains(registration.getSearchKey()) && "active".equalsIgnoreCase(temp.getStatus())) {
            System.out.println("Reservation Already Exists!");
            JOptionPane.showMessageDialog(null,registration.getSearchKey() + "Already Exists");
            return false;
        }

        if (registrationDatabase.contains(registration.getSearchKey()) && "cancelled".equalsIgnoreCase(temp.getStatus())) {
            temp.setRegistrationStatus("active");
            JOptionPane.showMessageDialog(null,"Member " + memberID + " has been registered to Class: " + classID);
            return true;
        }
    
        registrationDatabase.insertRecord(registration);
        JOptionPane.showMessageDialog(null,"Member " + memberID + " has been registered to Class: " + classID);
        gymClass.setAvailableSeats(gymClass.getAvailableSeats() - 1);
        return true;
    }
    
    // Description: Cancels a registration and issues a refund if the member cancels within 3 days of the registrationDate.
    // The method searches for registration in the MemberClassRegistrationDatabase, verifies the date, updates the status to "canceled" 
    //if the cancellation is valid and increases the number of available seats of the class by 1. Then it returns true if the cancellation
    // is valid and false otherwise.
    public boolean cancelRegistration(String memberID, String classID) {
        String key = memberID + classID;
        MemberClassRegistration registration = (MemberClassRegistration) registrationDatabase.getRecord(key);
        Class gymClass = (Class) classDatabase.getRecord(classID);

        if (!memberDatabase.contains(memberID)) {
            System.out.println("Member Doesn't Exist");
            JOptionPane.showMessageDialog(null,"Member " + memberID + " doesn't exist!");
            return false;
        }

        if (gymClass == null) {
            System.out.println("Class Doesn't Exist");
            JOptionPane.showMessageDialog(null,"Class " + classID+ " doesn't exist");
            return false;
        }

        if (registration == null) {
            System.out.println("Registration Doesn't Exist");
            JOptionPane.showMessageDialog(null,"Registration doesn't exist");
            return false;
        }

        if ("cancelled".equalsIgnoreCase(registration.getStatus())){
            JOptionPane.showMessageDialog(null,"Registration already cancelled");
            return false;
        }

        LocalDate registrationDate = registration.getRegistrationDate();
    
        // Check for refund eligibility
        boolean refund = Period.between(registrationDate, LocalDate.now()).getDays() <= 3;
    
        // Update the registration status to "canceled"  
        ((MemberClassRegistration) registrationDatabase.getRecord(key)).setRegistrationStatus("cancelled");

        // Increase the number of available seats
        gymClass.setAvailableSeats(gymClass.getAvailableSeats() + 1); 
    
        if (!refund) {
            System.out.println("No Refund!");
            JOptionPane.showMessageDialog(null,"Member " + memberID + " has been unregistered from Class: " + classID + System.lineSeparator() + "No Refund!");

        }else{
            System.out.println("Refund Issued.");
            JOptionPane.showMessageDialog(null,"Member " + memberID + " has been unregistered from Class: " + classID + System.lineSeparator() + "Refund Issued!");

        }
    
        return true; 
    }
    
    //Description: Returns a list of all class registrations stored in the MemberClassRegistrationDatabase.
    public ArrayList<MemberClassRegistration> getListOfRegistrations(){
        return registrationDatabase.returnAllRecords();
    }

    // Description: Writes all unsaved member, class, and registration data to their respective files before logging out.
    public void logout(){
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
        JOptionPane.showMessageDialog(null," Changes have been Saved!");

    }

}