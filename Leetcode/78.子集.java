package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode.cn/problems/subsets/description/
 *
 * algorithms
 * Medium (81.07%)
 * Likes:    1973
 * Dislikes: 0
 * Total Accepted:    600.9K
 * Total Submissions: 741.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10 
 * nums 中的所有元素 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> r = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        /*
        // 方法一：
        // 每个元素只有选与不选两种状态，故可用二进制保存
        // 数组幂集的个数可有数组元素数计算得出
        for (int i = 0; i < (1 << nums.length); i++) {
            r = new ArrayList<>();
            // 依次查看每一位
            for (int j = 0; j < nums.length ; j++) {
                // 与 1 做与运算，得到二进制的最后一位
                // eg：i = 0b11001，j = 2 时，i 右移两位得到 0b110，与 1 做与得到 0，则表示不选择该位对应的数字
                if ((i >> j & 1) == 1) {
                    r.add(nums[j]);
                }
            }
            res.add(r);
        }
        return res;
        */

        // 方法二：
        // 子集问题与组合类似，子集问题是收集树的所有节点的结果
        // 而组合问题、分割问题是收集树的叶子节点的结果
        backTracking(nums, 0);
        return res;
    }

    public void backTracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(r));
        for (int i = startIndex; i < nums.length; i++) {
            r.add(nums[i]);
            backTracking(nums, i + 1);
            r.remove(r.size() - 1);
        }
    }
}
// @lc code=end

