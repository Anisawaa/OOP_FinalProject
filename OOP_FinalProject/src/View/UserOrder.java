/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.*;
import javax.swing.*;
import Model.Connector;

/**
 *
 * @author Nisa
 */
public class UserOrder {
    private String menu_id;
    Connector connector = new Connector();
    
    public JFrame window = new JFrame("Order Menu");
   
    public JLabel lTitle = new JLabel("Order Menu");
    public JLabel lName = new JLabel ("Name ");
    public JTextField tfName = new JTextField();
    public JLabel lPhone = new JLabel ("Phone Number ");
    public JTextField tfPhone = new JTextField();
    public JLabel lAddress = new JLabel ("Address ");
    public JTextField tfAddress = new JTextField();
    public JLabel lID = new JLabel("Menu ID ");
    public JTextField tfID = new JTextField();
    public JLabel lAmount = new JLabel("Amount ");
    public JTextField tfAmount = new JTextField();

    public JButton bOrder = new JButton("Order");

    public UserOrder(String menu_id) {
        window.setLayout(null);
        window.setSize(400, 500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(lTitle);
        window.add(lName);
        window.add(tfName);
        window.add(lPhone);
        window.add(tfPhone);
        window.add(lAddress);
        window.add(tfAddress);
        window.add(lID);
        window.add(tfID);
        window.add(lAmount);
        window.add(tfAmount);       
        window.add(bOrder);
        
        tfID.setText(menu_id);
        tfID.setEditable(false);
        
        lTitle.setBounds(160, 15, 200, 60);
        lName.setBounds(180, 80, 120, 20);
        lPhone.setBounds(155, 150,120,20);
        lAddress.setBounds(175, 220, 120, 20);
        lID.setBounds(125, 290, 50, 20);
        lAmount.setBounds(212, 290, 50, 20);

        tfName.setBounds(125, 100, 140, 30);
        tfPhone.setBounds(125, 170, 140, 30);
        tfAddress.setBounds(125, 240, 140, 30);
        tfID.setBounds(125, 310, 50, 30);
        tfAmount.setBounds(212, 310, 50, 30);

        bOrder.setBounds(135, 370, 120, 30);       
    }
    
    public String getName() {
        return tfName.getText();
    }

    public String getPhone() {
        return tfPhone.getText();
    }

    public String getAddress() {
        return tfAddress.getText();
    }
    
    public String getID() {
        return tfID.getText();
    }
    
    public String getAmount() {
        return tfAmount.getText();
    }
}
