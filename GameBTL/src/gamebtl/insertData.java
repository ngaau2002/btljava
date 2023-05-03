/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamebtl;
import java.sql.*;
import java.io.*;
/**
 *
 * @author au duc nga
 */
public class insertData {
    private Statement stmt;
    private Connection conn;
    public insertData(int score){
        try {
            conn = Connect.ketNoi();
            stmt = conn.createStatement();
            String query ="INSERT INTO diem(score) VALUES('"+score+"')";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 
}
