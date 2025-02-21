package classes;

public class Patient extends Person {

    String mcpNum;
    char gender;
    String emergencyContact;
    String[] currentMeds;
    String medHistory;
    String bloodType;
    String insurance;
    String allergies;
    String address;
    String nextOfKin;
    String lastPresDate;

    // Constructor
    public Patient(int id, 
                   String firstName, 
                   String lastName, 
                   int age, 
                   String phoneNum, 
                   String mcpNum, 
                   char gender, 
                   String emergencyContact, 
                   String[] currentMeds, 
                   String medHistory, 
                   String bloodType, 
                   String insurance, 
                   String allergies, 
                   String address, 
                   String nextOfKin, 
                   String lastPresDate) {

        super(id, firstName, lastName, age, phoneNum); 
        this.mcpNum = mcpNum;
        this.gender = gender;
        this.emergencyContact = emergencyContact;
        this.currentMeds = currentMeds;
        this.medHistory = medHistory;
        this.bloodType = bloodType;
        this.insurance = insurance;
        this.allergies = allergies;
        this.address = address;
        this.nextOfKin = nextOfKin;
        this.lastPresDate = lastPresDate;
    }
}