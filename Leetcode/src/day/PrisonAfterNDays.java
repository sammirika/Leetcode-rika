package day;

/***
 * 8 间牢房排成一排，每间牢房不是有人住就是空着。
 * 每天，无论牢房是被占用或空置，都会根据以下规则进行更改：
 * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 * 否则，它就会被空置。
 * （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）
 * 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。
 * 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。
 * 示例 1：
 * 输入：cells = [0,1,0,1,1,0,0,1], N = 7
 * 输出：[0,0,1,1,0,0,0,0]
 * 解释：
 * 下表概述了监狱每天的状况：
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * **/

public class PrisonAfterNDays {

    public static void main(String[] args) {
        int[] A = new int[]{1,0,0,1,0,0,1,0};
        int[] B = PrisonAfterNDays.prisonAfterNDays(A,1000000000);
        for(int b:B){
            System.out.println(b);
        }
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        int[] arr = new int[8];
        arr[0] = 0;
        arr[7] = 0;
        int a = N % 14;
        int n = a == 0 ? 14 : a;
        while(n > 0) {
            for(int i = 1; i < 7; i++) {
                if((cells[i - 1] ^ cells[i + 1]) == 0) {
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
            }
            for(int j = 0; j < 8; j++) {
                cells[j] = arr[j];
            }
            n--;
        }
        return cells;
    }
}
