package Sreach;

import java.util.LinkedList;
import java.util.List;


/**
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * 示例 1：
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 *
 * ***/
public class splitIntoFibonacci_842 {

    public List<Integer> splitIntoFibonacci(String S) {
        LinkedList<Integer> res=new LinkedList<>();
        dfs(S,0,res);
        return res;
    }

    public boolean dfs(String S,int index,List<Integer> lis){
        if (index == S.length()) {
            return lis.size()>2;
        }
        for (int i=index+1;i<=S.length();i++) {
            String temp=S.substring(index,i);
            //长度大于10,或者Long解析出来大于INT_MAX了就直接break
            if (S.charAt(index) == '0' && i>index+1 || temp.length()>10 || Long.valueOf(temp)>Integer.MAX_VALUE) {
                break;
            }
            int str=Integer.valueOf(temp);
            int one=lis.size()>=2 ? lis.get(lis.size()-1):-1;
            int two=lis.size()>=2 ? lis.get(lis.size()-2):-1;
            lis.add(str);
            if ((one==-1 || two==-1 || one+two==str) && dfs(S,i,lis)) {
                return true;
            }
            lis.remove(lis.size()-1);
        }
        return false;
    }
}
