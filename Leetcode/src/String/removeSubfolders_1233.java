package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
 * 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * 输出：["/a","/c/d","/c/f"]
 * 解释："/a/b/" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 * 示例 2：
 * <p>
 * 输入：folder = ["/a","/a/b/c","/a/b/d"]
 * 输出：["/a"]
 * 解释：文件夹 "/a/b/c" 和 "/a/b/d/" 都会被删除，因为它们都是 "/a" 的子文件夹。
 */
public class removeSubfolders_1233 {

    public List<String> removeSubfolders(String[] folder) {
        // 先按字典排序
        Arrays.sort(folder);
        List<String> ret = new ArrayList<>();
        ret.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            int m = ret.get(ret.size() - 1).length();
            int n = folder[i].length();
            if (m >= n || !(ret.get(ret.size() - 1).equals(folder[i].substring(0, m)) && folder[i].charAt(m) == '/')) {
                ret.add(folder[i]);
            }
        }
        return ret;
    }
}
