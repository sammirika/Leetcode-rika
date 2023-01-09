package Sreach;

/**
 * 给你一个偶数 n​​​​​​ ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i​（下标 从 0 开始 计数）。
 * 一步操作中，你将创建一个新数组 arr ，对于每个 i ：
 * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
 * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 * 然后将 arr​​ 赋值​​给 perm 。
 * <p>
 * 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：最初，perm = [0,1]
 * 第 1 步操作后，perm = [0,1]
 * 所以，仅需执行 1 步操作
 * 示例 2：
 * <p>
 * 输入：n = 4
 * 输出：2
 * 解释：最初，perm = [0,1,2,3]
 * 第 1 步操作后，perm = [0,2,1,3]
 * 第 2 步操作后，perm = [0,1,2,3]
 * 所以，仅需执行 2 步操作
 */
public class reinitializePermutation_1806 {

    public int reinitializePermutation(int n) {
        if (n == 2) {
            return 1;
        }
        // 搜索,看是否所有的数都出现了;能形成闭环
        int ret = 1;
        boolean[] isVisit = new boolean[n];
        for (int i = 1; i < n - 1; i++) {
            int count = 0;
            int j = i;
            while (!isVisit[j]) {
                isVisit[j] = true;
                count++;
                j = j % 2 == 0 ? j / 2 : n / 2 + (j - 1) / 2;
            }
            ret = Math.max(ret, count);
        }
        return ret;
    }
}
