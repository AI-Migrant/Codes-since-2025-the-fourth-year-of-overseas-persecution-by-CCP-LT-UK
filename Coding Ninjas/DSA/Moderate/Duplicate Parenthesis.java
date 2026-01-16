import java.util.*;





public class Solution
{

    public static
    boolean
    duplicateParanthesis
    (
        String expr
    )
    {
        Stack < Character > stack = new Stack <> ();
        boolean t = false;


        for
        (
            char c
            : expr.toCharArray()
        )
        {

            if
            (
                c == ')'
            )
            {
                

                while
                (
                    stack.peek() != '('
                )
                {
                    stack.pop();
                    t = false;
                }


                if
                (
                    t
                )
                {
                    return t;
                }
                else
                {
                    stack.pop();
                    t = true;
                }

            }
            else
            {
                stack.push( c );
            }
            
        }


        return false;
    }

}
