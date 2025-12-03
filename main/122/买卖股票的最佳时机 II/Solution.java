//给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
//在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。
//然而，你可以在 同一天 多次买卖该股票，但要确保你持有的股票不超过一股。
//返回 你能获得的 最大 利润 。

class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }
}