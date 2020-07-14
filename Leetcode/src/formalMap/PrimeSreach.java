package formalMap;

//prim算法求最小生成树
public class PrimeSreach {

    //存放每个点的数组
    private char[] mVex;
    //邻接矩阵
    private int[][] Martix;

    public static final int INF = Integer.MAX_VALUE;

    public PrimeSreach(char[] mVex, int[][] Martix){
        this.mVex = mVex;
        this.Martix = Martix;
    }

    //prim 算法实现
    private char[] prim(int start){
        int len = mVex.length;
        //最小生成树的保存数组
        char[] prim = new char[len];
        int[] wight = new int[len];
        //记录最小生成树每个点的生成
        int index = 0;
        //直接加入起点
        prim[index++] = mVex[start];
        for (int i=0;i<len;i++){
            wight[i] = Martix[start][i];
        }
        //自己到自己为0
        wight[start] = 0;
        //贪心
        for (int i=1;i<len;i++){
            //两个变量
            int m=0;
            int n=0;
            int min = INF;
            //找出距离最小生成树最近的点
            while (m<len){
                if (wight[m]!=0 && wight[m]<min){
                    min = wight[m];
                    n = m;
                }
                m++;
            }
            prim[index++] = mVex[n];
            wight[n] = 0;
            //更新每个点到最小生成树的距离
            for (m=0;m<len;m++){
                if (wight[m]!=0){
                    wight[m] = Math.min(wight[m],Martix[n][m]);
                }
            }
        }

        return prim;
    }

    //求点在矩阵中的位置
    private int getPosition(char ch){
        for (int i=0;i<mVex.length;i++){
            if (ch == mVex[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] nums = new char[]{'A','B','C','D','E','F','G'};
        int[][] Martix = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        PrimeSreach kobe = new PrimeSreach(nums,Martix);
        char[] array = kobe.prim(0);
        for (char ch:array){
            System.out.println(ch);
        }
        //通过最小生成树求最小生成树权值
        int sum = 0;
        for (int i=1;i<array.length;i++){
            int min = INF;
            int n = kobe.getPosition(array[i]);
            //每次求0～i到j的最小权值
            for (int j=0;j<i;j++){
                int m = kobe.getPosition(array[j]);
                min = Math.min(min,Martix[m][n]);
            }
            sum += min;
        }
        System.out.println(sum);
    }
}
