package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * ***/
public class wordBreak_139 {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("leet");
        list.add("codes");
        System.out.println(wordBreak("leetcode",list));
    }

    //动态规划，每次从set里来比较前缀
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        //动态数组
        boolean[] dp = new boolean[s.length()+1];
        //空字符串怎么都是没问题的
        dp[0] = true;
        for (int i=1;i<=s.length();i++){
            for (int j=0;j<i;j++){
                //每次的起点必须是true
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    //直接找到true的点跳出
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
