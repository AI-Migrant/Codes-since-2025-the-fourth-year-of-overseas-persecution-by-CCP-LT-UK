import java.util.*;





public class Trie
{
    HashMap < Character, Trie > children;
    int p;
    int w;





    public
    Trie
    ()
    {
        this.children = new HashMap <> ();
        p = 0;
        w = 0;
    }





    public
    void
    insert
    (
        String word
    )
    {
        Trie curr = this;


        for
        (
            char c
            : word.toCharArray()
        )
        {
            
            if
            (
                !curr.children.containsKey( c )
            )
            {
                curr.children.put( c, new Trie() );
            }

            curr = curr.children.get( c );
            curr.p ++;
        }

        curr.w ++;
    }





    public
    int
    countWordsEqualTo
    (
        String word
    )
    {
        Trie curr = this;


        for
        (
            char c
            : word.toCharArray()
        )
        {

            if
            (
                !curr.children.containsKey( c )
            )
            {
                return 0;
            }
            else
            {
                curr = curr.children.get( c );
            }

        }


        return curr.w;
    }





    public
    int
    countWordsStartingWith
    (
        String word
    )
    {
        Trie curr = this;


        for
        (
            char c
            : word.toCharArray()
        )
        {

            if
            (
                !curr.children.containsKey( c )
            )
            {
                return 0;
            }
            else
            {
                curr = curr.children.get( c );
            }

        }


        return curr.p;
    }





    public
    void
    erase
    (
        String word
    )
    {
        Trie curr = this;


        for
        (
            char c
            : word.toCharArray()
        )
        {
            
            if
            (
                curr.children.get( c ).p < 2
            )
            {
                curr.children.remove( c );


                return;
            }
            else
            {
                curr = curr.children.get( c );
                curr.p --;
            }

        }


        curr.w --;
    }

}
