package review;

import java.util.Stack;

public class Solution_422 {

    /**
     * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
     * <p>
     * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，
     * 但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。
     * 网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     * 示例 1：
     * <p>
     * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
     * 输出：16
     * 解释：它的周长是上面图片中的 16 个黄色的边
     */
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        res -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列
     * 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
     * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
     * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
     * <p>
     * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，
     * 你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：false
     * 解释：序列中不存在 132 模式的子序列。
     * <p>
     * 输入：nums = [3,1,4,2]
     * 输出：true
     * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int len = nums.length - 1;
        Stack<Integer> stack = new Stack<>();
        // 最后的数
        int last = Integer.MIN_VALUE;
        for (int i = len; i >= 0; i--) {
            if (nums[i] < last) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                last = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }


}
