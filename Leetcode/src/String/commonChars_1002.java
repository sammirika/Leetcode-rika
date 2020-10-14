package String;

import java.util.ArrayList;
import java.util.List;

/***
 *
 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

 你可以按任意顺序返回答案。


 示例 1：

 输入：["bella","label","roller"]
 输出：["e","l","l"]
 示例 2：

 输入：["cool","lock","cook"]
 输出：["c","o"]
 * ***/
public class commonChars_1002 {


    public static List<String> commonChars(String[] A) {
        int[] hash = new int[26];
        for (char ch : A[0].toCharArray()) {
            hash[ch - 'a']++;
        }
        // 对hash的元素进行比较，每次取最小出现次数
        for (int i = 1; i < A.length; i++) {
            int[] temp = new int[26];
            for (char ch : A[i].toCharArray()) {
                temp[ch - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                hash[j] = Math.min(hash[j], temp[j]);
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int count = 0; count < hash[i]; count++) {
                str.append((char) (i + 'a'));
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            res.add(str.substring(i, i + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
    }
}
