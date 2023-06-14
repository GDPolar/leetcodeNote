import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 *
 * https://leetcode.cn/problems/target-sum/description/
 *
 * algorithms
 * Medium (48.84%)
 * Likes:    1599
 * Dislikes: 0
 * Total Accepted:    340.9K
 * Total Submissions: 699.5K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 * 
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 
 * 
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 
 * 
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1], target = 1
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 0 
 * -1000 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // 加法的和为 x, 减法的和就为 sum - x
        // 要满足 x - (sum - x) == target -> 2x == target + sum 
        if (Math.abs(target) > sum || (sum + target) % 2 == 1) {
            return 0;
        }
        int capacity = (sum + target) / 2;
        int[] dp = new int[capacity + 1];
        dp[0] = 1;
        // dp[i][j] = dp[i - 1][j]
        // dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]]
        for (int i = 0; i < nums.length; i++) {
            // dp[j] 表示选用 nums[0:i] 的元素填满容积为 j 的背包，有 dp[j] 种填法
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[capacity];
    }
}
// @lc code=end

