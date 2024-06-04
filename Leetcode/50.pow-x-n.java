package Leetcode;

/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.cn/problems/powx-n/description/
 *
 * algorithms
 * Medium (38.22%)
 * Likes:    1335
 * Dislikes: 0
 * Total Accepted:    444.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x^n^ ）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * n 是一个整数
 * 要么 x 不为零，要么 n > 0 。
 * -10^4 <= x^n <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    // 快速幂
    // eg：求 7^105
    // (105)D = (1101001)B
    // 7^105 = 7^64 * 7^32 * 7^8 * 7^1
    public double myPow(double x, int n) {
        int flag = 1;
        long nn = n;
        if (n < 0) {
            flag = -1;
            // n 取反可能会超出 int
            nn *= -1;
        }
        double res = 1.0;
        double a = x;
        while (nn > 0) {
            if ((nn & 1) == 1) {
                res *= a;
            }
            a *= a;
            nn >>= 1;
        }
        return flag > 0 ? res : (1 / res);
    }
}
// @lc code=end

