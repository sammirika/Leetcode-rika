package String;

import java.util.Stack;

/**
 *
 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。



 示例 1：

 输入："cdadabcc"
 输出："adbc"
 示例 2：

 输入："abcd"
 输出："abcd"
 *
 * ***/
public class smallestSubsequence_1081 {

    public static void main(String[] args) {
        System.out.println(smallestSubsequence("cdadabcc"));
    }

    //单调栈解决
    public static String smallestSubsequence(String text) {
        if(text.length() <= 1) {
            return text;
        }
        Stack<Character> stack = new Stack<>();
        for (int i=0; i< text.length(); i++){
            if (stack.contains(text.charAt(i))){
                continue;
            }
            while (!stack.empty() && stack.peek() > text.charAt(i) && text.indexOf(stack.peek(),i) != -1){
                stack.pop();
            }
            stack.push(text.charAt(i));
        }

        StringBuffer str = new StringBuffer();
        while (!stack.empty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
