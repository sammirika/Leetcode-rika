package Dp;


/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * ******/
public class maxProfit_714 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9},2));
    }

    public static int maxProfit(int[] prices, int fee) {
        if (prices.length<1){
            return 0;
        }
        //A,B代表两种状态，一种是持有，一种是不持有
        int[] A = new int[prices.length];
        int[] B = new int[prices.length];
        A[0] = -prices[0];
        B[0] = 0;
        for (int i=1;i<prices.length;i++){
            A[i] = Math.max(A[i-1],B[i-1]-prices[i]);
            B[i] = Math.max(B[i-1],prices[i]+A[i-1]-fee);
        }
        return B[prices.length-1];
    }
}
