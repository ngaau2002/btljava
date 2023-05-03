/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamebtl;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author au duc nga
 */
public class gioithieu {
    JButton back;
    JFrame frame;
    public gioithieu() throws IOException {
        frame = new JFrame("Giới thiệu");
        frame.setSize(426,548);
        Font f1 = new Font("Serif",6,25);
        Font f2 = new Font("Monospaced",4,22);
        Font f3 = new Font("Palatino Linotype",1,18);
        Font f4 = new Font("Palatino Linotype",1,13);
        JLabel ten,thanhvien,tvt,gioithieu;
        ten = new JLabel("Sản phẩm của cá nhân em");
        ten.setFont(f1);
        ten.setBounds(95,5, 400, 30);
        thanhvien = new JLabel("Thành viên");
        thanhvien.setFont(f2);
        thanhvien.setBounds(10,30,200, 30);
        Color xanh = hex2Rgb("#000080");
            tvt = new JLabel("* Họ và tên: Âu Đức Ngà");
            tvt.setFont(f3);
            tvt.setBounds(60,25,400, 100);
            tvt.setForeground(xanh);
            JLabel tvmsv = new JLabel("* Mã sinh viên: 211204317");
            tvmsv.setFont(f3);
            tvmsv.setBounds(60,45, 400, 100);
            tvmsv.setForeground(xanh);
            JLabel tlop = new JLabel("* Lớp: CNTT6-K62");
            tlop.setFont(f3);
            tlop.setBounds(60, 65, 400, 100);
            tlop.setForeground(xanh);
        gioithieu = new JLabel("Giới thiệu");
        gioithieu.setFont(f2);
        gioithieu.setBounds(10,120,200,30);
        JLabel lb = new JLabel("<html>* 2048 chơi trên một lưới vuông 4×4. Mỗi lần di chuyển là một lượt, người chơi sử dụng các phím mũi tên và các khối vuông sẽ trượt theo một trong bốn hướng tương ứng (lên, xuống, trái, phải). Mỗi lượt có một khối có giá trị 2 hoặc 4 sẽ xuất hiện ngẫu nhiên ở một ô trống trên lưới. Các khối vuông trượt theo hướng chỉ định cho đến khi chạm đến biên của lưới hoặc chạm vào khối vuông khác. Nếu hai khối vuông có cùng giá trị chạm vào nhau, chúng sẽ kết hợp lại thành một khối vuông có giá trị bằng tổng giá trị hai khối vuông đó (giá trị gấp đôi). Khối vuông kết quả không thể kết hợp với khối vuông khác một lần nữa trong một lượt di chuyển. Để dễ nhận biết thì các khối vuông giá trị khác nhau sẽ có màu sắc khác nhau<br>"
                + "* Bảng điểm ở góc trên bên phải cho biết điểm của người chơi. Ban đầu điểm bằng 0. Khi hai khối vuông kết hợp thì người chơi sẽ tăng điểm là giá trị khối vuông mới<br>"
                + "* Khi người chơi tạo được ô vuông có giá trị 2048 thì thắng cuộc. Khi không còn nước đi hợp lệ (không còn ô trống và các ô kề nhau đều khác giá trị) thì trò chơi kết thúc.</html>");
        lb.setBounds(30,110,380,400);
        lb.setFont(f4);
        lb.setForeground(xanh);
        ImageIcon icon = new ImageIcon("img/back.png");
        back = new JButton(icon);
        back.setBounds(350,470,50,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                            try {
                                new qlmenu();
                                exit();
                            } catch (IOException ex) {
                                Logger.getLogger(qlmenu.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
        });
        frame.add(back);
        frame.add(gioithieu);
        frame.add(lb);
        frame.add(tlop);
        frame.add(tvt);
        frame.add(tvmsv);
        frame.add(ten);
        frame.add(thanhvien);
        frame.getContentPane().add(new JPanelWithBackground("img/anhmo.png"));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
    public static Color hex2Rgb(String ColorStr){
        return new Color(
                Integer.valueOf(ColorStr.substring(1,3),16),
                Integer.valueOf(ColorStr.substring(3, 5),16),
                Integer.valueOf(ColorStr.substring(5, 7),16));
    }

    public JButton getBack() {
        return back;
    }
    public void exit(){
        frame.dispose();
    }
}
