package HuisuDigui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个由数字和运算符组成的字符串 expression ，
 * 按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 * 示例 1：
 * <p>
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2：
 * <p>
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * <p>
 * 1 <= expression.length <= 20
 * expression 由数字和算符 '+'、'-' 和 '*' 组成。
 * 输入表达式中的所有整数值在范围 [0, 99] 
 */
public class diffWaysToCompute_241 {

    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        // 分治算法
        int len = expression.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, len));
                // 分治之后从头计算
                for (int l : left) {
                    for (int r : right) {
                        switch (ch) {
                            case '-':
                                list.add(l - r);
                                break;
                            case '+':
                                list.add(l + r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.valueOf(expression));
        }
        map.put(expression, list);
        return list;
    }
}
