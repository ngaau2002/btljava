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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author au duc nga
 */
public class highscore {
    JFrame highscore;
    public highscore(Vector<Integer> a) throws IOException {
        highscore = new JFrame("HighScore");
        JLabel hisc = new JLabel("HIGHSCORE");
        Font f1 = new Font("Serif",6,25);
        hisc.setBounds(140, 10,200, 30);
        hisc.setFont(f1);
        highscore.add(hisc);
        Color red = gioithieu.hex2Rgb("#DF0029");
        Color xanh = gioithieu.hex2Rgb("#000080");
        Color cam = gioithieu.hex2Rgb("#EC870E");
        Color vang = gioithieu.hex2Rgb("#F1AF00");
        JLabel stt = new JLabel("STT"); 
        JLabel score = new JLabel("SCORE");
        Font f2 = new Font("Monospaced",1,22);
        Font f3 = new Font("Palatino Linotype",1,20);
        stt.setFont(f2);score.setFont(f2);
        stt.setBounds(100,40, 100, 30);
        score.setBounds(240,40, 100, 30);
        highscore.add(score);
        highscore.add(stt);
        highscore.setSize(426, 548);
        for (int i = 0; i <10; i++) {
            JLabel b = new JLabel("" + (i + 1));
            b.setBounds(115,40 * (i+2), 20,25);
            b.setFont(f3);
            JLabel sc = new JLabel("" + a.get(i));
            sc.setBounds(255,40 * (i+2), 100,25);
            sc.setFont(f3);
            if(i==0){
                b.setForeground(red);
                sc.setForeground(red);
            }
            else if(i==1){
                b.setForeground(cam);
                sc.setForeground(cam);
            }
            else if(i==2){
                b.setForeground(vang);
                sc.setForeground(vang);
            }
            else{
                b.setForeground(xanh);
                sc.setForeground(xanh);
            }
            highscore.add(b);
            highscore.add(sc);
        }
        ImageIcon icon = new ImageIcon("img/back.png");
        JButton back = new JButton(icon);
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
        highscore.add(back);
        highscore.getContentPane().add(new JPanelWithBackground("img/anhmo.png"));
        highscore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        highscore.setVisible(true);
        highscore.setResizable(false);
        highscore.setLocationRelativeTo(null);
    }
    public void exit(){
        highscore.dispose();
    }
}
