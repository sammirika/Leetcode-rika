package String;

/**
 *
 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

 示例 1:

 输入: "abab"

 输出: True

 解释: 可由子字符串 "ab" 重复两次构成。
 示例 2:

 输入: "aba"

 输出: False
 * ****/
public class repeatedSubstringPattern_459 {

    //假设母串S是由子串s重复N次而成， 则 S+S则有子串s重复2N次，
    // 现在S=Ns， S+S=2Ns 因此S在(S+S)[1:-1]中必出现一次以上
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
