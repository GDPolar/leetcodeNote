package Leetcode;

/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 *
 * https://leetcode.cn/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (70.85%)
 * Likes:    2206
 * Dislikes: 0
 * Total Accepted:    357.2K
 * Total Submissions: 504.2K
 * Testcase Example:  '3'
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：5
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        // dp[i] 为 i 个节点组成的不同二叉搜索树个数
        // dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
        // dp[4] = dp[3] * dp[0] + dp[2] * dp[1] + dp[1] * dp[2] + dp[0] * dp[3]
        // ...
        // dp[n] = dp[n] * dp[0] + dp[n-1] * dp[1] + ... + dp[1] * dp[n-1] + d[0] * dp[n]

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];

        // 等价于： n 个节点构成的二叉树的个数，即 Catalan 数
        // long ans = 1L;
        // int j = n;
        // for (int i = 2 * n; i > n + 1; i--) {
        //     ans *= i;
        //     while (j > 1 && ans % j == 0) {
        //         ans /= j--;
        //     }
        // }
        // return (int)(ans);
    }
}
// @lc code=end

