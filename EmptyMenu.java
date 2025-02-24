/*

This is an example menu that is set up to show you a way of structuring your project.
this doesnt have all requirements in it please refer to the sprint doc to view all requirements
 */

// package MedicationTracking;

import java.util.Scanner;
import java.util.Date;

import main.Doctor;
import main.Medication;
import main.Patient;

public class EmptyMenu {
    public static void main(String[] args) {
        MedicationTracking medicationTracking = new MedicationTracking();
        boolean exit = false;

        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=====Welcome To The Pharmacy Med Tracking System=====");
            System.out.println("What would you like to do? ");
            System.out.println("1: Add A New Patient");
            System.out.println("2: Add A New Doctor");
            System.out.println("3: Add A New Medication To The Pharmacy");
            System.out.println("4: Print System Report");
            System.out.println("5: Check If Meds Are Expired");
            System.out.println("6: Process A New Prescription");
            System.out.println("7: Print All Scripts For Specific Doctor");
            System.out.println("8: Restock the drugs in the pharmacy");
            System.out.println("9: print all scripts for specific patient");
            System.out.println("10: Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addANewPatient(scanner, medicationTracking);
                    break;
                case 2:
                    addANewDoctor(scanner, medicationTracking);
                    break;
                case 3:
                    addNewMedicationToPharmacy(scanner, medicationTracking);
                    break;
                case 4:
                    printPharmacyReport(medicationTracking);
                    break;
                case 5:
                    checkExpiredMeds(medicationTracking);
                    break;
                case 6:
                    processANewScript(scanner, medicationTracking);
                    break;
                case 7:
                    printScriptsForSpecificDoctor(scanner, medicationTracking);
                    break;
                case 8:
                    restockPharmacyDrugs(scanner, medicationTracking);
                    break;
                case 9:
                    printAllScriptsForPatientByName(scanner, medicationTracking);
                    break;
                case 10:
                    exit = true;
                    System.out.println("Exiting The System! Good Bye!");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

    }

    private static void printAllScriptsForPatientByName(Scanner scanner, MedicationTracking system) {

    }

    private static void restockPharmacyDrugs(Scanner scanner, MedicationTracking system) {

    }

    private static void printScriptsForSpecificDoctor(Scanner scanner, MedicationTracking system) {

    }

    private static void processANewScript(Scanner scanner, MedicationTracking system) {

    }

    private static void checkExpiredMeds(MedicationTracking system) {

    }

    private static void printPharmacyReport(MedicationTracking system) {

    }

    private static void addNewMedicationToPharmacy(Scanner scanner, MedicationTracking medicationTracking) {
        System.out.print("Enter Medication Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Dosage (e.g., 500mg): ");
        String dose = scanner.nextLine();

        System.out.print("Enter Quantity in Stock: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create a new Medication object
        Medication newMedication = new Medication(name, dose, quantity);

        // Add the medication to the system
        medicationTracking.addMedication(newMedication);

        System.out.println("\nMedication added successfully!");
        newMedication.displayMedicationInfo(); // Display the medication details
    }

    private static void addANewDoctor(Scanner scanner, MedicationTracking medicationTracking) {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNum = scanner.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter Office Address: ");
        String officeAddress = scanner.nextLine();

        System.out.print("Enter License Number: ");
        String licenseNum = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        // Create a new Doctor object
        Doctor newDoctor = new Doctor(id, firstName, lastName, age, phoneNum, specialization, officeAddress, licenseNum,
                email);

        // Add the doctor to the system
        medicationTracking.addDoctor(newDoctor);
        System.out.println("Doctor added successfully!");
    }

    private static void addANewPatient(Scanner scanner, MedicationTracking medicationTracking) {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNum = scanner.nextLine();

        System.out.print("Enter MCP Number: ");
        String mcpNum = scanner.nextLine();

        System.out.print("Enter Gender (M/F): ");
        char gender = scanner.next().charAt(0);
        scanner.nextLine();

        System.out.print("Enter Emergency Contact: ");
        String emergContact = scanner.nextLine();

        System.out.print("Enter Current Medications (comma-separated): ");
        String[] currentMeds = scanner.nextLine().split(",");

        System.out.print("Enter Medical History (comma-separated): ");
        String[] medHistory = scanner.nextLine().split(",");

        System.out.print("Enter Blood Type: ");
        String bloodType = scanner.nextLine();

        System.out.print("Enter Insurance Provider: ");
        String insurance = scanner.nextLine();

        System.out.print("Enter Allergies (comma-separated, or 'None'): ");
        String allergies = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Next of Kin: ");
        String nextOfKin = scanner.nextLine();

        System.out.print("Enter Last Prescription Date (yyyy-MM-dd): ");
        String lastPresDateStr = scanner.nextLine();
        Date lastPresDate = java.sql.Date.valueOf(lastPresDateStr); // Convert String to Date

        // Create a new Patient object
        Patient newPatient = new Patient(id, firstName, lastName, age, phoneNum, mcpNum,
                gender, emergContact, currentMeds, medHistory, bloodType, insurance,
                allergies, address, nextOfKin, lastPresDate);

        // Add patient to the system
        medicationTracking.addPatient(newPatient);
        System.out.println("Patient added successfully!");
    }

}
