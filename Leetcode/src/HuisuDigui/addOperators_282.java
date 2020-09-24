package HuisuDigui;

import java.util.ArrayList;
import java.util.List;

/***
 * 给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 *，返回所有能够得到目标值的表达式。
 * 示例 1:
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"]
 * 示例2:
 *
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 * 示例 3:
 *
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]
 *
 * *****/
public class addOperators_282 {

    // 回溯，但是过程中需要记录乘法表达式的乘数
    List<String> res = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return res;
        }
        dfs(num, target, "", 0, 0, 0);
        return res;
    }

    // diff来记录乘数
    private void dfs(String num, int target, String str, int index, long sum, long diff) {
        if (index == num.length() && (long) target == sum) {
            res.add(str);
        }
        for (int i = index; i < num.length(); i++) {
            String cur = num.substring(index, i + 1);
            if (cur.length() > 1 && cur.charAt(0) == '0') {
                break;
            }
            if (str.length() > 0) {
                dfs(num, target, str + "+" + cur, i + 1, sum + Long.valueOf(cur), Long.valueOf(cur));
                dfs(num, target, str + "-" + cur, i + 1, sum - Long.valueOf(cur), -Long.valueOf(cur));
                dfs(num, target, str + "*" + cur, i + 1, sum - diff + (diff * Long.valueOf(cur)), diff * Long.valueOf(cur));
            } else {
                dfs(num, target, cur, i + 1, Long.valueOf(cur), Long.valueOf(cur));
            }
        }
    }

    public static void main(String[] args) {
        addOperators_282 kobe = new addOperators_282();
        System.out.println(kobe.addOperators("105", 5));
    }
}
