package backend;

public class Member {
   private String memberID;
   private String name;
   private String membershipType;
   private String email;
   private String phoneNumber;
   private String status;

    public Member(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        this.email = email;
        this.memberID = memberID;
        this.membershipType = membershipType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public String lineRepresentation()
    {
        return memberID + "," + name + "," + membershipType + ","+ email + "," + phoneNumber + "," + status;
    }
    public  String getSearchKey()
    {
        return memberID;
    }
    public Object[] toObjectArray() {
        return new Object[]{memberID, name, email,membershipType,phoneNumber,status};
    }

}
