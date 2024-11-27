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
        // TODO code application logic here
       Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        int number1 = scanner.nextInt(); // Đọc số nguyên thứ nhất

        System.out.print("Nhập số thứ hai: ");
        int number2 = scanner.nextInt(); // Đọc số nguyên thứ hai

        // Tính tổng hai số
        int sum = number1 + number2;

        // Hiển thị kết quả
        System.out.println("Tổng của " + number1 + " và " + number2 + " là: " + sum);

        // Đóng Scanner để tránh rò rỉ tài nguyên
        scanner.close();
    }
        
    }


