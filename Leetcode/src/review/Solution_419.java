package review;

import java.lang.reflect.Array;
import java.util.*;

public class Solution_419 {

    /**
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
     * 例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    /**
     * 全字母句 指包含英语字母表中每个字母至少一次的句子。
     * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
     * 如果是，返回 true ；否则，返回 false 。
     * 示例 1：
     * <p>
     * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
     * 输出：true
     * 解释：sentence 包含英语字母表中每个字母至少一次。
     */
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char ch : sentence.toCharArray()) {
            set.add(ch);
        }
        return set.size() == 26;
    }

    /**
     * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
     * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。
     * Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
     * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
     * 注意：Tony 可以按任意顺序购买雪糕。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：costs = [1,3,2,4,1], coins = 7
     * 输出：4
     * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if (coins - cost >= 0) {
                count++;
                coins -= cost;
            } else {
                break;
            }
        }
        return count;
    }


    /**
     * 给你一个二维数组 tasks ，用于表示 n​​​​​​ 项从 0 到 n - 1 编号的任务。
     * 其中 tasks[i] = [enqueueTimei, processingTimei] 意味着第 i​​​​​​​​​​ 项任务将会于
     * enqueueTimei 时进入任务队列，需要 processingTimei 的时长完成执行。
     * 现有一个单线程 CPU ，同一时间只能执行 最多一项 任务，该 CPU 将会按照下述方式运行：
     * 如果 CPU 空闲，且任务队列中没有需要执行的任务，则 CPU 保持空闲状态。
     * 如果 CPU 空闲，但任务队列中有需要执行的任务，则 CPU 将会选择 执行时间最短 的任务开始执行。如果多个任务具有同样的最短执行时间，则选择下标最小的任务开始执行。
     * 一旦某项任务开始执行，CPU 在 执行完整个任务 前都不会停止。
     * CPU 可以在完成一项任务后，立即开始执行一项新任务。
     * 返回 CPU 处理任务的顺序。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：tasks = [[1,2],[2,4],[3,2],[4,1]]
     * 输出：[0,2,3,1]
     * 解释：事件按下述流程运行：
     * - time = 1 ，任务 0 进入任务队列，可执行任务项 = {0}
     * - 同样在 time = 1 ，空闲状态的 CPU 开始执行任务 0 ，可执行任务项 = {}
     * - time = 2 ，任务 1 进入任务队列，可执行任务项 = {1}
     * - time = 3 ，任务 2 进入任务队列，可执行任务项 = {1, 2}
     * - 同样在 time = 3 ，CPU 完成任务 0 并开始执行队列中用时最短的任务 2 ，可执行任务项 = {1}
     * - time = 4 ，任务 3 进入任务队列，可执行任务项 = {1, 3}
     * - time = 5 ，CPU 完成任务 2 并开始执行队列中用时最短的任务 3 ，可执行任务项 = {1}
     * - time = 6 ，CPU 完成任务 3 并开始执行任务 1 ，可执行任务项 = {}
     * - time = 10 ，CPU 完成任务 1 并进入空闲状态
     */
    // 按照题意的数据结构
    class Task {
        private int id;
        private int enqueueTimei;
        private int processingTimei;

        public Task(int id, int enqueueTimei, int processingTimei) {
            this.id = id;
            this.enqueueTimei = enqueueTimei;
            this.processingTimei = processingTimei;
        }
    }

    public int[] getOrder(int[][] tasks) {
        List<Task> taskList = new ArrayList<>();
        int len = tasks.length;
        for (int i = 0; i < len; i++) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        // 以进入时间升序排序
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.enqueueTimei - o2.enqueueTimei;
            }
        });
        // 构建小顶堆
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.processingTimei == o2.processingTimei) {
                    return o1.id - o2.id;
                } else {
                    return o1.processingTimei - o2.processingTimei;
                }
            }
        });
        int now = 0;
        int[] res = new int[len];
        int i = 0;
        int index = 0;
        while (i < len) {
            while (i < len && taskList.get(i).enqueueTimei <= now) {
                priorityQueue.add(taskList.get(i));
                i++;
            }
            // 如果空闲
            if (priorityQueue.isEmpty()) {
                now = taskList.get(i).enqueueTimei;
                while (i < len && taskList.get(i).enqueueTimei <= now) {
                    priorityQueue.add(taskList.get(i));
                    i++;
                }
            }
            Task task = priorityQueue.poll();
            res[index++] = task.id;
            now += task.processingTimei;
        }
        // 如果还有没执行完毕的任务
        while (!priorityQueue.isEmpty()) {
            res[index++] = priorityQueue.poll().id;
        }
        return res;
    }
}
