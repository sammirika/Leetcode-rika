package kexin;
/**
 * {{1,2,15},{2,3,20},{2,4,5},{2,5,30}}
 * 计算二维数组中最后个数的和
 * ****/
public class CaculateArray {
    public static void main(String[] args) {
        System.out.println(funtion(new int[][]{{1,2,15},{2,3,20},{2,4,5},{2,5,30}}));
    }

    public static int funtion(int[][] num){
        int sum = 0;
        for(int[] temp:num){
            for (int i=0;i<temp.length;i++){
                if (i==temp.length-1){
                    sum += temp[i];
                }
            }
        }
        return sum;
    }
}
