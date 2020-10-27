package com.kwq.algorithm.algorithmics.list;

import com.kwq.algorithm.model.ListNode;

import java.util.Stack;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/23
 * @DESC :
 */
public class List_243 {

    public boolean isPalindrome(ListNode head) {
        ListNode pre = head;
        Stack<Integer> stack = new Stack<>();
        if(pre != null && pre.next == null) return true;
        while(pre!=null){
            if(!stack.empty() && stack.peek().intValue() == pre.data){
                stack.pop();
            }else{
                stack.push(pre.data);
            }
            pre = pre.next;
        }
        return stack.empty() ? true : false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        List_243 main = new List_243();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        boolean palindrome = main.isPalindrome(head);
        boolean palindrome1 = main.isPalindrome(head1);
        System.out.println(palindrome);
        System.out.println(palindrome1);
    }
}
