package Leetcode;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 *
 * https://leetcode.cn/problems/course-schedule/description/
 *
 * algorithms
 * Medium (53.96%)
 * Likes:    1997
 * Dislikes: 0
 * Total Accepted:    444.6K
 * Total Submissions: 818.3K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi]
 * ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 
 * 
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 
 * 
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 
 * 示例 2：
 * 
 * 
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 * 
 * 
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    // 课程的依赖关系用有向图描述
    // 没有先决条件限制的课程即入度为 0 的节点
    // 入度为 0 的节点入列，然后逐个出列，减小直接后续节点的入度。
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        // map 存储每个节点的直接后续节点
        HashMap<Integer, ArrayList<Integer>> outMap = new HashMap<>(numCourses);
        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            ArrayList<Integer> out;
            if ((out = outMap.get(p[1])) == null) {
                out = new ArrayList<>();
                outMap.put(p[1], out);
            }
            out.add(p[0]);
        }
        // 入度为 0 的节点入队
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 节点出列后，将后续节点入度 - 1
                int course = queue.poll();
                ArrayList<Integer> out = outMap.get(course);
                if (out != null) {
                    // 后续节点入度新变为 0，则安排入列
                    out.forEach((e) -> {
                        if (--indegree[e] <= 0) {
                            queue.offer(e);
                        }
                    });
                }
            }
        }
        for (int i : indegree) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

