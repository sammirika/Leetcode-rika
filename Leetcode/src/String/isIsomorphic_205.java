package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * ****/
public class isIsomorphic_205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab","aa"));
    }
    //映射就是用一个map来解决了
    public static boolean funtion(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        if (s==null && t==null){
            return true;
        }
        for (int i=0;i<s.length();i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)){
                if (map.get(a)!=b){
                    return false;
                }
            }else {
                map.put(a,b);
            }
        }
        return true;
    }
    private static boolean isIsomorphic(String s,String t){
        return funtion(s,t) && funtion(t,s);
    }
}
