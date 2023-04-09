import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 *
 * https://leetcode.cn/problems/candy/description/
 *
 * algorithms
 * Hard (49.51%)
 * Likes:    1165
 * Dislikes: 0
 * Total Accepted:    204.5K
 * Total Submissions: 413.3K
 * Testcase Example:  '[1,0,2]'
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 
 * 
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 
 * 
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * ⁠    第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == ratings.length
 * 1 <= n <= 2 * 10^4
 * 0 <= ratings[i] <= 2 * 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] dpl = new int[ratings.length];
        dpl[0] = 0;
        int anser = 0;
        // dp 思想，dpl[i] 的值表示 ratings[i] 元素左侧连续递减序列长度
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dpl[i] = dpl[i - 1] + 1;
            } else {
                dpl[i] = 0;
            }
        }
        // 同理，dpr[i] 的值表示 ratings[i] 元素右侧连续递减序列长度
        // 此处只需要用到 dpr[] 中临近的两个值，故可以简化为只保存 dpr[i+1] 和 dpr[i]
        // prevRight 即 dpr[i + 1]，currRight 即 dpr[i]
        int prevRight = 0, currRight = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i + 1 < ratings.length && ratings[i] > ratings[i + 1]) {
                currRight = prevRight + 1;
            } else {
                currRight = 0; 
            }
            anser += Math.max(currRight, dpl[i]) + 1;
            prevRight = currRight;
        }
        return anser;
    }
}
// @lc code=end

