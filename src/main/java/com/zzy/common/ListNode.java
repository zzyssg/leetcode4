package com.zzy.common;

/**
 * @ClassName ListNode
 * @Author ZZy
 * @Date 2024/1/22 23:19
 * @Description
 * @Version 1.0
 */
public class ListNode {

    public  int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
