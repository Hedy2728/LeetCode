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

    public int findContentChildren1(int[] g, int[] s) {
        if(g == null || s == null) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1,2,6}, s = {1,2,3,4};
        System.out.println(new Solution().findContentChildren1(g,s));
    }
}
