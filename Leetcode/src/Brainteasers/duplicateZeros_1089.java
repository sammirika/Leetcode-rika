package Brainteasers;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 */
public class duplicateZeros_1089 {

    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int countZero = 0;
        for (int num : arr) {
            if (num == 0) {
                countZero++;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                countZero--;
            }
            if (i + countZero < len) {
                arr[i + countZero] = arr[i];
                // 如果arr[i]为0
                if (arr[i] == 0 && i + countZero + 1 < len) {
                    arr[i + countZero + 1] = 0;
                }
            }
        }
    }
}
