package leetcode347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        for (char c : map.keySet()) {
            pq.offer(c);
        }
        char[] res = new char[s.length()];
        int index = 0;
        while(!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < map.get(c); i++) {
                res[index++] = c;
            }
        }
        return new String(res);

    }
}
