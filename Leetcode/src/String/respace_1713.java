package String;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 *
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 *
 * ****/
public class respace_1713 {

    public static void main(String[] args) {
        System.out.println(respace(new String[]{"looked","just","like","her","brother"},"jesslookedjustliketimherbrother"));
    }


    //动态计划计算，这里本身也是用字典来分字符，容易误导
    public static int respace(String[] dictionary, String sentence) {
        //把字典加入set
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int len = sentence.length();
        int[] dp = new int[len+1];
        for (int i=1;i<=len;i++){
            dp[i] = dp[i-1] + 1;
            for (int j=0;j<i;j++){
                if (set.contains(sentence.substring(j,i))){
                    dp[i] = Math.min(dp[i],dp[j]);
                }
            }
        }
        return dp[len];

    }
}
