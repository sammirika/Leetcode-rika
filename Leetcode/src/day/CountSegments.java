/**
 * *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * ***/

package day;

public class CountSegments {

    public static void main(String[] args) {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }

    public static int countSegments(String s) {
        if (s==null || s.length()==0){
            return 0;
        }
        String[] array = s.split("/s");
        int count = 0;
        for (String S:array){
            if (S!=" "){
                count++;
            }
        }
        return count;
    }
}
