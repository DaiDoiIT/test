/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.Scanner;


/**
 *
 * @author vanh
 */
public class Test {
    private String id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Positive(message = "Age must be a positive number")
    private int age;

    // Constructors, Getters, and Setters
    public User() {}

    public User(String id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {


        ArrayList<String> tasks = new ArrayList<>();

        // Tạo JFrame
        JFrame frame = new JFrame("Giao diện đơn giản");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout()); // Sử dụng FlowLayout

        // Tạo một JTextField
        JTextField textField = new JTextField(20);

        // Tạo một JButton
        JButton button = new JButton("Nhấn vào đây");

        // Tạo JLabel để hiển thị kết quả
        JLabel label = new JLabel("Kết quả sẽ hiển thị ở đây");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add a Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove a Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter a new task: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Task added!");
                    break;
                case 2:
                    System.out.println("\nYour Tasks:");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet!");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nYour Tasks:");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove!");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                        System.out.print("Enter the task number to remove: ");
                        int taskNumber = scanner.nextInt();
                        if (taskNumber > 0 && taskNumber <= tasks.size()) {
                            tasks.remove(taskNumber - 1);
                            System.out.println("Task removed!");
                        } else {
                            System.out.println("Invalid task number!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();



        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);


        System.out.print("Nhập số thứ nhất: ");
        int number1 = scanner.nextInt(); // Đọc số nguyên thứ nhất

        System.out.println("JJJ");
        System.out.println("JJJ");
        System.out.println("Đỗ Hồng Minh");
        

        int a = 10;
        int b = 5;


        // Thêm ActionListener cho JButton
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy văn bản từ JTextField và hiển thị trên JLabel
                String inputText = textField.getText();
                label.setText("Bạn đã nhập: " + inputText);
            }
        });

        // Thêm các thành phần vào JFrame
        frame.add(new JLabel("Nhập nội dung:"));
        frame.add(textField);
        frame.add(button);
        frame.add(label);


        // In kết quả
        System.out.println("Tổng: " + sum);
        System.out.println("Hiệu: " + difference);
        System.out.println("Tích: " + product);
        System.out.println("Thương: " + quotient);
        if (number % 2 == 0) {
            System.out.println(number + " là số chẵn.");
        }
        else {
        // Hiển thị JFrame
        frame.setVisible(true);


        System.out.print("Nhập số thứ hai: ");
        int number2 = scanner.nextInt(); // Đọc số nguyên thứ hai

        // Tính tổng hai số
        int sum = number1 + number2;

        // Hiển thị kết quả
        System.out.println("Tổng của " + number1 + " và " + number2 + " là: " + sum);


        // Đóng Scanner để tránh rò rỉ tài nguyên
        scanner.close();
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
        System.out.println(a + "là một số");
        System.out.println("A commit");
        System.out.println("Phép toán: 1 + 1 = 2");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < args.length; j++) {
                System.out.println(j);
            }
        }
        System.out.println("An");
        
    }

    

