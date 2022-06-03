/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.awt.event.*;
import View.*;
import javax.swing.*;
import Model.Connector;


/**
 *
 * @author Nisa
 */
public class Controller extends JFrame {
    Dashboard dashboard;
    LoginasAdmin loginasAdmin;
    UserPage userPage;
    AdminPage adminPage;
    MenuPage menuPage;
    MenuAdd menuAdd;
    QueuePage queuePage;
    FoodUpdate foodUpdate;
    UserOrder userOrder;
    
    Connector connector;
    
    public Controller (Connector connector) {
        this.connector = connector;
        
        Dashboard dashboard = new Dashboard();
        
        dashboard.bLogin.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LoginasAdmin loginasAdmin = new LoginasAdmin();
                
                loginasAdmin.bLogin.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        String username = loginasAdmin.getUsername();
                        String password = loginasAdmin.getPassword();

                        if (username.equals("admin") && password.equals("admin")) {
                            AdminPage adminPage = new AdminPage();
                            loginasAdmin.window.dispose();
                            
                            adminPage.bMenu.addActionListener(new ActionListener() {           
                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    MenuPage menuPage = new MenuPage();
                                    
                                    menuPage.table.addMouseListener(new MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            super.mouseClicked(e);
                                            int row = menuPage.table.getSelectedRow();
                                            int col = menuPage.table.getSelectedColumn();

                                            String menu_name = menuPage.table.getValueAt(row, 2).toString();
                                            System.out.println("data : " + menu_name);
                                            
                                            Object[] options = {"Update", "Delete"};
                                            int selection = JOptionPane.showOptionDialog(null, "            What do you want to do?", "Option", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                                            
                                            if (selection == 0) {
                                                String menu_id = menuPage.table.getValueAt(row, 0).toString();
                                                FoodUpdate foodUpdate = new FoodUpdate(menu_id);
                                                
                                                foodUpdate.bUpdate.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        String menu_type = foodUpdate.getType();
                                                        String menu_name = foodUpdate.getName();
                                                        String price = foodUpdate.getPrice();
                                                        connector.updateData(menu_id, menu_type, menu_name, price);
                                                        
                                                        foodUpdate.window.dispose();
                                                        menuPage.window.dispose();
                                                    }
                                                });
                                            }
                                            
                                            else if (selection == 1) {
                                                int option1 = JOptionPane.showConfirmDialog(null, "Are tou sure?", "Option", JOptionPane.YES_NO_OPTION);
                                                
                                                if (option1 == 0) {   
                                                    connector.deleteData(menu_name);
                                                    menuPage.window.dispose();
                                                }
                                            }
                                        }  
                                    });
                                    
                                    menuPage.bAdd.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            MenuAdd menuAdd = new MenuAdd();

                                            menuAdd.bAdd.addActionListener(new ActionListener() {           
                                                @Override
                                                public void actionPerformed(ActionEvent arg0) {
                                                    String menu_type = menuAdd.getType();
                                                    String menu_name = menuAdd.getName();
                                                    String price = menuAdd.getPrice();
                                                    connector.insertData(menu_type, menu_name, price);
                                                    
                                                    menuAdd.window.dispose();
                                                    menuPage.window.dispose();
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                            
                            adminPage.bQueue.addActionListener(new ActionListener() {           
                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    QueuePage queuePage = new QueuePage();
                                    
                                    queuePage.table.addMouseListener(new MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            super.mouseClicked(e);
                                            int row = queuePage.table.getSelectedRow();
                                            int col = queuePage.table.getSelectedColumn();

                                            String order_id = queuePage.table.getValueAt(row, 0).toString();
                                            System.out.println("Order ID : " + order_id);
                                            int option2 = JOptionPane.showConfirmDialog(null, "Do you want to delete it?", "Option", JOptionPane.YES_NO_OPTION);

                                            if (option2 == 0) {
                                                connector.deleteQueue(order_id);
                                                queuePage.window.dispose();
                                            }
                                        }  
                                    });
                                }
                            });

                        }

                        else {
                            JOptionPane.showMessageDialog(null, "Invalid username or password");
                        }
                    }
                });
            }
        });
        
        dashboard.bOrder.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent arg0) {
                UserPage userPage = new UserPage();
                
                userPage.table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        int row = userPage.table.getSelectedRow();
                        int col = userPage.table.getSelectedColumn();

                        String menu_id = userPage.table.getValueAt(row, 0).toString();
                        System.out.println("Menu ID : " + menu_id);
                        String price = userPage.table.getValueAt(row, 3).toString();
                        
                        UserOrder userOrder = new UserOrder(menu_id);
                        
                        userOrder.bOrder.addActionListener(new ActionListener() {           
                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                String name = userOrder.getName();
                                String phone = userOrder.getPhone();
                                String address = userOrder.getAddress();
                                String menu_id = userOrder.getID();
                                String amount = userOrder.getAmount();
                                        
                                connector.insertQueue(name, phone, address, menu_id, amount, price);
                                userOrder.window.dispose();
                                userPage.window.dispose();
                            }
                        });
                    }  
                });
            }
        });
    }
}
