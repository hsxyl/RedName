package xsb.codeforce.rd614_div2;

import java.util.Comparator;
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
public class D {

    private static final long maxT = (long) 1e16;
    private static final int maxLen = 100;
    static Scanner scanner = new Scanner(System.in);
    static long[] nodeX = new long[maxLen];
    static long[] nodeY = new long[maxLen];
    private static long x0, y0, ax, ay, bx, by, xs, ys, t;
    private static int maxX, maxY, maxIndex;

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

    static long costBetweenIndex(int i1, int i2) {
        return Math.abs(nodeX[i1] - nodeX[i2]) + Math.abs(nodeY[i1] - nodeY[i2]);
    }

    static long costBetweenPointAndNode(long x, long y, int nodeIndex) {
        return Math.abs(nodeX[nodeIndex] - x) + Math.abs(nodeY[nodeIndex] - y);
    }

    static long goDownScore(int index, long t) {
        int downMax = upperBinarySearch(0, index + 1, t, i -> costBetweenIndex(index, index - i), Long::compare) - 1;
        return downMax + 1;
    }

    static long goUpScore(int index, long t) {
        int upMax = upperBinarySearch(0, maxIndex, t, i -> costBetweenIndex(index, index + i), Long::compare) - 1;
        return upMax + 1;
    }

    /**
     * 从x0,y0先走到编号为index的node,再往下走的最大分数
     *
     * @param index
     * @return
     */
    static long gotoIndexThanDownScore(int index) {
        long _t = t;
        _t -= costBetweenPointAndNode(xs, ys, index);
        if (_t < 0) {
            return 0;
        }
        return goDownScore(index, _t);
    }

    /**
     * 从x0,y0先走到原点再往上走的最大分数
     *
     * @return
     */
    static long gotoOriginThanUpScore() {
        long _t = t;
        _t -= costBetweenPointAndNode(xs, ys, 0);
        if (_t < 0) {
            return 0;
        }
        return goUpScore(0, _t);
    }

    static long solve() {
        int cellX = upperBinarySearch(0, maxX + 1, xs, i -> nodeX[i], Long::compare);
        int cellY = upperBinarySearch(0, maxY + 1, ys, i -> nodeY[i], Long::compare);
        int cellIndex = Math.max(cellX, cellY);
        cellIndex = Math.min(cellIndex,maxIndex);
        long result = 0;
        for (; cellIndex > 0; cellIndex--) {
            result = Math.max(result, gotoIndexThanDownScore(cellIndex));
        }
        return Math.max(result, gotoOriginThanUpScore());
    }

    /**
     * 计算node的x,y坐标
     */
    static void init() {
        nodeX[0] = x0;
        nodeY[0] = y0;

        int index = 0;
        do {
            index++;
            nodeX[index] = ax * nodeX[index - 1] + bx;
        } while (nodeX[index] <= maxT);
        maxX = index + 1;

        index = 0;
        do {
            index++;
            nodeY[index] = ay * nodeY[index - 1] + by;
        } while (nodeY[index] <= maxT);
        maxY = index + 1;
        maxIndex = Math.min(maxX,maxY);

    }

    static void input() {
        x0 = scanner.nextLong();
        y0 = scanner.nextLong();
        ax = scanner.nextLong();
        ay = scanner.nextLong();
        bx = scanner.nextLong();
        by = scanner.nextLong();
        xs = scanner.nextLong();
        ys = scanner.nextLong();
        t = scanner.nextLong();
    }

    public static void main(String[] args) {
        input();
        init();
        System.out.println(solve());
    }
}
