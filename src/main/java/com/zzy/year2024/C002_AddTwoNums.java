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

    public ListNode addTwoNum(ListNode n1, ListNode n2) {
        ListNode headNode = new ListNode(-1);
        ListNode dummyNode = headNode;
        int up = 0;
        int cur = 0;
        while (n1 != null || n2 != null) {
            int n1Val = n1 == null ? 0 : n1.val;
            int n2Val = n2 == null ? 0 : n2.val;
            cur = (n1Val + n2Val + up) / 10;
            up = (n1Val + n2Val + up) % 10;
            ListNode curNode = new ListNode(cur);
            headNode.next = curNode;
            headNode = headNode.next;
            n1 = n1 == null ? null : n1.next;
            n2 = n2 == null ? null : n2.next;
        }
        if (up != 0) {
            ListNode lastNode = new ListNode(up);
            headNode.next = lastNode;
            headNode = headNode.next;
        }
        return dummyNode.next;

    }



}



