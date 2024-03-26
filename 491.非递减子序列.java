/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 非递减子序列
 *
 * https://leetcode.cn/problems/non-decreasing-subsequences/description/
 *
 * algorithms
 * Medium (51.89%)
 * Likes:    776
 * Dislikes: 0
 * Total Accepted:    172.5K
 * Total Submissions: 332.8K
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

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) {
            return res;
        }
        f(nums, 0, new ArrayList<>());
        return res;
    }

    
    private void f(int[] nums, int begin, List<Integer> list) {
        if (list.size() > 1) {
            res.add(new ArrayList<>(list));
        }
        // 已知数据范围较小，用数组模拟 set
        int[] set = new int[210];
        for (int i = begin; i < nums.length; i++) {
            // 同一层上的元素的入选条件为不能与出现过的元素相同
            // 去重逻辑是树的同一层中的元素不能重复
            // 由于数组不是有序的，因此查重要用 set，而不是像有序数组那样直接和同一层的前一元素比较
            if (set[nums[i] + 100] != 0) {
                continue;
            }
            set[nums[i] + 100] = 1;
            // 同一列上的元素的入选条件为大于等于父节点的元素
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                f(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
// @lc code=end

