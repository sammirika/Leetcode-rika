package day;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：equation = "3a-1=a+2"
 * 输出：1.50000
 * */


public class Solution {


    public static void main(String[] args) {
        String input = "3a-1=a+2";
        Solution S = new Solution();
        System.out.println(S.jisuan(input));
    }

    public  double jisuan(String str){

        String[] array = str.split("=");//把方程式以等号分割

        List<String> list = new ArrayList<String>();//定义一个list
        StringBuffer stringBuffer = new StringBuffer("");
        String[] left = array[0].split("\\+");//把等号左边的以加号分割
        for(int j = 0; j<left.length; j++){//遍历
            String[] c = left[j].split("-");//再以减号分割
            for (int k = 0; k < c.length; k++) {//遍历
                if(k%2 == 1){
                    c[k]="-"+c[k];
                }
                list.add(c[k]);
            }
        }
        String[] right = array[1].split("\\+");
        for(int j = 0; j<right.length; j++){//遍历
            String[] e = right[j].split("-");
            for (int k = 0; k < e.length; k++) {
                if(k%2 == 0){
                    e[k]="-"+e[k];
                }
                list.add(e[k]);
            }
        }
        double cSum = 0;
        double xSum = 0;
        for (int i = 0; i < list.size(); i++) {//遍历list
            String f = list.get(i);
            if(isContainX(f)){
                double changshu = Double.valueOf(f);
                cSum+=changshu;
            }else{
                String s = f.substring(0, f.length()-1);
                double xishu = Double.valueOf(s);
                xSum += xishu;
            }
        }
        if(cSum==0&&xSum==0){
            System.out.println("Infinite solutions");
        }else if(cSum!=0&&xSum==0){
            System.out.println("No solution");
        }else{
            double jieguo = cSum/xSum*(-1);
            System.out.println("x="+jieguo);
            return jieguo;
        }
        return 0;
    }
    private boolean isContainX(String A){
        char[] array = A.toCharArray();
        for(int i=0;i<array.length;i++){
            if(array[i]>='a' && array[i]<='z'){
                return false;
            }
        }
        return true;
    }
}