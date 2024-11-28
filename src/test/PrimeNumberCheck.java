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

public class PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập một số nguyên dương: ");
        int number = scanner.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " là số nguyên tố.");
        } else {
            System.out.println(number + " không phải là số nguyên tố.");
        }

        scanner.close();
    }

    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // Số nhỏ hơn hoặc bằng 1 không phải số nguyên tố
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // Nếu n chia hết cho i, không phải số nguyên tố
            }
        }
        return true; // Nếu không chia hết cho số nào từ 2 đến √n, là số nguyên tố
    }
}



