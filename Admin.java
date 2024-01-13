package User;

import java.util.Scanner;

public class Admin extends User   {
    final String position = "Admin";
    
    public Admin(String username, String password) {
        super(username, password);
    }

    public static void displayAdminMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Register User");
        System.out.println("2. Register Invoice");
        System.out.println("3. View Invoices");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    
    @Override
    public void changePassword() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter username of the student to change password: ");
            String studentUsername = scanner.nextLine();

            // Locate the student in the system
            Student student = findStudent(studentUsername);

            if (student != null) {
                System.out.print("Enter new password for student " + student.getUsername() + ": ");
                String newPassword = scanner.nextLine();
                student.setPassword(newPassword);
                System.out.println("Password changed successfully for student " + student.getUsername() + " by admin " + getUsername());
            } else {
                System.out.println("Student not found. Password not changed.");
            }
        }
    }

    private Student findStudent(String studentUsername) {
        return null;
    }

    @Override
    public String getUserType() {
        return "Admin";
    }

}

