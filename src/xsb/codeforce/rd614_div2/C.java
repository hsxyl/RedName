package xsb.codeforce.rd614_div2;

import java.util.Scanner;

/**
 * <p>题目链接: https://codeforces.com/contest/1293/problem/C </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/1/21
 */
public class C {
    static int n, q;
    static int[][] lock;
    static boolean[][] pass;
    static int[] unpass;

    static void lockPoint(int x,int y) {
        if(y<0||y>=n) {
            return;
        }
        lock[x][y]+=1;
        if(lock[x][y]==1&&!pass[x][y]) {
            unpass[x]++;
        }
    }

    static void releasePoint(int x,int y) {
        if(y<0||y>=n) {
            return;
        }
        lock[x][y]-=1;
        if(lock[x][y]==0&&!pass[x][y]) {
            unpass[x]--;
        }
    }

    /**
     * 当一个坐标被设置为不可通行状态
     * @param x
     * @param y
     */
    static void lock(int x, int y) {
        pass[x][y]=false;
        lockPoint(1-x,y-1);
        lockPoint(1-x,y);
        lockPoint(1-x,y+1);
        if(lock[x][y]!=0) {
            unpass[x]++;
        }
    }

    /**
     * 当一个坐标被设置为可通行状态
     * @param x
     * @param y
     */
    static void release(int x,int y) {
        pass[x][y]=true;
        releasePoint(1-x,y-1);
        releasePoint(1-x,y);
        releasePoint(1-x,y+1);
        if(lock[x][y]!=0) {
            unpass[x]--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        lock = new int[2][n];
        pass = new boolean[2][n];
        unpass = new int[2];
        unpass[0]=unpass[1]=0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                pass[i][j] = true;
            }
        }
        int x, y;
        for (int i = 0; i < q; i++) {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            if (pass[x][y]) {
                lock(x, y);
            } else {
                release(x,y);
            }
            if(unpass[0]!=0||unpass[1]!=0) {
                System.out.println("no");
            }
            else {
                System.out.println("yes");
            }
        }
    }
}
