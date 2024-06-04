package Leetcode;
/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = 0;
        for(int i = 0; i < nums.length; i++) {
            nums[i - n] = nums[i];
            if (nums[i] == val) {
                n++;
            }
        }
        return nums.length - n;
    }
}
// @lc code=end

