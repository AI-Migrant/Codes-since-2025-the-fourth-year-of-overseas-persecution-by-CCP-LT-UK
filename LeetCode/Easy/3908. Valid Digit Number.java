class Solution {
    public boolean validDigit(int n, int x) {
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness
        return Integer.toString(n).indexOf(Integer.toString(x)) > 0;
    }
}