package main;

import java.util.Date;

public static void main(String[] args) {
    // Create an instance of MedicationSystem
    MedicationSystem system = new MedicationSystem();

    // Create and add doctors
    Doctor doctor1 = new Doctor(1, "John", "Doe", 45, "1234567890",
            "Cardiologist", "123 Main St", "LIC12345", "john.doe@example.com");
    Doctor doctor2 = new Doctor(2, "Jane", "Smith", 40, "0987654321",
            "Dermatologist", "456 Elm St", "LIC67890", "jane.smith@example.com");

    system.addDoctor(doctor1);
    system.addDoctor(doctor2);

    // Display doctors
    System.out.println("Doctors after adding:");
    System.out.println(system.findDoctor(1));
    System.out.println(system.findDoctor(2));

    // Create and add a patient
    Patient patient1 = new Patient(1, "Alice", "Johnson", 30, "1122334455",
            "MCP123", 'F', "Bob Johnson", new String[] { "Med1" }, new String[] { "Surgery" },
            "O+", "InsuranceX", "Peanuts", "789 Oak St", "Carol Johnson", new Date());

    system.addPatient(patient1);

    // Display patients
    System.out.println("\nPatients after adding:");
    System.out.println(system.findPatient(1));

    // Create and add a medication
    Medication med1 = new Medication(101, "Paracetamol", "500mg", 50);
    system.addMedication(med1);

    // Display medications
    System.out.println("\nMedications after adding:");
    System.out.println(system.findMedication(101));

    // Edit a doctor's details
    system.editDoctor(1, "John", "Doe", 50, "9998887776",
            "Neurologist", "999 New St", "NEWLIC12345", "new.email@example.com");

    // Display updated doctor
    System.out.println("\nDoctor after editing:");
    System.out.println(system.findDoctor(1));

    // Delete a patient
    system.deletePatient(patient1);

    // Try to find deleted patient
    System.out.println("\nTrying to find deleted patient:");
    System.out.println(system.findPatient(1)); // Should print null
}
