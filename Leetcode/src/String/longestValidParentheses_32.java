package String;


import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * ***/
public class longestValidParentheses_32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("((()()"));
    }

    public static int longestValidParentheses(String s) {
        //用栈来计算
        Stack<Integer> stack = new Stack<>();
        int preIndex = 0;
        //nums数组来标记能括号的点，能括号1，不能0，最后就变成了求最长连续有效1
        int[] nums = new int[s.length()];
        while (preIndex<s.length()){
            if (s.charAt(preIndex)=='('){
                stack.push(preIndex);
            }else if (!stack.empty() && s.charAt(preIndex)==')'){
                nums[stack.pop()] = 1;
                nums[preIndex] = 1;
            }
            preIndex++;
        }
        //这样nums就变成了1，1，0，1，1求连续的1的最大长度即可
        int max = 0;
        int tmp = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==1){
                tmp++;
                max = Math.max(tmp,max);
            }else {
                tmp = 0;
            }
        }
        return max;
    }
}
