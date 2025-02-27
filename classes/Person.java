package classes;

public class Person {
     
    public int id;
    public String firstName;
    public String lastName;
    public int age;
    public String phoneNum;

    public Person(int id, String firstName, String lastName, int age, String phoneNum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNum = phoneNum;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName + ", " + "Age: " + age + ", Phone Number: " + phoneNum;
    }
}

