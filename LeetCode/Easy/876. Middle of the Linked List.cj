/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int64
 *     public var next: ?ListNode
 *     public init() {
 *         val = 0
 *         next = None
 *     }
 *     public init(val: Int64) {
 *         this.val = val
 *         next = None
 *     }
 * }
 */

// Solution 1
class Solution {
    func middleNode(head: ?ListNode): ?ListNode {
        var answer = head ?? ListNode()
        var curr = head?.next ?? None
        
        while (let Some(next) <- curr?.next) {
            answer = answer.next ?? ListNode()
            curr = next?.next ?? None
        }
        
        answer
    }
}



// Solution 2
class Solution
{
    
    func
    middleNode
    (
        head: ?ListNode
    )
    : ?ListNode
    {
        var ans: ListNode = head ?? ListNode()
        var curr: ?ListNode = head?.next ?? None
        
        
        while
        (
            let Some( next ) <- curr?.next
        )
        {
            ans = ans.next ?? ListNode()
            
            if
            (
                let Some( nextnext ) <- next?.next
            )
            {
                curr = nextnext
            }
            else
            {
                break
            }
            
        }
        
        
        return ans
    }
    
}
