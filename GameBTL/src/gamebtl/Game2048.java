/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gamebtl;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author au duc nga
 */
public class Game2048 {
    JFrame game;
    QLMH qlmanhinh;
    VeMH Vemanhinh;
    QuanLyData qldt;
//    public void start(){
//        init();
//        setUp();
//        runGame();
//    }
    public Game2048() {
        init();
        setUp();
        runGame();
    }
    
    public void init(){
        game = new JFrame();
        qlmanhinh = new QLMH(Vemanhinh,game,qldt);
    }
    public void setUp(){
        qlmanhinh.setUp(game);
    }
    public void runGame(){
        game.setVisible(true);
        game.setLocationRelativeTo(null);
    }
    public static Color hex2Rgb(String ColorStr){
        return new Color(
                Integer.valueOf(ColorStr.substring(1,3),16),
                Integer.valueOf(ColorStr.substring(3, 5),16),
                Integer.valueOf(ColorStr.substring(5, 7),16));
    }
    /**
     * @param args the command line arguments
     */
    public JFrame getGame() {
        return game;
    }

    public void setGame(JFrame game) {
        this.game = game;
    }
    public boolean over(){
        return qlmanhinh.getOver();
    }
    public String getScore(){
        return qlmanhinh.getScore().getText();
    }
}
