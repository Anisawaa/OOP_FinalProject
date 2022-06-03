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
public class FoodUpdate {
    private String menu_id;
    Connector connector = new Connector();
    
    public JFrame window = new JFrame("Update Menu");
   
    public JLabel lTitle = new JLabel("Update Menu");
    public JLabel lID = new JLabel("Menu ID");
    public JTextField tfID = new JTextField();
    public JLabel lType = new JLabel ("Type ");
    String[] Type = {"Foods", "Drinks", "Dessert", "Snack"};
    JComboBox cType = new JComboBox(Type);
    public JLabel lName = new JLabel ("Name ");
    public JTextField tfName = new JTextField();
    public JLabel lPrice = new JLabel("Price ");
    public JTextField tfPrice = new JTextField();

    public JButton bUpdate = new JButton("Update");

    public FoodUpdate(String menu_id) {
        this.menu_id = menu_id;
        
        window.setLayout(null);
        window.setSize(400,400);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(lTitle);
        window.add(lType);
        window.add(cType);
        window.add(lName);
        window.add(tfName);
        window.add(lPrice);
        window.add(tfPrice);
        window.add(bUpdate);
        
        tfID.setText(menu_id);
        tfID.setEditable(false);

        
        lTitle.setBounds(155, 15, 200, 60);
        lType.setBounds(180, 80, 120, 20);
        lName.setBounds(180, 150,120,20);
        lPrice.setBounds(180,220,120,20);

        cType.setBounds(125, 100, 140, 30);
        tfName.setBounds(125, 170, 140, 30);
        tfPrice.setBounds(125, 240, 140, 30);

        bUpdate.setBounds(135, 300, 120, 30);       
    }
    
    public String getType() {
        return cType.getSelectedItem().toString();
    }

    public String getName() {
        return tfName.getText();
    }

    public String getPrice() {
        return tfPrice.getText();
    }
}
