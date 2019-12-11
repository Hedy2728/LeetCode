package leetcode347;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num:nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }
            else {
                map.put(num, map.get(num)+1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });//chong xie pai xu fang fa, shi de qi wei chu xian ci shu pai xu

        for (Integer key: map.keySet()){
            if (pq.size() < k) {
                pq.add(key);
            }
            else if (map.get(pq.peek()) < map.get(key)){
                pq.remove();
                pq.add(key);
            }
        }

        while (!pq.isEmpty()) {
            list.add(pq.remove());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(new Solution().topKFrequent(nums, 2));
    }
}
