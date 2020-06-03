package day;

public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        System.out.println(ConsecutiveNumbersSum.consecutiveNumbersSum(63660706));
    }


    public static int consecutiveNumbersSum(int N) {
        int res = 0;
        for(int start = 1;start<=N;start++){
            int target = N;
            int x = start;
            while(target>0){
                target -= x++;
            }
            if(target==0){
                res++;
            }
        }
        return res;
    }
}
