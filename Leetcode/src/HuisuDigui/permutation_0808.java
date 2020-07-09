package HuisuDigui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 *
 * ****/
public class permutation_0808 {

    public static void main(String[] args) {
        permutation_0808 kobe = new permutation_0808();
        String[] list = kobe.permutation("qqe");
        for (String A:list){
            System.out.println(A);
        }
    }

    //回溯
    char[] array;
    List<String> res = new ArrayList<>();
    public String[] permutation(String S) {
        StringBuffer str = new StringBuffer();
        array = S.toCharArray();
        Arrays.sort(array);
        boolean[] visit = new boolean[array.length];
        bfs(str,0,visit);
        return res.toArray(new String[0]);

    }

    private void bfs(StringBuffer str, int depth,boolean[] visit){
        if (depth==array.length){
            res.add(str.toString());
            return;
        }
        for (int i=0;i<array.length;i++){
            if (!visit[i]){
                if (i>0 && !visit[i-1] && array[i] == array[i-1]){
                    continue;
                }
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
