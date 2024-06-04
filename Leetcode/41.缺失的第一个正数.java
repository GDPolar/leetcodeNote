package Leetcode;

/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 *
 * https://leetcode.cn/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (44.30%)
 * Likes:    2098
 * Dislikes: 0
 * Total Accepted:    382K
 * Total Submissions: 859.2K
 * Testcase Example:  '[1,2,0]'
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {

    // https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/description/
    // 元素的取值范围为 [0, n-1]，因此可将原数组当哈希表用
    public int findRepeatDocument(int[] documents) {
        for (int i = 0; i < documents.length; i++) {
            while (documents[i] != i) {
                int targetIndex = documents[i];
                // 注意跳出，否则死循环
                if (documents[targetIndex] == documents[i]) {
                    return documents[i];
                }
                int temp = documents[targetIndex];
                documents[targetIndex] = documents[i];
                documents[i] = temp;
            }
        }
        return -1;
    }

    // 此题与上题类似，虽然元素的取值范围为正负无穷，但真正有存储到哈希表意义的只有取值范围为 [1, n] 的元素
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i+1) {
                int tar = nums[i] - 1;
                // 注意跳出，否则死循环
                if (nums[i] == nums[tar]) {
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[tar];
                nums[tar] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
// @lc code=end

