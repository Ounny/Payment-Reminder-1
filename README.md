# Payment-Reminder-1
School Payment Reminder System
Introduction
The School Payment Reminder System simplifies payment management for university administrators. It maintains student records, tracks payment information (invoices), and generates automated reminders to notify students about pending fees. This project embraces key Object-Oriented Programming (OOP) concepts to provide a robust and adaptable structure.

** Class and object
- Register : For new user to register in to the system
- Login : For user that have account for login to the system
- User : to identify the user who are student or admin.
- Student : Identify as a student and can access a specific method as student
- Admin : Identify as a admin and can access a specific method as admin
- Invoice : For access the invoice information
- Panel : For create a frame for admin to login
- Test : For run the out put of the whole system.

** Process
- Register/Login : First if student don't have account they have to register to create account. When they have account they can login to our system to use it.
- Student : Once user login as a student, they can view the notification, view the invoice of thier payment and can view their payment history.
- Admin : Once user login  as a admin, they can view all student invoice and can update all of it and also they can register invoice for a student.

**Object-Oriented Programming Concepts
1. Inheritance
*The User class serves as the Super class for Student and Admin classes, allowing them to inherit common features such as username and password.
1.1 Override
*Method overriding occurs when a subclass provides a specific implementation for a method that is already defined in its superclass. We write override method from user class that is changePassword() is overridden in the Student and Admin classes. The Student class provides a specific implementation for changing the student's password, and the Admin class does the same for an admin.
    In student class:
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
    In admin class:
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
1.2 Overloading Method
*Method overloading occurs when a class has multiple methods with the same name but different parameter lists (different number or types of parameters). We use in student class.
    public Student(String username, String password){
        super(username, password);
    }

2. Encapsulation
2.1 Public Access Modifier:
*Public  can access with other class. We create these two method as a public class because other class have to use it to access the information   like username and password.
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
2.2 Private Access Modifier:
* Private can access with the same class and can not access to  other classes. We create those field as a private because we want specific value to the student class and other class can not acces with these field.
    private Character gender;
    private String dateOfBirth;
    private String contactNumber;
    private String address;
    private String email;
    private String major;
2.3 Protected Access Modifier
*Protect can access in the same package. We use it in user class that the password field is marked as protected, allowing subclasses like Student and admin to access it directly.
   protected String password;
2.4  Default (Package-Private) Access Modifier:
* We use in the User class. The constructor and methods without any access modifier are using the default access, limiting access to classes within the same package.
3. Polymorphism
3.1 Casting
*Our system cast the user to student so it access the method of student
User user = new Student(tmpUsername, tmpPassword);
    if (user instanceof Student) {
    Student student = (Student) user;
    userList.add(student); 
    }
userList.add(user);
3.2 Method equal
*The equals method is used to compare the equality of two objects. We use equal method in Student class to compare the date of birth of student.
public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;  // Check equality in the User class
    if (!(obj instanceof Student)) return false;

    Student tmpStudent = (Student) obj;

    // Compare additional properties specific to Student
    return Objects.equals(this.dateOfBirth, tmpStudent.dateOfBirth) &&
           Objects.equals(this.username, tmpStudent.username);
    }
3.3 Method to string
*The toString method is a method provided by the Object class, and it is meant to return a string representation of an object. We use in student class this method overrides the toString() method in the User class, providing a custom string representation that includes specific information about a student.
    
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

4. Abstraction
**An abstract class is a class that cannot be instantiated on its own and is typically used as a base class for other classes. In user class we use abtract classs and abtract metthod call  getUserType.Abstract methods like getUserType() provide a blueprint for subclasses, ensuring a standardized structure across different user types.The purpose is to let subclasses specify the type of user they represen
    abstract class User
    public abstract String getUserType(); 

5. Interfaces
*An interface is a collection of abstract methods (methods without a body) and constants. We create interfaces (ChangeMajorOperation) define specific operations. So, ChangeMajorOperation is implemented in the Student class, allowing the change of a student's major.
    
    public interface ChangeMajorOperation {
    void changeMajor(Student student, String newMajor);
}

6. Anonymous Class
*Anonymous classes are used when creating instances of classes with unique implementations . We create the new instance user that is teacher if teacher want use our system the use during registration to create a custom user instance.
     User teacher = new User(tmpUsername, tmpPassword) {
                @Override
                public String getUserType() {
                    return "teacher";
                }
            };
    
            System.out.println(teacher);
        } 
7. Exception Handling
*Exception handling  is a mechanism that allows to handle runtime errors, also known as exceptions, in a controlled and graceful manner. The system handles various wrong inputs using exception handling. We use in the user login process, incorrect inputs (like invalid usernames or passwords) are managed to prevent system crashes and provide user-friendly error messages
    try {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split("/");

            // Ensure that the line has enough parts
            if (parts.length >= 2) {
                String tmpUsername = parts[0];
                String tmpPassword = parts[1];

                // Create a User object
                User user = new Student(tmpUsername, tmpPassword);
            // cast to Student and add to a specific list:
                if (user instanceof Student) {
                    Student student = (Student) user;
                    userList.add(student); 
                }

                // Add the User to the general userList
                userList.add(user);
            } else {
                System.out.println("Invalid data format in UserInfo.txt: " + line);
            }
        }

        bufferedReader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

8. File I/O Operations
Storage of Information
User, Admin, and Invoice Info Files:
Three separate files are used to store distinct types of information:
-User Info File: Stores authentication-related data for users.
-Admin Info File: Contains specific information related to administrators.
-Invoice Info File: Stores details regarding invoices, including payment-related information.
9. Static methods
*A static method is a method that belongs to a class rather than an instance of the class. Use static method in the User class dispay menu for student to choose the option. That can not change the information and in invoice class we Reads invoice information from a file, processes it, and prints each line.
    public static void displayUserMenu() {
        System.out.println("User Menu:");
        System.out.println("1. View Notifications");
        System.out.println("2. View my Invoices");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }
10.Lamda expresstion
*A lambda expression  is a concise way to represent an anonymous function (a function without a name). So we use lamda expression the test class for print to change the new major for student.
     ChangeMajorOperation changeMajor = (student, newMajor) -> student.changeMajor(student, newMajor);

+Project Structure
-User Package
User Class: Base class with common properties (username and password). Implements methods like toString() and equals().
Student Class: Subclass of User representing a student. Implements the ChangeMajorOperation interface and provides additional properties such as gender and major.
-Invoice Package
Invoice Class: Manages invoice details, including charges. Provides methods for setting charges, calculating total amounts, and viewing invoices.

Conclusion
By incorporating OOP principles, this project achieves a modular, extensible, and maintainable design. Inheritance, encapsulation, polymorphism, abstraction, interfaces, and anonymous classes contribute to the effectiveness of the School Payment Reminder System.




