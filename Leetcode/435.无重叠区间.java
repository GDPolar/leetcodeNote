package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 *
 * https://leetcode.cn/problems/non-overlapping-intervals/description/
 *
 * algorithms
 * Medium (51.11%)
 * Likes:    942
 * Dislikes: 0
 * Total Accepted:    211.6K
 * Total Submissions: 413.9K
 * Testcase Example:  '[[1,2],[2,3],[3,4],[1,3]]'
 *
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回
 * 需要移除区间的最小数量，使剩余区间互不重叠 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= intervals.length <= 10^5
 * intervals[i].length == 2
 * -5 * 10^4 <= starti < endi <= 5 * 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, (e1, e2) -> {
            // 排序很耗时，此处少做一层，后续处理时再比较，整体时间少很多
            // if (e1[0] == e2[0]) {
            //     return Integer.compare(e1[1], e2[1]);
            // }
            return Integer.compare(e1[0], e2[0]);
        });
        int ans = 0;
        // int[] rightBorder = intervals[0];
        // // [1,4], [1,3], [1,4], [1,5], [2,4], [2,5], [2,3], [3,9], [4,5], [6,7]
        // for (int i = 1; i < intervals.length; i++) {
        //     if (intervals[i][0] == rightBorder[0]) {
        //         // [1,4], [1,3], [1,4], [1,5]
        //         if (intervals[i][1] < rightBorder[1]) { rightBorder = intervals[i];}
        //         ans++;
        //     } else if (intervals[i][0] >= rightBorder[1]) {
        //         // [1,4], [4,5], [6,7]
        //         rightBorder = intervals[i];
        //         continue;
        //     } else if (intervals[i][1] <= rightBorder[1]) {
        //         // [1,4], [2,4], [2,3]
        //         rightBorder = intervals[i];
        //         ans++;
        //     } else {
        //         // [1,4], [2,5], [3,9]
        //         ans++;
        //     }
        // }

        // 优化 rightBorder
        int rightBorder = intervals[0][1];
        // [1,4],[1,3],[1,4],[1,5],[2,4],[2,5],[2,3],[3,9],[4,5],[6,7]
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= rightBorder) {
                // 没有重叠
                // [1,4], [4,5], [6,7]
                rightBorder = intervals[i][1];
                continue;
            } else if (intervals[i][1] <= rightBorder) {
                // [1,4], [1,3], [1,4], [1,5], [2,4], [2,5], [2,3]
                if (intervals[i][1] < rightBorder) { rightBorder = intervals[i][1];}
                ans++;
            } else {
                // [1,4], [2, 5], [3, 9]
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

