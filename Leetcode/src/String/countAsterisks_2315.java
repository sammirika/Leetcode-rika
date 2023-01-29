package String;

/**
 * 给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
 * 请你返回 不在 竖线对之间，s 中 '*' 的数目。
 * 注意，每个竖线 '|' 都会 恰好 属于一个对。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "l|*e*et|c**o|*de|"
 * 输出：2
 * 解释：不在竖线对之间的字符加粗加斜体后，得到字符串："l|*e*et|c**o|*de|" 。
 * 第一和第二条竖线 '|' 之间的字符不计入答案。
 * 同时，第三条和第四条竖线 '|' 之间的字符也不计入答案。
 * 不在竖线对之间总共有 2 个星号，所以我们返回 2 。
 * 示例 2：
 * <p>
 * 输入：s = "iamprogrammer"
 * 输出：0
 * 解释：在这个例子中，s 中没有星号。所以返回 0 。
 */
public class countAsterisks_2315 {

    public int countAsterisks(String s) {
        int ret = 0;
        int len = s.length();
        boolean flag = true;
        char[] array = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (array[i] == '|') {
                flag = !flag;
            }
            if (flag && array[i] == '*') {
                ret++;
            }
        }
        return ret;
    }
}
