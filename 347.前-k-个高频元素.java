import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 *
 * https://leetcode.cn/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (63.51%)
 * Likes:    1518
 * Dislikes: 0
 * Total Accepted:    411.8K
 * Total Submissions: 648.5K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * 
 * 
 * 
 * 
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * 
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // ①：由优先队列实现一个容量为 k 的小顶堆
        // 保存频率最大的 k 个元素，且堆顶是这 k 个里面频率最小的
        // ②：由优先队列实现一个大顶堆，依次弹出 k 个元素作为答案
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (queue.size() < k){
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            }
            else {
                // 若待加入的元素的频率比堆顶元素频率还小，跳过该元素
                // 否则如下弹出堆顶最小元素，然后加入新元素
                if(entry.getValue() > queue.peek()[1]) {
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
// @lc code=end

