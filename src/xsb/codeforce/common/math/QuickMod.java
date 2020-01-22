package xsb.codeforce.common.math;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Scanner;

/**
 * @author xushenbao
 * @desc 快速幂
 * @create 2020/1/21
 */
public class QuickMod {

    /**
     * 快速幂
     *
     * @param base
     * @param e
     * @return
     */
    public static long quickMod(long base, long e) {
        long ret = 1;
        while (e > 0) {
            if (e % 2 != 0) {
                ret *= base;
            }
            base *= base;
            e >>= 1;
        }
        return ret;
    }

    /**
     * 快速幂+取模
     *
     * @param base 底
     * @param e    幂
     * @param mod  取模
     * @return
     */
    public static long quickMod(long base, long e, long mod) {
        long ret = 1;
        while (e > 0) {
            if (e % 2 != 0) {
                ret *= base;
                ret %= mod;
            }
            base *= base;
            base %= mod;
            e >>= 1;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(quickMod(4,5));
        System.out.println(quickMod(4,5,2));
        System.out.println(Long.MAX_VALUE);
    }
}
