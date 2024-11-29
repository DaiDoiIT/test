/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

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
    
}
