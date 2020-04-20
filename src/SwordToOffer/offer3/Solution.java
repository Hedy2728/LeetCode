package SwordToOffer.offer3;

import java.util.HashSet;

public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length == 0) {
            return false;
        }
        //HashMap<Integer, Integer> hashMap = new HashMap<>();
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < length; i++) {
//            if (!set.contains(numbers[i])) {
//                set.add(numbers[i]);
//            } else {
//                duplication[0] = numbers[i];
//                return true;
//            }
//        }
//        return false;
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] nums = {2,3,1,0,2,5,3};
        int[] nums = {1,2,3};
        int[] dup = new int[nums.length];
        System.out.println(s.duplicate(nums, nums.length,dup));
    }
}
