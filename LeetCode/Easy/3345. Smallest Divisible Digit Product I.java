class Solution {
    public int smallestNumber(int n, int t) {
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness
        while (!isOK(n, t)) {
            n++;
        }

        return n;
    }
    
    
    boolean isOK(int n, int t) {
        int product = 1;
        
        while (n > 0) {
            product *= n % 10;
            n /= 10;
        }
        
        return product % t == 0;
    }
}