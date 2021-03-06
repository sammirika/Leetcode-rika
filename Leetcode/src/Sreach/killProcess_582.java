package Sreach;

import java.util.ArrayList;
import java.util.List;


/***
 * 给 n 个进程，每个进程都有一个独一无二的 PID （进程编号）和它的 PPID （父进程编号）。
 * 每一个进程只有一个父进程，但是每个进程可能会有一个或者多个孩子进程。它们形成的关系就像一个树状结构。只有一个进程的 PPID 是 0 ，意味着这个进程没有父进程。所有的 PID 都会是唯一的正整数。
 * 我们用两个序列来表示这些进程，第一个序列包含所有进程的 PID ，第二个序列包含所有进程对应的 PPID。
 * 现在给定这两个序列和一个 PID 表示你要杀死的进程，函数返回一个 PID 序列，表示因为杀这个进程而导致的所有被杀掉的进程的编号。
 * 当一个进程被杀掉的时候，它所有的孩子进程和后代进程都要被杀掉。
 * 你可以以任意顺序排列返回的 PID 序列。
 * 示例 1:
 *
 * 输入:
 * pid =  [1, 3, 10, 5]
 * ppid = [3, 0, 5, 3]
 * kill = 5
 * 输出: [5,10]
 * 解释:
 *            3
 *          /   \
 *         1     5
 *              /
 *             10
 * 杀掉进程 5 ，同时它的后代进程 10 也被杀掉。
 * ***/
public class killProcess_582 {

    private List<Integer> res = new ArrayList<>();

    private int[] parent;

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (pid.size() == 0 || ppid.size() == 0) {
            return res;
        }
        this.parent = new int[100000];
        for (int i = 0; i < pid.size(); i++) {
            parent[pid.get(i)] = ppid.get(i);
        }
        for (int i = 0; i < pid.size(); i++) {
            if (find(pid.get(i), kill)) {
                res.add(pid.get(i));
            }
        }
        return res;

    }

    // find 函数，
    private boolean find(int val, int kill) {
        if (val == kill) {
            return true;
        }
        while (val != parent[val]) {
            if (parent[val] == kill) {
                return true;
            }
            val = parent[val];
        }
        return false;
    }


    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(10);
        list1.add(5);
        list2.add(3);
        list2.add(0);
        list2.add(5);
        list2.add(3);
        killProcess_582 kobe = new killProcess_582();
        System.out.println(kobe.killProcess(list1, list2, 5));
    }


}
