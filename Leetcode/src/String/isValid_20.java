package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 ****/
public class isValid_20 {

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        //初始化map
        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && map.containsKey(s.charAt(i))) {
                if (stack.pop() != map.get(s.charAt(i))) {
                    return false;
                }
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
