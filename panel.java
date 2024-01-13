package Invoice;


import javax.swing.*;

import User.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panel extends JPanel implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;

    // Callback interface for login success
    public interface LoginCallback {
        void onLoginSuccess(String username);
    }

    private LoginCallback loginCallback;

    public panel(LoginCallback loginCallback) {
        this.loginCallback = loginCallback;

        // Initialize GUI components and add them to the panel
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Empty label as a placeholder
        add(loginButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Assuming you have a method in your Login class to verify the login
        if (Login.verifyLogin(username, password)) {
            // Notify the main console application about the successful login
            loginCallback.onLoginSuccess(username);
        } else {
            JOptionPane.showMessageDialog(this, "Login failed. Please check your username and password.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login");
            panel loginPanel = new panel(username -> {
                // This is the callback method for successful login
                System.out.println("Login successful! Welcome, " + username);
                // Implement further logic here
            });
            frame.add(loginPanel);
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
