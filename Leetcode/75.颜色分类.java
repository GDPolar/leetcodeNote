package Leetcode;

/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 *
 * https://leetcode.cn/problems/sort-colors/description/
 *
 * algorithms
 * Medium (61.18%)
 * Likes:    1785
 * Dislikes: 0
 * Total Accepted:    645.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 
 * 
 * 
 * 
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * 
 * 
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // 俩指针都是开区间
        int ptr0 = 0, ptr2 = nums.length - 1;
        for (int i = 0; i < ptr2 + 1; i++) {
            // 遍历是从左到右的，因此和尾部的二段边界交换后，要进一步处理
            while (i <= ptr2 && nums[i] == 2) {
                nums[i] = nums[ptr2];
                nums[ptr2] = 2;
                ptr2--;
            }
            // 遍历是从左到右的，因此和头部的零段边界交换后，换来的数一定不为 0
            if (nums[i] == 0) {
                nums[i] = nums[ptr0];
                nums[ptr0] = 0;
                ptr0++;
            }
        }
    }
}
// @lc code=end

