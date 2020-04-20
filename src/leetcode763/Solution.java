package leetcode763;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return list;
        }

        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        int anchor = 0, j = 0;
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(last[S.charAt(i) - 'a'], j);
            if (i == j) {
                list.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        String str = "ababcbacadefegdehijhklij";
        System.out.println(s.partitionLabels(str));
    }
}
