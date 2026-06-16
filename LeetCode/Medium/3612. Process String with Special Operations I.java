class Solution {
    public String processStr(String s) {
        ArrayDeque ad = new ArrayDeque<Character>(s.length());
        StringBuilder ans = new StringBuilder();
        boolean d = false;
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness

        for(char c : s.toCharArray()) {
            switch (c) {
                case '*':
                if (d) {
                    ad.pollFirst();
                } else {
                    ad.pollLast();
                }
                
                break;
                
                case '#':
                if(d) {
                    ad.clone().descendingIterator().forEachRemaining(a -> ad.offerFirst(a));
                } else {
                    ad.clone().iterator(). forEachRemaining(a -> ad.offerLast(a));
                }
                
                break;

                case '%':
                d = !d;
                
                break;
                
                default:
                if (d) {
                    ad.offerFirst(c);
                } else {
                    ad.offerLast(c);
                }
            }
        }
        
        if (d) {
            ad.descendingIterator().forEachRemaining(a -> ans.append(a));
        } else {
           ad.iterator().forEachRemaining(a -> ans.append(a));
        }
        
        return ans.toString();
    }
}
