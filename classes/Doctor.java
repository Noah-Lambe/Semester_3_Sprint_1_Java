package classes;

public class Doctor extends Person{
        
    private String specialization;
    private String officeAddress;
    private String licenseNum;
    private String email;

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

    public String getSpecialization() {
        return specialization;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public String licenseNum() {
        return licenseNum;
    }

    public String getEmail() {
        return email;
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

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress; 
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Validation methods

    public boolean isValidPhoneNum() {
        return phoneNum.matches("\\d{3}-\\d{3}-\\d{4}"); // Used ChatGPT to help with regex statements
    }
    
    public boolean isValidEmail() {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
    
    public boolean isValidLicenseNum() {
        return licenseNum.matches("^[A-Z]{3}\\d{3}$");
    }

    // To String method

    @Override
    public String toString() {
        return "Doctor [Full Name: " + firstName + " " + lastName + 
           ", Age: " + age + 
           ", Phone Number: " + phoneNum + 
           ", Specialization: " + specialization + 
           ", Office Address: " + officeAddress + 
           ", License Number: " + licenseNum + 
           ", Email: " + email + "]";
    }
}
