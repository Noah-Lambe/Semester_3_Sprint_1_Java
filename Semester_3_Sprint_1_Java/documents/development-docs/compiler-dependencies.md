# Compiler-Time Dependencies

The following are the required dependencies for compiling the **Medication Tracking System** program:

### 1. **Java Standard Library**
   - **`java.util.ArrayList`**:
     - Provides a resizable array implementation of the `List` interface. Commonly used for storing dynamic collections of elements.
     ```java
     import java.util.ArrayList;
     ```

   - **`java.util.Scanner`**:
     - Used for capturing input from the user via the console.
     ```java
     import java.util.Scanner;
     ```

   - **`java.util.Date`**:
     - Represents a specific instant in time, with millisecond precision. Used for handling dates and times.
     ```java
     import java.util.Date;
     ```

   - **`java.time.LocalDate`**:
     - Represents a date without time, often used for handling dates in a more modern and readable way.
     ```java
     import java.time.LocalDate;
     ```

   - **`java.util.Random`**:
     - Used for generating random numbers, which can be useful in simulations or random selections.
     ```java
     import java.util.Random;
     ```

   - **`java.util.List`**:
     - The core interface in the Java Collections Framework that defines the behavior of list-based data structures.
     ```java
     import java.util.List;
     ```

   - **`java.util.Arrays`**:
     - Provides utility methods for working with arrays, such as sorting and searching.
     ```java
     import java.util.Arrays;
     ```

### 2. **Custom Classes (Project-Specific)**
   These classes are part of the **Medication Tracking System** and are located in the `classes` package. These are essential for the system's functionality:

   - **`Doctor`**:
     - A class representing a doctor in the pharmacy management system.
     ```java
     import classes.Doctor;
     ```

   - **`Patient`**:
     - A class representing a patient in the pharmacy management system.
     ```java
     import classes.Patient;
     ```

   - **`Prescription`**:
     - A class representing a prescription, typically containing details about the medication and the prescribing doctor.
     ```java
     import classes.Prescription;
     ```

   - **`Medication`**:
     - A class representing a medication, including details like its name, quantity, and expiration date.
     ```java
     import classes.Medication;
     ```

---

These dependencies are required for the successful compilation of the **Medication Tracking System**. Ensure that the classes in the `classes` package are available and compiled alongside the program to avoid any missing reference errors.
