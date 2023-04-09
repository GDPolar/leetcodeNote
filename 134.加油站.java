/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 *
 * https://leetcode.cn/problems/gas-station/description/
 *
 * algorithms
 * Medium (51.94%)
 * Likes:    1210
 * Dislikes: 0
 * Total Accepted:    241K
 * Total Submissions: 465.3K
 * Testcase Example:  '[1,2,3,4,5]\n[3,4,5,1,2]'
 *
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一
 * 的。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 
 * 示例 2:
 * 
 * 
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 10^5
 * 0 <= gas[i], cost[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int finStore = 0;
        int curStore = 0;
        int answer = 0;
        for (int i = 0; i < cost.length; i++) {
            curStore += gas[i] - cost[i];
            finStore += gas[i] - cost[i];
            // curStore < 0 表示从 i 前的任一位置出发，到 i 处时都会失败
            // 此时 cost[i] 大于 gas[i] 与之前用剩下的油量之和
            if (curStore < 0) {
                answer = i + 1;
                curStore = 0;
            }
        }
        if (finStore < 0) {
            return -1;
        }
        return answer;

        /* 
        int ans = 0;
        // 油量最低的时候
        int storeMin = Integer.MAX_VALUE;
        // 实时油量
        // 按理来说，从符合要求的位置出发后，实时油量应始终保持大于等于 0
        // 此处强行让实时油量小于零也继续
        int store = 0;
        for (int i = 0; i < gas.length; i++) {
            if (storeMin > store) {
                storeMin = store;
                ans = i;
            }
            store += gas[i];
            store -= cost[i];
        }
        // 总获得小于总消耗，无论从何处出发都不能走完一圈
        if (store < 0) {
            return -1;
        }
        return ans;
        */
    }
}
// @lc code=end

