/**
 *
 给定一个经过编码的字符串，返回它解码后的字符串。
 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 示例:
 s = "3[a]2[bc]", 返回 "aaabcbc".
 s = "3[a2[c]]", 返回 "accaccacc".
 s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * ****/

package day;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class DecodeString_394 {

    public static void main(String[] args) {
        DecodeString_394 kobe = new DecodeString_394();
        System.out.println(kobe.decodeString("2[abc]3[cd]ef"));
    }

    //全局变量记录字符移动
    int ptr;
    //使用栈求解
    public String decodeString(String s) {
        Stack<String> stk = new Stack<>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.push(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.push(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                Stack<String> sub = new Stack<>();
                while (!"[".equals(stk.peek())) {
                    sub.push(stk.pop());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.pop();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.pop());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.push(t.toString());
            }
        }

        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(Stack<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
