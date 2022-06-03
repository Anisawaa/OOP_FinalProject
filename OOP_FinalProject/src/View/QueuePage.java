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
public class QueuePage {
    public String menu_id, type, name;
    public int price;
    int totalQueue;
    public String queue[][] = new String[500][7];
    
    Controller controller;
    Connector connector = new Connector();
    
    public JFrame window = new JFrame("Queue List");
    public JTable table = new JTable();
    public DefaultTableModel tableModel;
    public JScrollPane scrollPane;
    public Object columnName[] = {"Queue ID", "Name", "Phone Number", "Address", "Menu ID", "Amount", "Price"};

    public QueuePage() {
        tableModel = new DefaultTableModel(columnName, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        window.add(scrollPane);
        
        scrollPane.setBounds(20, 35, 500, 300);
        
        window.setLayout(null);
        window.setSize(550, 450);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        showData();
    }

    private void showData() {
        queue = connector.readQueue();
        table.setModel((new JTable(queue, columnName)).getModel());
    }
}
