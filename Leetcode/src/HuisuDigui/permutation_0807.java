package HuisuDigui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *
 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。

 示例1:

 输入：S = "qwe"
 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 示例2:

 输入：S = "ab"
 输出：["ab", "ba"]
 * ***/
public class permutation_0807 {
    public static void main(String[] args) {
        permutation_0807 kobe = new permutation_0807();
        String[] array = kobe.permutation("qwe");
        for (String A:array){
            System.out.println(A);
        }
    }

    char[] array;
    List<String> set = new ArrayList<>();

    public String[] permutation(String S) {
        array = S.toCharArray();
        boolean[] visit = new boolean[array.length];
        bfs(new StringBuffer(),0,visit);
        return set.toArray(new String[0]);

    }
    private void bfs(StringBuffer str, int depth, boolean[] visit){
        if (depth==array.length){
            set.add(str.toString());
            return;
        }
        for (int i=0;i<array.length;i++){
            if (!visit[i]){
                visit[i] = true;
                str.append(array[i]);
                bfs(str,depth+1,visit);
                //剪枝
                visit[i] = false;
                str.deleteCharAt(str.length()-1);
            }
        }
    }
}
