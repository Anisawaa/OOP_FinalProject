/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oop_finalproject;

import View.*;
import Model.*;
import Controller.*;

/**
 *
 * @author Nisa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connector connector = new Connector();
        Controller controller = new Controller(connector);
    }
    
}
