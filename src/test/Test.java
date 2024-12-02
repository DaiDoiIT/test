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
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;


/**
 *
 * @author vanh
 */
public class SumCalculator {
    public static void main(String[] args) {
        // Tạo một đối tượng Scanner để đọc đầu vào từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập số N
        System.out.print("Nhập một số nguyên dương N: ");
        int N = scanner.nextInt();

        // Kiểm tra xem N có hợp lệ không
        if (N <= 0) {
            System.out.println("Vui lòng nhập một số nguyên dương lớn hơn 0.");
        } else {
            int sum = 0;

            // Tính tổng các số từ 1 đến N
            for (int i = 1; i <= N; i++) {
                sum += i;
            }

            // Hiển thị kết quả
            System.out.println("Tổng các số từ 1 đến " + N + " là: " + sum);
        }

        // Đóng Scanner
        scanner.close();
    }
}

public class CircleAreaCalculator {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhận dữ liệu đầu vào từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Hỏi người dùng nhập bán kính
        System.out.print("Nhập bán kính của hình tròn: ");
        double radius = scanner.nextDouble();

        // Công thức tính diện tích hình tròn
        double area = Math.PI * Math.pow(radius, 2);

        // In kết quả
        System.out.println("Diện tích hình tròn với bán kính " + radius + " là: " + area);

        // Đóng Scanner
        scanner.close();
    }
}

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

        // In kết quả
        System.out.println("Tổng: " + sum);
        System.out.println("Hiệu: " + difference);
        System.out.println("Tích: " + product);
        System.out.println("Thương: " + quotient);

           System.out.println(number + " là số chẵn.");

       } else {

           System.out.println(number + " là số lẻ.");

       }
        System.out.println("JJJ");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

    }

    

        System.out.println("A commit");
        System.out.println("Lê Tuấn Anh");
        System.out.println("Nguyễn Thái An");
        System.out.println("Lần thứ 2");
    }

    
    }

}

