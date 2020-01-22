package xsb.codeforce.common.binary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

/**
 * <p>题目链接: </p>
 * <p>题解链接: </p>
 *
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/1/21
 */
public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 3, 6);
        System.out.println(lowerBinarySearch(0, list.size(), 3, list::get, Integer::compare));
        System.out.println(upperBinarySearch(0, list.size(), 3, list::get, Integer::compareTo));
    }

    /**
     * 在[begin,end)升序区间二分查找目标aim的下限
     *
     * @param begin
     * @param end
     * @param aim
     * @param indexToClass 将index转换为指定的类型T
     * @param comparator   比较器
     * @param <T>          实际的类型
     * @return 返回一个int表示不小于aim的最大值的下标，若return==q,即[begin,end)范围内没有大于aim的
     */
    public static <T> int lowerBinarySearch(int begin, int end, T aim, Function<Integer, T> indexToClass, Comparator<T> comparator) {
        while (begin < end) {
            int m = (begin + end) >> 1;
            if (comparator.compare(aim, indexToClass.apply(m)) > 0) {
                begin = m + 1;
            } else {
                end = m;
            }
        }
        return begin;
    }

    /**
     * 在[begin,end)升序区间二分查找目标aim的
     *
     * @param begin
     * @param end
     * @param aim
     * @param indexToClass 将index转换为指定的类型T
     * @param comparator   比较器
     * @param <T>          实际的类型
     * @return 返回一个int表示大于aim的最小值的下标，若return==q,即[begin,end)范围内没有小于aim的
     */
    public static <T> int upperBinarySearch(int begin, int end, T aim, Function<Integer, T> indexToClass, Comparator<T> comparator) {
        while (begin < end) {
            int m = (begin + end) >> 1;
            if (comparator.compare(aim, indexToClass.apply(m)) >= 0) {
                begin = m + 1;
            } else {
                end = m;
            }
        }
        return begin;
    }
}
