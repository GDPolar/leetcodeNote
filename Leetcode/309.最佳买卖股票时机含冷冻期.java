package Leetcode;

/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (64.15%)
 * Likes:    1524
 * Dislikes: 0
 * Total Accepted:    259.6K
 * Total Submissions: 404.8K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * 
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 
 * 
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 
 * 
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3 
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 
 * 示例 2:
 * 
 * 
 * 输入: prices = [1]
 * 输出: 0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        // dp[i][1] 已买入（之前已买入或当天买入）
        // 由于之前已卖出和当天卖出的结局方案不同，因此不能设置为同一种状态
        // dp[i][2] 之前已卖出
        // dp[i][3] 当天卖出
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3]);
            dp[i][3] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[dp.length - 1][2], dp[dp.length - 1][3]);
    }
}
// @lc code=end

