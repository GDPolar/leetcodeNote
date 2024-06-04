package Leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map.Entry;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 *
 * https://leetcode.cn/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (49.83%)
 * Likes:    2228
 * Dislikes: 0
 * Total Accepted:    423.2K
 * Total Submissions: 849.8K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
 * 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回 滑动窗口中的最大值 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * 
 * 
 */

// @lc code=start
class Solution {
    // 正常做法：使用单调双端队列
    Deque<Integer> deque = new LinkedList<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            addAfterChecked(nums, i);
        }
        for (int i = k - 1; i < nums.length; i++) {
            addAfterChecked(nums, i);
            // 队头元素为窗口的最大值
            res[i - k + 1] = deque.peek();
            // 此轮滑出的元素正好是原窗口内最大元素，将其删除
            if (deque.peek() == nums[i - k + 1]) {
                deque.remove();
            }
        }   
        return res;
    }
    // 向队尾添加元素前先丢掉队列中所有小于它的元素
    // 保证队列为单调递减
    private void addAfterChecked(int[] nums, int index) {
        while (!deque.isEmpty() && deque.getLast() < nums[index]) {
            // 由队列单调递减，故从尾部遍历删除
            deque.removeLast();
        }
        deque.add(nums[index]);
    }
}
    /*
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        // 第一个窗口要特殊处理，因为如下代码虽然理论上可行，但是测试样例有变态的样例
        // eg1 输入：nums = [1,2,3...500000,500001], k = 500000
        // eg2 输入：nums = [2147483647,2147483647...,2147483647], k = 500000
        // 巨恶心，直接把耗时从 3 ms 拖到 1000 ms
        // for (int i = 0; i < k; i++) {
        //     if (nums[i] >= max) {
        //         maxIndex = i;
        //         max = nums[i];
        //     }
        // }

        int left = 0;
        for (int right = k - 1; right < n; right++) {
            // 最大值仍在窗口内
            if (left <= maxIndex) {
                // 新加入的元素小于仍处在窗口内的原最大元素
                if (nums[right] >= nums[maxIndex]) {
                    maxIndex = right;
                    max = nums[right];
                }
            }

            // 以下两个 else if 分支只会在第一个窗口内执行
            // 专门为变态测试样例优化
            else if (nums[right] >= max -1) {
                maxIndex = right;
                max = nums[right];
            }
            else if (nums[left] >= max - 1) {
                maxIndex = left;
                max = nums[left];
            }

            else {
                // 重新在窗口中找最大值
                max = Integer.MIN_VALUE;
                for (int j = left; j <= right; j++) {
                    if (nums[j] >= max) {
                        maxIndex = j;
                        max = nums[j];
                    }
                }
            }
            ans[left++] = max;
        }
        return ans;
    }


    // [-7,-8,7,5,7,1,6,0]\n4
    // [1,3,6,-1,2,-3,3,6,7]\n3
}
*/
// @lc code=end

