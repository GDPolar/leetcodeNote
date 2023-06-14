/*
 * @lc app=leetcode.cn id=879 lang=java
 *
 * [879] 盈利计划
 *
 * https://leetcode.cn/problems/profitable-schemes/description/
 *
 * algorithms
 * Hard (54.79%)
 * Likes:    275
 * Dislikes: 0
 * Total Accepted:    27.3K
 * Total Submissions: 49.9K
 * Testcase Example:  '5\n3\n[2,2]\n[2,3]'
 *
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * 
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * 
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * 
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * 总的来说，有两种计划。
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * 输出：7
 * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 1 
 * 1 
 * profit.length == group.length
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // dp[i][j][k] 表示从前 i 个工作中选择，消耗人数不超过 j，利润大于等于 k 的方案数
        // dp[i][j][k] 
        // dp[i - 1][j][k]  dp[i][j - group[i]][k - profit[i]]
        int mod = (int)(1e9 + 7);
        int[][][] dp = new int[group.length + 1][n + 1][minProfit + 1];
        
        // dp[0][j][0] 表示不选任何工作，消耗人数不超过 j，利润大于等于 0 的方案数
        // 有且只有一种情况
        // dp[0][j][k], k > 0 表示不选任何工作，消耗人数不超过 j，利润大于 0 的方案数
        // 没有任何情况满足，都为 0
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j][0] = 1;
        }        
        for (int i = 1; i < dp.length; i++) {
            int index = i - 1;
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    // 不选当前工作
                    dp[i][j][k] = dp[i - 1][j][k];
                    // 注意考虑转移方程时对应的实际意义！
                    // 此题中利润大于等于一个负数是合理的，数值上等价于利润为 0
                    if (j >= group[index]) {
                        // 可选当前工作
                        dp[i][j][k] += dp[i - 1][j - group[index]][Math.max(0, k - profit[index])];
                        dp[i][j][k] %= mod;
                    }

                }
            }
        }
        return dp[group.length][n][minProfit];
    }
}
// @lc code=end

