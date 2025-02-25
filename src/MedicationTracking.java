import java.util.ArrayList;
import main.Doctor;
import main.Patient;
import main.Prescription;
import main.Medication;
import java.util.Date;

public class MedicationTracking {
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Medication> medications;
    private ArrayList<Prescription> prescriptions;

    public MedicationTracking() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Methods to add a doctor, patient, and medication to the list
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    // Methods to delete doctor, patient, and medication from the list
    public void deleteDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public void deletePatient(Patient patient) {
        patients.remove(patient);
    }

    public void deleteMedication(Medication medication) {
        medications.remove(medication);
    }

    // Methods to search for a doctor, patient, or medication in the list
    public Doctor findDoctorByName(String firstName, String lastName) {
        for (Doctor doctor : doctors) {
            if (doctor.getFirstName().equalsIgnoreCase(firstName) &&
                    doctor.getLastName().equalsIgnoreCase(lastName)) {
                return doctor;
            }
        }
        return null;
    }

    public Patient findPatientByName(String firstName, String lastName) {
        for (Patient patient : patients) {
            if (patient.getFirstName().equalsIgnoreCase(firstName) &&
                    patient.getLastName().equalsIgnoreCase(lastName)) {
                return patient;
            }
        }
        return null;
    }

    public Medication findMedicationByName(String name) {
        for (Medication medication : medications) {
            if (medication.getName().equalsIgnoreCase(name)) {
                return medication;
            }
        }
        return null;
    }

    // Method to edit details for a Doctor
    public void editDoctor(
            String firstName, String lastName, int age, String phoneNum,
            String specialization, String officeAddress, String licenseNum, String email) {

        Doctor doctor = findDoctorByName(firstName, lastName);

        if (doctor != null) {
            doctor.setAge(age);
            doctor.setPhoneNum(phoneNum);
            doctor.setSpecialization(specialization);
            doctor.setOfficeAddress(officeAddress);
            doctor.setLicenseNum(licenseNum);
            doctor.setEmail(email);

            System.out.println("Doctor details updated successfully.");
        } else {
            System.out.println("Doctor with name " + firstName + " " + lastName + " not found.");
        }
    }

    // Method to edit details for a Patient
    public void editPatient(
            int id, String firstName, String lastName, int age, String phoneNum, String mcpNum,
            char gender, String emergContact, String[] currentMeds, String[] medHistory,
            String bloodType, String insurance, String allergies, String address,
            String nextOfKin, Date lastPresDate) {

        Patient patient = findPatientByName(firstName, lastName);

        if (patient != null) {
            patient.setId(id);
            patient.setFirstName(firstName);
            patient.setLastName(lastName);
            patient.setFullName(firstName, lastName);
            patient.setAge(age);
            patient.setPhoneNum(phoneNum);
            patient.setMcpNum(mcpNum);
            patient.setGender(gender);
            patient.setEmergContact(emergContact);
            patient.setCurrentMeds(currentMeds);
            patient.setMedHistory(medHistory);
            patient.setBloodType(bloodType);
            patient.setInsurance(insurance);
            patient.setAllergies(allergies);
            patient.setAddress(address);
            patient.setNextOfKin(nextOfKin);
            patient.setLastPresDate(lastPresDate);

            System.out.println("Patient details updated successfully.");
        } else {
            System.out.println("Patient with name " + firstName + " " + lastName + " not found.");
        }
    }

    // Method to edit details for a Medication
    public void editMedication(String name, String dose, int quantityInStock) {
        Medication medication = findMedicationByName(name);

        if (medication != null) {
            medication.setName(name);
            medication.setDose(dose);
            medication.setQuantityInStock(quantityInStock);

            System.out.println("Medication details updated successfully.");
        } else {
            System.out.println("Medication with name " + name + " not found.");
        }
    }

    public void printSystemReport() {
        System.out.println("\n===== SYSTEM REPORT =====");
        System.out.println("Doctors:");
        doctors.forEach(System.out::println);
        System.out.println("\nPatients:");
        patients.forEach(System.out::println);
        System.out.println("\nMedications:");
        medications.forEach(System.out::println);
        System.out.println("\nPrescriptions:");
        prescriptions.forEach(System.out::println);
    }

    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients in the system.");
        } else {
            System.out.println("\n===== Patient List =====");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }
}
