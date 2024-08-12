package SystemDesign;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，
 * 使得所形成的新单词存在于你构建的字典中。
 * 实现 MagicDictionary 类：
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，
 * dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，
 * 判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。
 * 如果可以，返回 true ；否则，返回 false 。
 * 示例：
 * <p>
 * 输入
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 * <p>
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 */
public class MagicDictionary_676 {


    List<String> set;

    public MagicDictionary_676() {
        // 初始化
        set = new ArrayList<>();
    }

    public void buildDict(String[] dictionary) {
        for (String dic : dictionary) {
            set.add(dic);
        }
    }

    public boolean search(String searchWord) {
        int count = 0;
        for (String str : set) {
            for (int i = 0; i < str.length(); i++) {
                if (str.length() != searchWord.length()) {
                    continue;
                    //继续搜
                }
                if (str.charAt(i) != searchWord.charAt(i)) {
                    count++;
                }
            }
            if (count == 1) {
                return true;
            } else {
                count = 0;
            }
        }
        return false;
    }


}
