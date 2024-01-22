package com.zzy.year2024;

import com.zzy.common.ListNode;

import java.util.List;

/**
 * @ClassName AddTwoNums
 * @Author ZZy
 * @Date 2024/1/22 23:17
 * @Description
 * @Version 1.0
 */
public class C002_AddTwoNums {

    //未尝试考虑：不同时为空的情况
    public ListNode addTwoNode(ListNode node1, ListNode node2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        ListNode n1 = node1;
        ListNode n2 = node2;
        int left = 0;
        int cur = 0;
        while (n1 != null && n2 != null) {
            cur = (node1.val + node2.val + left) / 10;
            left = (node1.val + node2.val + left) % 10;
            curNode.next = new ListNode(cur);
            curNode = curNode.next;
            n1 = n1.next;
            n2 = n2.next;
        }
        ListNode n3 = (n1 == null) ? n2 : n1;
        while (n3 != null) {
            cur = (n3.val + left) / 10;
            left = (n3.val + left) % 10;
            curNode.next = new ListNode(cur);
        }
        if (left != 0) {
            curNode.next = new ListNode(left);
        }
        return dummyNode.next;
    }



}



