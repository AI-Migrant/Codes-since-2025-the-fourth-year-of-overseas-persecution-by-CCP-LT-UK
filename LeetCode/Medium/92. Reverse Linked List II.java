/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution
{
    private ListNode tail;




    public
    ListNode
    reverseBetween
    (
        ListNode head
        , int left
        , int right
    )
    {
        final ListNode answer = new ListNode( 0, head );
        final int i = right - left;
        head = answer;


        while
        (
            left > 1
        )
        {
            head = head.next;

            left --;
        }


        final ListNode mid = head.next;
        head.next = this.reverse( head, head.next, i );
        mid.next = tail;


        return answer.next;
    }




    ListNode
    reverse
    (
        final ListNode prev
        , final ListNode head
        , final int i
    )
    {
        final ListNode next = head.next;
        head.next = prev;

        if
        (
            i == 0
        )
        {
            tail = next;

            return head;
        }
        else
        {
            return reverse( head, next, i - 1 );
        }

    }

}
