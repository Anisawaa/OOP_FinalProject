/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.*;
import javax.swing.*;
import Model.Connector;
import javax.swing.table.DefaultTableModel;
import Controller.Controller;

/**
 *
 * @author Nisa
 */
public class MenuPage {
    public String menu_id, type, name;
    public int price;
    int totalData;
    public String data[][] = new String[500][4];
    
    Controller controller;
    Connector connector = new Connector();
    
    public JFrame window = new JFrame("Menu List");
    public JTable table = new JTable();
    public DefaultTableModel tableModel;
    public JScrollPane scrollPane;
    public Object columnName[] = {"Menu ID", "Type", "Name", "Price"};
    
    public JButton bAdd = new JButton("Add New Menu");

    public MenuPage() {
        tableModel = new DefaultTableModel(columnName, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        window.add(scrollPane);
        window.add(bAdd);
        
        scrollPane.setBounds(20, 35, 500, 300);
        bAdd.setBounds(210, 350, 120, 30);
        
        window.setLayout(null);
        window.setSize(550, 450);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        showData();
    }

    private void showData() {
        data = connector.readData();
        table.setModel((new JTable(data, columnName)).getModel());
    }
}
