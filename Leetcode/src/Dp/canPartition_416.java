package Dp;


/**
 *
 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

 注意:

 每个数组中的元素不会超过 100
 数组的大小不会超过 200
 示例 1:

 输入: [1, 5, 11, 5]

 输出: true

 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * ****/
public class canPartition_416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        // 求出数组的和，因为这里的分隔我们是以sum/2的背包来进行计算
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 必须是偶数
        if (sum % 2 != 0) {
            return false;
        }
        int C = sum / 2;
        // 定义容量为sum/2+1的dp数组，如果出现某一刻dp 数组的值为true证明找到目标分割
        boolean[] dp = new boolean[C + 1];
        // 判断是否直接可以直接填满背包
        for (int i = 0; i <= C; i++) {
            dp[i] = (nums[0] == i);
        }

        //双重循环，动态规划,num[0]已经计算过了
        for (int i = 1; i < nums.length; i++) {
            for (int j = C; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[C];
    }


    // 递归解法，使用记忆化搜索
    private int[][] memo;

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        // 求出数组的和，因为这里的分隔我们是以sum/2的背包来进行计算
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 必须是偶数
        if (sum % 2 != 0) {
            return false;
        }
        this.memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                memo[i][j] = -1;
            }
        }
        return getPartition(nums, sum / 2, nums.length - 1);

    }

    private boolean getPartition(int[] nums, int sum, int index) {
        if (sum == 0) {
            return true;
        }
        // 如果包里面的超了或者搜索完都没找到，返回false
        if (sum < 0 || index < 0) {
            return false;
        }
        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }
        memo[index][sum] = (getPartition(nums, sum, index - 1) || getPartition(nums, sum - nums[index], index - 1)) ? 1 : 0;
        return memo[index][sum] == 1;
    }
}
