package String;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *****/
public class reverseWords_557 {

    // 字符串反序
    public static String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        String[] arrays = s.split(" ");
        StringBuilder str = new StringBuilder();
        int len = arrays.length;
        for (int i = 0; i < arrays.length - 1; i++) {
            str.append(new StringBuffer(arrays[i]).reverse());
            str.append(" ");
        }
        str.append(new StringBuffer(arrays[len - 1]).reverse());
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
