package Dp;

/**
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
 * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1, 5, 2]
 * 输出：False
 * 解释：一开始，玩家1可以从1和2中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 False 。
 * 示例 2：
 * <p>
 * 输入：[1, 5, 233, 7]
 * 输出：True
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 * 最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
 ***/
public class PredictTheWinner_486 {

    // 新建内部类表明先手还是后手
    class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }
        int len = nums.length;
        Pair[][] dp = new Pair[len][len];
        // 初始化dp数组
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        // 赋初值
        for (int i = 0; i < len; i++) {
            dp[i][i].first = nums[i];
            dp[i][i].second = 0;
        }
        // 动态规划
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int j = l + i - 1;
                // 计算先手左右分别的最大值
                int left = nums[i] + dp[i + 1][j].second;
                int right = nums[j] + dp[i][j - 1].second;
                if (left > right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }
        return dp[0][len - 1].first - dp[0][len - 1].second >= 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 2};
        PredictTheWinner_486 kobe = new PredictTheWinner_486();
        System.out.println(kobe.PredictTheWinner(nums));
    }
}
