package leetcode46;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return lists;
        }

        List<Integer> ins = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrace(nums, lists, ins, visited);
        return lists;
    }

    private void backtrace(final int[] num, List<List<Integer>> lists, List<Integer> ins, boolean[] visited) {
        if (ins.size() == num.length) {
            lists.add(new ArrayList<>(ins));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited[i]) {
                continue;
            }
            ins.add(num[i]);
            visited[i] = true;
            backtrace(num, lists, ins, visited);
            ins.remove(ins.size()-1);
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permute(new int[]{1,2,3}));
    }
}
