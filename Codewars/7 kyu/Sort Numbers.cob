       identification division.
       program-id. SortNumbers.
       data division.
       working-storage section.
       77 t               pic s9(3).
       77 k               pic 999.
      
       linkage section.
       01 nums.
          05 nums-length  pic 9(3).
          05 xs           pic s9(3) occurs 0 to 100 times
                                    depending on nums-length.
       01 result.
          05 res-length   pic 9(3).
          05 res          pic s9(3) occurs 0 to 100 times
                                    depending on res-length
                                    indexed by i j.
      
       procedure division using nums result.
           move nums-length to k.
      
           perform until k is less than 2
               set i to 2
               set j to 1
      
               perform until i is greater than k
                   if xs(i) is less than xs(j) then
                       move xs(i) to t
                       move xs(j) to xs(i)
                       move t to xs(j)
                   end-if
      
                   set i up by 1
                   set j up by 1
               end-perform
      
               subtract 1 from k
           end-perform.
      
           set i to 1.
           move nums-length to res-length.
      
           perform until i is greater than res-length
               move xs(i) to res(i)
               set i up by 1
           end-perform.
      
           goback.
       end program SortNumbers.
      