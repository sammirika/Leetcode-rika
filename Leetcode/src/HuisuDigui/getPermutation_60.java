package HuisuDigui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 ***/
public class getPermutation_60 {

    // 回溯超时
    List<String> res = new ArrayList<>();
    public String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }
        boolean[] visit = new boolean[n + 1];
        dfs(n, new StringBuilder(), visit);
        return res.get(k - 1);
    }

    private void dfs(int n, StringBuilder str, boolean[] visit) {

        if (str.length() == n) {
            res.add(str.toString());
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                str.append(i);
                dfs(n, str, visit);
                visit[i] = false;
                str.deleteCharAt(str.length() - 1);
            }
        }
    }

    // 数学方法
    public String getPermutation1(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        getPermutation_60 kobe = new getPermutation_60();
        System.out.println(kobe.getPermutation(4, 9));
    }
}
