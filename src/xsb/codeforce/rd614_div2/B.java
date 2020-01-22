package xsb.codeforce.rd614_div2;

import java.util.Scanner;

/**
 * <p>题目链接: https://codeforces.com/contest/1293/problem/B </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/1/21
 */
public class B {
    public static void main(String[] args) {
        final int mx = (int)1e5*2;
        double[] tmp = new double[mx];
        for(int i=1;i<mx;i++) {
            tmp[i] = tmp[i-1]+ 1/(double)i;
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(tmp[n]);
    }
}
