package ListNode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/***
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * ***/
public class reconstructQueue_406 {


    public int[][] reconstructQueue(int[][] people) {

        if (people.length == 0) {
            return people;
        }
        // 贪心排序，第一个数字大的在前降序，同等高度比较第二个数字升序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        LinkedList<int[]> res = new LinkedList<>();
        // 利用linkedList特性插入排序
        for (int[] temp : people) {
            res.add(temp[1], temp);
        }
        return res.toArray(new int[people.length][people[0].length]);
    }
}
