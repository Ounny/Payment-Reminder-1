/*
 * 1. Register (validate the username before register)
 * 2. login 
 * 
 * save data in text file
 * login, can display information more than username and pasword
 * can change username
 * can change password
 * overriding toString method
 * overriding equal method
 */

/*
 * 
 * Usernames cannot contain an ampersand (&), equals sign (=), underscore (_), apostrophe ('), dash (-), plus sign (+), comma (,), brackets (<,>), or more than one period (.)
 * 
 * Special characters, including the following are not acceptable: (){}[]|`¬¦!"£$%^&*"<>:;#~_-+=,@.
 * 
 */

package Testing;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import Invoice.Invoice;

import User.Admin;
import User.ChangeMajorOperation;
import User.Login;
import User.Register;
import User.Student;
import User.User;

public class Test {
    private static String tmpUsername;
    private static String tmpPassword;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean runSystem = true;

        while (runSystem) {
            displayMenu();
            
            int choice;
            String hasAccount;
            
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Do you have an account? (y/N): ");
                    hasAccount = sc.nextLine();

                    if (hasAccount.equalsIgnoreCase("N")) {
                        registerAccount();
                    } else {
                        loginAccount();
                    }
                    break;
                case 2:
                    runSystem = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 2.");
            }
        }
        sc.close();
    }


    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
    }

    public static void registerAccount() {
        System.out.println("Register:");
        System.out.print("Do you want to register as a student? (y/N): ");
        String isStudent = sc.nextLine();
    
        if (isStudent.equalsIgnoreCase("Y")) {
            do {
                System.out.print("Input name: ");
                tmpUsername = sc.nextLine();
            } while (Login.verifyUserName(tmpUsername));
    
            System.out.print("Input password: ");
            tmpPassword = sc.nextLine();

            // Using anonymous class to create a Student instance
            User teacher = new User(tmpUsername, tmpPassword) {
                @Override
                public String getUserType() {
                    return "teacher";
                }
            };
    
            System.out.println(teacher);
        } else {
            System.out.println("Registration as admin is not supported in this example.");
        }
    }
    
    
    public static void loginAccount() {
        System.out.print("Login as (student/admin): ");
        String userType = sc.nextLine();
    
        if (userType.equalsIgnoreCase("student")) {
            String userTmpUsername, userTmpPassword;
    
            do {
                System.out.print("Input name: ");
                userTmpUsername = sc.nextLine();
            } while (Login.loginUsername(userTmpUsername));
    
            do {
                System.out.print("Input password: ");
                userTmpPassword = sc.nextLine();
            } while (Login.loginPassword(userTmpPassword));
    
            User user = new Student(userTmpUsername, userTmpPassword);
            // Assuming Student is a concrete subclass of User
            Login.loginUser(user);
    
        } else if (userType.equalsIgnoreCase("admin")) {
            String adminTmpUsername, adminTmpPassword;
    
            do {
                System.out.print("Input name: ");
                adminTmpUsername = sc.nextLine();
            } while (Login.loginAdminname(adminTmpUsername));
    
            do {
                System.out.print("Input password: ");
                adminTmpPassword = sc.nextLine();
            } while (Login.loginAdminPassword(adminTmpPassword));
    
            Admin admin = new Admin(adminTmpUsername, adminTmpPassword);
            // Assuming Admin is a concrete subclass of User
            Login.loginAdmin(admin);
        } else {
            System.out.println("Invalid user type.");
        }
    }
    
// --------------------------------------------------------------------------------
    
// --------------------------------------------------------------------------------    
    public static void studentFlow() {
        boolean userRunning = true;
        while (userRunning) {
            // Display user menu
            User.displayUserMenu();

            // Take user input
            int userChoice = sc.nextInt();
            sc.nextLine(); // Consume the newline
    
            // Perform actions based on user input
            switch (userChoice) {
                case 1:
                    // Logic for viewing notifications
                    System.out.println("Displaying Notifications:");
                    // Implement logic to show notifications to the user
                    break;
                case 2:
                    // Logic for viewing all invoices
                    System.out.print("Please put your name again if you want to view your invoice history: ");
                    tmpUsername = sc.nextLine();
                    Invoice.viewInvoiceIndividual(tmpUsername);
                    break;
                    // Implement logic to display all invoices to the user
                   
                case 3:
                    // Exit the user menu
                    userRunning = false;
                    System.out.println("Exiting user menu.");
                    break;
                default:
                    // Handle invalid input
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }    
    }



    // --------------------------------------------------------------------------------
    public static void adminFlow() {
        boolean adminRunning = true;
        while (adminRunning) {
            // Display admin menu and handle admin actions...
            Admin.displayAdminMenu();

            int adminChoice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (adminChoice) {
                // Handle admin actions based on input...
                case 1:
                    registerAccount();
                    break;
                case 2:
                    System.out.println("register invoice");
                    generateInvoice();
                    break;
                case 3:
                    System.out.println("view invoice");
                    viewInvoice();
                    break;
                case 4:
                    adminRunning = false;
                    System.out.println("Exiting admin menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
// --------------------------------------------------------------------------------

    public static void generateInvoice() {
        LocalDate issusDate = LocalDate.now();
        LocalDate dueDate = issusDate.plusDays(30);

        System.out.println("Welcome to Invoice Generator!");
        System.out.print("Enter invoice number: ");
        int invoiceNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter department: ");
        String department = sc.nextLine();

        // Set charges
        System.out.println("\nEnter charges information:");
        System.out.print("How many charges are there? : ");
        int numCharges = sc.nextInt();

        sc.nextLine(); // Consume the newline character

        String[] chargesDescription = new String[numCharges];
        double[] chargesAmount = new double[numCharges];

        for (int i = 0; i < numCharges; i++) {
            System.out.print("Enter description for charge " + (i + 1) + ": ");
            chargesDescription[i] = sc.nextLine();

            System.out.print("Enter amount for charge " + (i + 1) + ": ");
            chargesAmount[i] = sc.nextDouble();

            sc.nextLine(); // Consume the newline character
        }
        Invoice.setCharges(chargesDescription, chargesAmount);
        String chargeDescription = Arrays.toString(Invoice.getChargesDescription());
        String chargeAmount = Arrays.toString(Invoice.getChargesAmount());
        Double totalAmount = Invoice.getTotalAmount();
    
        new Invoice(invoiceNumber, studentName, department, issusDate, dueDate, chargeDescription, chargeAmount, totalAmount);
    
        Register.registerInvoice(invoiceNumber, studentName, department, issusDate, dueDate, chargeDescription, chargeAmount, totalAmount);
    

    
        System.out.println("Invoice generated successfully.");
    }

    public static void viewInvoice() {
        int choice;
        do {
            System.out.println("1. View all invoices");
            System.out.println("2. View individual invoice");
            System.out.println("0. Back");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("All Invoices:");
                    Invoice.viewInvoice();
                    break;

                case 2:
                    System.out.print("View Individual Invoice: ");
                    tmpUsername = sc.nextLine();
                    Invoice.viewInvoiceIndividual(tmpUsername);
                    break;

                case 0:
                    System.out.println("Going back to the main menu.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);
        
    }

    ChangeMajorOperation changeMajor = (student, newMajor) -> student.changeMajor(student, newMajor);
    


}
