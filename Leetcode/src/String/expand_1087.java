package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 我们用一个特殊的字符串 S 来表示一份单词列表，之所以能展开成为一个列表，是因为这个字符串 S 中存在一个叫做「选项」的概念：
 * <p>
 * 单词中的每个字母可能只有一个选项或存在多个备选项。如果只有一个选项，那么该字母按原样表示。
 * <p>
 * 如果存在多个选项，就会以花括号包裹来表示这些选项（使它们与其他字母分隔开），例如 "{a,b,c}" 表示 ["a", "b", "c"]。
 * <p>
 * 例子："{a,b,c}d{e,f}" 可以表示单词列表 ["ade", "adf", "bde", "bdf", "cde", "cdf"]。
 * <p>
 * 请你按字典顺序，返回所有以这种方式形成的单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："{a,b}c{d,e}f"
 * 输出：["acdf","acef","bcdf","bcef"]
 * 示例 2：
 * <p>
 * 输入："abcd"
 * 输出：["abcd"]
 *****/
public class expand_1087 {

    List<String> res = new ArrayList<>();

    public String[] expand(String S) {
        if (S.indexOf('{') == -1) {
            return new String[]{S};
        }
        dfs(S, new StringBuilder(), 0);
        Collections.sort(res);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(String S, StringBuilder str, int index) {
        // 加入res
        if (index == S.length()) {
            res.add(str.toString());
            return;
        }

        if (S.charAt(index) == '{') {
            // 统计{}中间的字符数目
            int count = 0;
            for (int i = index + 1; S.charAt(i) != '}'; i++) {
                count++;
            }
            // 每次对{}里的字母进行回溯
            for (int i = index + 1; S.charAt(i) != '}'; i++) {
                char ch = S.charAt(i);
                if (ch != ',') {
                    str.append(ch);
                    // 每次跳过一个{}
                    dfs(S, str, index + count + 2);
                    str.deleteCharAt(str.length() - 1);
                }
            }
        } else {
            // 常规情况按全排列进行回溯
            str.append(S.charAt(index));
            dfs(S, str, index + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        expand_1087 kobe = new expand_1087();
        String[] resluts = kobe.expand("{a,b}c{d,e}f");
        for (String reslut : resluts) {
            System.out.println(reslut);
        }
    }
}
