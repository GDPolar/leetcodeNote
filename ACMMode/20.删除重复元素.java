/**
 * 
题目描述
根据一个递增的整数序列构造有序单链表，删除其中的重复元素

输入描述
输入包括多组测试数据，每组测试数据占一行，第一个为大于等于0的整数n，表示该单链表的长度，后面跟着n个整数，表示链表的每一个元素。整数之间用空格隔开

输出描述
针对每组测试数据，输出包括两行，分别是删除前和删除后的链表元素，用空格隔开
如果链表为空，则只输出一行，list is empty

输入示例
5 1 2 3 4 5
5 1 1 2 2 3
0

输出示例
1 2 3 4 5 
1 2 3 4 5 
1 1 2 2 3 
1 2 3 
list is empty


 */

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
    public ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println("list is empty ");
                continue;
            }
            ListNode head = new ListNode();
            ListNode tail = head;
            int last = -1;
            while (n-- > 0) {
                int v = sc.nextInt();
                if (v != last) {
                    ListNode t = new ListNode(v);
                    tail.next = t;
                    tail = t;
                    last = v;
                }
            }
            printLinkedList(head);
            if (head.next != null) {
                removeDuplicates(head);
                printLinkedList(head);
            }
        }
        sc.close();
    }

    public static void printLinkedList(ListNode head) {
        if (head.next == null) {
            System.out.println("list is empty ");
            return;
        }
        ListNode node = head.next;
        while (node != null) {
            System.out.print(node.val);
        }
        System.out.println();
    }

    public static void removeDuplicates(ListNode head) {
        int last = -1;
        ListNode prev = head, curr = head.next;
        while (curr != null) {
            if (curr.val == last) {
                prev.next = curr.next;
                curr.next = null;
            } else {
                last = curr.val;
                prev = curr;
                curr = curr.next;
            }
        }
    }
}