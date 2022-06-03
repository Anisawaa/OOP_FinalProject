/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;

/**
 *
 * @author Nisa
 */
public class LoginasAdmin extends JFrame {
    
    public JFrame window = new JFrame ("Login as Admin");
    
    public JLabel lTitle = new JLabel("Welcome to Burger Queen App!");
    
    public JLabel lUsername = new JLabel("Username");
    public JTextField fUsername = new JTextField();
    
    public JLabel lPassword = new JLabel("Password");
    public JPasswordField fPassword = new JPasswordField();
    
    public JButton bLogin = new JButton("Login");
    
    public LoginasAdmin() {
        window.setSize(400,400);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        
        window.add(lTitle);
        window.add(lUsername);
        window.add(fUsername);
        window.add(lPassword);
        window.add(fPassword);
        window.add(bLogin);
        
        lTitle.setBounds(110, 10, 200, 60);
        lUsername.setBounds(165, 85, 150, 30);
        fUsername.setBounds(120, 115, 150, 30);
        lPassword.setBounds(165, 160, 100, 30);
        fPassword.setBounds(120, 190, 150, 30);
        bLogin.setBounds(135, 270, 120, 30);        
    }
    
    public String getUsername() {
        return fUsername.getText();
    }
    
    public String getPassword() {
        return fPassword.getText();
    }
}