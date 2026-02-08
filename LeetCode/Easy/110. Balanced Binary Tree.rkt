; Definition for a binary tree node.
#|

; val : integer?
; left : (or/c tree-node? #f)
; right : (or/c tree-node? #f)
(struct tree-node
  (val left right) #:mutable #:transparent)

; constructor
(define (make-tree-node [val 0])
  (tree-node val #f #f))

|#

(define/contract (is-balanced root)
  (-> (or/c tree-node? #f) boolean?)
  (not (= (solve root) -1)))
   
(define (solve root)
  (cond
    [(not root) 0]
    [else
      (define left (solve (tree-node-left root)))
      (define right (solve (tree-node-right root)))
     
      (if
        [or (= left -1)
            (= right -1)
            (> (abs (- left right)) 1)]
        -1
        [add1 (max left right)])]))