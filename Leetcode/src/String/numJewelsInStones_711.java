package String;

/**
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 
 * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * ***/
public class numJewelsInStones_711 {

    public static int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0){
            return 0;
        }
        // hash索引
        int[] hash = new int[60];
        for (char ch:J.toCharArray()){
            hash[ch - 64]++;
        }
        int res = 0;
        for (char ch:S.toCharArray()){
            if (hash[ch - 64] == 1){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println('A' + 0);
        System.out.println(numJewelsInStones("aA","aAAbbbb"));
    }
}
