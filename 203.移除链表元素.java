/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 添加虚拟头节点
        ListNode vhead = new ListNode();
        vhead.next = head;
        // 前后指针
        ListNode p = vhead, q = p.next;
        while (q != null) {
            if (q.val == val) {
                p.next = q.next;    
                // 注意记得更新 q 指针
                q = q.next;
                continue;
            } 
            p = q;
            q = q.next;
        }
        return vhead.next;
    }
}
// @lc code=end

