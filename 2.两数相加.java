import java.util.List;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */


 
// 简化代码
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, p = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = p = new ListNode(sum % 10);
            } else {
                p.next = new ListNode(sum % 10);
                p = p.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return head;
    }
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l1.next == null) return l2;
        if (l2.val == 0 && l2.next == null) return l1;
        ListNode res = new ListNode(0);
        ListNode p = null;
        ListNode t = res;
        int carry = 0;
        while (l1 != null && l2 != null) {
            res.val = l1.val + l2.val + carry;
            carry = res.val > 9 ? 1 : 0;
            res.val -= carry * 10;
            res.next = new ListNode(0);
            p = res;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            res.val = l1.val + carry;
            carry = res.val > 9 ? 1 : 0;
            res.val -= carry * 10;
            res.next = new ListNode(0);
            p = res;
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            res.val = l2.val + carry;
            carry = res.val > 9 ? 1 : 0;
            res.val -= carry * 10;
            res.next = new ListNode(0);
            p = res;
            res = res.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            res.val = 1;
        } else {
            p.next = null;
        }
        return t;
    }
}
// @lc code=end


