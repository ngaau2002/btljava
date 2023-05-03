/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamebtl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author au duc nga
 */
public class qlmenu{
    public Menu p;
    public qlmenu() throws IOException {
        p = new Menu();
        p.getVaogame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game2048 newgame = new Game2048();
                p.out();
            }
        });
        p.getGioithieu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gioithieu k = new gioithieu();
                } catch (IOException ex) {
                    Logger.getLogger(qlmenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                p.out();
            }
        });
        p.getHighscore().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String QUERY = "SELECT score FROM diem ORDER BY score desc";
                    Connection conn = Connect.ketNoi();
                    Statement stmt = null;
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
                    Vector<Integer> a = new Vector<>();
                    int dem=0;
                    try {
                        while(rs.next()){
                            int temp = rs.getInt("score");
                            a.add(temp);
                        }
                        new highscore(a);
                        p.out();
                    } catch (SQLException ex) {
                        Logger.getLogger(qlmenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(qlmenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public static void main(String[] args) throws IOException {
        new qlmenu();
    }
    
}
