/*

This is an example menu that is set up to show you a way of structuring your project.
this doesnt have all requirements in it please refer to the sprint doc to view all requirements
 */

package medicationtracking;
import java.util.Scanner;

public class EmptyMenu {
    public static void main(String[] args) {
        MedicationTracking medicationTracking = new MedicationTracking();
        boolean exit = false;

        while (!exit){
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
                    addANewPatient(scanner,system);
                    break;
                case 2:
                    addANewDoctor(scanner);
                    break;
                case 3:
                    addNewMedicationToPharmacy(scanner, system);
                    break;
                case 4:
                    printPharmacyReport(system);
                    break;
                case 5:
                    checkExpiredMeds(system);
                    break;
                case 6:
                    processANewScript(scanner,system);
                    break;
                case 7:
                    printScriptsForSpecificDoctor(scanner,system);
                    break;
                case 8:
                    restockPharmacyDrugs(scanner,system);
                    break;
                case 9:
                    printAllScriptsForPatientByName(scanner,system);
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

    private static void addNewMedicationToPharmacy(Scanner scanner, MedicationTracking system) {

    }

    private static void addANewDoctor(Scanner scanner) {
    }

    private static void addANewPatient(Scanner scanner, MedicationTracking system) {


    }

}
}
