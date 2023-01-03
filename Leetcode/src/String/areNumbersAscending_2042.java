package String;


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 句子是由若干 token 组成的一个列表，token 间用 单个 空格分隔，句子没有前导或尾随空格。
 * 每个 token 要么是一个由数字 0-9 组成的不含前导零的 正整数 ，要么是一个由小写英文字母组成的 单词 。
 * 示例，"a puppy has 2 eyes 4 legs" 是一个由 7 个 token 组成的句子："2" 和 "4" 是数字，
 * 其他像 "puppy" 这样的 tokens 属于单词。
 * 给你一个表示句子的字符串 s ，你需要检查 s 中的 全部 数字是否从左到右严格递增
 * （即，除了最后一个数字，s 中的 每个 数字都严格小于它 右侧 的数字）。
 * 如果满足题目要求，返回 true ，否则，返回 false 。
 * 示例 1：
 * <p>
 * example-1
 * <p>
 * 输入：s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
 * 输出：true
 * 解释：句子中的数字是：1, 3, 4, 6, 12 。
 * 这些数字是按从左到右严格递增的 1 < 3 < 4 < 6 < 12 。
 * 示例 2：
 * <p>
 * 输入：s = "hello world 5 x 5"
 * 输出：false
 * 解释：句子中的数字是：5, 5 。这些数字不是严格递增的。
 */
public class areNumbersAscending_2042 {

    public boolean areNumbersAscending(String s) {
        // 字符串处理
        String[] array = s.split(" ");
        int preNum = Integer.MIN_VALUE;
        boolean flag = false;
        int num = Integer.MAX_VALUE;
        for (String str : array) {
            if (isNumberic(str)) {
                if (preNum == Integer.MIN_VALUE) {
                    preNum = Integer.parseInt(str);
                } else {
                    num = Integer.parseInt(str);
                    if (num <= preNum) {
                        return false;
                    }
                    preNum = num;
                }
            }
        }
        return true;
    }

    // 判断是否为数字
    private boolean isNumberic(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        areNumbersAscending_2042 kobe = new areNumbersAscending_2042();
        System.out.println(kobe.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }
}
