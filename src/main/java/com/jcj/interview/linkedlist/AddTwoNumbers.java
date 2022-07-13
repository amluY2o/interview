package com.jcj.interview.linkedlist;

import com.jcj.interview.common.ListNode;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int n = 0;
        while (l1 != null  || l2 != null){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + n;
            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else{
               tail.next = new ListNode(sum % 10);
               tail = tail.next;
            }
            n = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(n > 0){
            tail.next = new ListNode(n);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result!= null){
            System.out.print(result.val + " ");
            result = result.next;
        }


    }
}
