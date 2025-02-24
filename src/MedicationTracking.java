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
    public Doctor findDoctor(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    public Patient findPatient(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public Medication findMedication(int id) {
        for (Medication medication : medications) {
            if (medication.getId() == id) {
                return medication;
            }
        }
        return null;
    }

    // Method to edit details for a Doctor
    public void editDoctor(
            int id, String firstName, String lastName, int age, String phoneNum,
            String specialization, String officeAddress, String licenseNum, String email) {
        Doctor doctor = findDoctor(id);
        if (doctor != null) {
            doctor.setFirstName(firstName);
            doctor.setLastName(lastName);
            doctor.setAge(age);
            doctor.setPhoneNum(phoneNum);
            doctor.setSpecialization(specialization);
            doctor.setOfficeAddress(officeAddress);
            doctor.setLicenseNum(licenseNum);
            doctor.setEmail(email);
        } else {
            System.out.println("Doctor with ID " + id + " not found.");
        }
    }

    // Method to edit details for a Patient
    public void editPatient(
            int id, String firstName, String lastName, int age, String phoneNum, String mcpNum,
            char gender, String emergContact, String[] currentMeds, String[] medHistory,
            String bloodType, String insurance, String allergies, String address,
            String nextOfKin, Date lastPresDate) {
        Patient patient = findPatient(id);
        if (patient != null) {
            patient.setId(id);
            patient.setFirstName(firstName);
            patient.setLastName(lastName);
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
        } else {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    // Method to edit details for a Medication
    public void editMedication(int id, String name, String dose, int quantityInStock) {
        Medication medication = findMedication(id);
        if (medication != null) {
            medication.setName(name);
            medication.setDose(dose);
            medication.setQuantityInStock(quantityInStock);
        } else {
            System.out.println("Medication with ID " + id + " not found.");
        }
    }
}
