package leetcode167;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret  = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            hashMap.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(target - numbers[i]) && hashMap.get(target - numbers[i]) != i) {
                ret[0] = i+1;
                ret[1] = hashMap.get(target - numbers[i])+1;
                break;
            }
        }
        return ret;
    }
}
