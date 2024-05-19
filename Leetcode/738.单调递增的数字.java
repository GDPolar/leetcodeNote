/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 *
 * https://leetcode.cn/problems/monotone-increasing-digits/description/
 *
 * algorithms
 * Medium (50.29%)
 * Likes:    365
 * Dislikes: 0
 * Total Accepted:    86.8K
 * Total Submissions: 172.6K
 * Testcase Example:  '10'
 *
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: n = 10
 * 输出: 9
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: n = 1234
 * 输出: 1234
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: n = 332
 * 输出: 299
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 0 <= n <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        if (n < 10) {
            return n;
        }
        char[] cs = Integer.toString(n).toCharArray();
        // 从前往后遍历时，某次操作可能会影响上次操作的结果
        // eg: 668841 -> 667999
        // 故从后往前遍历
        int flag = Integer.MAX_VALUE;
        for (int i = cs.length - 1; i > 0; i--) {
            // 找到最左的不符合但增的位置
            if (cs[i] < cs[i - 1]) {
                cs[i - 1]--;
                flag = i;
            }
        }
        for (int i = flag; i < cs.length; i++) {
            cs[i] = '9';
        }
        return Integer.parseInt(new String(cs));
    }
}
// @lc code=end

