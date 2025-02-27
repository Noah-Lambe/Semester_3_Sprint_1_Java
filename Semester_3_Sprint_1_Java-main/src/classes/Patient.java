package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Patient extends Person {

    String mcpNum;
    char gender;
    String emergContact;
    String[] currentMeds;
    String[] medHistory;
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
                   String emergContact, 
                   String[] currentMeds, 
                   String[] medHistory, 
                   String bloodType, 
                   String insurance, 
                   String allergies, 
                   String address, 
                   String nextOfKin, 
                   String lastPresDate) {

        super(id, firstName, lastName, age, phoneNum); 
        this.mcpNum = mcpNum;
        this.gender = gender;
        this.emergContact = emergContact;
        this.currentMeds = currentMeds;
        this.medHistory = medHistory;
        this.bloodType = bloodType;
        this.insurance = insurance;
        this.allergies = allergies;
        this.address = address;
        this.nextOfKin = nextOfKin;
        this.lastPresDate = lastPresDate;
    }

    // Getter methods

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getMcpNum() {
        return mcpNum;
    }

    public char getGender() {
        return gender;
    }

    public String getEmergContact() {
        return emergContact;
    }

    public String[] getCurrentMeds() {
        return currentMeds;
    }

    public String[] getMedHistory() {
        return medHistory;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getInsurance() {
        return insurance;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getAddress() {
        return address;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public String getLastPresDate() {
        return lastPresDate;
    }

    // Setter methods

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setMcpNum(String mcpNum) {
        this.mcpNum = mcpNum;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setEmergContact(String emergContact) {
        this.emergContact = emergContact;
    }

    public void setCurrentMeds(String[] currentMeds) {
        this.currentMeds = currentMeds;
    }

    public void setMedHistory(String[] medHistory) {
        this.medHistory = medHistory;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public void setLastPresDate(String lastPresDate) {
        this.lastPresDate = lastPresDate;
    }

    // Methods to add and remove current medications

    public void addMedication(String newMed) {
    currentMeds = Arrays.copyOf(currentMeds, currentMeds.length + 1);
    currentMeds[currentMeds.length - 1] = newMed;
    }

    public void removeMedication(String medToRemove) {
    List<String> medsList = new ArrayList<>(Arrays.asList(currentMeds));
    medsList.remove(medToRemove);
    currentMeds = medsList.toArray(new String[0]);
}

    // To String method

    @Override
    public String toString() {
    return "Patient [ID: " + id + 
           ", Name: " + firstName + " " + lastName + 
           ", Age: " + age + 
           ", Phone Number: " + phoneNum + 
           ", MCP Number: " + mcpNum + 
           ", Gender: " + (gender == 'M' ? "Male" : gender == 'F' ? "Female" : "Other") + 
           ", Emergency Contact: " + emergContact + 
           ", Blood Type: " + bloodType + 
           ", Insurance: " + insurance + 
           ", Allergies: " + allergies + 
           ", Address: " + address + 
           ", Next of Kin: " + nextOfKin + 
           ", Last Prescription Date: " + lastPresDate + 
           ", Current Medications: " + (currentMeds.length > 0 ? String.join(", ", currentMeds) : "None") + 
           ", Medical History: " + (medHistory.length > 0 ? String.join(", ", medHistory) : "None") + "]";
    }
}