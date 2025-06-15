package LinkedList;

public class Test {
    public static void main(String[] args) {
        MergeKSortedLists merger = new MergeKSortedLists();

        // Helper to create lists
        ListNode l1 = createList(new int[]{1, 4, 5});
        ListNode l2 = createList(new int[]{1, 3, 4});
        ListNode l3 = createList(new int[]{2, 6});

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode merged = merger.mergeKLists(lists);
        printList(merged);
    }

    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
