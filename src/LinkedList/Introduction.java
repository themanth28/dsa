package LinkedList;

class Node{
    int data;
    Node next;

    Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}

public class Introduction {
    public static void main(String[] args) {
        int[] arr = {12,3,4,6};
        Node head = convertArrToLL(arr);
//        System.out.println(head.data);

//        Node temp = insertElementAtHead(head,10);
//        Node temp = insertElementAtTail(head,10);
//        Node temp = insertElementAtK(head,10,2);
        Node temp = insertElementBeforeValueX(head,10,3);
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static Node convertArrToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static Node insertElementAtHead(Node head, int el){
        if(head == null){
            return new Node(el);
        }
        Node newHead = new Node(el);
        newHead.next = head;
        return newHead;
    }

    public static Node insertElementAtTail(Node head, int el){
        if(head == null){
            return new Node(el);
        }
        Node tail = new Node(el);
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = tail;
        return head;
    }

    public static Node insertElementAtK(Node head, int el, int k){
        if(k == 1){
            return insertElementAtHead(head,el);
        }
        int count = 0;
        Node temp = head;
        while (temp.next!=null){
            count++;
            if(k-1 == count){
                temp.next = new Node(el, temp.next);
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node insertElementBeforeValueX(Node head, int el, int x){
        if(head.data == x){
            return new Node(el, head);
        }
        Node temp = head;
        Node prev = null;
        while (temp.next!=null){
            if(temp.data == x){
                Node ele = new Node(el);
                prev.next = ele;
                ele.next = temp;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

}
