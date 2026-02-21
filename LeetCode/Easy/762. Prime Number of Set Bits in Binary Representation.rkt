(define/contract (count-prime-set-bits left right)
  (-> exact-integer? exact-integer? exact-integer?)
  (define answer 0)
  (define vec (make-vector 20 #t))
  (vector-set! vec 0 #f)
  (vector-set! vec 1 #f)

  (for ([i (in-range 2 20)])
    (when (vector-ref vec i)
      (for ([j (in-range (* i i) 20 i)])
        (vector-set! vec j #f))))

  (for ([i (in-inclusive-range left right)])
    (define k 0)
    (for ([j (in-range 0 20)])
      (when (bitwise-bit-set? i j)
        (set! k (add1 k))))
    (when (vector-ref vec k)
      (set! answer (add1 answer))))

  answer)



; Solution2
(define/contract (count-prime-set-bits left right)
  (-> exact-integer? exact-integer? exact-integer?)
  (define vec (make-vector 20 #t))
  (vector-set! vec 0 #f)
  (vector-set! vec 1 #f)

  (for ([i (in-range 2 20)])
    (when (vector-ref vec i)
      (for ([j (in-range (* i i) 20 i)])
        (vector-set! vec j #f))))

  (length (filter (λ (i) (vector-ref vec (length (filter (λ (j) (bitwise-bit-set? i j)) (range 0 20))))) (range left (add1 right)))))