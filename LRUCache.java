public class LRUCache {
    private int capacityInt;
    private Set<Integer> keyList;
    private Map<Integer, Integer> kvMap;

    public LRUCache(int capacity) {
        capacityInt = capacity;
        keyList = new LinkedHashSet<>();
        kvMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (keyList.contains(key)) {
            keyList.remove(key);
            keyList.add(key);
            return kvMap.get(key);
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if ((capacityInt > 0) && (keyList.contains(key))) {
            keyList.remove(key);
            kvMap.remove(key);
        }
        if ((capacityInt > 0) && (keyList.size() == capacityInt)) {
            // Full
            Iterator<Integer> itTemp = keyList.iterator();
            int keyTemp = itTemp.next();
            keyList.remove(keyTemp);
            kvMap.remove(keyTemp);
        }
        keyList.add(key);
        kvMap.put(key, value);
    }
}