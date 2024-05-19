/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = 999999;
        int left = 0, right = 0;
        int sum = nums[0];
        // [left, right] 左闭右闭
        while (left <= right && right < nums.length) {
            if (sum < target) {
                if (++right < nums.length) {
                    sum += nums[right];
                }
            } else {
                // 闭区间长度为端点差加 1
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return ans == 999999 ? 0 : ans;
    }
}
// @lc code=end

