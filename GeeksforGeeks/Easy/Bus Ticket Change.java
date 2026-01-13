class Solution
{
    
    public
    boolean
    canServe
    (
        int [] arr
    )
    {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        
        
        for
        (
            int note
            : arr
        )
        {
            
            if
            (
                note == 10
            )
            {
                
                if
                (
                    five == 0
                )
                {
                    return false;
                }
                else
                {
                    five --;
                    ten ++;
                }
                
            }
            else if
            (
                note == 20
            )
            {
                
                if
                (
                    five == 0
                )
                {
                    return false;
                }
                else if
                (
                    ten > 0
                )
                {
                    five --;
                    ten --;
                    twenty ++;
                }
                else if
                (
                    five < 3
                )
                {
                    return false;
                }
                else
                {
                    five -= 3;
                    twenty ++;
                }
                
            }
            else
            {
                five ++;
            }
            
        }
        
        
        return true;
    }
    
}
