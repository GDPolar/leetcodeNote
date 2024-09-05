package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 *
 * https://leetcode.cn/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (69.13%)
 * Likes:    1467
 * Dislikes: 0
 * Total Accepted:    419.5K
 * Total Submissions: 607.8K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i
 * 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 方法一：单调栈
        // 适用于要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，用单调栈
        // 保持递减栈
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        // 若某位置之后都没有更大的出现，则会一直留在栈内，ans 相应的位置为默认值 0
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pre = stack.pop();
                ans[pre] = i - pre;
            }
            stack.push(i);
        }
        // return ans;

        // 方法二（速度快）：
        int[] res = new int[temperatures.length];
        if (temperatures.length == 1) {
            return res;
        }
        // 从后往前遍历
        for (int i = temperatures.length - 2; i >=0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                res[i] = 1;
            } else {
                int j = res[i + 1] + (i + 1);
                while (true) {
                    if (temperatures[j] > temperatures[i]) { 
                        // 找到了 i 元素右边第一个比它大的元素
                        res[i] = j - i;
                        break;
                    } else if (res[j] == 0) {
                        // i 元素右边最大的元素仍小于等于 i 元素
                        res[i] = 0;
                        break;
                    } else {
                        // 寻找下一个更大的元素
                        j += res[j];
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

