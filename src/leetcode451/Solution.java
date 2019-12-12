package leetcode451;

import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            }
            else {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (Character c: map.keySet()){
            int f = map.get(c);
            if (bucket[f] == null) {
                bucket[f] = new ArrayList<>();
            }
            bucket[f].add(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = bucket.length-1; i >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (Character c: bucket[i]){
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abccdss";
        System.out.println(new Solution().frequencySort(str));
    }
}
