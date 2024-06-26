package Leetcode;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 *
 * https://leetcode.cn/problems/number-of-provinces/description/
 *
 * algorithms
 * Medium (62.18%)
 * Likes:    1107
 * Dislikes: 0
 * Total Accepted:    305.9K
 * Total Submissions: 492K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * 
 * 
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c
 * 间接相连。
 * 
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而
 * isConnected[i][j] = 0 表示二者不直接相连。
 * 
 * 返回矩阵中 省份 的数量。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    // 并查集
    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int res = 0;
        int[] set = new int[isConnected.length];
        for (int i = 0; i < parent.length; i++) {
            int p = find(i);
            if (set[p] == 0) {
                res++;
                set[p] = 1;
            }
        }
        return res;
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

