/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * ****/
package day;

import java.util.HashMap;
import java.util.Map;

public class SubarraysDivByK_947 {

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
    }

    /**此方法超时了**/
//    public static int subarraysDivByK(int[] A, int K) {
//        int len = A.length;
//        if (len==0){
//            return -1;
//        }
//        int count = 0;
//        for (int i=0;i<len;i++){
//            int sum = 0;
//            for (int j=i;j<len;j++){
//                sum += A[j];
//                if (sum%K==0){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
    public static int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

}
