/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (44.93%)
 * Likes:    2410
 * Dislikes: 0
 * Total Accepted:    337.4K
 * Total Submissions: 750.9K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入： heights = [2,4]
 * 输出： 4
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        // 保存 i 位置的左侧第一个小于 heights[i] 的柱子的位置
        int[] minLeftIndex = new int[heights.length];
        // 保存 i 位置的右侧第一个小于 heights[i] 的柱子的位置
        int[] minRightIndex = new int[heights.length];
        int size = heights.length;

        // 此处初始化为 -1，防止下面 while 死循环
        minLeftIndex[0] = -1; 
        for (int i = 1; i < size; i++) {
            int t = i - 1;
            // 这里不是用 if，而是不断向左寻找
            while (t >= 0 && heights[t] >= heights[i]) {
                t = minLeftIndex[t];
            }
            // 上面 minLeftIndex[0] = -1 为开区间，则此处也应为开区间
            minLeftIndex[i] = t;
        }
        // 此处初始化为 size，防止下面 while 死循环
        minRightIndex[size - 1] = size; 
        for (int i = size - 2; i >= 0; i--) {
            int t = i + 1;
            // 这里不是用 if，而是不断向右寻找
            while (t < size && heights[t] >= heights[i]) {
                t = minRightIndex[t];
            }
            // 上面 minRightIndex[size - 1] = size 为开区间，则此处也应为开区间
            minRightIndex[i] = t;
        }
        
        int ans = 0;
        for (int i = 0; i < size; i++) {
            // 开区间 (minLeftIndex[i], minRightIndex[i])
            ans = Math.max(heights[i] * (minRightIndex[i] - minLeftIndex[i] - 1), ans);
        }
        return ans;


        /*
        // 暴力法（超时）
        for (int i = 0; i < heights.length; i++) {
            int left = i, right = i;
            while (left >= 0) {
                if (heights[left] < heights[i]) {
                    break;
                }
                left--;
            }
            while (right < heights.length) {
                if (heights[right] < heights[i]) {
                    break;
                }
                right++;
            }
            ans = Math.max(ans, (right - left - 1) * heights[i]);
        }
        return ans;
         */
    }
}
// @lc code=end

