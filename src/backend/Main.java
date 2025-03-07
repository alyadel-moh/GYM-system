package backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TrainerDatabase trainerDatabase = new TrainerDatabase("Trainers.txt");
        MemberDatabase memberDatabase = new MemberDatabase("Members.txt");
        ClassDatabase classDatabase = new ClassDatabase("Classes.txt");
        MemberClassRegistrationDatabase memberClassRegistrationDatabase = new MemberClassRegistrationDatabase("Registration.txt");

        Adminrole adminrole = new Adminrole();
        TrainerRole trainerRole = new TrainerRole();
        
        ArrayList<Trainer> trainers;
        Trainer trainer1;
        Trainer trainer2;

        ArrayList<Member> members;
        Member member1;
        Member member2;

        ArrayList <Class> classes;
        Class class1;
        Class class2;

        ArrayList<MemberClassRegistration> memberClassRegistrations;
        MemberClassRegistration memberClassRegistration1;
        MemberClassRegistration memberClassRegistration2;

        Scanner scanner = new Scanner(System.in);
       
        /*        * adminrole.addTrainer("T2009","alyadel","alyadel@gmail.com","yoga","1234");
         * adminrole.addTrainer("T2007","alyadel","alyadel@gmail.com","yoga","1234");
         * adminrole.addTrainer("T2007","alyadel","alyadel@gmail.com","yoga","1234");
         * adminrole.addTrainer("T2008","alyadel","alyadel@gmail.com","yoga","1234");
         * adminrole.addTrainer("T2005","alyadel","alyadel@gmail.com","yoga","1234");
         * trainers = adminrole.getListofTrainers();
         * for(int i = 0 ; i < trainers.size() ; i++)
         * System.out.println(trainers.get(i).lineRepresentation());
         * adminrole.logout();
         * adminrole.removeTrainer("T2007");
         * adminrole.removeTrainer("T2008");
         * trainers = adminrole.getListofTrainers();
         * for(int i = 0 ; i < trainers.size() ; i++)
         * System.out.println(trainers.get(i).lineRepresentation());
         * adminrole.logout();
         */
        
         /*
          trainerDatabase.readFromFile();
          trainer2 =
          trainerDatabase.createRecordFrom("T2002,adel,adel@gmail.com,yoga,0123");
          trainers = trainerDatabase.returnAllRecords();
          for(int i = 0 ; i < trainers.size() ; i++)
            System.out.println(trainers.get(i).lineRepresentation());
          System.out.println(trainerDatabase.contains("T1001"));
          System.out.println(trainerDatabase.contains("bb"));

          trainer1 = (Trainer) trainerDatabase.getRecord("T1002");
          System.out.println(trainer1.lineRepresentation());
          trainerDatabase.insertRecord(new Trainer("alyyy@gmail.com","alyyy","1234","fit","T2009"));
          trainerDatabase.insertRecord(trainer2);
          trainerDatabase.deleteRecord("T1001");
          trainers = trainerDatabase.returnAllRecords();
        */

        /* memberDatabase.readFromFile();
         member2 =  memberDatabase.createRecordFrom("M1004,alyyy,monthlly,alyyy@gmail.com,123456,notactive");
         members = memberDatabase.returnAllRecords();
          for(int i = 0 ; i < members.size() ; i++)
         System.out.println(members.get(i).lineRepresentation());
          System.out.println(memberDatabase.contains("T1001"));
          System.out.println(memberDatabase.contains("M1002"));
          member1 = (Member) memberDatabase.getRecord("M1003");
          System.out.println(member1.lineRepresentation());
          memberDatabase.insertRecord(new
          Member("M2006","mazennnn","weekly","mazeennn2@gmail.com","1233555","active"));
          memberDatabase.insertRecord(member2);
         memberDatabase.deleteRecord("a");
          memberDatabase.deleteRecord("M1002");
          memberDatabase.deleteRecord("YYYY");
          members = memberDatabase.returnAllRecords();
          for(int i = 0 ; i < members.size() ; i++)
            System.out.println(members.get(i).lineRepresentation());
          memberDatabase.saveToFile();
         */
         

        /*classDatabase.readFromFile();
          class2 = classDatabase.createRecordFrom("C105,fitness,T1005,40,5");
          classes = classDatabase.returnAllRecords();
          for(int i = 0 ; i < classes.size() ; i++)
            //System.out.println(classes.get(i).lineRepresentation());
            System.out.println(classes.get(i).getSearchKey());
          System.out.println(classDatabase.contains("C103"));
          System.out.println(classDatabase.contains("bb"));
          class1 = (Class) classDatabase.getRecord("C102");
          //System.out.println(class1.lineRepresentation());
          classDatabase.insertRecord(new Class("C106","yoga","T1006",20,10));
          classDatabase.insertRecord(class2);
          classDatabase.deleteRecord("C103");
          classes = classDatabase.returnAllRecords();
         classDatabase.saveToFile();
         */
        
         /* memberClassRegistrationDatabase.readFromFile();
        memberClassRegistration1 =
        memberClassRegistrationDatabase.createRecordFrom("M1008,C1008,2024-10-02,active");

        memberClassRegistrations = memberClassRegistrationDatabase.returnAllRecords();
        for (int i = 0; i < memberClassRegistrations.size(); i++)
            //System.out.println(memberClassRegistrations.get(i).lineRepresentation());
            System.out.println(memberClassRegistrations.get(i).getSearchKey());
        System.out.println(memberClassRegistrationDatabase.contains("M1002"));
        System.out.println(memberClassRegistrationDatabase.contains("bb"));

        
        memberClassRegistrationDatabase
                .insertRecord(new MemberClassRegistration("M1003", "C1007", LocalDate.of(2024, 10, 02), "notactive"));
        memberClassRegistration2 = (MemberClassRegistration) memberClassRegistrationDatabase.getRecord("M1003 C1007");
        System.out.println(memberClassRegistration2.lineRepresentation());

        memberClassRegistrationDatabase.insertRecord(memberClassRegistration2);
        memberClassRegistrationDatabase.deleteRecord("M1003");
        memberClassRegistrations = memberClassRegistrationDatabase.returnAllRecords();
        memberClassRegistrationDatabase.saveToFile(); */
       
         
         

        members = trainerRole.getListOfMembers();
        for(Member member : members ){
            System.out.println(member.lineRepresentation());
        }

        trainerRole.addClass("C101", "yoda", "99i", 60, 18);
        trainerRole.addMember("M1001", "Magdy", "monthly", "haggag@.com", "0122012", "active");
        trainerRole.addMember("1001","Magdy","yearly","alyadel@gmail.com","01013999191","active");
        trainerRole.cancelRegistration("232","C101");
        trainerRole.cancelRegistration("M1001","C101");
        classes = trainerRole.getListOfClasses();
        memberClassRegistrations = trainerRole.getListOfRegistrations();
        members = trainerRole.getListOfMembers();       
        trainers = adminrole.getListofTrainers();
        for(Class classs : classes){
            System.out.println(classs.lineRepresentation());
        }

        for(Member member : members){
            System.out.println(member.lineRepresentation());
        }

        for(MemberClassRegistration regis : memberClassRegistrations){
            System.out.println(regis.lineRepresentation());
        }

        trainerRole.registerMemberForClass("M1001", "C101", LocalDate.now());
        trainerRole.logout();
        
    }
}