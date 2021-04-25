package com.echo.serenity.structures;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xushu.
 */
public class RecursionReverseList {

    public static void main(String[] args) {
        printList(createNode(Arrays.asList(1, 2, 3, 4, 5)));
        printList(reverse(createNode(Arrays.asList(1, 2, 3, 4, 5))));
        printList(reverseN(createNode(Arrays.asList(1, 2, 3, 4, 5)), 3));
        printList(reverseRange(createNode(Arrays.asList(1, 2, 3, 4, 5)), 2, 4));
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head; //last.next = head
        head.next = null;
        return last;
    }

    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        ListNode successor = head.next.next;
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static ListNode reverseRange(ListNode head, int n, int m) {
        if (n == 1) {
            return reverseN(head, m);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseRange(head.next, n - 1, m - 1);
        return head;
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
