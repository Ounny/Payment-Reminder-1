package User;

import java.util.Objects;
import java.util.Scanner;

public class Student extends User implements ChangeMajorOperation {
    private Character gender;
    private String dateOfBirth;
    private String contactNumber;
    private String address;
    private String email;
    private String major;

    public Student(String username, Character gender, String dateOfBirth, String contactNumber, String address, String email, String password, String major) {
        super(username, password);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.address = address;
        this.email = email;
        this.major = major;
    }
   //
    public Student(String username, String password){
        super(username, password);
    }
    // Getter methods
    public Character getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }

    // Setter methods
    public void setGender(Character gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public void changePassword() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter current password: ");
            String currentPassword = scanner.nextLine();
    
            // Check if the current password matches
            if (currentPassword.equals(getPassword())) {
                System.out.println("Please ask an admin to set up a new password for student " + getUsername());
            } else {
                System.out.println("Incorrect current password. Password not changed.");
            }
        }
    }
@Override
    public String toString() {
        String s = "Student is created \n"
                + super.toString()  // Call toString from the User class
                + "\nGender: " + this.gender
                + "\nDate of Birth: " + this.dateOfBirth
                + "\nContact number: " + this.contactNumber
                + "\nAddress: " + this.address
                + "\nEmail: " + this.email
                + "\nMajor: " + this.major;

        return s;
    }

    @Override
    public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;  // Check equality in the User class
    if (!(obj instanceof Student)) return false;

    Student tmpStudent = (Student) obj;

    // Compare additional properties specific to Student
    return Objects.equals(this.dateOfBirth, tmpStudent.dateOfBirth) &&
           Objects.equals(this.username, tmpStudent.username);
    }



    @Override
    public String getUserType() {
        return "Student";
    }
    
    @Override
    public void changeMajor(Student student, String newMajor) {
        System.out.println("Changing major for student " + student.getUsername() + " to " + newMajor);
        student.setMajor(newMajor);
        System.out.println("Major changed successfully.");
    }
    public static void displayStudentPanel() {
    }
    public void setPassword(String newPassword) {
    }



}






