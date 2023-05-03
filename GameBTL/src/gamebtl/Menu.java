/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamebtl;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author au duc nga
 */
public class Menu {
    JFrame frame;
    JButton vaogame,highscore,gioithieu;
    public Menu() throws IOException {
        frame = new JFrame("Menu");
        frame.setSize(426,548);
        vaogame = new JButton("Vào Game");
        vaogame.setBounds(150,205,120, 50);
        ImageIcon a = new ImageIcon("img/vaogame.png");
        vaogame.setIcon(a);
        ImageIcon b = new ImageIcon("img/highscore.png");
        highscore = new JButton(b);
        highscore.setBounds(150,270,120,50);
        ImageIcon c = new ImageIcon("img/introduce.png");
        gioithieu = new JButton(c);
        gioithieu.setBounds(150, 335, 120, 50);
        frame.add(gioithieu);
        frame.add(highscore);
        frame.add(vaogame);
        frame.getContentPane().add(new JPanelWithBackground("img/2.png"));
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
    public JButton getVaogame() {
        return vaogame;
    }

    public JButton getHighscore() {
        return highscore;
    }

    public JButton getGioithieu() {
        return gioithieu;
    }
    public void out(){
        frame.dispose();
    }
}
