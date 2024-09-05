package Leetcode;

/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 *
 * https://leetcode.cn/problems/rotting-oranges/description/
 *
 * algorithms
 * Medium (51.34%)
 * Likes:    917
 * Dislikes: 0
 * Total Accepted:    208.9K
 * Total Submissions: 396.8K
 * Testcase Example:  '[[2,1,1],[1,1,0],[0,1,1]]'
 *
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 
 * 
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 
 * 
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 * 
 * 
 */

// @lc code=start

import java.util.ArrayDeque;

class Solution {
    
    // BFS 用来求最短路径

    // 类似树的层序遍历，用队列存
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    int good = 0;

    public int orangesRotting(int[][] grid) {
        int res = 0; 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    good++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty() && good > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] e = queue.poll();
                checkAndOffer(e[0], e[1] + 1, grid);
                checkAndOffer(e[0], e[1] - 1, grid);
                checkAndOffer(e[0] + 1, e[1], grid);
                checkAndOffer(e[0] - 1, e[1], grid);
            }
            res++;
        }
        return good > 0 ? -1 : res;
    }

    public void checkAndOffer(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == 1) {
            good--;
            grid[x][y] = 2;
            queue.offer(new int[]{x, y});
        }
    }
}
// @lc code=end

