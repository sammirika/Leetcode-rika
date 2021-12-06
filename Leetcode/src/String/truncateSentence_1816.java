package String;

/**
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。
 * 每个单词仅由大小写英文字母组成（不含标点符号）。
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s​​​​​​ 和一个整数 k​​​​​​ ，请你将 s​​ 截断 ​，​​​使截断后的句子仅含 前 k​​​​​​ 个单词。返回 截断 s​​​​​​ 后得到的句子。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello how are you Contestant", k = 4
 * 输出："Hello how are you"
 * 解释：
 * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
 * 前 4 个单词为 ["Hello", "how", "are", "you"]
 * 因此，应当返回 "Hello how are you"
 */
public class truncateSentence_1816 {

    public static String truncateSentence(String s, int k) {
        // 已空格分割
        String[] arr = s.split(" ");
        if (k >= arr.length) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                str.append(arr[i]);
            } else {
                str.append(arr[i]);
                str.append(" ");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
    }
}
