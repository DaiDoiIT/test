/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;
import javax.swing.*;
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
    }
    
}
