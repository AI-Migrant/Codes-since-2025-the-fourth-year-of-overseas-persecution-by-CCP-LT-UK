       identification division.
       program-id. Divisors.
      
       data division.
       local-storage section.
       77 N            pic 999.
       77 d            pic 999.
       77 q            pic 9(5).
       77 r            pic 9(5).
      
       linkage section.
       01  num         pic 9(6).
       01  result.
           03  resLen  pic 9(3).
           03  res     pic 9(6) occurs 0 to 200 times
                                depending on resLen
                                indexed by i, j.
      
       procedure division using num result.
      *   set `resLen` to 0 if `num` is a prime number.
          set i to 0.
          set j to 201.
          compute N rounded = function sqrt(num)
      
          perform varying d from 2 by 1 until d is greater than N
              divide num by d
                  giving q
                  remainder r
      
              if r equals to 0 then
                  set i up by 1
                  set j down by 1
                  move d to res(i)
                  move q to res(j)
              end-if
          end-perform.
          
          if res(i) equals to res(j) then
              set j up by 1
          end-if.
      
          perform until j is greater than 200
              set i up by 1
              move res(j) to res(i)
              set j up by 1
          end-perform.
        
          move i to resLen.
      
          goback.
       end program Divisors.
      