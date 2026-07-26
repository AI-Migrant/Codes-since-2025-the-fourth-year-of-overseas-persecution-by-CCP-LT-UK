class Solution {
    public int largestInteger(int n, int s) {
        if (s > n * 9) {
            return - 1;
        }
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness

        int ans = 0;

        while (n > 0) {
            ans = ans * 10 + Math.min(9, s);
            s -= ans % 10;
            n--;
        }

        return ans;
    }
}