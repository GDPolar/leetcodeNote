/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (61.66%)
 * Likes:    2434
 * Dislikes: 0
 * Total Accepted:    1M
 * Total Submissions: 1.7M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * 
 * 
 * 
 * 提示： 
 * 
 * 
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 快排和堆排序时间复杂度为 nlogn
        // 可使用快排的思想，只要某次划分确定的数最终位于倒数第 k 个下标的时候，就找到答案
        // 或堆排序的思想，找到第 k 大的元素就是答案
        int length = nums.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(nums, length, i);
        }
        for (int i = length - 1; i >= length - k; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
        return nums[length - k];

    }
    public void heapify(int[] nums, int length, int current) {
        int lchild = 2 * current + 1;
        int rchild = 2 * current + 2;
        int max = current;
        if (lchild < length && nums[max] < nums[lchild]) {
            max = lchild;
        }
        if (rchild < length && nums[max] < nums[rchild]) {
            max = rchild;
        }
        if (max != current) {
            int temp = nums[current];
            nums[current] = nums[max];
            nums[max] = temp;
            heapify(nums, length, max);
        }
    }
}
// @lc code=end

