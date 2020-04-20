package leetcode279;

import java.util.*;

public class Solution {
    //枚举法：适合n较小的元素
    public int numSquares(int n) {
        int res = Integer.MAX_VALUE;
        int minNum = (int)Math.sqrt(n);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < minNum+1; i++) {
            list.add(i * i);
        }

        if (list.contains(n)) {
            return 1;
        }

        for (int i : list) {
            if (n < i) {
                break;
            }
            int num = numSquares(n - i) + 1;
            res = Math.min(num, res);
        }
        return res;
    }



    //贪心枚举法
    public int numSquares1(int n) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j*j <= cur; j++) {
                    int next = cur - j * j;
                    if (next == 0) {
                        return res;
                    }

                    if (!set.contains(next)) {
                        queue.add(next);
                        set.add(next);
                    }
                }
            }
        }
        return -1;
    }

    //2、3都属于回溯法的一种，或者称为是dfs
    public int numSquares2(int n) {
        if (n == 0) {
            return 0;
        }

        int count = Integer.MAX_VALUE;
        for (int i = 1; i*i <= n; i++) {
            count = Math.min(count, numSquares2(n - i*i)+1);
        }
        return count;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    public int numSquares3(int n) {

        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (n == 0) {
            return 0;
        }

        int count = Integer.MAX_VALUE;
        for (int i = 1; i*i <= n; i++) {
            count = Math.min(count, numSquares3(n - i*i)+1);
        }

        map.put(n, count);
        return count;
    }

    //动态规划
    public int numSquares4(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                if (dp[i] != 0) {
                    dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                } else {
                    dp[i] = dp[i-j*j]+1;
                }
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares2(12));
    }
}
