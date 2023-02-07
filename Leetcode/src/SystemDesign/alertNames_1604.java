package SystemDesign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。
 * 如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。
 * 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
 * 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
 * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
 * 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
 * <p>
 * 示例 1：
 * <p>
 * 输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
 * 输出：["daniel"]
 * 解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
 * 示例 2：
 * <p>
 * 输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
 * 输出：["bob"]
 * 解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
 */
public class alertNames_1604 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, LinkedList<String>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            // 默认值
            LinkedList<String> timeList = map.getOrDefault(keyName[i], new LinkedList<>());
            timeList.add(keyTime[i]);
            map.put(keyName[i], timeList);
        }
        // 排序list
        List<String> ret = new LinkedList<>();
        // 遍历map
        for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
            String timeKey = entry.getKey();
            List<String> timeList = entry.getValue();
            // 以时间排序
            timeList.sort((o1, o2) -> o1.compareTo(o2));
            // 看是否大于3次
            for (int i = 2; i < timeList.size(); i++) {
                long t1 = convertTimetoLong(timeList.get(i));
                long t2 = convertTimetoLong(timeList.get(i - 2));
                // 同一小时
                if (t1 - t2 <= 60) {
                    ret.add(timeKey);
                    break;
                }
            }
        }
        //
        ret.sort(((o1, o2) -> o1.compareTo(o2)));
        return ret;
    }

    // 计算时间
    private long convertTimetoLong(String time) {
        String[] t = time.split(":");
        return Long.parseLong(t[0]) * 60 + Long.parseLong(t[1]);
    }
}
