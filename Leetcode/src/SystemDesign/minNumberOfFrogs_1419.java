package SystemDesign;

/**
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，
 * 所以 croakOfFrogs 中会混合多个 “croak” 。
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。 
 * <p>
 * 示例 1：
 * <p>
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 * 示例 2：
 * <p>
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 */
public class minNumberOfFrogs_1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        int ret = 0;
        // 记录字符串下标
        int[] map = new int[5];
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            int index = indexFrogs(croakOfFrogs.charAt(i));
            if (index == -1) {
                return -1;
            }
            // 尾,必须是按顺序来
            if (index == 4) {
                ret = Math.max(ret, map[0] - map[4]);
            }
            map[index]++;
            if (index != 0 && map[index] > map[index - 1]) {
                return -1;
            }
        }
        // 判断是否满足所有字符出现次数相等
        for (int i = 1; i <= 4; i++) {
            if (map[i] != map[i - 1]) {
                return -1;
            }
        }
        return ret;
    }

    public int indexFrogs(char ch) {
        // 根据字符返回对应字符应该存在的索引
        switch (ch) {
            case 'c':
                return 0;
            case 'r':
                return 1;
            case 'o':
                return 2;
            case 'a':
                return 3;
            case 'k':
                return 4;
            default:
                return -1;
        }
    }
}
