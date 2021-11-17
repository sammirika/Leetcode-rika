package String;

/***
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
 * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 */
public class maxProduct_318 {

    public static int maxProduct(String[] words) {
        //  使用位运算求解
        int len = words.length;
        int[] mask = new int[len];
        int index = 0;
        for (String str : words) {
            int t = 0;
            for (int i = 0; i < str.length(); i++) {
                int num = str.charAt(i) - 'a';
                t |= (1 << num);
            }
            mask[index++] = t;
        }
        int ret = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(1 | 11);
    }
}
