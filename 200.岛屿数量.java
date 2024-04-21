/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode.cn/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (60.30%)
 * Likes:    2461
 * Dislikes: 0
 * Total Accepted:    805.4K
 * Total Submissions: 1.3M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：grid = [
 * ⁠ ["1","1","1","1","0"],
 * ⁠ ["1","1","0","1","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","1","0","0"],
 * ⁠ ["0","0","0","1","1"]
 * ]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 
 * grid[i][j] 的值为 '0' 或 '1'
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int x, int y) {
        // 二叉树的 DFS 使用 root == null 检查合法性结束递归
        // 此问题使用 (x, y) 坐标检查合法性结束递归
        if (0 <= x && x < grid.length && 0 <= y && y < grid[0].length) {
            if (grid[x][y] == '1') {
                // 二叉树的 DFS 不会重复访问，此问题用标记来防止重复访问
                grid[x][y] = '2';
                dfs(grid, x - 1, y);
                dfs(grid, x + 1, y);
                dfs(grid, x, y - 1);
                dfs(grid, x, y + 1);
            }
        }
    }


    // 方法二：并查集
    int[] parent;
    int cs;
    public int numIslands2(char[][] grid) {
        parent = new int[grid.length * grid[0].length];
        cs = grid[0].length;
        for (int i = 0; i < parent.length; i++) {
            if (grid[i / cs][i % cs] == '1') {
                parent[i] = i;
            } else {
                parent[i] = -1;
            }
        }
        //合并第一行
        for (int j = 1; j < grid[0].length; j++) {
            if (grid[0][j - 1] == '1' && grid[0][j] == '1') {
                union(j - 1, j);
            }
        }
        //合并第一列
        for (int i = 1; i < grid.length; i++) {
            if (grid[i - 1][0] == '1' && grid[i][0] == '1') {
                union(cs * (i - 1), cs * i);
            }
        }


        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                // 合并上一行
                if (grid[i][j] == '1' && grid[i][j-1] == '1') {
                    union(f(i, j), f(i, j - 1));
                } 
                // 合并上一列
                if (grid[i][j] == '1' && grid[i-1][j] == '1') {
                    union(f(i, j), f(i - 1, j));
                } 
            }
        }
        int res = 0;
        int[] set = new int[parent.length];
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                int p = find(i);
                if (set[p] == 0) {
                    res++;
                    set[p] = 1;
                }
            }
        }
        return res;
    }

    public int f(int i, int j) {
        return i * cs + j;
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
// @lc code=end

