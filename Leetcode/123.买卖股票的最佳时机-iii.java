/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (58.73%)
 * Likes:    1433
 * Dislikes: 0
 * Total Accepted:    260.3K
 * Total Submissions: 442.9K
 * Testcase Example:  '[3,3,5,0,0,3,1,4]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4
 * 。   
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：prices = [7,6,4,3,1] 
 * 输出：0 
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 
 * 示例 4：
 * 
 * 
 * 输入：prices = [1]
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        /* 
        // 由于两次交易时间无交集，可将两次交易拆成两个独立的一次交易
        int[] dplr = new int[prices.length];
        int[] dprl = new int[prices.length];

        //从左向右
        int min = prices[0];
        dplr[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dplr[i] = Math.max(dplr[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        //从右向左
        int max = prices[prices.length - 1];
        dprl[prices.length - 1] = 0;
        for (int j = prices.length - 2; j >= 0; j--) {
            dprl[j] = Math.max(dprl[j + 1], max - prices[j]);
            max = Math.max(max, prices[j]);
        }

        int res = 0;
        for (int i = 0; i < dplr.length; i++) {
            res = Math.max(res, dplr[i] + dprl[i]);
        }
        return res;
        */

        /* 
        // dp[i][0] 表示在第 i 天前和第 i 天未操作的当前现金
        // dp[i][1] 表示在第 i 天时第一次已持有股票（第 i 天前已持有或第 i 天买入）的当前现金
        // dp[i][2] 表示在第 i 天时完成了第一次交易（第 i 天前已卖出或第 i 天卖出）的当前现金
        // dp[i][3] 表示在第 i 天时第二次已持有股票（第 i 天前已持有或第 i 天买入）的当前现金
        // dp[i][4] 表示在第 i 天时完成了第二次交易（第 i 天前已卖出或第 i 天卖出）的当前现金
        int[][] dp = new int[prices.length + 1][5];

        // dp[i][0] 始终为 0
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = 0;
        dp[0][3] = Integer.MIN_VALUE;
        dp[0][4] = 0;
        for (int i = 1; i <= prices.length; i++) {
            int index = i - 1;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[index]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[index]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[index]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[index]);
        }
        return dp[dp.length - 1][4];
        */

        // 优化空间后
        int pro1 = -prices[0];
        int pro2 = 0;
        int pro3 = -prices[0];
        int pro4 = 0;
        for (int i = 1; i < prices.length; i++) {
            pro4 = Math.max(pro4, pro3 + prices[i]);
            pro3 = Math.max(pro3, pro2 - prices[i]);
            pro2 = Math.max(pro2, pro1 + prices[i]);
            pro1 = Math.max(pro1, - prices[i]);
        }
        return pro4;
    }
}
// @lc code=end

