package xsb.codeforce.rd614_div2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <p>题目链接: https://codeforces.com/contest/1293/problem/A </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/1/21
 */
public class A {

    static int findClosedFloor(int n,int s,int k,int[] closed) {
        Set<Integer> set = new HashSet<>();
        for (int aClosed : closed) {
            set.add(aClosed);
        }
        int i=0;
        while(true) {
            if((s+i)<=n&&!set.contains(s+i)) {
                return i;
            }
            if((s-i)>0&&!set.contains(s-i)) {
                return i;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int k = scanner.nextInt();
            int[] closed = new int[k];
            for(int i=0;i<k;i++) {
                closed[i] = scanner.nextInt();
            }
            System.out.println(findClosedFloor(n,s,k,closed));
        }
    }
}
