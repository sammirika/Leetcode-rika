package Sreach;

import java.util.*;

/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。 
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 示例 2：
 * <p>
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 */
public class removeInvalidParentheses_301 {

    public List<String> removeInvalidParentheses(String s) {
        // 广度优先搜索
        List<String> ret = new ArrayList<>();
        if (s.equals("()") || s.equals("")) {
            ret.add(s);
            return ret;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        Set<String> set = new HashSet<>();
        boolean isFound = false;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isPair(cur)) {
                ret.add(cur);
                isFound = true;
            }
            if (isFound) {
                continue;
            }
            // 开始搜索
            for (int i = 0; i < cur.length(); i++) {
                String str;
                if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                    if (i == cur.length() - 1) {
                        str = cur.substring(0, cur.length() - 1);
                    } else {
                        str = cur.substring(0, i) + cur.substring(i + 1);
                    }
                    if (set.add(str)) {
                        queue.offer(str);
                    }
                }
            }
        }
        if (ret.isEmpty()) {
            ret.add("");
        }
        return ret;
    }

    // 验证括号是否是成对的
    private boolean isPair(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                if (count != 0) {
                    count--;
                } else {
                    return false;
                }
            }
        }
        return count == 0;
    }

}
