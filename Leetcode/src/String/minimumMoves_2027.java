package String;

/**
 * 给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
 * 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。注意，如果字符已经是 'O' ，
 * 只需要保持 不变 。
 * 返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "XXX"
 * 输出：1
 * 解释：XXX -> OOO
 * 一次操作，选中全部 3 个字符，并将它们转换为 'O' 。
 * 示例 2：
 * <p>
 * 输入：s = "XXOX"
 * 输出：2
 * 解释：XXOX -> OOOX -> OOOO
 * 第一次操作，选择前 3 个字符，并将这些字符转换为 'O' 。
 * 然后，选中后 3 个字符，并执行转换。最终得到的字符串全由字符 'O' 组成。
 */
public class minimumMoves_2027 {

    public int minimumMoves(String s) {
        int len = s.length();
        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'X') {
                ret++;
                i += 2;
            }
        }
        return ret;
    }
}
