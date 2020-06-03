/***
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 * 解释：本示例答案不唯一。
 * 按此输出 A = "()()", B = "()()", max(depth(A), depth(B)) = 1，它们的深度最小。
 * 像 [1,1,1,0,0,1,1,1]，也是正确结果，其中 A = "()()()", B = "()", max(depth(A), depth(B)) = 1 。
 *
 * ****/
package stack;

public class MaxDepthAfterSplit_1111 {

    //可以使得栈深度为最小的分配方式就是最为合理的分配方式，这里选择
    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.equals("")) return new int[0];
        int depth=0;
        int[] res = new int[seq.length()];
        //遍历
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {//入栈,栈内深度增加
                res[i] = ++depth % 2;
            } else {//出栈，栈内深度减少
                res[i] = depth-- % 2;
            }
        }
        return res;
    }
}
