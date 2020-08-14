package com.kwq.algorithm.algorithmics.list;

import com.kwq.algorithm.model.ListLink;
import com.kwq.algorithm.model.ListNode;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/7/15
 * @DESC : 合并两个排好序的链表
 */
public class MainAlgorithm {
    public static void main(String[] args) {
        ListLink listLink = new ListLink();
        listLink.addLast(0);
        listLink.addLast(2);
        listLink.addLast(4);

        ListLink listLink1 = new ListLink();
        listLink1.addLast(1);
        listLink1.addLast(3);
        listLink1.addLast(40);
        listLink1.addLast(50);

        ListNode listNode = mergerListNode(listLink.getListLink(), listLink1.getListLink());
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }

    public static ListNode mergerListNode(ListNode listNode1, ListNode listNode2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.data < listNode2.data) {
                tail.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                tail.next = listNode2;
                listNode2 = listNode2.next;
            }
            tail = tail.next;
        }
        tail.next = listNode1 != null ? listNode1 : listNode2;
        return head.next;
    }
}
