import java.util.*;
public class LRUCache {
    private int capacityInt;
    private Map<Integer, Integer> kvMap;

    public LRUCache(int capacity) {
        capacityInt = capacity;
        kvMap = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if (kvMap.containsKey(key)) {
            int value = kvMap.get(key);
            kvMap.remove(key);
            kvMap.put(key, value);
            return value;
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if ((capacityInt > 0) && (kvMap.containsKey(key))) {
            kvMap.remove(key);
        }
        if ((capacityInt > 0) && (kvMap.size() == capacityInt)) {
            // Full
            kvMap.remove(kvMap.keySet().iterator().next());
        }
        kvMap.put(key, value);
    }
}