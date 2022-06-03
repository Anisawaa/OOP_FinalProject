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
public class Dashboard extends JFrame {
    
    public JFrame window = new JFrame ("Dashboard");
    
    public JLabel lTitle = new JLabel("Welcome to Burger Queen App!");
    
    public JButton bOrder = new JButton("Take an Order");
    public JButton bLogin = new JButton("Login as Admin");
    
    public Dashboard() {
        window.setSize(400,400);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        
        window.add(lTitle);
        window.add(bOrder);
        window.add(bLogin);
        
        lTitle.setBounds(110, 40, 200, 60);
        bOrder.setBounds(135, 150, 120, 30);
        bLogin.setBounds(135, 220, 120, 30);
    }
}