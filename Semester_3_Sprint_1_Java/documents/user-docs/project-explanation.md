# Pharmacy Medication Tracking System

The Pharmacy Medication Tracking System is a Java-based application that manages pharmacy operations, including patients, doctors, medications, prescriptions, and pharmacy inventory. It allows pharmacy staff to efficiently track patient prescriptions, manage doctor and medication data, and generate reports, such as those for expired medications and prescription histories.  
The application uses object-oriented principles, with inheritance playing a crucial role in organizing entities like doctors, patients, and prescriptions.

## Classes and Their Functionality

### Persons Class
The `Persons` class is the base class for all the persons in the system (Doctors and Patients). It contains common variables that are shared by both doctors and patients.

### Doctor Class
The `Doctor` class extends `Persons` and represents a doctor in the system. It provides methods for adding, editing, and managing doctor-specific data, such as specialty, license number, etc.

### Patient Class
The `Patient` class extends `Persons` and represents a patient in the system. It provides methods for managing patient-specific data, adding, and removing patients.

### Medications Class
The `Medications` class represents medications in the system. This class is used to manage inventory and expiration dates. It also has methods for removing and adding medications to the pharmacy's inventory.

### Prescription Class
The `Prescription` class is a subclass of `Doctor`, `Patient`, and `Medications`. It associates a doctor with a patient and any prescribed medications. This class also has methods to allow editing, creating, and removing prescriptions, and managing associations of specific medications with specific doctors.

### MedicationTracking Class
The `MedicationTracking` class manages the main operations of the system, such as adding and removing whole patients, doctors, medications, and prescription objects from the system. It acts as the central repository for all entities in the system and performs the CRUD operations for these entities. It contains methods for interacting with all records in the system and can generate reports.

### Menu Class
The `Menu` class functions as the main class and serves as the entry point of the program. It displays a menu to the user, presenting different options for interacting with the system. Based on the user’s selection, the appropriate method from `MedicationTracking` is called.
