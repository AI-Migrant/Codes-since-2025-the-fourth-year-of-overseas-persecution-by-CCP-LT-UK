(define/contract (binary-gap n)
  (-> exact-integer? exact-integer?)
  (define answer 0)

  (let ([p 30])
    (for ([i (in-inclusive-range 0 30)])
      (when (bitwise-bit-set? n i)
      (set! answer (max answer (- i p)))
      (set! p i))))

  answer)