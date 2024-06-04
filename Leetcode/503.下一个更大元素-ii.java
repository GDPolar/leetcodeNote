package Leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 *
 * https://leetcode.cn/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (66.58%)
 * Likes:    799
 * Dislikes: 0
 * Total Accepted:    194.9K
 * Total Submissions: 292.2K
 * Testcase Example:  '[1,2,1]'
 *
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的
 * 下一个更大元素 。
 * 
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1
 * 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数； 
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        // 从 nums[max+1] 开始到 nums[max] 结束，保证每个元素都能找到下一个最大值
        Deque<Integer> stack = new LinkedList<>();
        stack.push(max);
        for (int i = 1; i <= nums.length; i++) {
            int curr = (max + i) % nums.length;
            while (!stack.isEmpty() && nums[curr] > nums[stack.peek()]) {
                res[stack.peek()] = nums[curr];
                stack.pop();
            }
            stack.push(curr);
        }
        // 此时留在 stack 中的序号对应的元素等于 nums[max]
        // 相应的 res 中的值为默认值 -1
        return res;
    }
}
// @lc code=end

