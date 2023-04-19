import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 *
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (52.20%)
 * Likes:    1722
 * Dislikes: 0
 * Total Accepted:    401.8K
 * Total Submissions: 770.2K
 * Testcase Example:  '[1,5,11,5]'
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        // 暴力法使用回溯，找出所有的子集，超时
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 原问题等价于判断是否存在子集合的和为总和的一半
        if (sum % 2 == 0) {
            // 从序列中选择子序列使得和接近目标
            // 转化为容量为 sum / 2 的 01 背包问题
            // 此题定义每一个物体的重量和价值相同，每个物体性价比都一样，因此尽可能地塞满背包收益大
            // 滚动数组版：
            int[] dp = new int[sum / 2 + 1];
            // 遍历的轮数为物品个数
            for (int i = 0; i < nums.length; i++) {
                // 滚动数组需要从后往前遍历
                for (int j = dp.length - 1; j >= 0; j--) {
                    if (nums[i] <= j) {
                        dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
                    }
                }
                if (dp[dp.length - 1] == sum / 2) {
                    return true;
                }
            }

            // 二维数组版：
            int[][] dp2 = new int[nums.length][sum / 2 + 1];
            // 初始化第一行
            for (int i = nums[0]; i < dp2[0].length; i++) {
                dp2[0][i] = nums[0];
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < dp2[0].length; j++) {
                    if (nums[i] > j) {
                        // 不能添加第 i 个元素，否则超过容量大小
                        dp2[i][j] = dp2[i - 1][j];
                    } else {
                        // 可添加第 i 个元素，则比较添加与不添加哪个收益大
                        // 对于此题，定义每一个物体的重量和价值相同，每个物体性价比都一样，因此尽可能地塞满背包收益大
                        dp2[i][j] = Math.max(dp2[i - 1][j], nums[i] + dp2[i - 1][j - nums[i]]);
                    }
                }
                if (dp2[i][dp2[i].length - 1] == (sum / 2)) {
                    return true;
                }
            }
        }
        return false;
    }


}
// @lc code=end

