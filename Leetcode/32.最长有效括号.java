package Leetcode;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 *
 * https://leetcode.cn/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (37.91%)
 * Likes:    2552
 * Dislikes: 0
 * Total Accepted:    475.4K
 * Total Submissions: 1.2M
 * Testcase Example:  '"(()"'
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = ""
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 3 * 10^4
 * s[i] 为 '(' 或 ')'
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        // dp[i] 表示以 s[i - 1] 结尾的最长有效括号长度
        int[] dp = new int[s.length() + 1];
        for (int i = 2; i <= s.length(); i++) {
            // 合法的子串结尾一定是右括号
            if (s.charAt(i - 1) == ')') {
                if (s.charAt(i - 2) == '(') {
                    // ...(()  -> 0 + 2
                    // ...)()  -> m + 2
                    dp[i] = 2 + dp[i - 2];
                } else {
                    // ...#* (()))，根据 * 的状态判断
                    if ((i - 2 - dp[i - 1] >= 0) && s.charAt(i - 1 - dp[i - 1] - 1) == '(') {
                        // ...#( (()))，* 为左括号， dp[i] = 1 + dp[i - 1] + 1 + dp[#]
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    }
                    // ...#) (()))，* 为 右括号，匹配失败
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
// @lc code=end

