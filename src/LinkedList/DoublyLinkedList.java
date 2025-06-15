package LinkedList;

import java.util.Arrays;

class DLNode{
    int data;
    DLNode next;
    DLNode back;

    DLNode(int data1, DLNode next1, DLNode back1){
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    DLNode(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }

}
public class DoublyLinkedList {

    public static void print(DLNode head){
        System.out.print("[");
        while (head.next !=null){
            System.out.print(head.data + ", ");
            head = head.next;
        }
        System.out.print(head.data);
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,8};
        DLNode head1 = convertArrToDLL(arr1);
        int[] arr2 = {4,3,2,5,4,1,7,6,4,8,5,4};
        DLNode head2 = convertArrToDLL(arr2);
//        head = deleteKthNode(head,3);
//        deleteNNode(head.next.next);
//        head1 = reverseDLL(head1);
//        print(head1);
//        DLNode sol = addDLL(head1,head2);
//        DLNode head = oddEven(head1);
//        DLNode head = removeKthNodeFromEnd(head1, 3);
//        DLNode head = reverseIterative(head1);
//        DLNode head = reverseRecursive(head1);
//        print(head);
//        int[] arr3 = {1,2,3,3,2,1,1};
//        DLNode head3 = convertArrToDLL(arr3);
//        System.out.println(checkLLPalindrome(head3));
//        print(head3);

//        findIntersection

//        int[] arrInt1 = {1,2,3,4,5};
//        DLNode headInt1 = convertArrToDLL(arrInt1);
//        int[] arrInt2 = {6,7,8,9,1};
//        DLNode headInt2 = convertArrToDLL(arrInt2);
//        int[] arrInt3 = {10, 11, 12, 13};
//        DLNode headInt3 = convertArrToDLL(arrInt3);
//
//        DLNode tail1 = fetchTailNode(headInt1);
//        DLNode tail2 = fetchTailNode(headInt2);
//
//
////        tail1.next = headInt3;
////        tail2.next = headInt3;
////        System.out.println(findIntersection(headInt1, headInt2).data);
//
//
//        tail1.next = headInt2;
//        tail2.next = headInt2;
//
//        DLNode startingPoint = findStartingPointInLoop(headInt1);
//        System.out.println(startingPoint.data);
//        DLNode head = deleteAllOccurrencesOfK(head2, 4);
//        print(head);
//        int[] arr = {1,2,3,4,6,7,8,9,10};
//        DLNode head = convertArrToDLL(arr);
//        findPairEqualToSum(head,5);
        System.out.println(Arrays.toString(arr2));
        DLNode head = reverseNodesInKGroup(head2,3);
        print(head);
    }

//    public static DLNode

    public static DLNode getKthNode(DLNode temp, int k){
        k -= 1;
        while (temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public static DLNode reverseNodesInKGroup(DLNode head, int k){

        DLNode temp = head;
        DLNode prevLast = null;
        while (temp!=null){
            DLNode kthNode = getKthNode(temp,k);
            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }

            DLNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseIterative(temp);
            if(temp == head){
                head = kthNode;
            }
            else {
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }
        return head;

    }

    public static void findPairEqualToSum(DLNode head, int sum){
        DLNode left = head;
        DLNode right = fetchTailNode(head);
        while (right.data>left.data){
            if(left.data+right.data == sum){
                System.out.println(left.data + " " + right.data);
                left = left.next;
                right = right.back;
            } else if (left.data + right.data < sum) {
                left = left.next;
            }else {
                right = right.back;
            }

        }
    }

    public static DLNode deleteAllOccurrencesOfK(DLNode head, int k){
        DLNode temp = head;
        while (temp != null){
            if(temp.data == k){
                if(temp == head){
                    head = head.next;
                }
                DLNode prev = temp.back;
                DLNode nextNode = temp.next;

                if(prev != null) prev.next = nextNode;
                if(nextNode != null) nextNode.back = prev;
                temp = nextNode;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static DLNode findStartingPointInLoop(DLNode head){
        DLNode slow = head;
        DLNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static DLNode fetchTailNode(DLNode head){
        DLNode prev = null;
        while (head!=null){
            prev = head;
            head = head.next;
        }
        return prev;
    }

    public static DLNode findIntersection(DLNode head1, DLNode head2){

        if(head1 == null || head2 == null){
            return null;
        }

        DLNode temp1 = head1;
        DLNode temp2 = head2;

        while (temp1 != temp2){

            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2){
                return temp1;
            }

            if(temp1 == null){
                temp1 = head2;
            }
            if(temp2 == null){
                temp2 = head1;
            }

        }

        return temp1;

    }

    public static DLNode addOneRecursise(DLNode head){
        int carry = addHelper(head);
        if(carry == 1){
            DLNode newHead = new DLNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    private static int addHelper(DLNode temp) {
        if(temp == null){
            return 1;
        }
        int carry = addHelper(temp.next);
        temp.data += carry;
        if(temp.data < 10)
            return 0;
        temp.data = 0;
        return 1;
    }

    public static DLNode addOneToLL(DLNode head){
        DLNode reversedHead = reverseIterative(head);
        int carry = 1;
        reversedHead.data += 1;
        while (reversedHead!=null){

            reversedHead = reversedHead.next;
        }
        return reversedHead;
    }

    public static boolean checkLLPalindrome(DLNode head){

        DLNode fast = head;
        DLNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        DLNode newHead = reverseIterative(slow.next);
        DLNode first = head;
        DLNode second = newHead;
        while (second != null){
            if(first.data != second.data){
                reverseIterative(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseIterative(newHead);
        return true;

    }

    public static DLNode reverseIterative(DLNode head){
        DLNode prev = null;
        DLNode temp = head;

        while (temp != null){
            DLNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static DLNode reverseRecursive(DLNode head){

        if(head == null || head.next == null){
            return head;
        }
        DLNode newHead = reverseRecursive(head.next);
        DLNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    
    public static DLNode removeKthNodeFromEnd(DLNode head, int k){
        DLNode fast = head;
        DLNode slow = head;
        for (int i = 0; i<k; i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        DLNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode.next = null;
        return head;
    }
    public static DLNode oddEven(DLNode head){
        DLNode odd = head;
        DLNode even = head.next;
        DLNode evenHead = even;
        while (even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }


    public static DLNode addDLL(DLNode head1, DLNode head2){
        DLNode dummyNode = new DLNode(-1);
        DLNode curr = dummyNode;
        DLNode temp1 = head1;
        DLNode temp2 = head2;
        int carry = 0;
        while (temp1 != null || temp2 != null){
            int sum = carry;
            if(temp1 != null) sum += temp1.data;
            if(temp2 != null) sum += temp2.data;

            DLNode newNode = new DLNode(sum%10);
            carry = sum/10;

            curr.next = newNode;
            curr = curr.next;
            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }

        if(carry>0){
            curr.next = new DLNode(carry);
        }
        return dummyNode.next;
    }

    public static DLNode reverseDLL(DLNode head){
        if(head == null || head.next == null){
            return head;
        }
        DLNode prev = null;
        DLNode current = head;
        while (current != null){
            prev = current.back;
            current.back = current.next;
            current.next = prev;

            current = current.back;
        }
        return prev.back;
    }

    private static DLNode convertArrToDLL(int[] arr) {
        DLNode head = new DLNode(arr[0]);
        DLNode prev = head;
        for (int i=1; i< arr.length; i++){
            DLNode temp = new DLNode(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void deleteNNode(DLNode temp){
        DLNode prev = temp.back;
        DLNode front = temp.next;
        if(front == null){
            prev.next = null;
            temp.back = null;
            return;
        }
        if(prev == null){
//            deleteHead
        }
        prev.next = front;
        front.back = prev;
        temp.next = temp.back = null;
    }

    private static DLNode deleteKthNode(DLNode head, int k){
        if(head == null){
            return null;
        }
        int cnt = 0;
        DLNode temp = head;
        while (temp != null){
            cnt++;
            if(k == cnt){
                break;
            }
            temp = temp.next;
        }
        DLNode prev = temp.back;
        DLNode front = temp.next;

        if(prev == null && front == null){
            return null;
        }
        if(prev == null){
            // return deleteHead(head);
        }
        if(front == null){
            // return deleteTail(head);
        }

        prev.next = front;
        front.back = prev;

        temp.back = null;
        temp.next = null;
        return head;
    }
}
