/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamebtl;
//import static newpackage.selectData.QUERY;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.awt.event.KeyEvent;
import  java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import  javax.swing.*;
/**
 *
 * @author au duc nga
 */
public class QLMH {
    public int margin = 2;
    public int widthmh = 400+ 3*margin;
    public int heightmh = 400+ 3*margin;
    QuanLyData qldt;
    VeMH vemanhinh;
    JLabel score;
    public QLMH(VeMH vemanhinh,JFrame frame,QuanLyData data) {
        this.vemanhinh = vemanhinh;
        this.vemanhinh = new VeMH();
        this.qldt = qldt;
        this.qldt = new QuanLyData();
        this.vemanhinh.veCacNut(frame, widthmh ,heightmh, margin);
    }
    
    public VeMH getVemanhinh() {
        return vemanhinh;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    public int getMargin() {
        return margin;
    }

    public int getHeightmh() {
        return heightmh;
    }

    public int getWidthmh() {
        return widthmh;
    }

    public void setHeightmh(int heightmh) {
        this.heightmh = heightmh;
    }

    public void setWidthmh(int widthmh) {
        this.widthmh = widthmh;
    }
    public void setUp(JFrame frame){
        frame.setSize(widthmh+16+2*margin,heightmh+38+2*margin+100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setResizable(false);
       
        vemanhinh.getBack().addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            new qlmenu();
            frame.dispose();
            if(qldt.getScore() > 0) {
                String diem = Integer.toString(qldt.getScore());
            }
        } catch (IOException ex) {
            Logger.getLogger(QLMH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        });
        frame.getContentPane().setBackground(Game2048.hex2Rgb("#000000"));
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    qldt.moveLeft();
                }
                else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    qldt.moveRight();               
                }
                else if(e.getKeyCode()==KeyEvent.VK_UP){
                    qldt.moveTop();
                }
                else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    qldt.moveBottom();
                }
                vemanhinh.getScore().setText("Score: "+ qldt.getScore());
                vemanhinh.update();
                if(qldt.getWin()){
                    vemanhinh.getGameover().setText("GAME WIN!!");
                }
                if(qldt.getKt()){
                    vemanhinh.getGameover().setText("GAME OVER");
                    String QUERY = "SELECT score FROM diem";
                    Connection conn = Connect.ketNoi();
                    Statement stmt = null;
                    int kt=0;
                    try {
                        stmt = conn.createStatement();
                    } catch (SQLException ex) {
                        Logger.getLogger(QLMH.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ResultSet rs = null;
                    try {
                        rs = stmt.executeQuery(QUERY);
                    } catch (SQLException ex) {
                        Logger.getLogger(QLMH.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        while(rs.next()){
                            if(qldt.getScore()== rs.getInt("score")) {
                                kt =1;
                                break;
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(QLMH.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(kt ==0)    new insertData(qldt.getScore());
                    if(e.getKeyCode()==KeyEvent.VK_SPACE){
                        Game2048 newgame =  new Game2048();
                    }
                }
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    public boolean getOver() {
        return qldt.getKt();
    }

    public JLabel getScore() {
        return score;
    }
    
}
