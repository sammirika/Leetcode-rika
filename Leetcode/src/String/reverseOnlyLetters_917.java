package String;

import java.util.Stack;

/**
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 * 示例 1：
 * <p>
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * <p>
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 */
public class reverseOnlyLetters_917 {

    // 标记法
    public String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        boolean[] visit = new boolean[101];
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >= 'a' && array[i] <= 'z') || (array[i] >= 'A' && array[i] <= 'Z')) {
                stack.push(array[i]);
                visit[i] = true;
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (visit[i]) {
                str.append(stack.pop());
            } else {
                str.append(array[i]);
            }
        }
        return str.toString();
    }

    //双指针
    public String reverseOnlyLetters1(String s) {
        char[] array = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetter(array[left])) {
                left++;
            }
            if (!Character.isLetter(array[right])) {
                right--;
            }
            if (Character.isLetter(array[left]) && Character.isLetter(array[right])) {
                char tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(array);
    }

}
