package String;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 *
 */
public class lengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        if (s.length() < 1){
            return 0;
        }
        int count = 1;
        int index = s.length()-1;
        while (index >= 0){
            if (s.charAt(index) == ' '){
                index--;
                continue;
            }else if (s.charAt(index) != ' '){
                while (index >= 0 && s.charAt(index) != ' '){
                    count++;
                    index--;
                }
                break;
            }
        }
        return count;
    }
}
