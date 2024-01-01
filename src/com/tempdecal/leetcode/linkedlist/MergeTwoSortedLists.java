package com.tempdecal.leetcode.linkedlist;

public class MergeTwoSortedLists {
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        ListNode newNode = new ListNode();
        ListNode newHead = newNode;
        while (!(list1 == null && list2 == null)) {
            if (list1 == null) {
                newNode.val = list2.val;
                list2 = list2.next;
                if (list2 !=null){
                    newNode.next = new ListNode();
                    newNode = newNode.next;
                }
            } else if (list2 == null) {
                newNode.val = list1.val;
                list1 = list1.next;
                if (list1 !=null){
                    newNode.next = new ListNode();
                    newNode = newNode.next;
                }
            } else {
                if (list1.val == list2.val) {
                    newNode.val = list1.val;
                    newNode.next = new ListNode(list2.val);
                    list1 = list1.next;
                    list2 = list2.next;
                    if (!(list1 ==null || list2==null)){
                        newNode.next.next = new ListNode();
                        newNode = newNode.next.next;
                    }
                }
                else if (list1.val < list2.val) {
                    newNode.val = list1.val;
                    newNode.next = new ListNode();
                    list1 = list1.next;
                    newNode = newNode.next;
                } else {
                    newNode.val = list2.val;
                    newNode.next = new ListNode();
                    list2 = list2.next;
                    newNode = newNode.next;
                }
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        int[] head = {1, 2, 3, 4, 5};

        ListNode listNode11 = new ListNode(head[0]);
        ListNode listNode12 = new ListNode(head[1]);
        ListNode listNode13 = new ListNode(head[3]);

        ListNode listNode21 = new ListNode(head[0]);
        ListNode listNode23 = new ListNode(head[2]);
        ListNode listNode25 = new ListNode(head[3]);

        listNode11.next = listNode12;
        listNode12.next = listNode13;

        listNode21.next = listNode23;
        listNode23.next = listNode25;

        ListNode j = mergeTwoLists(listNode11, listNode21);
        while (j != null) {
            System.out.println(j.val);
            j = j.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }
}
