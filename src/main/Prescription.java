package main;

import java.time.LocalDate;

public class Prescription {
    private static int counter = 1;

    private int prescriptionID;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate prescriptionExpiry;

    // Constructor
    public Prescription(Doctor doctor, Patient patient, Medication medication) {
        this.prescriptionID = counter++;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExpiry = LocalDate.now().plusYears(1);
    }

    // Getters
    public int getPrescriptionID() {
        return prescriptionID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public LocalDate getPrescriptionExpiry() {
        return prescriptionExpiry;
    }

    // Setters
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public void setPrescriptionExpiry(LocalDate prescriptionExpiry) {
        this.prescriptionExpiry = prescriptionExpiry;
    }

    // Check if the prescription is expired
    public boolean isExpired() {
        return LocalDate.now().isAfter(prescriptionExpiry);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "ID=" + prescriptionID +
                ", Doctor='" + doctor.getFullName() + '\'' +
                ", Patient='" + patient.getFullName() + '\'' +
                ", Medication='" + medication.getName() + '\'' +
                ", Expiry Date=" + prescriptionExpiry +
                (isExpired() ? " (Expired)" : " (Valid)") +
                '}';
    }
}
