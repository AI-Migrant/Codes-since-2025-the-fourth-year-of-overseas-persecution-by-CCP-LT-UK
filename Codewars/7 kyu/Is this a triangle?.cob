       identification division.
       program-id. is-triangle.
      
       data division.
       working-storage section.
       77 m           PIC 9(8).
       77 s           PIC 9(8).
      
       linkage section.
       01 x           PIC 9(8).
       01 y           PIC 9(8).
       01 z           PIC 9(8).
       01 result      PIC 9.
      
       procedure division using x y z result.
      * Set result to 1 for 'true', 0 for 'false'
          move function max(x, y, z) to m.
          move function sum(x, y, z) to s.
          subtract m from s.
          
          if m is less than s then
            move 1 to result
          else
            move 0 to result
          end-if.
      
          goback.
       end program is-triangle.
