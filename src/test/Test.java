/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author vanh
 */
public class Test {

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
        


        System.out.print("Nhập số thứ nhất: ");
        int number1 = scanner.nextInt(); // Đọc số nguyên thứ nhất

        System.out.println("JJJ");
        System.out.println("JJJ");
        System.out.println("Đỗ Hồng Minh");
        
    }


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
        

           

       }

}

System.out.println("A commit");System.out.println("Lê Tuấn Anh");System.out.println("Nguyễn Thái An");System.out.println("Lần thứ 2");

}

}

}

public class OrderController {

    private final Map<Integer, Order> orders = new HashMap<>();
    private int currentId = 1;

    // Create Order

    // Get Order by ID

    // Update Order

    // Delete Order

    // List All Orders

    // Order class (inner class for simplicity)
    static class Order {
        private int id;
        private String customerName;
        private double totalAmount;

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }
    }}

    private JTable productTable;
    private DefaultTableModel cartModel;
    private JLabel totalLabel;

public SalesApp() {
        setTitle("Giao diện Bán hàng");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tạo bảng sản phẩm
        String[] productColumns = {"ID", "Tên sản phẩm", "Giá"};
        Object[][] productData = {
            {1, "Sản phẩm A", 50000},
            {2, "Sản phẩm B", 75000},
            {3, "Sản phẩm C", 100000}
        };

        JTable productTable = new JTable(productData, productColumns);
        JScrollPane productScrollPane = new JScrollPane(productTable);

        // Tạo bảng giỏ hàng
        String[] cartColumns = {"Tên sản phẩm", "Số lượng", "Giá"};
        cartModel = new DefaultTableModel(cartColumns, 0);
        JTable cartTable = new JTable(cartModel);
        JScrollPane cartScrollPane = new JScrollPane(cartTable);

        // Khu vực tổng tiền
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalLabel = new JLabel("Tổng tiền: 0 VNĐ");
        totalPanel.add(totalLabel);

        // Nút thêm vào giỏ hàng
        JButton addToCartButton = new JButton("Thêm vào giỏ hàng");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    String productName = productTable.getValueAt(selectedRow, 1).toString();
                    int price = Integer.parseInt(productTable.getValueAt(selectedRow, 2).toString());
                    String quantityStr = JOptionPane.showInputDialog("Nhập số lượng:");
                    if (quantityStr != null && !quantityStr.isEmpty()) {
                        try {
                            int quantity = Integer.parseInt(quantityStr);
                            int total = price * quantity;

                            // Thêm sản phẩm vào giỏ hàng
                            cartModel.addRow(new Object[]{productName, quantity, total});
                            updateTotal();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm!");
                }
            }
        });

        // Thêm các thành phần vào giao diện
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.add(productScrollPane);
        centerPanel.add(cartScrollPane);

        add(centerPanel, BorderLayout.CENTER);
        add(addToCartButton, BorderLayout.SOUTH);
        add(totalPanel, BorderLayout.NORTH);
    }

    private void updateTotal() {
        int total = 0;
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            total += Integer.parseInt(cartModel.getValueAt(i, 2).toString());
        }
        totalLabel.setText("Tổng tiền: " + total + " VNĐ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SalesApp app = new SalesApp();
            app.setVisible(true);
        });
    }

    public class SumEvenNumbers {
        public static void main(String[] args) {
            int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            int sum = 0;

            for (int number : numbers) {
                if (number % 2 == 0) {
                    sum += number;
                }
            }

            System.out.println("Tổng các số chẵn trong mảng là: " + sum);
        }
    }

    public class SumEvenNumbers {
        public static void main(String[] args) {
            int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            int sum = 0;

            for (int number : numbers) {
                if (number % 2 == 0) {
                    sum += number;
                }
            }

            System.out.println("Tổng các số chẵn trong mảng là: " + sum);
        }
    }

    class Contact {
        private String name;
        private String phoneNumber;
        private String email;

        public Contact(String name, String phoneNumber, String email) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
        }
    }

    // Lớp ContactManager quản lý danh sách liên hệ
    class ContactManager {
        private ArrayList<Contact> contacts;

        public ContactManager() {
            this.contacts = new ArrayList<>();
        }

        // Thêm liên hệ mới
        public void addContact(Contact contact) {
            contacts.add(contact);
            System.out.println("Liên hệ đã được thêm thành công!");
        }

        // Hiển thị tất cả liên hệ
        public void displayContacts() {
            if (contacts.isEmpty()) {
                System.out.println("Không có liên hệ nào trong danh sách.");
            } else {
                System.out.println("Danh sách liên hệ:");
                for (Contact contact : contacts) {
                    System.out.println(contact);
                }
            }
        }

        // Tìm kiếm liên hệ theo tên
        public void searchContact(String name) {
            boolean found = false;
            for (Contact contact : contacts) {
                if (contact.getName().equalsIgnoreCase(name)) {
                    System.out.println("Liên hệ tìm thấy: " + contact);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy liên hệ với tên: " + name);
            }
        }

        // Xóa liên hệ theo tên
        public void deleteContact(String name) {
            boolean removed = contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
            if (removed) {
                System.out.println("Liên hệ đã được xóa thành công!");
            } else {
                System.out.println("Không tìm thấy liên hệ với tên: " + name);
            }
        }
    }

    // Chương trình chính
public class ContactManagementSystem {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Quản Lý Danh Bạ ---");
            System.out.println("1. Thêm liên hệ");
            System.out.println("2. Hiển thị danh sách liên hệ");
            System.out.println("3. Tìm kiếm liên hệ");
            System.out.println("4. Xóa liên hệ");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();
                    manager.addContact(new Contact(name, phoneNumber, email));
                    break;
                case 2:
                    manager.displayContacts();
                    break;
                case 3:
                    System.out.print("Nhập tên để tìm kiếm: ");
                    String searchName = scanner.nextLine();
                    manager.searchContact(searchName);
                    break;
                case 4:
                    System.out.print("Nhập tên để xóa: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteContact(deleteName);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại!");
            }
        } while (choice != 5);

        scanner.close();
    }
}

public class SumTwoNumbers {
    public static void main(String[] args) {
        // Tạo một đối tượng Scanner để nhận dữ liệu nhập từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập số nguyên thứ nhất
        System.out.print("Nhập số nguyên thứ nhất: ");
        int num1 = scanner.nextInt();

        // Nhập số nguyên thứ hai
        System.out.print("Nhập số nguyên thứ hai: ");
        int num2 = scanner.nextInt();

        // Tính tổng hai số
        int sum = num1 + num2;

        // Hiển thị kết quả
        System.out.println("Tổng của " + num1 + " và " + num2 + " là: " + sum);

        // Đóng scanner
        scanner.close();
    }
}