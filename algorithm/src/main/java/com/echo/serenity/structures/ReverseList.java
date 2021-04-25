package com.echo.serenity.structures;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xushu.
 */
public class ReverseList {

    public static void main(String[] args) {
        printList(createNode(Arrays.asList(1, 2, 3, 4, 5)));
        printList(reverse(createNode(Arrays.asList(1, 2, 3, 4, 5))));
        printList(reverseN(createNode(Arrays.asList(1, 2, 3, 4, 5)), 3));
        printList(reverseRange(createNode(Arrays.asList(1, 2, 3, 4, 5)), 2, 4));
    }

    public static ListNode reverse(ListNode head) {
        ListNode preNode = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }

    public static ListNode reverseN(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode currentNode = head;
        int i = 1;
        while (currentNode != null && i <= n) {
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
            i++;
        }
        head.next = currentNode;
        return preNode;
    }

    public static ListNode reverseRange(ListNode head, int n, int m) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        for (int i = 0; i < n - 1; i++) {
            preNode = preNode.next;
        }
        ListNode currentNode = preNode.next;
        for (int i = 0; i < m - n; i++) {
            ListNode nextNode = currentNode.next;
            currentNode.next = nextNode.next;
            nextNode.next = preNode.next;
            preNode.next = nextNode;
        }
        return dummyNode.next;
    }

    private static ListNode createNode(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(list.get(0));
        head.next = createNode(list.subList(1, list.size()));
        return head;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value);
            System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }

    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

}
