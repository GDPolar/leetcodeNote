/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode.cn/problems/3sum/description/
 *
 * algorithms
 * Medium (36.93%)
 * Likes:    5948
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 3.7M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
 * k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 
 * 你返回所有和为 0 且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // 直接三重循环 O(n^3) 超时，将第二、三层循环用双指针优化为 O(n)，总复杂度为 O(n^2)，因此需要将数组排序。
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int sum;
        for(int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break; // 此时三者必定都是正数，不满足
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            // 第二层循环定义两指针 left = i + 1  、right = length - 1
            // 若三者和大于 0 ，right 指针左移；若三者和小于 0，left 指针右移。
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    // Arrays.asList(Object ...) 生成一个 list
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // 去重
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    // 去重
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

