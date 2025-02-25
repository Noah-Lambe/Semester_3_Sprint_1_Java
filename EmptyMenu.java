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
import main.Prescription;

public class EmptyMenu {
    public static void main(String[] args) {
        MedicationTracking medicationTracking = new MedicationTracking();
        boolean exit = false;

        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=====Welcome To The Pharmacy Med Tracking System=====");
            System.out.println("What would you like to do? ");
            System.out.println("1: Add A New Patient");
            System.out.println("2: Remove A Patient");
            System.out.println("3: Edit A Patient");
            System.out.println("4: Search For A Patient");
            System.out.println("5: Add A New Doctor");
            System.out.println("6: Remove A Doctor");
            System.out.println("7: Edit A Doctor");
            System.out.println("8: Search A Doctor");
            System.out.println("9: Add A New Medication To The Pharmacy");
            System.out.println("10: Remove A Medication To The Pharmacy");
            System.out.println("11: Edit A Medication To The Pharmacy");
            System.out.println("12: Search A Medication To The Pharmacy");
            System.out.println("13: Accept Perscription From A Doctor");
            System.out.println("14: Add Patients To A Doctor");
            System.out.println("15: Generate Report: Print a report summarizing all data, including patients, doctors, and medications in the system");
            System.out.println("16: Generate Report: Check to see if any drug is expired in the system. If they are generate a report of the ones that are");
            System.out.println("17: Generate Report: Print a list of all prescriptions for a specific doctor");
            System.out.println("18: Restock All Drugs In The Pharmacy");
            System.out.println("0: Exit");
            System.out.println("19: Print all patients");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addANewPatient(scanner, medicationTracking);
                    break;
                case 2:
                    removeAPatient(scanner, medicationTracking);
                    break;
                case 3:
                    editAPatient(scanner, medicationTracking);
                    break;
                case 4:
                    searchForAPatient(scanner, medicationTracking);
                    break;
                case 5:
                    addANewDoctor(scanner, medicationTracking);
                    break;
                case 6:
                    removeADoctor(scanner, medicationTracking);
                    break;
                case 7:
                    editADoctor(scanner, medicationTracking);
                    break;
                case 8:
                    searchADoctor(scanner, medicationTracking);
                    break;
                case 9:
                    addNewMedicationToPharmacy(scanner, medicationTracking);
                    break;
                case 10:
                    removeMedicationToPharmacy(scanner, medicationTracking);
                    break;
                case 11:
                    editMedicationToPharmacy(scanner, medicationTracking);
                    break;
                case 12:
                    searchNewMedicationToPharmacy(scanner, medicationTracking);
                    break;
                case 13:
                    processANewScript(scanner, medicationTracking);
                    break;
                case 14:
                    addPatientToADoctor(scanner, medicationTracking);
                    break;
                case 15:
                    printPharmacyReport(scanner, medicationTracking);
                    break;
                case 16:
                    checkExpiredMeds(scanner, medicationTracking);
                    break;
                case 17:
                    allPrescriptions(scanner, medicationTracking);
                    break;
                case 18:
                    restockPharmacyDrugs(scanner, medicationTracking);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting The System! Good Bye!");
                    break;
                case 19:
                    medicationTracking.displayAllPatients();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

    }

    // Report 1
    private static void printPharmacyReport(Scanner scanner, MedicationTracking system) {

    }

    // Report 2
    private static void checkExpiredMeds(Scanner scanner, MedicationTracking system) {

    }

    // Report 3
    private static void allPrescriptions(Scanner scanner, MedicationTracking system) {
        // Combined together in report 3
    // private static void printAllScriptsForPatientByName(Scanner scanner, MedicationTracking system) {

    // }

    

    // private static void printScriptsForSpecificDoctor(Scanner scanner, MedicationTracking system) {

    // }
    }


    // Restock Drugs
    private static void restockPharmacyDrugs(Scanner scanner, MedicationTracking system) {

    }

    //Add Patients To a Doctor
    private static void addPatientToADoctor(Scanner scanner, MedicationTracking system) {

    }

    

    // Accept A New Perscription
    private static void processANewScript(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter Patient's Name: ");
        String patientName = scanner.nextLine();

        System.out.print("Enter Doctor's Name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Enter Medication Name: ");
        String medicationName = scanner.nextLine();

        Doctor doctor = system.findDoctorByName(doctorName.split(" ")[0], doctorName.split(" ")[1]);
        Patient patient = system.findPatientByName(patientName.split(" ")[0], patientName.split(" ")[1]);
        Medication medication = system.findMedicationByName(medicationName);

        // Validate if all objects exist
        if (doctor == null) {
            System.out.println("Error: Doctor " + doctorName + " not found.");
            return;
        }
        if (patient == null) {
            System.out.println("Error: Patient " + patientName + " not found.");
            return;
        }
        if (medication == null) {
            System.out.println("Error: Medication " + medicationName + " not found.");
            return;
        }

        // Create a Prescription object with the correct parameters
        Prescription newPrescription = new Prescription(doctor, patient, medication);

        // Add the prescription to the system
        system.addPrescription(newPrescription);
        System.out.println("\nPrescription processed successfully for " + patientName);
    }

    // Add, Remove, Edit and Search Medication
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

    private static void removeMedicationToPharmacy(Scanner scanner, MedicationTracking medicationTracking) {

    }

    private static void editMedicationToPharmacy(Scanner scanner, MedicationTracking medicationTracking) {

    }

    private static void searchNewMedicationToPharmacy(Scanner scanner, MedicationTracking medicationTracking) {

    }

    // Add, Remove, Edit and Search Doctor
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

    private static void removeADoctor(Scanner scanner, MedicationTracking medicationTracking) {

    }

    private static void editADoctor(Scanner scanner, MedicationTracking medicationTracking) {
        
    }

    private static void searchADoctor(Scanner scanner, MedicationTracking medicationTracking) {
        
    }

    // Add, Remove, Edit and Search Patient
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

    private static void removeAPatient(Scanner scanner, MedicationTracking medicationTracking) {
        
    }
    
    private static void editAPatient(Scanner scanner, MedicationTracking medicationTracking) {
        
    }
   
    private static void searchForAPatient(Scanner scanner, MedicationTracking medicationTracking) {
        
    }
}