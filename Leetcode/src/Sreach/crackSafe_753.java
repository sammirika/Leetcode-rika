package Sreach;

import java.util.HashSet;
import java.util.Set;

/***
 * 有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。
 * 你可以随意输入密码，保险箱会自动记住最后 n位输入，如果匹配，则能够打开保险箱。
 * 举个例子，假设密码是"345"，你可以输入"012345"来打开它，只是你输入了 6 个字符.
 * 请返回一个能打开保险箱的最短字符串。
 *
 *
 * 示例1:
 *
 * 输入: n = 1, k = 2
 * 输出: "01"
 * 说明: "10"也可以打开保险箱。
 *
 * 示例2:
 *
 * 输入: n = 2, k = 2
 * 输出: "00110"
 * 说明: "01100", "10011", "11001" 也能打开保险箱。
 *
 * ****/
public class crackSafe_753 {

    // 从00.. n个0的字符串为起点一直到k-1....为终点，一笔画带过,欧拉回路问题

    // set保存排列组合
    private Set<String> set = new HashSet<>();
    private StringBuilder str = new StringBuilder();
    public String crackSafe(int n, int k) {
        if (n==0 && k == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n-1;i++){
            sb.append(0);
        }
        String start = sb.toString();
        dfs(start,k);
        // 最后需要加入start
        str.append(start);
        return str.toString();
    }

    // 回溯寻找欧拉回路
    private void dfs(String start, int k){
        for (int i=0;i<k;i++){
            String temp = start + i;
            // 不同的回路需要加入到ans中
            if (!set.contains(temp)){
                set.add(temp);
                dfs(temp.substring(1),k);
                str.append(i);
            }
        }
    }

    public static void main(String[] args) {
        crackSafe_753 kobe = new crackSafe_753();
        System.out.println(kobe.crackSafe(1,2));
    }
}
