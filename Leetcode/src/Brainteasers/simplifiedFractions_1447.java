package Brainteasers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。
 * 分数可以以 任意 顺序返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 */
public class simplifiedFractions_1447 {

    public List<String> simplifiedFractions(int n) {
        if (n < 2) {
            return new ArrayList<>();
        }
        Set<String> list = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int gcd = getGcd(i, j);
                if (gcd == 1) {
                    list.add(j + "/" + i);
                } else {
                    list.add(j / gcd + "/" + i / gcd);
                }
            }
        }
        return new ArrayList<>(list);
    }

    // gcd
    private int getGcd(int num1, int num2) {
        int ret = num1 % num2;
        if (ret == 0) {
            return num2;
        }
        return getGcd(num2, ret);
    }

    public static void main(String[] args) {
        simplifiedFractions_1447 kobe = new simplifiedFractions_1447();
        System.out.println(kobe.simplifiedFractions(1));
    }
}
