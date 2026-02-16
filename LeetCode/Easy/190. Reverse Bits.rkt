(define/contract (reverse-bits n)
  (-> exact-integer? exact-integer?)
  (define answer 0)

  (for ((i (in-range 1 31)) (j (in-inclusive-range 30 0 -1)))
    (when (bitwise-bit-set? n i)
      (set! answer (bitwise-ior answer (arithmetic-shift 1 j)))))

  answer)


;solution 2
(define/contract (reverse-bits n)
  (-> exact-integer? exact-integer?)
  (define answer 0)

  (for ((i (in-inclusive-range 1 30)))
    (when (bitwise-bit-set? n (- 31 i))
      (set! answer (bitwise-ior answer (arithmetic-shift 1 i)))))

  answer)