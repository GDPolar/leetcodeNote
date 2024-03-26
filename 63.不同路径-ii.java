/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 *
 * https://leetcode.cn/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (41.00%)
 * Likes:    1027
 * Dislikes: 0
 * Total Accepted:    362.3K
 * Total Submissions: 883.7K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        // dp[i][j] 表示从 (1, 1) 到 (i, j) 的路径数目
        int[][] dp = new int[m + 1][n + 1];
        // dp[1][0] 无意义，只是为了方便计算使得 dp[1][1] 为 1
        dp[1][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] != 1) {
                    // 若该位置为障碍物，则设为 0
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m][n];


        /* 
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int k = 0; k < n; k++) {
            if (obstacleGrid[0][k] == 1) {
                break;
            }
            dp[0][k] = 1;
        }
        for (int k = 0; k < m; k++) {
            if (obstacleGrid[k][0] == 1) {
                break;
            }
            dp[k][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
        */
    }
}
// @lc code=end

