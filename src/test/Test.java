/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

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

    class Student {
    private String name;
    private int age;
    private ArrayList<Integer> grades;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return grades.isEmpty() ? 0 : (double) sum / grades.size();
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + calculateAverageGrade());
    }
}
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showAllStudents();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
}

private static void addStudent() {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Student student = new Student(name, age);
        System.out.print("Enter student's name: ");

        System.out.print("Enter student's name: ");
        System.out.print("Viet ANh");
        System.out.print("Enter number of grades: ");
        int numGrades = scanner.nextInt();
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            int grade = scanner.nextInt();
            student.addGrade(grade);
        }
        students.add(student);
        System.out.println("Student added successfully!");
    }

    private static void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                student.displayInfo();
                System.out.println();
            }
        }
    }
}

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


         

           System.out.println(number + " là số lẻ.");
       }

        System.out.println("JJJ");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        JFrame frame = new JFrame("Giao Diện Đơn Giản");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Tạo một nhãn (label)
        JLabel label = new JLabel("Chào mừng bạn đến với Java GUI!", JLabel.CENTER);

        // Tạo một nút (button)
        JButton button = new JButton("Nhấn vào đây");

        // Định nghĩa hành động khi nút được nhấn
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cập nhật nhãn khi nút được nhấn
                label.setText("Nút đã được nhấn!");
            }
        });

        // Đặt bố cục và thêm các thành phần vào khung
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(label);
        frame.add(button);

        // Hiển thị cửa sổ
        frame.setVisible(true);

        System.out.println("A commit");
        System.out.println("Lê Tuấn Anh");


        // Tạo khung cửa sổ (frame)
        JFrame frame = new JFrame("Ứng dụng Chào Mừng");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);

        // Tạo một bảng điều khiển (panel) để chứa các thành phần
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Tạo các thành phần giao diện
        JLabel nameLabel = new JLabel("Nhập tên của bạn:");
        JTextField nameField = new JTextField(20);
        JButton greetButton = new JButton("Chào mừng");
        JLabel greetingLabel = new JLabel("", JLabel.CENTER);

        // Thêm các thành phần vào bảng điều khiển
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(greetButton);
        panel.add(greetingLabel);

        // Thêm bảng điều khiển vào cửa sổ
        frame.add(panel);

        // Định nghĩa hành động khi nút "Chào mừng" được nhấn
        greetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText(); // Lấy tên từ ô văn bản
                if (!name.isEmpty()) {
                    greetingLabel.setText("Chào mừng, " + name + "!");
                } else {
                    greetingLabel.setText("Vui lòng nhập tên.");
                }
            }
        });

        // Hiển thị cửa sổ
        frame.setVisible(true);

    }

        System.out.println("A commit");
        System.out.println("Lê Tuấn Anh");
        System.out.println("Nguyễn Thái An");
        System.out.println("Lần thứ 2");
        String fileName = "example.txt";
        String content = "Xin chào, đây là nội dung được ghi vào file.";

        // Ghi vào file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }

        // Đọc từ file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Nội dung trong file: " + line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }      

        int a = 4;
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

        System.out.println("Viet Anh");
    }
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
    
    System.out.println("Lê Tuấn Anh");
    ArrayList<String> students = new ArrayList<>();

        // Thêm sinh viên vào danh sách
        students.add("Nguyễn Văn A");
        students.add("Trần Thị B");
        students.add("Lê Văn C");

        // In danh sách sinh viên
        System.out.println("Danh sách sinh viên:");
        for (String student : students) {
            System.out.println("- " + student);
        }

        // Xóa một sinh viên
        students.remove("Trần Thị B");
        System.out.println("\nDanh sách sau khi xóa:");
        for (String student : students) {
            System.out.println("- " + student);
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

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame() {
        this.add(new GamePanel());
        this.setTitle("Paddle and Ball");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}

