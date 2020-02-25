package leetcode146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
//    private int capacity;
//    private lru<Integer, Integer> lruHashMap = new lru<>();
//    private class lru<K, V> extends LinkedHashMap<K, V> {
//        @Override
//        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//            return size()>capacity;
//        }
//    }
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        Integer value = lruHashMap.get(key);
//        if (value == null) {
//            return -1;
//        }
//        lruHashMap.remove(key);
//        lruHashMap.put(key, value);
//        return value;
//    }
//
//    public void put(int key, int value) {
//        if (lruHashMap.containsKey(key)) {
//            lruHashMap.remove(key);
//        }
//        lruHashMap.put(key, value);
//    }
    private int capacity;
    private Map<Integer, Integer> map = new HashMap<>();
    private LinkedList<Integer> list = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            list.remove(new Integer(key));
            list.addFirst(key);
            return map.get(key);
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(new Integer(key));
        } else {
            if (capacity <= map.size()) {
                int last = list.pollLast();
                map.remove(last);
            }
        }
        list.addFirst(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4

    }

}