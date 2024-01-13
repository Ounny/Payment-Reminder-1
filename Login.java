package User;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {
    // --------------------------------------------------------------------------------
    static ArrayList<User> userList = new ArrayList<User>(); 
    static ArrayList<Admin> adminList = new ArrayList<Admin>();


// --------------------------------------------------------------------------------    
public static void getUserList() {
    String filePath = "UserInfo.txt";

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
        


    public static void getAdminList()
    {
        String filePath = "AdminInfo.txt";
        
        try {
            // Create a FileReader
            FileReader fileReader = new FileReader(filePath);
            // Wrap the FileReader in a BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Read each line from the file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Process the line as needed
                //System.out.println(line);
                String[] parts = line.split("/");
                Admin tmp = new Admin(parts[0], parts[1]);
                adminList.add(tmp);
            }
    
            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be read
            e.printStackTrace();
        }
    }
 // --------------------------------------------------------------------------------   
    public static boolean verifyUserName(String username)
    {
        getUserList();        
        
        boolean exist = false;
        for(User i : userList)
        {
            // System.out.println(i.getName());
            if(i.getUsername().equals(username))
            {
                exist = true;
            }
          
        }

        if(exist==true)
        {
            System.out.println("User exist please pick different name");
            return true;
        }
        
        return false;
    }

    public static boolean verifyAdminName(String username)
    {
        getAdminList();        
    
        boolean exist = false;
        for(Admin i : adminList)
        {
            // System.out.println(i.getName());
            if(i.getUsername().equals(username))
            {
                exist = true;
            }
          
        }
    
        if(exist==true)
        {
            System.out.println("User exist please pick different name");
            return true;
        }
    
        return false;
    }
// --------------------------------------------------------------------------------
    public static boolean loginUsername(String username)
    {
        getUserList();

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return false; // User exists
            }
        }
        
        System.out.println("Sorry, User doesn't exist.");
        return true; // User doesn't exist
    }

    public static boolean loginAdminname(String username)
    {
        getAdminList();
    
        for (Admin admin : adminList) {
            if (admin.getUsername().equals(username)) {
                return false; // User exists
            }
        }
    
        System.out.println("Sorry, User admin doesn't exist.");
        return true; // User doesn't exist
    }
// --------------------------------------------------------------------------------
    public static boolean loginPassword(String password)
    {
        getUserList();

        for (User user : userList) {
            if (user.getPassword().equals(password)) {
                return false; // Password correct
            }
        }
        
        System.out.println("Sorry, Incorrect password.");
        return true; // Password not correct
    }

    public static boolean loginAdminPassword(String password)
    {
        getAdminList();
    
        for (Admin admin : adminList) {
            if (admin.getPassword().equals(password)) {
                return false; // Password correct
            }
        }
    
        System.out.println("Sorry, Incorrect password.");
        return true; // Password not correct
    }
// --------------------------------------------------------------------------------
    public static boolean loginUser(User tmpUser) {
        getUserList();

        for (User user : userList) {
            if (user.getUsername().equals(tmpUser.getUsername()) && user.getPassword().equals(tmpUser.getPassword())) {
                System.out.println("Login successful! Welcome, " + user.getUsername());
                if (user instanceof Student) {
                    // Check if the object is a Student and directly cast
                    Testing.Test.studentFlow();
                Testing.Test.studentFlow();
                return false; // Credentials matched
            }
        }
        return false;
    }
        return false;
}

    public static void loginAdmin(User tmpUser) {
        getAdminList();

        for (Admin admin : adminList) {
            if (admin.getUsername().equals(tmpUser.getUsername()) && admin.getPassword().equals(tmpUser.getPassword())) {
                System.out.println("Login successful! Welcome, " + admin.getUsername());
                Testing.Test.adminFlow();
                return; // Credentials matched
            }
        }
    }


    public static boolean loginUser(String username, String password) {
        return false;
    }


    public static boolean isUserStudent(String username) {
        return false;
    }


    public static boolean isUserAdmin(String username) {
        return false;
    }


    public static boolean verifyLogin(String username, String password) {
        return false;
    }

// --------------------------------------------------------------------------------
}