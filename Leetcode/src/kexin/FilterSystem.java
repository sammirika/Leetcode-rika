package kexin;

import java.util.HashMap;
import java.util.Map;

public class FilterSystem {

    Map<String, Integer> map;
    public FilterSystem() {
        map = new HashMap<>();
    }

    public int Add(String keyWord) {
        if (map.containsKey(keyWord)){
            map.put(keyWord,map.get(keyWord)+1);
        }else {
            map.put(keyWord,1);
        }
        return map.get(keyWord);
    }

    public int Remove(String keyWord) {
        if (!map.containsKey(keyWord)) {
            return -1;
        }
        map.put(keyWord,map.get(keyWord)-1);
        return map.get(keyWord);
    }

    // 使用keyWord过滤
    public String Filter(String senence) {
        //划分为字符串数组
        String[] array = senence.split(" ");
        //
        for (int i=0;i<array.length;i++){
            for (String temp:map.keySet()){
                if (cutString(array[i],temp)){
                    array[i] = array[i].substring(temp.length());
                }
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i=0;i<array.length-1;i++){
            if (array[i] != ""){
                str.append(array[i] + " ");
            }
        }
        if (array[array.length-1] != ""){
            str.append(array[array.length-1]);
        }
        return str.toString();
    }

    // 判断是否B是A的前缀
    private boolean cutString(String A, String B){
        int len1 = A.length();
        int len2 = B.length();
        if (len1 < len2){
            return false;
        }
        for (int i=0;i<len2;i++){
            if (A.charAt(i) != B.charAt(i)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        FilterSystem kobe = new FilterSystem();
        System.out.println(kobe.Add("hello"));
        System.out.println(kobe.Filter("helloworld hi"));
        System.out.println(kobe.Remove("hello"));
    }


}
