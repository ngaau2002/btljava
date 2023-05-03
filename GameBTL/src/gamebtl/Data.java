/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gamebtl;

/**
 *
 * @author au duc nga
 */
public class Data {
    private static Data data; 
    static{
        data = new Data();
    }
    public static Data getData(){
        return data;
    }
    public int arr[][] = new int[4][4];
//        {2,4,8,16},
//        {32,64,128,0},
//        {2,0,2048,1024},
//        {512,4,8,256}
//    };
}
