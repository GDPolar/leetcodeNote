package 笔试真题;

import java.util.Scanner;

/**
 * 小美的完美矩阵

小美拿到了一个n * n 的矩阵，其中每个元素是 0 或者 1。
小美认为一个矩形区域是完美的，当且仅当该区域内 0 的数量恰好等于 1 的数量。
现在，小美希望你回答有多少个i*i的完美矩形区域。你需要回答1<=i<=n的所有答案。


输入描述：
第一行输入一个正整数n，代表矩阵大小。
接下来的n行，每行输入一个长度为n的01 串，用来表示矩阵。


输出描述：
输出n行，第i行输出的i*i 完美矩形区域的数量。

样例输入：
4
1010
0101
1100
0011

样例输出：
0
7
0
1

 */

public class Test240309美团3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s.charAt(j) - '0';
            }
        }
        sc.close();
        // leftUpSum[i][j] 记录 matrix[i+1][j+1] 左上方的所有元素和（含自己）
        int[][] leftUpSum = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                leftUpSum[i][j] = leftUpSum[i-1][j] + leftUpSum[i][j-1] - leftUpSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        for (int k = 1; k <= n; k++) {
            int count = 0;
            // 枚举所有的边长 i 的正方形，判断正方形的和是否为 n*n/2
            for (int i = 0; i <= n-k; i++) {
                for (int j = 0; j <= n-k; j++) {
                    int currSum = leftUpSum[i+k][j+k] - leftUpSum[i][j+k] - leftUpSum[i+k][j] + leftUpSum[i][j]; 
                    if (currSum * 2 == k * k) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
