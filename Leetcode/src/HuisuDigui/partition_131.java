package HuisuDigui;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 ****/
public class partition_131 {

    public static void main(String[] args) {
        partition_131 kobe = new partition_131();
        List<List<String>> lists = kobe.partition("aab");
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        dfs(s, list);
        return res;
    }

    // 递归,利用参数s的长度来递归
    private void dfs(String s, List<String> list) {
        int len = s.length();
        if (len == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            String temp = s.substring(0, i + 1);
            if (isParlimer(temp)) {
                list.add(temp);
                String rest = s.substring(i + 1, len);
                dfs(rest, list);
                list.remove(list.size() - 1);
            }
        }
    }

    //判断回文字符串
    private boolean isParlimer(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
