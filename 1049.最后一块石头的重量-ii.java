import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 *
 * https://leetcode.cn/problems/last-stone-weight-ii/description/
 *
 * algorithms
 * Medium (69.01%)
 * Likes:    660
 * Dislikes: 0
 * Total Accepted:    118.6K
 * Total Submissions: 171.7K
 * Testcase Example:  '[2,7,4,1,8,1]'
 *
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 
 * 
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 
 * 
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {

    // 注意方法二中的剪枝！

    // 方法一：dp
    // 背包容量为 sum/2 
    // 第 i 个物品的重量、价值为 stones[i]，性价比都一样
    // 故欲使背包装满得到的总价值最大 等价于 背包装的重量最大
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[][] dp = new int[stones.length][target + 1];

        // 初始化第一行
        for (int i = stones[0]; i < dp[0].length; i++) {
            dp[0][i] = stones[0];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], stones[i] + dp[i - 1][j - stones[i]]);
                }
            }
        }

        return Math.abs(sum - 2 * dp[dp.length - 1][dp[0].length - 1]);
    }

    /*
    // 方法二：回溯。剪枝后速度比方法一快，为 0 ms
    int target;
    int ans = Integer.MAX_VALUE;
    public int lastStoneWeightI(int[] stones) {
        // 问题转化为：
        // 将给定的数组分为两个子集，欲求这两个子集的和的最小差值 
        // 答案求的两个子集就分别是 小于等于 sum/2 的最大和子集、大于等于 sum/2 的最小和子集
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        target = sum / 2;
        Arrays.sort(stones);

        // 通过回溯找和大于等于 sum/2 的最小子集
        // 即使 sum >= target 的条件下尽可能地小
        // 从大端开始
        backtracking(stones, stones.length - 1, 0);

        return Math.abs(sum - 2 * ans); 
    }
    
    // 返回值表示是否还要继续找
    private boolean backtracking(int[] stones, int index, int sum) { //找大于target的最小ns
        
        // 直接速通，找到了最终答案
        // sum 为奇数，最终答案为 1
        // sum 为偶数，最终答案为 0
        if (sum == target) {
            ans = target;
            return false;
        } 

        // 剪枝
        // 若 sum >= ans，后续操作必定也 >= ans，故跳过此次
        // 能减少 99.9744% 的耗时
        if (sum >= ans) {
            return true;
        }

        // 从后到前遍历完了一遍数组
        if (index < 0) {
            // 子集和大于等于 sum/2
            // 判断其是不是所有答案中和最小的
            if (sum >= target){
                ans = Math.min(sum, ans);
            }
            return true; 
        }

        // 先选，再不选，使尽早出现 sum >= target
        if (backtracking(stones, index - 1, sum + stones[index]) == true) {
            return backtracking(stones, index - 1, sum); 
        }

        // 运行到此处，表明 backtracking(stones, index - 1, sum + stones[index]) == false
        // 即在 backtracking(stones, index - 1, sum + stones[index]) 中已经找到了最终结果使 sum == target
        return false;
    }
    */
}
// @lc code=end

