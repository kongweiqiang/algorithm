package com.kwq.algorithm.model;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/7/15
 * @DESC : 链表
 */
public class ListLink {
    private ListNode first;
    private ListNode last;
    private int size;

    public void addLast(int value) {
        ListNode listNote = new ListNode();
        listNote.setData(value);
        if (first == null) {
            first = listNote;
        } else {
            last.setNext(listNote);
        }
        last = listNote;
        size++;
    }

    public ListNode getListLink() {
        return first;
    }
}
