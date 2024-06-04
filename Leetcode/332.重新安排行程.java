package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 *
 * https://leetcode.cn/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Hard (47.58%)
 * Likes:    752
 * Dislikes: 0
 * Total Accepted:    81.1K
 * Total Submissions: 170.5K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi]
 * 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * 
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK
 * 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * 
 * 
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 
 * 
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * 输出：["JFK","MUC","LHR","SFO","SJC"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * tickets[i].length == 2
 * fromi.length == 3
 * toi.length == 3
 * fromi 和 toi 由大写英文字母组成
 * fromi != toi
 * 
 * 
 */

// @lc code=start
class Solution {

    private ArrayList<String> res;
    private Map<String, Map<String, Integer>> map;

    private boolean backTracking(int ticketNum){
        if(res.size() == ticketNum + 1){
            return true;
        }
        String last = res.get(res.size() - 1);
        // map 不包含 last，表示无法找到下一程，此方案错误
        if(map.containsKey(last)){
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res.add(target.getKey());
                    target.setValue(--count);
                    if(backTracking(ticketNum)) return true;
                    res.remove(res.size() - 1);
                    target.setValue(++count);
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new ArrayList<>();
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(map.containsKey(t.get(0))){
                // 相同起点和终点的票
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                temp = new TreeMap<>();//升序Map
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);
        }
        res.add("JFK");
        backTracking(tickets.size());
        return res;
    }

    /*
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    int[] set;
    public List<String> findItinerary(List<List<String>> tickets) {
        set = new int[tickets.size()];
        // List<String>.get(0) 是元素的选择条件，实际选的元素是 get(1)
        // 故按元素排序即按 get(1) 的大小排序
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        backTracking(tickets, "JFK", 0);
        List<String> realRes = new ArrayList<>();
        realRes.add("JFK");
        for (int i = 0; i < res.size(); i++) {
            realRes.add(res.get(i));
        }
        return realRes;
    }

    public boolean backTracking(List<List<String>> tickets, String currPosition, int used) {
        if (used == tickets.size()) {
            res = new ArrayList<>(path);
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (i > 0 && tickets.get(i).get(0).equals(tickets.get(i - 1).get(0)) && tickets.get(i).get(1).equals(tickets.get(i - 1).get(01))) {
                // 同样的票
                continue;
            }
 
            if (set[i] != 1 && tickets.get(i).get(0).equals(currPosition)) {
                currPosition = tickets.get(i).get(1);
                path.add(currPosition);
                set[i] = 1;
                // 由于排好序了，第一个到达的叶子节点的路径即是符合题目的字典序最小的答案
                if (backTracking(tickets, currPosition, used + 1)) {
                    return true;
                }
                set[i] = 0;
                currPosition = tickets.get(i).get(0);
                path.remove(path.size() - 1);
            }

        }
        return false;
    }
    */

}
// @lc code=end

