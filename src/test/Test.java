/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

/**
 *
 * @author vanh
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int number = 10;

       if (number % 2 == 0) {

           System.out.println(number + " là số chẵn.");

       } else {

           System.out.println(number + " là số lẻ.");

       }
       System.out.println("Hello, World!");

        // Thực hiện phép tính cơ bản
        int a = 10;
        int b = 5;

        // Tính tổng, hiệu, tích, thương
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        double quotient = (double) a / b;

        // In kết quả
        System.out.println("Tổng: " + sum);
        System.out.println("Hiệu: " + difference);
        System.out.println("Tích: " + product);
        System.out.println("Thương: " + quotient);
    
    }
    
}
