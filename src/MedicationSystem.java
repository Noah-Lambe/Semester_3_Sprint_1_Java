import java.util.ArrayList;
import main.Doctor;
import main.Patient;
import main.Prescription;
import main.Medication;

public class MedicationSystem {
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Medication> medications;
    private ArrayList<Prescription> prescriptions;

    public MedicationSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Methods to add a doctor, patient and medication to the list
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    // Method to delete doctor, patient and medication in the list
    public void deleteDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public void deletePatient(Patient patient) {
        patients.remove(patient);
    }

    public void deleteMedication(Medication medication) {
        medications.remove(medication);
    }

    
}

