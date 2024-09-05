package Leetcode;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 *
 * https://leetcode.cn/problems/majority-element/description/
 *
 * algorithms
 * Easy (66.34%)
 * Likes:    2215
 * Dislikes: 0
 * Total Accepted:    975.9K
 * Total Submissions: 1.5M
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [3,2,3]
 * 输出：3
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 * 
 * 
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * 
 */

// @lc code=start

import java.util.Random;

class Solution {

    public int majorityElement(int[] nums) {
        // 此题定义众数数量一定严格大于一半
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else if (count == 0) {
                candidate = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public int majorityElement1(int[] nums) {
        Random random = new Random();
        while (true) {
            // 每次随机选择数组中的一个数，当众数恰好占据数组的一半时
            // 第一次就选中的数是众数的概率是 1/2
            // 第一次未选中，第二次才选中的概率是 1/4
            // 第一二次未选中，第三次才选中的概率是 1/8
            // ......
            // E(选中众数所需的次数) = 1*1/2 + 2*1/4 + ... = 2
            int candidate = nums[random.nextInt(nums.length)];
            if (count(candidate, nums)) {
                return candidate;
            }
        }
    }

    public boolean count(int candidate, int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (candidate == num) {
                res++;
            }
        }
        return res > nums.length / 2;
    }
}
// @lc code=end

