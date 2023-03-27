/**
 * @program: leetcode4
 * @description: 链表；求和————【1个解法】链表倒序排列，可以模拟从个位数依次相加；
 * @author: zzy
 * @create: 2023-03-27
 */
package com.zzy.leetcode001_010;

import java.util.HashMap;

public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ex = 0;
        ListNode dump = new ListNode(-1);
        ListNode head = dump;
        while(l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            if (l1 != null) {
                l1 = l1.next;
            }
            int num2 = l2 == null ? 0 : l2.val;
            if (l2 != null) {
                l2 = l2.next;
            }
            int num = (num1 + num2 + ex) % 10;
            ex = (num1 + num2 + ex) / 10;
            ListNode node = new ListNode(num);
            head.next = node;
            head = head.next;
        }
        if (ex != 0) {
            ListNode node0 = new ListNode(ex);
            head.next = node0;
        }
        return dump.next;

    }
}



   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
