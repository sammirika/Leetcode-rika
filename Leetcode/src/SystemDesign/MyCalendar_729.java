package SystemDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，
 * 则可以存储这个新的日程安排。
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  
 * start <= x < end 。
 * 实现 MyCalendar 类：
 * MyCalendar() 初始化日历对象。
 * boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。
 * 否则，返回 false 并且不要将该日程安排添加到日历中。
 * 示例：
 * <p>
 * 输入：
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * 输出：
 * [null, true, false, true]
 * <p>
 * 解释：
 * MyCalendar myCalendar = new MyCalendar();
 * myCalendar.book(10, 20); // return True
 * myCalendar.book(15, 25); // return False ，
 * 这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
 * myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，
 * 因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
 */
public class MyCalendar_729 {

    List<int[]> list;

    public MyCalendar_729() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int i = 0; i < list.size(); i++) {
            int[] num = list.get(i);
            if (!(end - 1 < num[0] || start > num[1])) {
                return false;
            }
        }
        list.add(new int[]{start, end - 1});
        return true;
    }
}
