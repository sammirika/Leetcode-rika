package day;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * **/

public class MySqrt {
    public static void main(String[] args) {
        System.out.println(MySqrt.mySqrt(2));
    }

    public static int mySqrt(int x) {
        if(x<2){
            return x;
        }
        int left = 2;
        int right = x/2;
        int aim;
        while (left<right){
            aim = left+(right-left)/2;
        }
        return right;

    }
}
