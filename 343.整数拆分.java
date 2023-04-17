/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 *
 * https://leetcode.cn/problems/integer-break/description/
 *
 * algorithms
 * Medium (62.26%)
 * Likes:    1159
 * Dislikes: 0
 * Total Accepted:    250.7K
 * Total Submissions: 402.9K
 * Testcase Example:  '2'
 *
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 
 * 返回 你可以获得的最大乘积 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 
 * 示例 2:
 * 
 * 
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 2 <= n <= 58
 * 
 * 
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        /* 动态规划法：
        * 数字 i 被拆成 j 和 i-j，此时有两种选择
        * ① 不拆 i-j，乘积为 j * (i-j)
        * ② 拆 i-j，乘积为 j * f(i-j)
        * 考虑使用 dp
        */
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            // 从 i - j 之后是重复计算
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        // return dp[n];
        
        /* 数学法：
        * 假设最终结果 r0 的某一个因子 f>4，那么将它替换为 2 和 f-2
        * 由于 2*(f-2) = 2f-4 > f，因此替换后得到的新结果 r1 > r0
        * 所以最终结果的因子只包括 1、2、3，而 1 不会使乘积变大，故不要拆出 1
        *    2 -> 2 
        *    3 -> 3
        *    4 -> 2+2
        *    5 -> 2+3
        *    6 -> 4+2 -> 2+2+2 或 3+3
        *         4*2 < 3*3 故选择 3+3
        *    7 -> 5+2 -> 2+2+3
        *    ...
        *    任意 n 的拆分方法唯一
        */
        
        // 10: 3 3 2 2
        // 11: 3 3 3 2
        // 12: 3 3 3 3
        // 13: 3 3 3 2 2
        // 14: 3 3 3 3 2
        // 15: 3 3 3 3 3
        // 16: 3 3 3 3 2 2
        if (n <= 3) {
            return n - 1;
        }
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }
        ans *= n;
        return ans;
    }
}
// @lc code=end

