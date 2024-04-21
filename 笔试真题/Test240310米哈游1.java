package 笔试真题;

import java.util.Scanner;

/**
 * 小盖和蹦蹦史莱姆
 * 
题目描述：
地图上有 n 个格子排成一排，最左边的格子为1，最右边的格子为n。
第 0 秒时，每个格子都有一只史莱姆。
第 i 只史莱姆的跳跃方向用数组 a 表示。
a[i]=0 表示史莱姆跳跃的方向是往左。
若第 i 秒史莱姆位于格子 x，那么第 i+1 秒史莱姆会跳到格子x-1 。如果当前史莱姆在格子1，则下一秒史莱姆将跳出地图。
a[i]=1 表示史莱姆跳跃的方向是往右。
若第 i 秒史莱姆位于格子 x，那么第 i+1 秒史莱姆会跳到格子x+1 。如果当前史莱姆在格子n，则下一秒史莱姆将跳出地图。

米小游想知道第1~n秒，地图上有多少个格子没有史菜姆

输入描述：
第一行包含一个整数n，n∈[1,3000]，表示地图上的格子数量。
第二行包含n 个整数ai，ai∈[0,1]，表示每只史莱姆的跳跃方向。

输出描述：
输出1~n秒格子上没有史莱姆的数量

样例

输入：
3
1 0 1

输出：
1 2 3

说明：
史莱姆1~3的跳跃方向分别为，往右，往左，往右。
第1秒，史莱姆1跳到格子 2，史菜姆2跳到格子1，史菜姆3跳出地图，格子3没有史莱姆。
第2秒，史莱姆1跳到格子3，史莱姆2跳出地图，格子1 2 没有史莱姆。
第3秒，史莱姆1跳出地图，格子1,2,3 没有史莱姆。

 */

public class Test240310米哈游1 {
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

        
    }
}
