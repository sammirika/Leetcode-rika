package Hash;

/**
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 *  s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。
 * "aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 * 示例 1：
 * <p>
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: strs = ["aaa","aaa","aa"]
 * 输出: -1
 */
public class findLUSlength_522 {

    public int findLUSlength(String[] strs) {
        int len = strs.length;
        int ret = -1;
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && isSubstr(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            //
            if (flag) {
                ret = Math.max(ret, strs[i].length());
            }
            flag = true;
        }
        return ret;
    }

    // 判断是否可以通过删除得到
    private boolean isSubstr(String A, String B) {
        int len1 = A.length();
        int len2 = B.length();
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 && index2 < len2) {
            if (A.charAt(index1) == B.charAt(index2)) {
                index1++;
            }
            index2++;
        }
        return index1 == len1;
    }
}
