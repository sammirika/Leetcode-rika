package Brainteasers;

/**
 * 小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
 * 如果小镇法官真的存在，那么：
 * 小镇法官不会信任任何人。
 * 每个人（除了小镇法官）都信任这位小镇法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
 * 如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, trust = [[1,2]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 3, trust = [[1,3],[2,3]]
 * 输出：3
 */
public class findJudge_997 {

    public int findJudge(int n, int[][] trust) {
        int[] hash = new int[n + 1];
        int[] count = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            hash[a]++;
            count[b]++;
        }
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0 && count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
