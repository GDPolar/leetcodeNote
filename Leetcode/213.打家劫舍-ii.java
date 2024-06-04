package Leetcode;

/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 *
 * https://leetcode.cn/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (44.14%)
 * Likes:    1376
 * Dislikes: 0
 * Total Accepted:    340.9K
 * Total Submissions: 772.4K
 * Testcase Example:  '[2,3,2]'
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈
 * ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // 假设数组长度为 5，则数组的下标为 0,1,2,3,4
        // (以下所说的从 a 到 b 表示闭区间 [a, b])
        // 考虑从下标 1 到下标 3 中选，得到的最大价值 A
        // 考虑从下标 0 到下标 3 中选，得到的最大价值 B
        //      如果 B 没有选下标 0，那么 B 等于 A
        //      如果 B 选了下标 0，那么 B 大于等于 A
        //      即 B >= A
        // 考虑从下标 1 到下标 4 中选，得到的最大价值 C
        //      如果 C 没有选下标 4，那么 C 等于 A
        //      如果 C 选了下标 4，那么 C 大于等于 A
        //      即 C >= A
        // 考虑从下标 0 到下标 4 中选，得到的最大价值 D
        //      如果 D 没有选下标 0，没有选下标 4，那么 D 等于 A
        //      如果 D 没有选下标 0，选了下标 4，那么 D 等于 C
        //      如果 D 没有选下标 4，选了下标 0，那么 D 等于 B
        //      即 D = Max(A, B, C) = Max(B, C)

        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(f(nums, 0, nums.length - 1), f(nums, 1, nums.length));
    }

    // [begin, end)
    public int f(int[] nums, int begin, int end) {
        // dp[i] 表示在 [1,i] 中选，价值的最大值
        int[] dp = new int[end - begin + 1];
        dp[0] = 0;
        dp[1] = nums[begin];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[begin + i - 1]);
        }
        return dp[dp.length - 1];
    }
}
// @lc code=end

