/**
 * Definition for a binary tree node.
 * public class BinaryTreeNode {
 *     public var val: Int64
 *     public var left: ?BinaryTreeNode
 *     public var right: ?BinaryTreeNode
 *     public init() {
 *         val = 0
 *         left = None
 *         right = None
 *     }
 *     public init(val: Int64) {
 *         this()
 *         this.val = val
 *     }
 * }
 */

class Solution
{
    private var maxDepth: UInt16
    private var answer: ?BinaryTreeNode




    init
    ()
    {
        this.maxDepth = 0
        this.answer = None
    }




    func
    subtreeWithAllDeepest
    (
        root: ?BinaryTreeNode
    )
    : ?BinaryTreeNode
    {
        this.solve( root, 0 )


        this.answer
    }




    private
    func
    solve
    (
        root: ?BinaryTreeNode
        , depth: UInt16
    )
    : UInt16
    {

        match
        (
            root
        )
        {
            case Some( node ) =>
                let left = solve( node.left, depth + 1 )
                let right = solve( node.right, depth + 1 )

                if
                (
                    left == right
                )
                {
                    
                    if
                    (
                        right >= this.maxDepth
                    )
                    {
                        this.maxDepth = right
                        this.answer = root
                    }
                    
                    right
                }
                else
                {
                    max( left, right )
                }


            case None =>

                depth
        }
        

    }

}
