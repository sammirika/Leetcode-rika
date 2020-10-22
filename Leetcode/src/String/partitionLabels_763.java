package String;

import java.util.ArrayList;
import java.util.List;


/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 ***/
public class partitionLabels_763 {

    public static List<Integer> partitionLabels(String S) {

        if (S == null || S.length() == 0) {
            return new ArrayList<>();
        }
        // 利用hash特性计算,找到最后一次出现位置
        int[] hash = new int[26];
        // 找到最后一次出现的位置
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < S.length()) {
            int index = hash[S.charAt(i) - 'a'];
            for (int j = i + 1; j < index && j < S.length(); j++) {
                if (hash[S.charAt(j) - 'a'] > index) {
                    index = hash[S.charAt(j) - 'a'];
                }
            }
            res.add(index - i + 1);
            i = index + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
