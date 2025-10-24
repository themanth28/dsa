package LinkedList;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeKSortedLists {

    public static ListNode convertArrToLL(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        for (int i=1; i<arr.length; i++){
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,4,5};
        int[] arr2 = {1,3,4};
        int[] arr3 = {2,6};
        ListNode head1 = convertArrToLL(arr1);
        ListNode head2 = convertArrToLL(arr2);
        ListNode head3 = convertArrToLL(arr3);
        ListNode[] listNodes = {head1,head2,head3};
        ListNode sol = mergeKLists(listNodes);
        while (sol.next!=null){
            System.out.print(sol.val + "->");
            sol = sol.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // Define a comparator for the priority queue (min-heap)
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Add the head of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
//                System.out.println(Objects.requireNonNull(minHeap.poll()).val);
            }
        }


        // Dummy head to simplify the result list construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Extract the smallest node and add its next to the heap
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}
