package tanxin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——
 * 我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，
 * 可以形成新的单词 another(另一个)。
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。
 * 你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 你需要输出替换之后的句子。
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 * <p>
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 */
public class replaceWords_648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word);
        }
        String[] array = sentence.split(" ");
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            for (int j = 0; j < str.length(); j++) {
                if (set.contains(str.substring(0, 1 + j))) {
                    array[i] = str.substring(0, 1 + j);
                    break;
                }
            }
        }
        return String.join(" ", array);
    }
}
