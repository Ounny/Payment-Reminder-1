package User;

// import java.io.BufferedReader;
// import java.io.FileReader;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;
import java.time.LocalDate;

// import java.util.ArrayList;
// import java.util.List;


public class Register {
    public static void registerAdmin(String adminTmpUsername, String adminTmpPassword) {
        // List<String> lines = readLinesFromFile("AdminInfo.txt");
        String filePath = "UserInfo.txt";

        // int nextUserId = getNextUserId(lines);

        // String writingContent = nextUserId + "/" + username + "/" + password;
        String writingContent = adminTmpUsername + "/" + adminTmpPassword;

        try {
            // Create a FileWriter in append mode by passing true as the second parameter
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Wrap the FileWriter in a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Append the data to the file
            bufferedWriter.write(writingContent);
            bufferedWriter.newLine(); // Add a new line for clarity

            // Close the BufferedWriter to ensure all data is flushed to the file
            bufferedWriter.close();

            System.out.println("Data has been appended to the file successfully.");
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
            System.out.println("Error saving data admin to file.");
        }
    }
    
    public static void registerUser(String userTmpUsername, String userTmpPassword) {
        // List<String> lines = readLinesFromFile("UserInfo.txt");
        String filePath = "UserInfo.txt";

        // int nextUserId = getNextUserId(lines);

        // String writingContent = nextUserId + "/" + username + "/" + password;
        String writingContent = userTmpUsername + "/" + userTmpPassword;

        try {
            // Create a FileWriter in append mode by passing true as the second parameter
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Wrap the FileWriter in a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Append the data to the file
            bufferedWriter.write(writingContent);
            bufferedWriter.newLine(); // Add a new line for clarity

            // Close the BufferedWriter to ensure all data is flushed to the file
            bufferedWriter.close();

            System.out.println("Data has been appended to the file successfully.");
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
            System.out.println("Error saving data user to file.");
        }
    }

    public static void registerInvoice(int invoiceNumber, String studentName, String department, LocalDate issusDate, LocalDate dueDate, String chargesDescription, String chargesAmount, Double totalAmount) {
        // List<String> lines = readLinesFromFile("UserInfo.txt");
        String filePath = "InvoiceInfo.txt";

        // int nextUserId = getNextUserId(lines);

        // String writingContent = nextUserId + "/" + username + "/" + password;
        String writingContent = invoiceNumber + "/" + studentName + "/" + department + "/" + issusDate + "/" + dueDate + "/" + chargesDescription + "/" + chargesAmount + "/" + totalAmount;
        try {
            // Create a FileWriter in append mode by passing true as the second parameter
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Wrap the FileWriter in a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Append the data to the file
            bufferedWriter.write(writingContent);
            bufferedWriter.newLine(); // Add a new line for clarity

            // Close the BufferedWriter to ensure all data is flushed to the file
            bufferedWriter.close();

            System.out.println("Data has been appended to the file successfully.");
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
            System.out.println("Error saving invoice to file.");
        }
    }
}

