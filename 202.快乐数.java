import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        // 无限循环即 会重复出现
        HashSet<Integer> hSet = new HashSet<>();
        while (true) {
            if (hSet.contains(n)) {
                return false;
            }
            else if (n == 1) {
                return true;
            }
            else {
                hSet.add(n);
                n = f(n);
            }
        }
    }
    public int f(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
// @lc code=end

