package xsb.codeforce.common.math;

import com.sun.org.apache.bcel.internal.generic.LineNumberGen;
import sun.rmi.runtime.Log;

import java.util.Scanner;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/1/22
 */
public class Number {

    public static int digitSum(long number) {
        return (int)Math.log10(number)+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long tmp = 8646196577975628l;
        long ten = 10;
        System.out.println(digitSum(tmp));
    }
}
