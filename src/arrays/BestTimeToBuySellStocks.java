package arrays;

public class BestTimeToBuySellStocks {
    /**
     * given an array which contains the prize of stocks on any day i,
     * you have to find the maximum profit that can be earned.
     *
     * you can purchase and sell stock only once.
     *
     * reference : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
     *
     * e.g.
     * Input: [7, 1, 5, 3, 6, 4]
     * Output: 5
     *
     * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
     *
     *
     * Approach : basically we have to find the difference between two numbers, selling and purchase price.
     * Now to make profit, selling > purchase
     *
     *
     * So, we have to find max(arr[i] - arr[j]) such that i > j
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices.length > 0) {
            int min = prices[0];
            for(int i = 1;i<prices.length;i++)
            {
                if(min<prices[i])
                {
                    if(prices[i] - min > maxProfit)
                    {
                        maxProfit  = prices[i] - min;
                    }
                }
                if(prices[i]<min)
                {
                    min = prices[i];
                }
            }
        }
        return maxProfit;
    }
}
