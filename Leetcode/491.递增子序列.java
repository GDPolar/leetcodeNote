package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 *
 * https://leetcode.cn/problems/non-decreasing-subsequences/description/
 *
 * algorithms
 * Medium (52.37%)
 * Likes:    623
 * Dislikes: 0
 * Total Accepted:    124.9K
 * Total Submissions: 238.5K
 * Testcase Example:  '[4,6,7,7]'
 *
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) {
            return res;
        }
        backTracking(nums, 0);
        return res;
    }
    // [1,2,3,1,1]
    // [2,1,2]
    public void backTracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            // 所有节点都需要，故不 return
            res.add(new ArrayList<>(path));
        }
        int[] set = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            // 纵向可以重复，不管
            // 原数组无序，横向用 set 去重
            if (set[nums[i] + 100] != 0 || 
                path.size() > 0 && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            // 标识 set
            set[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

