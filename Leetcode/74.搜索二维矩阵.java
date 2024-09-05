package Leetcode;

/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode.cn/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (49.60%)
 * Likes:    944
 * Dislikes: 0
 * Total Accepted:    430.4K
 * Total Submissions: 861.7K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3'
 *
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 
 * 
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0, d = matrix.length - 1;
        while (t <= d) {
            int m = t + (d - t) / 2;
            if (matrix[m][0] == target) {
                return true;
            } else if (matrix[m][0] < target) {
                t = m + 1;
            } else {
                d = m - 1;
            }
        }
        if (d < 0) {
            return false;
        }
        int l = 0, r = matrix[0].length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (matrix[d][m] == target) {
                return true;
            } else if (matrix[d][m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
// @lc code=end

