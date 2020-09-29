package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *****/
public class letterCombinations_17 {

    // 初始化映射
    private Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    private List<String> res = new ArrayList<>();
    private int len;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        this.len = digits.length();
        dfs(digits, new StringBuilder(), 0);
        return res;
    }

    private void dfs(String digits, StringBuilder str, int index) {
        if (str.length() == len) {
            res.add(str.toString());
        }
        if (index == len) {
            return;
        }
        String temp = map.get(digits.charAt(index));
        for (int i = 0; i < temp.length(); i++) {
            str.append(temp.charAt(i));
            dfs(digits, str, index + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        letterCombinations_17 kobe = new letterCombinations_17();
        List<String> list = kobe.letterCombinations("23");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
