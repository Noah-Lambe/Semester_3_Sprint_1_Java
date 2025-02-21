package classes;

public class Doctor extends Person{
        
    String specialization;
    String officeAddress;
    String licenseNum;
    String email;

    // Constructor
    public Doctor(int id, 
                  String firstName, 
                  String lastName, 
                  int age, 
                  String phoneNum, 
                  String specialization, 
                  String officeAddress, 
                  String licenseNum, 
                  String email) {
        
        super(id, firstName, lastName, age, phoneNum);
        this.specialization = specialization;
        this.officeAddress = officeAddress;
        this.licenseNum = licenseNum;
        this.email = email;
    }
}
