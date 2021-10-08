package HuisuDigui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。
 * 在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *  
 * 示例 1：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 */
public class findRepeatedDnaSequences_187 {

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<>();
        int len = s.length();
        int left = 0;
        if (len < 10) {
            return ret;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= len; i++) {
            String str = s.substring(left++, i);
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        for (String temp : map.keySet()) {
            if (map.get(temp) > 1) {
                ret.add(temp);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
