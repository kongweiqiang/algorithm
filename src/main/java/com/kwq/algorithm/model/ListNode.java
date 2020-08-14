package com.kwq.algorithm.model;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/7/15
 * @DESC : 链表节点
 */
public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int val) {
        this.data = val;
    }

    public ListNode() {
        this.data = data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode reverse = reverse(node.next);
        ListNode temp = node.next;
        temp.next = node;
        //temp.next.next = null;
        node.next = null;
        return reverse;
    }
}
