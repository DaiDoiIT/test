/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.util.Scanner;

/**
 *
 * @author vanh
 */
public class Test {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = factorial(number);
            System.out.println("The factorial of " + number + " is: " + result);
        }

        scanner.close();

        // TODO code application logic here

        System.out.println("JJJ");
        System.out.println("JJJ");
        System.out.println("Đỗ Hồng Minh");
        
    }


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

           System.out.println(number + " là số chẵn.");

        else {
           System.out.println(number + " là số lẻ.");
       }

        System.out.println("JJJ");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        System.out.println("A commit");
        System.out.println("Lê Tuấn Anh");
        System.out.println("Nguyễn Thái An");
        System.out.println("Lần thứ 2");
        int a = 4;
        System.out.println(a + "là một số");

        
    }