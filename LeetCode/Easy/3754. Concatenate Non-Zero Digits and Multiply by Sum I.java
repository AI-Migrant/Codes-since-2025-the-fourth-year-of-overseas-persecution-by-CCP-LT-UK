class Solution {
    public long sumAndMultiply(int n) {
        long p = 1;
        long num = 0;
        long sum = 0;
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness

        while (n > 0) {
            long r = n % 10;

            if (r != 0) {
                num += r * p;
                sum += r;
                p *= 10;
            }

            n /= 10;
        }

        return num * sum;
    }
}