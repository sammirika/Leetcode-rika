package String;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 示例 2：
 * <p>
 * 输入：s = "fviefuro"
 * 输出："45"
 */
public class originalDigits_423 {

    public static String originalDigits(String s) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        // 利用hash的特性
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }
        // 从零开始拼凑
        int count = s.length();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        boolean flag = false;
        while (count > 0) {
            for (int i = 0; i <= 9; i++) {
                String num = map.get(i);
                int tmp = 0;
                for (char ch : num.toCharArray()) {
                    if (hash[ch - 'a'] <= 0) {
                        break;
                    }
                    if (hash[ch - 'a'] > 0) {
                        tmp++;
                    }
                }
                if (tmp == num.length()) {
                    for (char ch : num.toCharArray()) {
                        hash[ch - 'a']--;
                    }
                    count -= tmp;
                    queue.offer(i);
                    flag = true;
                }
            }
            if (!flag) {
                return "";
            }
        }
        StringBuilder ret = new StringBuilder();
        while (!queue.isEmpty()) {
            ret.append(queue.poll());
        }
        return ret.toString();
    }
    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));
    }
}
