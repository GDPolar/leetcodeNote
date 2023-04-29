/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode.cn/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (62.53%)
 * Likes:    4283
 * Dislikes: 0
 * Total Accepted:    674.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // 方法一：
        int ans = 0;
        int[] lMaxHeight = new int[height.length];
        int[] rMaxHeight = new int[height.length];
        // 找到所有列的左侧最高高度和右侧最高高度
        lMaxHeight[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            lMaxHeight[i] = Math.max(lMaxHeight[i - 1], height[i]);
        }
        rMaxHeight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rMaxHeight[i] = Math.max(rMaxHeight[i + 1], height[i]);
        }
        // 两侧不积水
        for (int i = 1; i < height.length - 1; i++) {
            // 当前列积水高度 = min（左边柱子的最高高度，记录右边柱子的最高高度）- 当前柱子高度
            int min = Math.min(lMaxHeight[i], rMaxHeight[i]);
            if (min > height[i]) {
                ans += min - height[i];
            }
            // [2, 1, _ 1, 2]
        }
        // return ans;

        // 方法二：
        ans = 0;
        return ans;
    }
}
// @lc code=end

