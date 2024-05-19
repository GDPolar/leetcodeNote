/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0, j = nums.length - 1, k = j; k >= 0; k--) {
            // 左边绝对值大
            if (nums[i] + nums[j] < 0) {
                res[k] = nums[i] * nums[i];
                i++;
            } 
            // 右边绝对值大或相等
            else {
                res[k] = nums[j] * nums[j];
                j--;
            }
        }
        return res;
    }
}
// @lc code=end

