package Invoice;

import java.time.LocalDate;
import java.util.Arrays;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Invoice {
    private String studentName;
    private String studentID;
    private String programDetails;
    private int invoiceNumber;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private static double totalAmount;
    private static String[] chargesDescription;
    private static double[] chargesAmount;

    // Constructors, getters, and setters...

    // Constructors
    public Invoice(int invoiceNumber, String programDetails, String studentName, LocalDate invoiceDate, LocalDate dueDate, String description, String chargePrice, double totalAmount) {
        this.studentName = studentName;
        this.programDetails = programDetails;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
    }

    // Method to set charges
      public static void setCharges(String[] chargesDescription, double[] chargesAmount) {
        Invoice.chargesDescription = chargesDescription;
        Invoice.chargesAmount = chargesAmount;
        calculateTotalAmount();
    }

    // Method to calculate total amount
    private static void calculateTotalAmount() {
        Invoice.totalAmount = 0;
        for (double amount : chargesAmount) {
            totalAmount += amount;
        }
    }
    
    // Getters for private fields
    public String getStudentName() {
        return studentName;
    }

    public String getProgramDetails() {
        return programDetails;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public static double getTotalAmount() {
        return totalAmount;
    }

    public static String[] getChargesDescription() {
        return chargesDescription;
    }

    public static double[] getChargesAmount() {
        return chargesAmount;
    }

    public String toString() {
        return "StudentInvoice{" +
                "studentName='" + studentName + '\'' +
                ", studentID='" + studentID + '\'' +
                ", programDetails='" + programDetails + '\'' +
                ", invoiceNumber=" + invoiceNumber +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                ", totalAmount=" + totalAmount +
                ", chargesDescription=" + Arrays.toString(chargesDescription) +
                ", chargesAmount=" + Arrays.toString(chargesAmount) +
                '}';
    }

    public static ArrayList<Invoice> invoiceList = new ArrayList<>();

    public static void viewInvoice() {
        String filePath = "InvoiceInfo.txt";

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Process the line as needed
                // System.out.println(line);
                String[] parts = line.split("/");

                Invoice invoice = new Invoice(Integer.parseInt(parts[0]), parts[1], parts[2], LocalDate.parse(parts[3]), LocalDate.parse(parts[4]), parts[5], parts[6], Double.parseDouble(parts[7]));
                invoiceList.add(invoice);
                System.out.println(line);
            }

            bufferedReader.close();            
        } catch (IOException e) //Exceptions are unexpected events or errors that can occur during the execution of a program. 
         {
            e.printStackTrace();
        }
    }


    public static void viewInvoiceIndividual(String Username) {
        String filePath = "InvoiceInfo.txt";
    
        boolean found = false;
        System.out.println("-----------------------");
    
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
    
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("/");
                   // Casting used here
                new Invoice(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        LocalDate.parse(parts[3]),
                        LocalDate.parse(parts[4]),
                        parts[5],
                        parts[6],
                        Double.parseDouble(parts[7])
                );
    
                if (parts[1].equals(Username)) {
                    System.out.println(line);
                    found = true;
                }
            }
    
            if (!found) {
                System.out.println("Record not found.");
            }
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        System.out.println("-------------------------");
    } 
}

