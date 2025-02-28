import java.util.Scanner;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import classes.Doctor;
import classes.Medication;
import classes.Patient;
import classes.Prescription;
import classes.MedicationTracking;


public class EmptyMenu {
    public static void main(String[] args) {
        MedicationTracking medicationTracking = new MedicationTracking();

//        Medication expiredMed = new Medication("ExpiredMed", "100mg", 5);
//        expiredMed.setExpiryDate(LocalDate.of(2023, 1, 1));
//        medicationTracking.addMedication(expiredMed);

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
            System.out.println("13: Accept Prescription From A Doctor");
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

    public static void printPharmacyReport(Scanner scanner, MedicationTracking medicationTracking) {
        System.out.println("===== Pharmacy Report =====");
        System.out.println("\nPatients in the system:");
        medicationTracking.displayAllPatients();
        System.out.println("\nDoctors in the system:");
        medicationTracking.displayAllDoctors();
        System.out.println("\nMedications in the pharmacy:");
        medicationTracking.displayAllMedications();
        System.out.println("\nPrescriptions in the system:");
        medicationTracking.displayAllPrescriptions();
        System.out.println("\n===== End of Report =====");
    }

    private static void checkExpiredMeds(Scanner scanner, MedicationTracking system) {
        System.out.println("\n===== Expired Medications Report =====");
        boolean hasExpiredMeds = false;

        for (Medication medication : system.getMedications()) {
            if (medication.isExpired()) {
                hasExpiredMeds = true;
                System.out.println("Medication ID: " + medication.getId());
                System.out.println("Name: " + medication.getName());
                System.out.println("Dose: " + medication.getDose());
                System.out.println("Quantity in Stock: " + medication.getQuantityInStock());
                System.out.println("Expiry Date: " + medication.getExpiryDate() + " (Expired)");
                System.out.println("----------------------------------");
            }
        }

        if (!hasExpiredMeds) {
            System.out.println("No expired medications found.");
        }

    }

    private static void allPrescriptions(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter Doctor's First Name: ");
        String firstName = scanner.next();

        System.out.print("Enter Doctor's Last Name: ");
        String lastName = scanner.next();

        Doctor doctor = system.findDoctorByName(firstName, lastName);

        if (doctor == null) {
            System.out.println("Error: Doctor " + firstName + " " + lastName + " not found.");
            return;
        }

        System.out.println("\n===== Prescriptions for Dr. " + doctor.getFullName() + " =====");

        boolean hasPrescriptions = false;
        for (Prescription prescription : system.getPrescriptions()) {
            if (prescription.getDoctor().equals(doctor)) {
                hasPrescriptions = true;
                System.out.println("Prescription ID: " + prescription.getPrescriptionID());
                System.out.println("Patient: " + prescription.getPatient().getFullName());
                System.out.println("Medication: " + prescription.getMedication().getName() + " ("
                        + prescription.getMedication().getDose() + ")");
                System.out.println("Prescription Expiry Date: " + prescription.getPrescriptionExpiry());
                System.out.println("----------------------------------");
            }
        }

        if (!hasPrescriptions) {
            System.out.println("No prescriptions found for Dr. " + doctor.getFullName());
        }

    }

    private static void restockPharmacyDrugs(Scanner scanner, MedicationTracking medicationTracking) {
        System.out.print("Enter restock amount: ");
        if (scanner.hasNextInt()) {
            int restockAmount = scanner.nextInt();
            scanner.nextLine();

            medicationTracking.restockAllMedications(restockAmount);
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    private static void addPatientToADoctor(Scanner scanner, MedicationTracking system) {
        if (system.getDoctors().isEmpty() || system.getPatients().isEmpty()) {
            System.out.println("No Doctors or Patients available.");
            return;
        }

        System.out.println("\n===== List of Doctors =====");
        for (Doctor doctor : system.getDoctors()) {
            System.out.println("ID: " + doctor.getId() + " | Name: " + doctor.getFullName());
        }

        System.out.println("\n===== List of Patients =====");
        for (Patient patient : system.getPatients()) {
            System.out.println("ID: " + patient.getId() + " | Name: " + patient.getFullName());
        }

        System.out.print("\nEnter the ID of the doctor: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();

        Doctor selectedDoctor = null;
        for (Doctor doctor : system.getDoctors()) {
            if (doctor.getId() == doctorId) {
                selectedDoctor = doctor;
                break;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("Invalid doctor ID.");
            return;
        }

        System.out.print("\nEnter the ID of the patient: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient selectedPatient = null;
        for (Patient patient : system.getPatients()) {
            if (patient.getId() == patientId) {
                selectedPatient = patient;
                break;
            }
        }

        if (selectedPatient == null) {
            System.out.println("Invalid patient ID.");
            return;
        }

        selectedDoctor.addPatient(selectedPatient);
    }

    private static void processANewScript(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter Patient's Name: ");
        String patientName = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Enter Doctor's Name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Enter Medication Name: ");
        String medicationName = scanner.nextLine();

        Doctor doctor = system.findDoctorByName(doctorName.split(" ")[0], doctorName.split(" ")[1]);
        Patient patient = system.findPatientByName(patientName.split(" ")[0], patientName.split(" ")[1]);
        Medication medication = system.findMedicationByName(medicationName);

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

        Prescription newPrescription = new Prescription(doctor, patient, medication);
        system.addPrescription(newPrescription);
        System.out.println("\nPrescription processed successfully for " + patientName);
    }

    private static void addNewMedicationToPharmacy(Scanner scanner, MedicationTracking medicationTracking) {
        scanner.nextLine();
        System.out.print("Enter Medication Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Dosage (e.g., 500mg): ");
        String dose = scanner.nextLine();

        System.out.print("Enter Quantity in Stock: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Medication newMedication = new Medication(name, dose, quantity);
        medicationTracking.addMedication(newMedication);
        System.out.println("\nMedication added successfully!");
    }

    private static void removeMedicationToPharmacy(Scanner scanner, MedicationTracking medicationTracking) {
        if (medicationTracking.getMedications().isEmpty()) {
            System.out.println("No medications available to remove.");
            return;
        }

        System.out.println("\n===== Medication List =====");
        for (Medication medication : medicationTracking.getMedications()) {
            System.out.println("ID: " + medication.getId() + " | Name: " + medication.getName());
        }

        System.out.print("\nEnter the ID of the medication to remove: ");
        int medId = scanner.nextInt();
        scanner.nextLine();

        Medication medToRemove = null;
        for (Medication medication : medicationTracking.getMedications()) {
            if (medication.getId() == medId) {
                medToRemove = medication;
                break;
            }
        }

        if (medToRemove != null) {
            medicationTracking.deleteMedication(medToRemove);
            System.out.println("Medication " + medToRemove.getName() + " has been removed successfully.");
        } else {
            System.out.println("No medication found.");
        }
    }

    private static void editMedicationToPharmacy(Scanner scanner, MedicationTracking medicationTracking) {
        if (medicationTracking.getMedications().isEmpty()) {
            System.out.println("No medications available to edit.");
            return;
        }

        System.out.println("\n===== Medication List =====");
        for (Medication medication : medicationTracking.getMedications()) {
            System.out.println("ID: " + medication.getId() + " | Name: " + medication.getName());
        }

        System.out.print("\nEnter the ID of the medication to edit: ");
        int medId = scanner.nextInt();
        scanner.nextLine();

        Medication medToEdit = null;
        for (Medication medication : medicationTracking.getMedications()) {
            if (medication.getId() == medId) {
                medToEdit = medication;
                break;
            }
        }

        if (medToEdit == null) {
            System.out.println("No medication found.");
            return;
        }

        System.out.println("Editing medication: " + medToEdit.getName());

        System.out.print("Enter new Name (leave blank to keep [" + medToEdit.getName() + "]): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) medToEdit.setName(name);

        System.out.print("Enter new Dosage (leave blank to keep [" + medToEdit.getDose() + "]): ");
        String dose = scanner.nextLine();
        if (!dose.isEmpty()) medToEdit.setDose(dose);

        System.out.print("Enter new Quantity (leave blank to keep [" + medToEdit.getQuantityInStock() + "]): ");
        String quantityInput = scanner.nextLine();
        if (!quantityInput.isEmpty()) medToEdit.setQuantityInStock(Integer.parseInt(quantityInput));

        System.out.println("Medication details updated successfully!");
    }

    private static void searchNewMedicationToPharmacy(Scanner scanner, MedicationTracking medicationTracking) {
        if (medicationTracking.getMedications().isEmpty()) {
            System.out.println("No medications available to search.");
            return;
        }

        System.out.println("\n===== Medication List =====");
        for (Medication medication : medicationTracking.getMedications()) {
            System.out.println("ID: " + medication.getId() + " | Name: " + medication.getName());
        }

        System.out.print("\nEnter the ID of the medication to view details: ");
        int medId = scanner.nextInt();
        scanner.nextLine();

        Medication foundMedication = medicationTracking.findMedicationById(medId);
        if (foundMedication != null) {
            System.out.println("\n===== Medication Details =====");
            System.out.println(foundMedication.toString());
        } else {
            System.out.println("No medication found.");
        }
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

        Doctor newDoctor = new Doctor(id, firstName, lastName, age, phoneNum, specialization, officeAddress, licenseNum, email);
        medicationTracking.addDoctor(newDoctor);
        System.out.println("Doctor added successfully!");
    }

    private static void removeADoctor(Scanner scanner, MedicationTracking medicationTracking) {
        if (medicationTracking.getDoctors().isEmpty()) {
            System.out.println("No doctors available to remove.");
            return;
        }

        System.out.println("\n===== Doctor List =====");
        for (Doctor doctor : medicationTracking.getDoctors()) {
            System.out.println("ID: " + doctor.getId() + " | Name: " + doctor.getFullName());
        }

        System.out.print("\nEnter the ID of the doctor to remove: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();

        Doctor doctorToRemove = null;
        for (Doctor doctor : medicationTracking.getDoctors()) {
            if (doctor.getId() == doctorId) {
                doctorToRemove = doctor;
                break;
            }
        }

        if (doctorToRemove != null) {
            medicationTracking.deleteDoctor(doctorToRemove);
            System.out.println("Doctor " + doctorToRemove.getFullName() + " has been removed successfully.");
        } else {
            System.out.println("No doctor found.");
        }
    }

    private static void editADoctor(Scanner scanner, MedicationTracking medicationTracking) {
        if (medicationTracking.getDoctors().isEmpty()) {
            System.out.println("No doctors available to edit.");
            return;
        }

        System.out.println("\n===== Doctor List =====");
        for (Doctor doctor : medicationTracking.getDoctors()) {
            System.out.println("ID: " + doctor.getId() + " | Name: " + doctor.getFullName());
        }

        System.out.print("\nEnter the ID of the doctor to edit: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();

        Doctor doctorToEdit = null;
        for (Doctor doctor : medicationTracking.getDoctors()) {
            if (doctor.getId() == doctorId) {
                doctorToEdit = doctor;
                break;
            }
        }

        if (doctorToEdit == null) {
            System.out.println("No doctor found.");
            return;
        }

        System.out.println("Editing doctor: " + doctorToEdit.getFullName());

        System.out.print("Enter new First Name (leave blank to keep [" + doctorToEdit.getFirstName() + "]): ");
        String firstName = scanner.nextLine();
        if (!firstName.isEmpty()) doctorToEdit.setFirstName(firstName);

        System.out.print("Enter new Last Name (leave blank to keep [" + doctorToEdit.getLastName() + "]): ");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) doctorToEdit.setLastName(lastName);

        System.out.print("Enter new Age (leave blank to keep [" + doctorToEdit.getAge() + "]): ");
        String ageInput = scanner.nextLine();
        if (!ageInput.isEmpty()) doctorToEdit.setAge(Integer.parseInt(ageInput));

        System.out.print("Enter new Phone Number (leave blank to keep [" + doctorToEdit.getPhoneNum() + "]): ");
        String phoneNum = scanner.nextLine();
        if (!phoneNum.isEmpty()) doctorToEdit.setPhoneNum(phoneNum);

        System.out.print("Enter new Specialization (leave blank to keep [" + doctorToEdit.getSpecialization() + "]): ");
        String specialization = scanner.nextLine();
        if (!specialization.isEmpty()) doctorToEdit.setSpecialization(specialization);

        System.out.print("Enter new Office Address (leave blank to keep [" + doctorToEdit.getOfficeAddress() + "]): ");
        String officeAddress = scanner.nextLine();
        if (!officeAddress.isEmpty()) doctorToEdit.setOfficeAddress(officeAddress);

        System.out.print("Enter new Email (leave blank to keep [" + doctorToEdit.getEmail() + "]): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) doctorToEdit.setEmail(email);

        System.out.println("Doctor details updated successfully!");
    }

    private static void searchADoctor(Scanner scanner, MedicationTracking medicationTracking) {
        if (medicationTracking.getDoctors().isEmpty()) {
            System.out.println("No doctors available to search.");
            return;
        }

        System.out.println("\n===== Doctor List =====");
        for (Doctor doctor : medicationTracking.getDoctors()) {
            System.out.println("ID: " + doctor.getId() + " | Name: " + doctor.getFullName());
        }

        System.out.print("\nEnter the ID of the doctor to view details: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();

        Doctor foundDoctor = null;
        for (Doctor doctor : medicationTracking.getDoctors()) {
            if (doctor.getId() == doctorId) {
                foundDoctor = doctor;
                break;
            }
        }

        if (foundDoctor != null) {
            System.out.println("\n===== Doctor Details =====");
            System.out.println(foundDoctor.toString());
        } else {
            System.out.println("No doctor found.");
        }
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
        Date lastPresDate = java.sql.Date.valueOf(lastPresDateStr);

        Patient newPatient = new Patient(id, firstName, lastName, age, phoneNum, mcpNum,
                gender, emergContact, currentMeds, medHistory, bloodType, insurance,
                allergies, address, nextOfKin, lastPresDateStr);

        medicationTracking.addPatient(newPatient);
        System.out.println("Patient added successfully!");
    }

    private static void removeAPatient(Scanner scanner, MedicationTracking medicationTracking) {
        if (medicationTracking.getPatients().isEmpty()) {
            System.out.println("No patients available to remove.");
            return;
        }

        System.out.println("\n===== Patient List =====");
        for (Patient patient : medicationTracking.getPatients()) {
            System.out.println("ID: " + patient.getId() + " | Name: " + patient.getFullName());
        }

        System.out.print("\nEnter the ID of the patient to remove: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patientToRemove = null;
        for (Patient patient : medicationTracking.getPatients()) {
            if (patient.getId() == patientId) {
                patientToRemove = patient;
                break;
            }
        }

        if (patientToRemove != null) {
            medicationTracking.deletePatient(patientToRemove);
            System.out.println("Patient " + patientToRemove.getFullName() + " has been removed successfully.");
        } else {
            System.out.println("No patient found.");
        }
    }

    private static void editAPatient(Scanner scanner, MedicationTracking medicationTracking) {
        if (medicationTracking.getPatients().isEmpty()) {
            System.out.println("No patients available to edit.");
            return;
        }

        System.out.println("\n===== Patient List =====");
        for (Patient patient : medicationTracking.getPatients()) {
            System.out.println("ID: " + patient.getId() + " | Name: " + patient.getFullName());
        }

        System.out.print("\nEnter the ID of the patient to edit: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patientToEdit = null;
        for (Patient patient : medicationTracking.getPatients()) {
            if (patient.getId() == patientId) {
                patientToEdit = patient;
                break;
            }
        }

        if (patientToEdit == null) {
            System.out.println("No patient found.");
            return;
        }

        System.out.println("Editing patient: " + patientToEdit.getFullName());
        System.out.print("Enter new First Name (leave blank to keep current [" + patientToEdit.getFirstName() + "]): ");
        String firstName = scanner.nextLine();
        if (!firstName.isEmpty()) patientToEdit.setFirstName(firstName);

        System.out.print("Enter new Last Name (leave blank to keep current [" + patientToEdit.getLastName() + "]): ");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) patientToEdit.setLastName(lastName);

        System.out.print("Enter new Age (leave blank to keep current [" + patientToEdit.getAge() + "]): ");
        String ageInput = scanner.nextLine();
        if (!ageInput.isEmpty()) patientToEdit.setAge(Integer.parseInt(ageInput));

        System.out.print("Enter new Phone Number (leave blank to keep current [" + patientToEdit.getPhoneNum() + "]): ");
        String phoneNum = scanner.nextLine();
        if (!phoneNum.isEmpty()) patientToEdit.setPhoneNum(phoneNum);

        System.out.print("Enter new MCP Number (leave blank to keep current [" + patientToEdit.getMcpNum() + "]): ");
        String mcpNum = scanner.nextLine();
        if (!mcpNum.isEmpty()) patientToEdit.setMcpNum(mcpNum);

        System.out.print("Enter new Gender (leave blank to keep current [" + patientToEdit.getGender() + "]): ");
        String gender = scanner.nextLine();
        if (!gender.isEmpty()) patientToEdit.setGender(gender.charAt(0));

        System.out.print("Enter new Emergency Contact (leave blank to keep current [" + patientToEdit.getEmergContact() + "]): ");
        String emergContact = scanner.nextLine();
        if (!emergContact.isEmpty()) patientToEdit.setEmergContact(emergContact);

        System.out.print("Enter new Insurance Provider (leave blank to keep current [" + patientToEdit.getInsurance() + "]): ");
        String insurance = scanner.nextLine();
        if (!insurance.isEmpty()) patientToEdit.setInsurance(insurance);

        System.out.print("Enter new Address (leave blank to keep current [" + patientToEdit.getAddress() + "]): ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) patientToEdit.setAddress(address);

        System.out.print("Enter new Next of Kin (leave blank to keep current [" + patientToEdit.getNextOfKin() + "]): ");
        String nextOfKin = scanner.nextLine();
        if (!nextOfKin.isEmpty()) patientToEdit.setNextOfKin(nextOfKin);

        System.out.println("Patient details updated successfully!");
    }

    private static void searchForAPatient(Scanner scanner, MedicationTracking medicationTracking) {
        if (medicationTracking.getPatients().isEmpty()) {
            System.out.println("No patients available to search.");
            return;
        }

        System.out.println("\n===== Patient List =====");
        for (Patient patient : medicationTracking.getPatients()) {
            System.out.println("ID: " + patient.getId() + " | Name: " + patient.getFullName());
        }

        System.out.print("\nEnter the ID of the patient to view details: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient foundPatient = null;
        for (Patient patient : medicationTracking.getPatients()) {
            if (patient.getId() == patientId) {
                foundPatient = patient;
                break;
            }
        }

        if (foundPatient != null) {
            System.out.println("\n===== Patient Details =====");
            System.out.println(foundPatient.toString());
        } else {
            System.out.println("No patient found.");
        }
    }
}