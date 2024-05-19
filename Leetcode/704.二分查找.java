/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // 左闭右开
        int left = 0, right = nums.length;
        int middle;
        // 当 left = right 时，不符合左闭右开
        while(left < right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        /*
        // 或者另一种 左闭右闭
        int left = 0, right = nums.length - 1;
        int middle;
        // 当 left = right 时，符合左闭右闭
        while(left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        */
        return -1;
    }
}
// @lc code=end

