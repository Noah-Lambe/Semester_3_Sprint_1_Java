package main;
import java.time.LocalDate;
import java.util.Random;

public class Medication {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    // Constructor
    public Medication(String name, String dose, int quantityInStock) {
        this.id = idCounter++;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomExpiryDate(); // Generates a random expiry date
    }

    // Method to generate a random expiry date, including past dates
    private LocalDate generateRandomExpiryDate() {
        Random random = new Random();
        int daysOffset = random.nextInt(365 * 2) - 365; // Random date within a past and future year
        return LocalDate.now().plusDays(daysOffset);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDose() {
        return dose;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Check if medication is expired
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    // Restock method
    public void restock(int amount) {
        this.quantityInStock += amount;
        System.out.println("Restocked " + name + " by " + amount + " units. New stock: " + quantityInStock);
    }

    // Display medication details
    @Override
    public String toString() {
        return "Medication [ID: " + id +
                ", Name: " + name +
                ", Dosage: " + dose +
                ", Quantity in Stock: " + quantityInStock +
                ", Expiry Date: " + expiryDate + (isExpired() ? " (Expired)" : " (Valid)");
    }
}
