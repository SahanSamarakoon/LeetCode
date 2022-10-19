package com.tempdecal.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] head = {1, 2, 3, 4, 5};

        ListNode listNode1 = new ListNode(head[0]);
        ListNode listNode2 = new ListNode(head[1]);
        ListNode listNode3 = new ListNode(head[2]);
        ListNode listNode4 = new ListNode(head[3]);
        ListNode listNode5 = new ListNode(head[4]);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

//        ListNode i = reverseList(listNode1);
//        while (i!=null){
//            System.out.println(i.val);
//            i=i.next;
//        }

        ListNode j = simpleLoop(listNode1);
        while (j!=null){
            System.out.println(j.val);
            j=j.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;
        ListNode nextHead = head.next;
        head.next = null;
        return recurse(head, nextHead);
    }
    public static ListNode recurse(ListNode head, ListNode nextHead){
        if (nextHead==null) return head;
        ListNode tempNextHead = nextHead.next;
        nextHead.next=head;
        return recurse(nextHead, tempNextHead);
    }

    public static ListNode simpleLoop(ListNode head){
        if (head==null) return null;
        if (head.next==null) return head;
        ListNode nextHead = head.next;
        head.next=null;
        ListNode tempNode;
        while (nextHead!=null){
            tempNode = nextHead.next;
            nextHead.next=head;
            head = nextHead;
            nextHead = tempNode;
        }
        return head;
    }
}

