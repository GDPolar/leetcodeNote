package Leetcode;

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
        ListNode vHead = new ListNode();
        vHead.next = head;
        ListNode node = vHead;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
                // 进行过删除操作后，指针不应移动
            } else {
                node = node.next;
            }
        }
        return vHead.next;
    }
}
// @lc code=end

