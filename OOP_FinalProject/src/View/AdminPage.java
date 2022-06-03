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
public class AdminPage extends JFrame {
    public JFrame window = new JFrame ("Admin Page");
    
    public JLabel lTitle = new JLabel("Administrator Page");
    
    public JButton bMenu = new JButton("Menu List");
    public JButton bQueue = new JButton("Queue List");
    
    public AdminPage() {
        window.setSize(400,400);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        
        window.add(lTitle);
        window.add(bMenu);
        window.add(bQueue);
        
        lTitle.setBounds(140, 30, 200, 60);
        bMenu.setBounds(135, 110, 120, 30);
        bQueue.setBounds(135, 180, 120, 30);
    }
}
