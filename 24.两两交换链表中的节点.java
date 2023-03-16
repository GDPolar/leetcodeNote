/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp;
        // 创建虚拟头节点
        ListNode vHead = new ListNode(0, head);
        // 每两两交换前 prev.next 始终指向待交换的前一个节点
        ListNode prev = vHead;
        // 到表尾或只剩一个节点，则结束
        while(prev.next != null && prev.next.next != null) {
            // 保存原第一个节点
            temp = prev.next;
            // 原第二个节点移到 prev 的 next 处
            prev.next = prev.next.next;
            // 原第二个节点后面的尾巴交给原第一个节点
            temp.next = prev.next.next;
            // 原第一个节点接到原第二个节点（现第一个节点）后面
            prev.next.next = temp;
            // 更新 prev
            prev = temp;
        }
        return vHead.next;
    }
}
// @lc code=end

