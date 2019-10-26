package leetcode121;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, j = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[j];

            if (temp > maxProfit) {
                maxProfit = temp;
            }

            if (prices[i] < prices[j]) {
                j = i;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,6,4,3,2};
        System.out.println(new Solution().maxProfit(prices));
    }
}
