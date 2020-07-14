package formalMap;

/**
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 *
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 *
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 *
 * 示例 1:
 *
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * 示例 2:
 *
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 *
 * *****/

//两两uf来解决
public class minSwapsCouples_765 {
    //根结点数组
    private int[] parent;

    public static void main(String[] args) {
        int[] nums = new int[]{0,2,1,3};
        minSwapsCouples_765 kobe = new minSwapsCouples_765();
        System.out.println(kobe.minSwapsCouples(nums));
    }


    //情侣是一对一对的
    public int minSwapsCouples(int[] row) {
        if (row.length==0){
            return 0;
        }
        int len = row.length;
        parent = new int[len];
        //让两个情侣的根结点都是小点数
        for (int i=0;i<len;i+=2){
            parent[i] = i;
            parent[i+1] = i;
        }
        int res = len/2;
        //对相邻两个数进行两两合并
        for (int i=0;i<len;i+=2){
            union(row[i],row[i+1]);
        }
        //对根结点排查，如果是自己代表不需要移动,每次减去连通块个数
        for (int i=0;i<len;i++){
            if (parent[i]==i){
                res--;
            }
        }
        return res;
    }

    private void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
        if (rootp==rootq){
            return;
        }
        parent[rootq] = rootp;
    }


    private int find(int x){
        while (parent[x] != x){
            //路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;

    }


}
