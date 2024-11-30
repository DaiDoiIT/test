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


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import javax.swing.table.DefaultTableModel;

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
public class SalesSystemGUI {
    private JFrame frame;
    private JTable productTable;
    private JTable cartTable;
    private JLabel totalLabel;
    private DefaultTableModel cartModel;
    private double totalAmount = 0;

    public SalesSystemGUI() {
        // Tạo frame chính
        frame = new JFrame("Hệ Thống Bán Hàng");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Panel sản phẩm
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createTitledBorder("Danh Sách Sản Phẩm"));

        String[] productColumns = {"ID", "Tên Sản Phẩm", "Giá"};
        Object[][] productData = {
                {"1", "Sản phẩm A", 100000},
                {"2", "Sản phẩm B", 200000},
                {"3", "Sản phẩm C", 300000},
                {"4", "Sản phẩm D", 150000}
        };

        DefaultTableModel productModel = new DefaultTableModel(productData, productColumns);
        productTable = new JTable(productModel);
        productPanel.add(new JScrollPane(productTable), BorderLayout.CENTER);

        JButton addToCartButton = new JButton("Thêm vào giỏ hàng");
        productPanel.add(addToCartButton, BorderLayout.SOUTH);

        // Panel giỏ hàng
        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.setBorder(BorderFactory.createTitledBorder("Giỏ Hàng"));

        String[] cartColumns = {"Tên Sản Phẩm", "Giá", "Số Lượng", "Tổng Cộng"};
        cartModel = new DefaultTableModel(null, cartColumns);
        cartTable = new JTable(cartModel);
        cartPanel.add(new JScrollPane(cartTable), BorderLayout.CENTER);

        JPanel cartBottomPanel = new JPanel(new BorderLayout());
        totalLabel = new JLabel("Tổng Tiền: 0 VND");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cartBottomPanel.add(totalLabel, BorderLayout.WEST);

        JButton checkoutButton = new JButton("Thanh Toán");
        cartBottomPanel.add(checkoutButton, BorderLayout.EAST);
        cartPanel.add(cartBottomPanel, BorderLayout.SOUTH);

        // Thêm các panel vào frame
        frame.add(productPanel, BorderLayout.WEST);
        frame.add(cartPanel, BorderLayout.CENTER);

        // Xử lý sự kiện
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String productName = productTable.getValueAt(selectedRow, 1).toString();
                    double price = Double.parseDouble(productTable.getValueAt(selectedRow, 2).toString());
                    addToCart(productName, price);
                } else {
                    JOptionPane.showMessageDialog(frame, "Vui lòng chọn sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cartModel.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(frame, "Thanh toán thành công! Tổng số tiền: " + totalAmount + " VND", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    cartModel.setRowCount(0);
                    totalAmount = 0;
                    totalLabel.setText("Tổng Tiền: 0 VND");
                } else {
                    JOptionPane.showMessageDialog(frame, "Giỏ hàng trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Hiển thị giao diện
        frame.setVisible(true);
    }

    private void addToCart(String productName, double price) {
        boolean productExists = false;

        for (int i = 0; i < cartModel.getRowCount(); i++) {
            if (cartModel.getValueAt(i, 0).equals(productName)) {
                int quantity = Integer.parseInt(cartModel.getValueAt(i, 2).toString());
                cartModel.setValueAt(quantity + 1, i, 2);
                cartModel.setValueAt((quantity + 1) * price, i, 3);
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            cartModel.addRow(new Object[]{productName, price, 1, price});
        }

        totalAmount += price;
        totalLabel.setText("Tổng Tiền: " + totalAmount + " VND");
    }
    public static void main(String[] args) {
        new SalesSystemGUI();
    }
}
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
