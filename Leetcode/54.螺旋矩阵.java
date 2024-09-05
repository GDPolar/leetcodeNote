package Leetcode;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode.cn/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (50.57%)
 * Likes:    1652
 * Dislikes: 0
 * Total Accepted:    499.1K
 * Total Submissions: 985.9K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 
 * -100 
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        int x = 0, y = 0;
        for (int i = 0; i < matrix.length * matrix[0].length; ) {
            for (int j = 0; j < n - 1; j++) {
                res.add(matrix[x][y++]);
                i++;
            }
            if (m == 1) {
                // 单独一个点也视作符合结束条件
                // 最内部为一长横，即高为 1
                break;
            }
            for (int j = 0; j < m - 1; j++) {
                res.add(matrix[x++][y]);
                i++;
            }
            if (n == 1) {
                // 最内部为一长竖，即宽度为 1
                break;
            }
            for (int j = 0; j < n - 1; j++) {
                res.add(matrix[x][y--]);
                i++;
            }
            for (int j = 0; j < m - 1; j++) {
                res.add(matrix[x--][y]);
                i++;
            }
            m -= 2;
            n -= 2;
            x++;
            y++;
        }
        m = matrix.length;
        n = matrix[0].length;
        if (res.size() < m * n) {
            res.add(matrix[x][y]);
        }
        return res;
    }
}
// @lc code=end

