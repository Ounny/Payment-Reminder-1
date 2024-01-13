package User;

import java.util.Scanner;

public abstract class User {
    public String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void displayUserMenu() {
        System.out.println("User Menu:");
        System.out.println("1. View Notifications");
        System.out.println("2. View my Invoices");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }
    public void changePassword() {
        try (// Example: Allow the user to change their password
        Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter current password: ");
            String currentPassword = scanner.nextLine();
            if (currentPassword.equals(this.password)) {
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                this.password = newPassword;
                System.out.println("Password changed successfully!");
            } else {
                System.out.println("Incorrect current password. Password not changed.");
            }
        }
    }

    @Override
    public String toString() {
        String s = "User is created:"
                + "\nThe username is: " + this.username
                + "\nThe password is: " + this.password;

        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;//If either condition is true, the objects are not equal, and the method returns false.
        User tmpUser = (User) obj;
        return this.username.equals(tmpUser.username);
    }



    // Make any other methods abstract that should be implemented in subclasses
    public abstract String getUserType(); // Example abstract method
}

