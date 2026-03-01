/****************************************************************

 Following is the Linked list node structure already written:-

 class Node
 {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
 }

 *****************************************************************/


public class Solution {
    public static Node oddEvenList(Node head) {
        final Node oddHead = new Node();
        final Node evenHead = new Node();
        Node evenCurr = evenHead;
        Node oddCurr = oddHead;

        while (head != null) {
            oddCurr.next = head;
            oddCurr = oddCurr.next;
            head = head.next;

            if (head != null) {
                evenCurr.next = head;
                evenCurr = evenCurr.next;
                head = head.next;
            }
        }

        oddCurr.next = evenHead.next;
        evenCurr.next = null;

        return oddHead.next;
    }
}