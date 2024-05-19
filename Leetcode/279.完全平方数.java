/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 *
 * https://leetcode.cn/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (66.09%)
 * Likes:    1697
 * Dislikes: 0
 * Total Accepted:    400.6K
 * Total Submissions: 606K
 * Testcase Example:  '12'
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11
 * 不是。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 12
 * 输出：3 
 * 解释：12 = 4 + 4 + 4
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] nums = new int[(int) Math.sqrt(n)];
        for (int i = 1; ; i++) {
            int t = i * i;
            if (t == n) {
                return 1;
            } else if (t > n) {
                break;
            } else {
                nums[i - 1] = t;
            }
        }
        // 用 nums 中的数字填满容量为 n 的完全背包
        int[] dp = new int[n + 1];

        // 第一行
        // for (int j = 0; j <= n; j++) {
        //     int t = list.get(0);
        //     int k = j / t;
        //     if (k * t == j) { // 只有容量为第一个数的整数倍的才能凑出
        //         dp[j] = k;
        //     } else { // 其余则为无效值
        //         dp[j] = Integer.MAX_VALUE;
        //     }
        // }
        // 此题可简化写作
        for (int j = 0; j < dp.length; j++) {
            dp[j] = j;
        }

        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            for (int j = t; j < dp.length; j++) {
                // 此处的判断在此题可省略
                if (dp[j - t] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - t] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }
}
// @lc code=end

