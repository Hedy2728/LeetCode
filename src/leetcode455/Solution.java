package leetcode455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g ==null || s == null) {
            return 0;
        }
        int gi = 0, sj = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (gi < g.length && sj < s.length) {
            if (g[gi] <= s[sj]) {
                gi++;
            }
            sj++;
        }
        return gi;
    }

    public static void main(String[] args) {
        int[] g = {1,2,3}, s = {1,2,3,4};
        System.out.println(new Solution().findContentChildren(g,s));
    }
}
