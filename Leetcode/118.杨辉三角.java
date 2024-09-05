package Leetcode;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode.cn/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (75.89%)
 * Likes:    1179
 * Dislikes: 0
 * Total Accepted:    547.7K
 * Total Submissions: 717.8K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: numRows = 1
 * 输出: [[1]]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;

// @lc code=start


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> curr = new ArrayList<>(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    curr.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(new ArrayList<>(curr));
        }
        return res;
    }
}
// @lc code=end

