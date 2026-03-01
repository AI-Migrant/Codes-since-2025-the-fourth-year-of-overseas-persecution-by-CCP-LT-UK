// Solution 1
class Solution {
    func fizzBuzz(n: Int64): ArrayList<String> {
        ArrayList(n, { i =>
            match {
                case (i + 1) % 15 == 0 => "FizzBuzz"
                case (i + 1) % 5 == 0 => "Buzz"
                case (i + 1) % 3 == 0 => "Fizz"
                case _ => (i + 1).toString()
           }
        })
    }
}




// Solution 2
class Solution
{
    
    func
    fizzBuzz
    (
        n: Int64
    )
    : ArrayList < String >
    {
        let ans: ArrayList < String > = ArrayList( n )
        
        
        for
        (
            i
            in
            1..=n
        )
        {
            
            if
            (
               i % 3 == 0
            )
            {
                 
                 if
                 (
                     i % 5 == 0
                 )
                 {
                     ans.add( "FizzBuzz" )
                 }
                 else
                 {
                     ans.add( "Fizz" )
                 }
                 
            }
            else
            {
                
                if
                (
                    i % 5 == 0
                )
                {
                    ans.add( "Buzz" )
                }
                else
                {
                    ans.add( i.toString() )
                }
                
            }
            
        }
        
        
        ans
    }
    
}
