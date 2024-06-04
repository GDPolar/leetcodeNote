package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode.cn/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (49.28%)
 * Likes:    1866
 * Dislikes: 0
 * Total Accepted:    617.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        ArrayList<int[]> list = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > temp[1]) {
                // [1,4], [6,7]
                list.add(temp);
                temp = intervals[i];
            } else if (intervals[i][1] <= temp[1]) {
                // [1,4], [1,3], [1,4], [1,5], [2,4]
                continue;
            } else {
                // [1,4], [2, 5], [5, 9]
                temp[1] = Math.max(temp[1], intervals[i][1]);
            }
        }
        if (list.size() >= 1) {
            int[] last = list.get(list.size() - 1);
            if (last[1] >= temp[0]) {
                temp[1] = Math.max(temp[1], last[1]);
                list.remove(list.size() - 1);
            }
        }
        list.add(temp);
        return list.toArray(new int[list.size()][]);
    }
}
// @lc code=end

