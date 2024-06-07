
import java.util.Scanner;
class Doctor {
    private String name;
    private int id;
    private String specification;
    private String contactNo;
    public double salary;
    private String password;

    public Doctor(String name, int id, String specification, String contactNo, double salary, String password) {
        this.name = name;
        this.id = id;
        this.specification = specification;
        this.contactNo = contactNo;
        this.salary = salary;
        this.password = password;
    }

    public double getSalary(String password) {
        if (this.password.equals(password)) { 
            return salary;
        } else {
            System.out.println("Incorrect password for doctor " + name);
            return -1;
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSpecification() {
        return specification;
    }
}

class Patient {
    private String name;
    private int id;
    private String disease;
    private String doctor;
    private double bill;
    private int age;
    private String contactNo;

    public Patient(String name, int id, String disease, String doctor, int age, String contactNo) {
        this.name = name;
        this.id = id;
        this.disease = disease;
        this.doctor = doctor;
        this.age = age;
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDisease()
    {
        return disease;
    }

    public String getDoctor() {
        return doctor;
    }

    public int getAge() {
        return age;
    }

    public String getContactNo() {
        return contactNo;
    }
}

class Staff {
    private int id;
    private double salary;
    private String name;
    private String contactNo;
    private String password;

    public Staff(int id, double salary, String name, String contactNo, String password) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.contactNo = contactNo;
        this.password = password;
    }

    public double getSalary(String password) {
        if (this.password.equals(password)) {
            return salary;
        } else {
            System.out.println("Incorrect password for staff " + name);
            return -1;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class BillingDepartment {
    public static double calculateBill(Patient patient) {
        return 1000;
    }
}

public class HospitalManagementSystem {
    private static Doctor[] doctors = {
            new Doctor("Dr. Patil", 101, "General Physician", "1234567890", 70000, "pass1"),
            new Doctor("Dr. Lahane", 102, "Surgeon", "0987654321", 125000, "pass2"),
            new Doctor("Dr. Badgujar", 103, "Pediatrician", "9876543210", 68000, "pass3"),
            new Doctor("Dr. More", 104, "Cardiologist", "0123456789", 170000, "pass4"),
            new Doctor("Dr. Bhoir", 105, "Dermatologist", "6789012345", 130000, "pass5")
    };

    private static Patient[] patients = new Patient[100];
    private static int patientCount = 0;

    private static Staff[] staffs = {
            new Staff(201, 30000, "Nurse Priya", "4567890123", "staffpass1"),
            new Staff(202, 25000, "Receptionist Magade", "7890123456", "staffpass2"),
            new Staff(203, 35000, "Cleaner Pote", "2345678901", "staffpass3")
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Hospital Management System");
            System.out.println("1. Admit a Patient");
            System.out.println("2. Discharge a Patient and Generate Bill");
            System.out.println("3. Show All Patients");
            System.out.println("4. Access Doctor/Staff Salary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    admitPatient(scanner);
                    break;
                case 2:
                    dischargePatient(scanner);
                    break;
                case 3:
                    showAllPatients();
                    break;
                case 4:
                    accessSalary(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }

    private static void admitPatient(Scanner scanner) {
        System.out.println("Admit a Patient");
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient Disease: ");
        String disease = scanner.nextLine();
        System.out.println("Enter Which Doctor is needed for Patient : ");
        System.out.println("1. General Physician");
        System.out.println("2. Surgeon");
        System.out.println("3. Pediatrician");
        System.out.println("4. Cardiologist");
        System.out.println("5. Dermatologist");
        System.out.print("Enter choice: ");
        int doctorChoice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter patient contact number: ");
        String contactNo = scanner.nextLine();

        Doctor assignedDoctor = null;
        switch (doctorChoice) {
            case 1:
                assignedDoctor = getDoctorBySpecification("General Physician");
                break;
            case 2:
                assignedDoctor = getDoctorBySpecification("Surgeon");
                break;
            case 3:
                assignedDoctor = getDoctorBySpecification("Pediatrician");
                break;
            case 4:
                assignedDoctor = getDoctorBySpecification("Cardiologist");
                break;
            case 5:
                assignedDoctor = getDoctorBySpecification("Dermatologist");
                break;
            default:
                System.out.println("Invalid choice.");
        }

        if (assignedDoctor == null) {
            System.out.println("No doctor available for the specified choice.");
        } else {
            patients[patientCount++] = new Patient(name, patientCount, disease, assignedDoctor.getSpecification(), age, contactNo);
            System.out.println("Patient admitted successfully. Assigned doctor: " + assignedDoctor.getName() + ", Patient ID: " + patientCount);
        }
    }

    private static Doctor getDoctorBySpecification(String specification) {
        for (Doctor doctor : doctors) {
            if (doctor.getSpecification().equalsIgnoreCase(specification)) {
                return doctor;
            }
        }
        return null;
    }

    private static void dischargePatient(Scanner scanner) {
        System.out.println("Discharge a Patient and Generate Bill");
        System.out.print("Enter patient ID to discharge: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getId() == id) {
                double bill = BillingDepartment.calculateBill(patients[i]);
                System.out.println("Patient Name: " + patients[i].getName());
                System.out.println("Bill Amount: Rs. " + bill);
                patients[i] = patients[patientCount-1];
                patientCount++;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    private static void showAllPatients() {
        System.out.println("All Patients:");
        for (int i = 0; i < patientCount; i++) {
            System.out.println("Patient ID: " + patients[i].getId());
            System.out.println("Name: " + patients[i].getName());
            System.out.println("Disease of patient: "+patients[i].getDisease());
            System.out.println("Assigned Doctor by specification: " + patients[i].getDoctor());
            System.out.println("Age: " + patients[i].getAge());
            System.out.println("Contact No: " + patients[i].getContactNo());
            System.out.println();
        }
    }

    private static void accessSalary(Scanner scanner) {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                double salary = doctor.getSalary(password);
                if (salary != -1) {
                    System.out.println("Doctor " + doctor.getName() + "'s salary: Rs. "+salary);
                }
                return;
            }
        }

        for (Staff staff : staffs) {
            if (staff.getId() == id) {
                double salary = staff.getSalary(password);
                if (salary != -1) {
                    System.out.println("Staff " + staff.getName() + "'s salary: Rs. " + salary);
                }
                return;
            }
        }

        System.out.println("No doctor or staff found with ID " + id);
    }
}
