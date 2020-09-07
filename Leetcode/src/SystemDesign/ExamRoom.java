package SystemDesign;

import java.util.TreeSet;

/***
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。
 * (另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），
 * 代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p)
 * 时都保证有学生坐在座位 p上。
 * 示例：
 *
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 *
 * ****/
public class ExamRoom {
    int N;
    TreeSet<Integer> seats;

    public ExamRoom(int N) {
        //初始化
        this.N = N;
        this.seats = new TreeSet<>();
    }

    // 分配位置
    public int seat() {
        // 起始位置为0
        int student = 0;
        // 如果已经有人做了进行遍历
        if (seats.size() > 0) {
            Integer pre = null;
            int dist = seats.first();
            for (Integer seat : seats) {
                // 求出与前后两个点之间的距离
                if (pre != null) {
                    int temp = (seat - pre) >> 1;
                    if (temp > dist) {
                        student = (seat + pre) >> 1;
                        dist = temp;
                    }
                }
                // 移动前置
                pre = seat;
                // 判断加入到最后面的节点
                if (N - 1 - seats.last() > dist) {
                    student = N - 1;
                }
            }
        }
        seats.add(student);
        return student;
    }

    public void leave(int p) {
        seats.remove(p);
    }

}
