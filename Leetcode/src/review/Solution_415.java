package review;

import day.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

public class Solution_415 {

    /**
     * 给定一组字符，使用原地算法将其压缩。
     * 压缩后的长度必须始终小于或等于原数组长度。
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
     * 在完成原地修改输入数组后，返回数组的新长度。
     * 进阶：
     * 你能否仅使用O(1) 空间解决问题？
     * 示例 1：
     * <p>
     * 输入：
     * ["a","a","b","b","c","c","c"]
     * <p>
     * 输出：
     * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
     * <p>
     * 说明：
     * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
     */
    public static int compress(char[] chars) {
        int len = chars.length;
        List<Character> list = new ArrayList<>();
        int[] hash = new int[127];
        for (char ch : chars) {
            hash[ch - '"']++;
        }
        for (char ch : chars) {
            if (hash[ch - '"'] == 1) {
                list.add(ch);
            } else if (hash[ch - '"'] > 1) {
                list.add(ch);
                list.add((char) (hash[ch - '"'] + 48));
                hash[ch - '"'] = 0;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i);
        }
        return list.size();
    }

    /**
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * 每条从根节点到叶节点的路径都代表一个数字：
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     * 叶节点 是指没有子节点的节点。
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [1,2,3]
     * 输出：25
     * 解释：
     * 从根到叶子节点路径 1->2 代表数字 12
     * 从根到叶子节点路径 1->3 代表数字 13
     * 因此，数字总和 = 12 + 13 = 25
     */

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        int temp = root.val + num * 10;
        if (root.left == null && root.right == null) {
            return temp;
        }
        return dfs(root.left, temp) + dfs(root.right, temp);
    }


    /**
     * 给出一个按 非递减 顺序排列的数组 nums，和一个目标数值 target。
     * 假如数组 nums 中绝大多数元素的数值都等于 target，则返回 True，否则请返回 False。
     * 所谓占绝大多数，是指在长度为 N 的数组中出现必须 超过 N/2 次。
     * <p>
     * 示例 1：
     * 输入：nums = [2,4,5,5,5,5,5,6,6], target = 5
     * 输出：true
     * 解释：
     * 数字 5 出现了 5 次，而数组的长度为 9。
     * 所以，5 在数组中占绝大多数，因为 5 次 > 9/2。
     */
    public boolean isMajorityElement(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        if (!map.containsKey(target) || map.get(target) <= nums.length / 2) {
            return false;
        }
        return true;
    }

    /**
     * 对于字符串 S 和 T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
     * <p>
     * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：str1 = "ABCABC", str2 = "ABC"
     * 输出："ABC"
     * 示例 2：
     * <p>
     * 输入：str1 = "ABABAB", str2 = "ABAB"
     * 输出："AB"
     */
    public String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    /**
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
     * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
     * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; i++) {
            int temp = nums[i % len];
            while (!stack.isEmpty() && nums[stack.peek()] < temp) {
                res[stack.pop()] = temp;
            }
            if (i < len) {
                stack.push(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println((char) 48);
    }
}
