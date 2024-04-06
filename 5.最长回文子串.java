/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (38.19%)
 * Likes:    7144
 * Dislikes: 0
 * Total Accepted:    1.7M
 * Total Submissions: 4.4M
 * Testcase Example:  '"babad"'
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    // P(i,i) = true
    // P(i,i+1) = (S[i]​==S[i+1]​)
    // P(i,j) = P(i+1,j−1) && (S[i]​==S[j]​)​
    // 中心扩散法，所有的 P(i,j) 最终都由 P(i,i) 或 P(i,i+1) 开始
    // 类似 dp 思想，只不过不是通常的从 i-1 开始，而是从 i 和 i+1 开始
    public String longestPalindrome(String s) {
        // [resLeft, resRight]
        int resLeft = 0, resRight = 0;
        for (int i = 0; i < s.length(); i++) {
            // 长度为 1 和 长度为 2 这两种状态的判定方式不同
            int len1 = expanFromCenter(s, i, i);
            int len2 = expanFromCenter(s, i, i + 1);
            // len1 为奇数，len2 为偶数
            int len = Math.max(len1, len2);
            if (resRight - resLeft < len) {
                resRight = i + len / 2;
                resLeft = i - (len - 1) / 2;
            }
        }
        return s.substring(resLeft, resRight + 1);
    }

    private int expanFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // [left+1, right-1] 才是合法的区间
        return right - left - 1;
    }
}
// @lc code=end

