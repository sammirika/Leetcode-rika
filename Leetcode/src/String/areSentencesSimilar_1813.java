package String;

/**
 * 一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。
 * 比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
 * 如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）
 * 而得到另一个句子，那么我们称这两个句子是 相似的 。
 * 比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，
 * 我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
 * 给你两个句子 sentence1 和 sentence2 ，
 * 如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
 * 输出：true
 * 解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
 * 示例 2：
 * <p>
 * 输入：sentence1 = "of", sentence2 = "A lot of words"
 * 输出：false
 * 解释：没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
 */
public class areSentencesSimilar_1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] word1 = sentence1.split(" ");
        String[] word2 = sentence2.split(" ");
        int i = 0;
        int j = 0;
        int m = word1.length;
        int n = word2.length;
        // 找头尾
        while (i < m && i < n && word1[i].equals(word2[i])) {
            i++;
        }

        while (j < m - i && j < n - i && word1[m - j - 1].equals(word2[n - j - 1])) {
            j++;
        }

        return i + j == Math.min(m, n);
    }
}
