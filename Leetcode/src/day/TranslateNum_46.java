package day;
/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * *****/
public class TranslateNum_46 {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }

    public static int translateNum(int num) {
        //可以转化为dp或者递归解决，递归的条件跟余数有关，如果余数>25条件就不一样
        //递归出口
        if(num<=9){
            return 1;
        }
        int temp = num%100;
        //如果新增后缀加上前一个数大于‘z’那么就没有新增作用
        if (temp<=9 || temp>=26){
            return translateNum(num/10);
        }else{
            return translateNum(num/10) + translateNum(num/100);
        }
    }
}
