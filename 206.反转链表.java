/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        /*
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head, curr = prev.next, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            if (prev == head) {
                prev.next = null;
            }
            prev = curr;
            curr = temp;
        }
        return prev;
        */

        // 递归
        if (head == null || head.next == null) {
            return head;
        }
        // 将函数看作黑盒，输入一个链表的头节点，函数将链表反转，并返回反转后的头（即原链表的尾）
        // 输入 head.next，则反转从 head.next 到最后的链表
        // 此时 head 仍指向反转后的链表，即 head.next 为反转后链表的尾
        ListNode reHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;    
    }
}
// @lc code=end

