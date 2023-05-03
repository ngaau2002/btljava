/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamebtl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author au duc nga
 */
public class VeMH {

    JLabel arrlb[][] = new JLabel[4][4];
    JLabel score;
    JLabel gameover;
    JButton back;
    
    public void veCacNut(JFrame frame, int W, int H, int M) {
        int w = (W - (3 * M)) / 4;
        int h = (H - (3 * M)) / 4;
        int x = 0, y = 0;
        for (int i = 0; i < 4; i++) {
            y = i * h + (1 + i) * M + 100;
            for (int j = 0; j < 4; j++) {
                x = j * h + (j + 1) * M;
                arrlb[i][j] = taoO(x, y, w, h, i, j);
                frame.add(arrlb[i][j]);
            }
        }
        ImageIcon icon = new ImageIcon("img/back.png");
        back = new JButton(icon);
        back.setBounds(10, 20, 50, 30);
        frame.add(back);
        score = new JLabel("Score: 0");
        score.setBounds(200, 35, 250, 30);
        Font font = new Font("Serif", 1, 30);
        score.setFont(font);
        score.setForeground(Color.WHITE);
        frame.add(score);
        gameover = new JLabel("");
        gameover.setBounds(125, 70, 250, 30);
        Font f1 = new Font("MV Boli", 6, 25);
        gameover.setForeground(Color.WHITE);
        gameover.setFont(f1);
        frame.add(gameover);
        frame.add(new JLabel());
    }

    private JLabel taoO(int x, int y, int w, int h, int i, int j) {
        JLabel l = new JLabel("");
        l.setBounds(x, y, w, h);
        setBG(l, i, j);
        l.setOpaque(true);
        return l;
    }

    private void setBG(JLabel l, int i, int j) {
        int data = Data.getData().arr[i][j];
        String mau = "";
        switch (data) {
            case 2:
                mau = "83C75D";
                break;
            case 4:
                mau = "5BBD2B";
                break;
            case 8:
                mau = "50A625";
                break;
            case 16:
                mau = "489620";
                break;
            case 32:
                mau = "367517";
                break;
            case 64:
                mau = "006241";
                break;
            case 128:
                mau = "C9E4D6";
                break;
            case 256:
                mau = "00676B";
                break;
            case 512:
                mau = "CAE5E8";
                break;
            case 1024:
                mau = "103667";
                break;
            case 2048:
                mau = "BFCAE6";
                break;
            default:
                mau = "373737";
                break;
        }
        if (data == 0) {
            l.setText("");
        } else {
            l.setText("" + data);
        }
        l.setFont(new Font("Sefif", Font.BOLD, 26));
        l.setForeground(Game2048.hex2Rgb("#0000FF"));
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setVerticalAlignment(SwingConstants.CENTER);
        l.setBackground(Game2048.hex2Rgb("#" + mau));
    }

    public void update() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                setBG(arrlb[i][j], i, j);
                
            }
        }
    }

    public void setScore(JLabel score) {
        this.score = score;
    }

    public JLabel getScore() {
        return score;
    }

    public JLabel getGameover() {
        return gameover;
    }

    public JButton getBack() {
        return back;
    }

}
