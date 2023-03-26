import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode.cn/problems/combinations/description/
 *
 * algorithms
 * Medium (77.26%)
 * Likes:    1321
 * Dislikes: 0
 * Total Accepted:    505.3K
 * Total Submissions: 654.5K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 
 * 你可以按 任何顺序 返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> r = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return res;
    }

    public void backTracking(int n, int k, int startIndex) {
        if (k == 0) {
            res.add(new ArrayList<>(r));
            return;
        }
        // i <= n - k + 1 剪枝操作
        for (int i = startIndex; i <= n - k + 1; i++) {
            r.add(i);
            backTracking(n, k - 1, i + 1);
            // 执行至此，意味着向 res 里添加了一个结果
            // 回溯，撤销处理的节点
            r.remove(r.size() - 1);
        }
    }
}
// @lc code=end

