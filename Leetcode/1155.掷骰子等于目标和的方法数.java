/*
 * @lc app=leetcode.cn id=1155 lang=java
 *
 * [1155] 掷骰子的N种方法
 *
 * https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/description/
 *
 * algorithms
 * Medium (50.77%)
 * Likes:    165
 * Dislikes: 0
 * Total Accepted:    19K
 * Total Submissions: 37.4K
 * Testcase Example:  '1\n6\n3'
 *
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * 
 * 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 k^n 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 * 
 * 答案可能很大，你需要对 10^9 + 7 取模 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 1, k = 6, target = 3
 * 输出：1
 * 解释：你扔一个有6张脸的骰子。
 * 得到3的和只有一种方法。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 2, k = 6, target = 7
 * 输出：6
 * 解释：你扔两个骰子，每个骰子有6个面。
 * 得到7的和有6种方法1+6 2+5 3+4 4+3 5+2 6+1。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：n = 30, k = 30, target = 500
 * 输出：222616187
 * 解释：返回的结果必须是对 10^9 + 7 取模。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    // 分组背包
    public int numRollsToTarget(int n, int k, int target) {
        /* 
        int mod = 7 + (int)1e9;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 每组必选一个，故考虑到第 i 组时，target 若小于 i 无意义
            for (int j = i; j < dp[0].length; j++) {
                for (int m = 1; m <= k; m++) {
                    if (j >= m) {
                        dp[i][j] += dp[i - 1][j - m];
                        dp[i][j] %= mod;
                    }
                    
                }
            }
        }
        return dp[n][target];
        */

        // 方法二：
        if (target < n || target > n * k) {
            return 0;
        }
        int modd = (int)(1e9 + 7);
        // 第一轮只使用一个骰子，得到的最大的和为 k
        long[] count = new long[k + 1];
        for (int i = 1; i <= k; i++) {
            count[i] = 1;
        }
        // i 表示下一轮是用到前几个骰子
        for (int i = 2; i <= n; i++) {
            // newCount 的长度表示下一轮最大的和
            // + 1 方便表示
            long[] newCount = new long[i * k + 1];
            // j 表示本轮的合理的和的范围
            for (int j = i - 1; j <= (i - 1) * k; j++) {
                // 计算下一轮的结果
                for (int m = 1; m <= k; m++) {
                    newCount[j + m] += count[j];
                    newCount[j + m] %= modd;
                }
            }
            count = newCount;
        }
        return (int)count[target];
    }
}
// @lc code=end

