package SystemDesign;

public class MyHashMap_706 {
    /** Initialize your data structure here. */
    private int[] hash;
    private int[] values;
    public MyHashMap_706() {
        this.hash = new int[1000001];
        this.values = new int[1000001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (hash[key]==0){
            values[key] = value;
            // 代表着这个键值操作过
            hash[key]++;
        }else {
            values[key] = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (hash[key] == 0){
            return -1;
        }
        return values[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (hash[key] == 1){
            hash[key]--;
            values[key] = 0;
        }
    }
}
