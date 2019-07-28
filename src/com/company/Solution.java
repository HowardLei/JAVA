package com.company;

import java.util.HashMap;

/**
 * Solution class
 *
 * @author apple
 * @date 2019-07-25
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = 0;
        value = l1.val + l2.val;
        boolean flag = needFlag(value);
        value %= 10;
        ListNode node = new ListNode(value);
        ListNode temp = node;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            if (flag) {
                value = l1.val + l2.val + 1;
            } else {
                value = l1.val + l2.val;
            }
            flag = needFlag(value);
            value %= 10;
            var map = addNode(l1, l2, flag, value);
            for (ListNode listNode : map.keySet()) {
                temp.next = listNode;
                temp = temp.next;
            }
            for (Boolean aBoolean : map.values()) {
                flag = aBoolean;
            }
        }
        if (l1.next == null && l2.next == null && flag) {
            ListNode newNode = new ListNode(1);
            temp.next = newNode;
            temp = temp.next;
        }
        if (l1.next == null && l2.next != null) {
            while (l2.next != null) {
                l2 = l2.next;
                if (flag) {
                    value = l2.val + 1;
                } else {
                    value = l2.val;
                }
                flag = needFlag(value);
                value %= 10;
                ListNode newNode = new ListNode(value);
                temp.next = newNode;
                temp = temp.next;
            }
            if (flag) {
                ListNode newNode = new ListNode(1);
                temp.next = newNode;
                temp = temp.next;
            }
        }
        if (l2.next == null && l1.next != null) {
            while (l1.next != null) {
                l1 = l1.next;
                if (flag) {
                    value = l1.val + 1;
                } else {
                    value = l1.val;
                }
                flag = needFlag(value);
                value %= 10;
                ListNode newNode = new ListNode(value);
                temp.next = newNode;
                temp = temp.next;
            }
            if (flag) {
                ListNode newNode = new ListNode(1);
                temp.next = newNode;
                temp = temp.next;
            }
        }
        return node;
    }
    private boolean needFlag(int value) {
        return value >= 10;
    }
    private HashMap<ListNode, Boolean> addNode(ListNode l1, ListNode l2, boolean flag, int value) {
        var map = new HashMap<ListNode, Boolean>(1);
        l1 = l1.next;
        l2 = l2.next;
        if (flag) {
            value = l1.val + l2.val + 1;
        } else {
            value = l1.val + l2.val;
        }
        flag = needFlag(value);
        value %= 10;
        ListNode newNode = new ListNode(value);
        map.put(newNode, flag);
        return map;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}