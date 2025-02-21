public class Main {
    public static void main(String[] args) {
        // Create Medication objects
        Medication med1 = new Medication("Paracetamol", "500mg", 50);
        Medication med2 = new Medication("Amoxicillin", "250mg", 30);

        // Display medication info
        med1.displayMedicationInfo();
        med2.displayMedicationInfo();

        // Check expiration
        System.out.println("Is " + med1.getName() + " expired? " + med1.isExpired());

        // Restock medication
        med1.restock(20);
    }
}
