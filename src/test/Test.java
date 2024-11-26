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
        System.out.println("Hello, World!");

        // Tạo một đối tượng Scanner để nhập dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập số thứ nhất
        System.out.print("Nhập số thứ nhất: ");
        int num1 = scanner.nextInt();

        // Nhập số thứ hai
        System.out.print("Nhập số thứ hai: ");
        int num2 = scanner.nextInt();

        // Tính tổng
        int sum = num1 + num2;

        // In kết quả
        System.out.println("Tổng của hai số là: " + sum);

        // Đóng Scanner
        scanner.close();

    }

}
