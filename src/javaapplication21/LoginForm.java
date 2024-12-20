package javaapplication21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginForm extends JFrame {
    private JTextField useridField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        setLookAndFeel();

      
        useridField = new JTextField(20);
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

      
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.WEST;

       
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("UserId:"), gbc);

        gbc.gridx = 1;
        panel.add(useridField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

      
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER; 
        panel.add(loginButton, gbc);

        add(panel);

    
        getContentPane().setBackground(new Color(173, 216, 230)); 

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_id = useridField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

               
                if (checkLogin(user_id, username, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    dispose(); 
                    new ActivitySelectionForm(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
                }
            }
        });
    }


    private boolean checkLogin(String user_id, String username, String password) {
     
        SecureDatabaseAccess proxy = new DatabaseProxy();
        if (proxy.getDatabaseConnection() == null) {
            return false; 
        }

        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Users WHERE user_id = ? AND username = ? AND password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(user_id));  
            statement.setString(2, username); 
            statement.setString(3, password); 
            ResultSet resultSet = statement.executeQuery();
            
            return resultSet.next(); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false; 
    }


    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}
