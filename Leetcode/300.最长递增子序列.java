/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 *
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (54.77%)
 * Likes:    3239
 * Dislikes: 0
 * Total Accepted:    745K
 * Total Submissions: 1.4M
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7]
 * 的子序列。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * 
 * 
 */

// @lc code=start

class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            // dp[j] 表示从 0 到 j 以 nums[j] 结尾的最长序列的长度
            // 因为子序列不一定连续，故遍历到第 i 个节点时不能只考虑第 i - 1 个节点
            // 要考虑 0 到 i - 1 的所有节点，故再次循环
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
        */


        // 方法二：修改状态定义，复杂度 nlogn
        // 已经得到的上升子序列的结尾的数越小，那么遍历的时候后面接上一个数，会有更大的可能构成一个长度更长的上升子序列
        // tail[i] 表示长度为 i + 1 的所有上升子序列的结尾的最小值
        // eg：[10, 9, 2, 5, 3, 7] 中，tail[0] = 2, tail[1] = 3, tail[2] = 7
        // 可证明数组 tail 也严格上升
        // 状态转移规则：
        // 若新数 num 大于 tail 的最后一个元素，则放在最后，否则
        // 找到 tail 中存在的第一个大于 num 的元素用 num 替换，使 tail 数组中的元素尽可能小

        // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小的元素
        int[] tail = new int[nums.length];
        tail[0] = nums[0];
        // end 表示有序数组 tail 的实际长度
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            // 新元素比 tail 数组实际有效的末尾的那个元素还大
            if (nums[i] > tail[end]) {
                // 直接添加在那个元素的后面
                tail[++end] = nums[i];
            } else {
                // 二分查找
                // 在有序数组 tail 中，找到第一个大于等于 nums[i] 的元素，尝试让那个元素更小
                int left = 0;
                int right = end;
                // [左闭右开)
                while (left < right) {
                    int mid = left + ((right - left) / 2);
                    if (tail[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                // 若 tail 中存在与 num[i] 相等的数，则此时 left 所指位置即为该元素位置
                // 若 tail 中不存在与 num[i] 相等的数，则此时 left 所指位置即为第一个大于 nums[i] 的元素
                tail[left] = nums[i];
            }
        }
        return end + 1;
    }
}
// @lc code=end

