package day;

public class MaxScore {
    public static void main(String[] args) {
        System.out.println(MaxScore.maxScore("011101"));
    }


    public static int maxScore(String s) {
        int num0 = 0;
        int num1 = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                num0++;
            }else {
                num1++;
            }
        }
        int count0=0;
        int count1 = num1;
        for(int i=0;i<s.length()-1;i++){
            if (s.charAt(i)=='0'){
                count0++;
            }else {
                count1--;
            }
            max = Math.max(max,count0+count1);
        }
        return max;
    }
}
