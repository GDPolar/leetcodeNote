/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 *
 * https://leetcode.cn/problems/unique-paths/description/
 *
 * algorithms
 * Medium (67.70%)
 * Likes:    1740
 * Dislikes: 0
 * Total Accepted:    606.1K
 * Total Submissions: 895.4K
 * Testcase Example:  '3\n7'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 
 * 问总共有多少条不同的路径？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：m = 3, n = 7
 * 输出：28
 * 
 * 示例 2：
 * 
 * 
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：m = 7, n = 3
 * 输出：28
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：m = 3, n = 3
 * 输出：6
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 题目数据保证答案小于等于 2 * 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // dp[i][j] 表示从 (1, 1) 到 (i, j) 的路径数目
        int[][] dp = new int[m + 1][n + 1];
        // dp[1][0] 无意义，只是为了方便计算使得 dp[1][1] 为 1，从而令 dp[1][*] 和 dp[*][1] 为 1
        dp[1][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        // return dp[m][n];

        
        // 方法二：转化为数学问题
        // 从 (1, 1) 走到 (m, n) 且只能向右或向下，一共要走 m+n-2 步
        // 从 step1、step2、step3 到 step(m+n-2) 中有 m-1 步向下，n-1 步向右
        // 问题转化为从 m+n-2 中不重复地选 m-1 个数 或 从 m+n-2 中不重复地选 n-1 个数
        // 注意：为防止连乘导致溢出，代码实现公式时要不断除以分母
        long ans = 1; // 分子
        int denominator = m - 1; // 分母
        int count = m - 1;
        int t = m + n - 2;
        while (count-- != 0) {
            ans *= (t--);
            while (denominator != 0 && ans % denominator == 0) {
                ans /= denominator;
                denominator--;
            }
        }
        return (int)ans;
    }
}
// @lc code=end

