package HuisuDigui;


import java.util.Arrays;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 ***/
public class canPartition_416 {


    // 动态规划解法
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        // 判断是否能分成两个子集
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int size = sum / 2;
        // 动态规划判断背包问题,判断是否能装满这个容量为一半的背包
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        // 遍历数组，可以知道那些容量下的背包是满的
        if (nums[0] <= size) {
            dp[nums[0]] = true;
        }
        // 动态规划
        for (int i = 1; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                // 提前返回
                if (dp[size]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[size];

    }

    // 记忆化搜索解法
    private int[][] memo;

    public boolean canPartition1(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        // 判断是否能分成两个子集
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int size = sum / 2;
        this.memo = new int[nums.length][size + 1];
        // 记忆化数组初始化
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(nums, size, nums.length - 1);
    }

    private boolean dfs(int[] nums, int sum, int index) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || index < 0) {
            return false;
        }
        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }
        // 选择背或者不背
        memo[index][sum] = (dfs(nums, sum, index - 1) || dfs(nums, sum - nums[index], index - 1)) ? 1 : 0;
        return memo[index][sum] == 1;
    }
}
