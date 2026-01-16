public class Solution
{

    public static
    int
    maxArea
    (
        int[] height
    )
    {
        int i = 0;
        int j = height.length - 1;
        int k = 0;
        int ans = Math.min( height[i], height[j] ) * j;


        while
        (
            i < j
        )
        {

            if
            (
                height[i] < height[j]
            )
            {
                k = i + 1;

                
                while
                (
                    j > k
                )
                {


                    if
                    (
                        height[i] < height[k]
                    )
                    {
                        break;
                    }

                    k ++;
                }


                i = k;
            }
            else
            {
                k = j - 1;

                
                while
                (
                    k > i
                )
                {

                    if
                    (
                        height[j] < height[k]
                    )
                    {
                        break;
                    }
                    
                    k --;
                }


                j = k;
            }
            
            ans = Math.max( ans, Math.min( height[i], height[j] ) * ( j - i ) );
        }


        return ans;
    }

}
