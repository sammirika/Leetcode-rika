package day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 *
 * 最终结果按照字典顺序输出。
 *
 * 示例 1:
 *
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 ***/


public class LargeGroupPositions {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list = LargeGroupPositions.largeGroupPositions("abcdddeeeeaabbbcd");
        for(List<Integer> A:list){
            System.out.println(A);
        }
    }

    public static List<List<Integer>> largeGroupPositions(String S) {
        S = S+"A";
        List<List<Integer>> lists = new ArrayList<>();
        int count = 1;
        for(int i=0,j=1;i<S.length()&&j<S.length();i++){
            while(S.charAt(j)==S.charAt(i) && j<S.length()-1){
                count++;
                j++;
            }
            if(count>=3){
             lists.add(Arrays.asList(new Integer[]{i,j-1}));
            }
            count = 1;
            i = j-1;
            j++;
        }
        return lists;
    }
}
