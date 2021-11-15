package FormalStruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 实现词典类 WordDictionary ：
 * <p>
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，
 * 返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 * 示例：
 * <p>
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * <p>
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 */
class WordDictionary {

    Map<Integer, List<String>> map;

    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        int len = word.length();
        if (map.containsKey(len)) {
            List<String> res = map.get(len);
            res.add(word);
            map.put(len, res);
        } else {
            List<String> res = new ArrayList<>();
            res.add(word);
            map.put(len, res);
        }
    }

    public boolean search(String word) {
        int len = word.length();
        if (!map.containsKey(len)) {
            return false;
        }
        List<String> res = map.get(len);
        for (int i = 0; i < res.size(); i++) {
            String str = res.get(i);
            for (int j = 0; j < str.length(); j++) {
                if (word.charAt(j) == '.' || word.charAt(j) == str.charAt(j)) {
                    if (j == str.length() - 1) {
                        return true;
                    }
                    continue;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
