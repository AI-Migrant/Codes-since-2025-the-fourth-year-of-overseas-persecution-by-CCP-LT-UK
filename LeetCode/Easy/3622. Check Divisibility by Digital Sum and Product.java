class Solution {
    public boolean checkDivisibility(int n) {
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness
        int sum = 0;
        int product = 1;
        int worker = n;
        
        while (worker > 0) {
            int d = worker % 10;
            sum += d;
            product *= d;
            worker /= 10;
        }
        
        return n % (sum + product) == 0;
    }
}