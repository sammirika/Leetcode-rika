package String;

/**
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 * <p>
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 * <p>
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 */
public class diStringMatch_942 {

    public static int[] diStringMatch(String s) {
        int len = s.length() + 1;
        int[] ans = new int[len];
        int t = 0;
        for (int i = 0; i < len-1; i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = t++;
            }
        }
        t = len - 1;
        for (int i = 0; i < len-1; i++) {
            if (s.charAt(i) == 'D') {
                ans[i] = t--;
            }
        }
        ans[len - 1] = t;
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = diStringMatch("IDID");
        for (int num : ans) {
            System.out.println(num);
        }
    }
}
