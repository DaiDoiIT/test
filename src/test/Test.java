/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author vanh
 */
public class Test {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        System.out.println("JJJ");
        System.out.println("This is a commit");
        System.out.println("Hey");
        System.out.println("New clone");
        System.out.println("\nSố chẵn:");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("\nSố lẻ:");
        for (int j = 0; j < 10; j++) {
            if (j % 2 != 0) {
                System.out.println(j);
            }
        }
        System.out.println("Wednesday commit");
        ArrayList<NewFile> list = new ArrayList<>();
        list.add(new NewFile("01", 02, "Name"));
        list.add(new NewFile("02", 10, "Ten"));
        System.out.println(list);
    }
    
}