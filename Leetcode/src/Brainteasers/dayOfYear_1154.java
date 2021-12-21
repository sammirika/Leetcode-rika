package Brainteasers;

/**
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，
 * 依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 * <p>
 * 输入：date = "2019-02-10"
 * 输出：41
 */
public class dayOfYear_1154 {

    public static int dayOfYear(String date) {
        // 计算年
        int year = Integer.parseInt(date.substring(0, 4));
        int[] monthDay = new int[12];
        monthDay[0] = 31;
        monthDay[1] = 28;
        monthDay[2] = 31;
        monthDay[3] = 30;
        monthDay[4] = 31;
        monthDay[5] = 30;
        monthDay[6] = 31;
        monthDay[7] = 31;
        monthDay[8] = 30;
        monthDay[9] = 31;
        monthDay[10] = 30;
        monthDay[11] = 31;
        if (year % 4 == 0) {
            monthDay[1] = 29;
        }
        int month = Integer.parseInt(date.substring(5, 7));
        int ret = 0;
        for (int i = 0; i < month - 1; i++) {
            ret += monthDay[i];
        }
        ret += Integer.parseInt(date.substring(8));
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-01-09"));
    }
}
