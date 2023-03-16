/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int step = n - 1;
        // x、y 为每一圈的起点，初始位于左上角
        int x = 0, y = 0;
        // 一圈圈地模拟
        while (step > 0) {
            int i = x, j = y;
            int temp;
            // [左上, 右上)
            for (temp = 0; temp < step; temp++) {
                res[i][j++] = num++;
            }
            // [右上, 右下)
            for (temp = 0; temp < step; temp++) {
                res[i++][j] = num++;
            }
            // [右下, 左下)
            for (temp = 0; temp < step; temp++) {
                res[i][j--] = num++;
            }
            // [左下, 左上)
            for (temp = 0; temp < step; temp++) {
                res[i--][j] = num++;
            }
            // 转完一圈后，指针回到起点，下一圈的起点位于右下方
            x = i + 1;
            y = j + 1;
            step -= 2;
        }
        if (n % 2 == 1) {
            res[x][y] = n * n;
        }
        return res;
    }
}
// @lc code=end

