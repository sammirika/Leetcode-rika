package kexin;

import java.util.Stack;

/**
 * 输入1：78922751937
 * 输出1：33
 * 输入2：275478981611
 * 输出2：31
 * ****/
public class kexin605_01 {

    //定义一个总分数为全局变量
    int sum = 0;

    public static void main(String[] args) {
        kexin605_01 lihaoyu = new kexin605_01();
        System.out.println(lihaoyu.CaculateScore("27547898161122"));
    }

    public int CaculateScore(String number){
        //记录下标
        int preindex = 0;
        //先把简单的单个计算完成，这样搞可能空间复杂度比较高
        for (int i=0;i<number.length();i++){
            if (isSeven(Character.toString(number.charAt(i)))){
                sum += 2;
            }
            if (is369(Character.toString(number.charAt(i)))){
                sum += 5;
            }
        }
        //计算连续2的分数，只有连续的2才会累加
        Stack<Integer> stackTwo = new Stack<>();
        while (preindex<number.length()){
            if (number.charAt(preindex)=='2'){
                stackTwo.push(preindex);
            }else{
                caculateStackTwo(stackTwo);
            }
            preindex++;
        }
        //结尾处理
        caculateStackTwo(stackTwo);
        preindex = 0;
        //计算连续的数，利用单调栈特性，先计算递增或者递减
        Stack<Integer> stack1 = new Stack<>();
        //初始入栈
        stack1.push(preindex++);
        while (preindex<number.length()){
            if ((int)number.charAt(preindex)==(int)number.charAt(preindex-1)+1){
                stack1.push(preindex);
            }else{
                caculateStackContinue(stack1);
                stack1.push(preindex);
            }
            preindex++;
        }
        //结尾处理
        caculateStackContinue(stack1);

        //递减
        preindex = 0;
        Stack<Integer> stack2 = new Stack<>();
        //初始入栈
        stack2.push(preindex++);
        while (preindex<number.length()){
            if ((int)number.charAt(preindex)==(int)number.charAt(preindex-1)-1){
                stack2.push(preindex);
            }else {
                caculateStackContinue(stack2);
                stack2.push(preindex);
            }
            preindex++;
        }
        //结尾处理
        caculateStackContinue(stack2);
        return sum;
    }

    private boolean isSeven(String s){
        if (Integer.parseInt(s)==7){
            return true;
        }
        return false;
    }

    private boolean is369(String s){
        int num = Integer.parseInt(s);
        if (num==3 || num==6 || num==9){
            return true;
        }
        return false;
    }

    private void caculateStackTwo(Stack<Integer> stack){
        if (stack.size()>=2){
            sum += (stack.size()-1)*3;
        }
        //清空
        stack.clear();
    }

    //递增递减计算
    private void caculateStackContinue(Stack<Integer> stack){
        if (stack.size()>=2){
            sum += stack.size()*stack.size();
        }
        //清空
        stack.clear();
    }


}
