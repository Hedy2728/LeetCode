package leetcode122;

public class Solution2 {
    public int maxProfit(int[] prices){
        int ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                ans+=(prices[i]-prices[i-1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
