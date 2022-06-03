/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Nisa
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost/food_delivery";
    String DBusername = "root";
    String DBpassword = "";
    
    Connection conn;
    Statement statement;
    String data[][] = new String[500][4];
    String queue[][] = new String[500][7];
    
    public Connector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Conenction Success");
        }
        
        catch (Exception ex) {
            System.out.println("Connection Failed" + ex.getMessage());
        }
    }
    
    public String[][] readData() {
        try {
            int totalData = 0;
            String query = "SELECT * FROM menu";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
                data[totalData][0] = resultSet.getString("menu_id");
                data[totalData][1] = resultSet.getString("type");
                data[totalData][2] = resultSet.getString("name");
                data[totalData][3] = resultSet.getString("price");
                totalData++;
            }
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        finally {
            return data;
        }
    }
    
    public String[][] readQueue() {
        try {
            int totalQueue = 0;
            String query = "SELECT * FROM orders";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
                queue[totalQueue][0] = resultSet.getString("order_id");
                queue[totalQueue][1] = resultSet.getString("name");
                queue[totalQueue][2] = resultSet.getString("phone_number");
                queue[totalQueue][3] = resultSet.getString("address");
                queue[totalQueue][4] = resultSet.getString("menu_id");
                queue[totalQueue][5] = resultSet.getString("amount");
                queue[totalQueue][6] = resultSet.getString("price");
                totalQueue++;
            }
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        finally {
            return queue;
        }
    }
    
    public void insertData(String menu_type, String menu_name, String menu_price) {
        try {
            int price = Integer.parseInt(menu_price);
            
            String query =  "INSERT INTO `menu` (`type`, `name`, `price`) VALUES ('"+menu_type+"','"+menu_name+"','"+price+"')";
                    
            statement = conn.createStatement();
            statement. executeUpdate(query);
                   
            System.out.println("Input Success");
            JOptionPane.showMessageDialog(null, "Input Success");
        }
                
        catch (Exception ex) {
        System.out.println("Input Failed");
        }
    }
    
    
    public void updateData(String id, String menu_type, String menu_name, String menu_price){
        try {
            int price = Integer.parseInt(menu_price);
            int menu_id = Integer.parseInt(id);
            
            String query = "UPDATE `menu` SET type = '" + menu_type + "', name = '" + menu_name + "', price = '" + menu_price + "' WHERE menu_id = '" + menu_id + "'";
            statement = conn.createStatement();
            statement.executeUpdate(query);

            System.out.println("Update Success");
            JOptionPane.showMessageDialog(null, "Update Success");
        }
        catch (Exception ex) {
            System.out.println("Update Failed : " + ex.getMessage());
        }
    }
    
    public void deleteData(String menu_name) {
        try {
            String query = "DELETE FROM `menu` WHERE name ='" + menu_name + "'";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete Successes");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
    }
    
    public void insertQueue(String name, String phone_number, String address, String menu_id, String order_amount, String order_price) {
        try {
            int amount = Integer.parseInt(order_amount);
            int price = Integer.parseInt(order_price);
            int total_price = amount * price;
            
            String query =  "INSERT INTO `orders` (`name`, `phone_number`, `address`, `menu_id`, `amount`, `price`) VALUES ('"+name+"','"+phone_number+"','"+address+"','"+menu_id+"','"+order_amount+"','"+total_price+"')";
            String query2 =  "INSERT INTO `history` (`name`, `phone_number`, `address`, `menu_id`, `amount`, `price`) VALUES ('"+name+"','"+phone_number+"','"+address+"','"+menu_id+"','"+order_amount+"','"+total_price+"')";
            
            statement = conn.createStatement();
            statement. executeUpdate(query);
                   
            System.out.println("Input Success");
            JOptionPane.showMessageDialog(null, "Input Success");
        }
                
        catch (Exception ex) {
        System.out.println("Input Failed");
        }
    }
    
    public void deleteQueue(String order_id) {
        try {
            
            String query = "DELETE FROM `orders` WHERE order_id ='" + order_id + "'";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete Successes");
        }
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
    }
}
