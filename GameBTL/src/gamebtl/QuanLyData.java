/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamebtl;

import java.util.Random;

/**
 *
 * @author au duc nga
 */
public class QuanLyData {

    Random r = new Random();
    int score, kt = 0;

    public QuanLyData() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Data.getData().arr[i][j] = 0;
            }
        }
        taoSo();
    }

    public void taoSo() {
        int oConTrong = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] == 0) {
                    oConTrong++;
                }
            }
        }
        if (oConTrong >= 2) {
            if (r.nextInt(10) > 6) {
                oConTrong = 1;
            } else {
                oConTrong = 2;
            }
        }

        while (oConTrong != 0) {
            int x = r.nextInt(4);
            int y = r.nextInt(4);
            while (Data.getData().arr[x][y] != 0) {
                x = r.nextInt(4);
                y = r.nextInt(4);
            }
            if (r.nextInt(10) > 6) {
                Data.getData().arr[x][y] = 4;

            } else {
                Data.getData().arr[x][y] = 2;
            }
            oConTrong--;
        }
    }

    public void moveLeft() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] != 0) {
                    donO(i, j, 0, -1);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] != 0) {
                    gopO(i, j, 0, 1);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] != 0) {
                    donO(i, j, 0, -1);
                }
            }
        }
        taoSo();
    }

    public void moveRight() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] != 0) {
                    donO(i, j, 0, 1);
                }
            }
        }
        for (int i = 0;i<4 ;i++) {
            for (int j = 3; j >=0; j--) {
                if (Data.getData().arr[i][j] != 0) {
                    gopO(i, j, 0, 1);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] != 0) {
                    donO(i, j, 0, 1);
                }
            }
        }
        taoSo();

    }

    public void moveTop() {
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] != 0) {
                    donO(i, j, -1, 0);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] != 0) {
                    gopO(i, j, -1, 0);
                }
            }
        }
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] != 0) {
                    donO(i, j, -1, 0);
                }
            }
        }
        taoSo();
    }

    public void moveBottom() {
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] != 0) {
                    donO(i, j, 1, 0);
                }
            }
        }
        for (int i = 3; i >=0; i--) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] != 0) {
                    gopO(i, j, 1, 0);
                }
            }
        }
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (Data.getData().arr[i][j] != 0) {
                    donO(i, j, 1, 0);
                }
            }
        }
        taoSo();
    }

    private void donO(int i, int j, int it, int jt) {
        if (i == 0 && it == -1) {
            return;
        }
        if (i == 3 && it == 1) {
            return;
        }
        if (j == 0 && jt == -1) {
            return;
        }
        if (j == 3 && jt == 1) {
            return;
        }
        int x = i + it;
        int y = j + jt;
        if (Data.getData().arr[x][y] != 0) {
            return;
        }
        int k = Data.getData().arr[i][j];
        Data.getData().arr[x][y] = k;
        Data.getData().arr[i][j] = 0;
        donO(x, y, it, jt);
    }

    private void gopO(int i, int j, int it, int jt) {
        kt = 1;
        if (i == 0 && it == -1) {
            return;
        }
        if (i == 3 && it == 1) {
            return;
        }
        if (j == 0 && jt == -1) {
            return;
        }
        if (j == 3 && jt == 1) {
            return;
        }
        int x = i + it;
        int y = j + jt;
        if (Data.getData().arr[x][y] != Data.getData().arr[i][j]) {
            kt = 0;
            return;
        }
        int k = Data.getData().arr[i][j] * 2;
        score = score + k;
        Data.getData().arr[x][y] = k;
        Data.getData().arr[i][j] = 0;
        gopO(i, j, it, jt);
    }

    public int getScore() {
        return score;
    }
    public boolean getWin(){
        boolean kt = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if ((Data.getData().arr[i][j] == 2048)) {
                    return kt = true;
                }
            }
        }
        return kt;
    }
    public boolean getKt() {
        int dem = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                if ((Data.getData().arr[i][j] != 0 && Data.getData().arr[i + 1][j] != 0) && (Data.getData().arr[i][j] != Data.getData().arr[i + 1][j])) {
                    dem++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if ((Data.getData().arr[i][j] != 0 && Data.getData().arr[i][j + 1] != 0) && (Data.getData().arr[i][j] != Data.getData().arr[i][j + 1])) {
                    dem++;
                }
            }
        }
        return dem == 24;
    }

}
