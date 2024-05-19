/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode.cn/problems/4sum/description/
 *
 * algorithms
 * Medium (37.01%)
 * Likes:    1594
 * Dislikes: 0
 * Total Accepted:    453.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a],
 * nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 
 * 
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * 
 * 你可以按 任意顺序 返回答案 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // 类似第 15 题三数之和，就外面多套一层循环，复杂度为O(n^3)
    // 注意剪枝能减少大量时间，小心溢出
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length <= 3) {
            return res;
        }
        Arrays.sort(nums);
        // 防止四个 int 相加导致溢出，转为 long
        long sum;
        long ltarget = (long) target;
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            // 去重
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // 目前最小的 4 个元素之和大于 target，不会再有结果，直接结束
            if ((long) nums[i]+ nums[i + 1] + nums[i + 2] + nums[i + 3] > ltarget) {
                break;
            }
            // 目前固定的一个元素 + 最大的三个元素之和小于 target，本轮循环中不可能出结果，直接进入下一轮
            if ((long) nums[i]+ nums[length - 1] + nums[length - 2] + nums[length - 3] < ltarget) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                } 
                // 目前最小的 4 个元素之和大于 target，不会再有结果，直接结束
                if ((long) nums[i]+ nums[j] + nums[j + 1] + nums[j + 2] > ltarget) {
                    break;
                }
                // 目前固定的两个元素 + 最大的两个个元素之和小于 target，本轮循环中不可能出结果，直接进入下一轮
                if ((long) nums[i]+ nums[j] + nums[length - 1] + nums[length - 2] < ltarget) {
                    continue;
                }
                // 第三层循环定义两指针 left = i + 1   、 right = length - 1 
                // 若四者和大于 0 ，right 指针左移；若四者和小于 0，left 指针右移。
                for (int left = j + 1, right = length - 1; left < right; ) {
                    sum = (long) nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum == ltarget) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // 去重
                        while(left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        // 去重
                        while(left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } 
                    else if (sum < ltarget) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

