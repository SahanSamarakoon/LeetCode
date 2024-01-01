package com.tempdecal.leetcode.linkedlist;

public class LinkedListCycle {

    public static void main(String[] args) {
        int[] head = {1, 2, 3, 4, 5};

        ListNode listNode1 = new ListNode(head[0]);
        ListNode listNode2 = new ListNode(head[1]);
        ListNode listNode3 = new ListNode(head[2]);
        ListNode listNode4 = new ListNode(head[3]);
        ListNode listNode5 = new ListNode(head[4]);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        twoPointer(listNode1);
    }

    private static void twoPointer(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast){
                System.out.println("Cycle detected");
                return;
            }
        }
        System.out.println("No cycle detected");
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
}
