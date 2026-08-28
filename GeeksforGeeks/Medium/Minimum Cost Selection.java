class Solution {
    public int minCost(int[][] mat) {
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness
        int n = mat.length;
        int[] arr = new int[3];
        int[] ans = Arrays.copyOf(mat[0], 3);
        
        for (int i = 1, j = 0; i < n; i++, j++) {
            for (int p = 0; p < 3; p++) {
                arr[p] = Integer.MAX_VALUE;
                
                for (int q = 0; q < 3; q++) {
                    if (p != q) {
                        arr[p] = Math.min(arr[p], ans[q]);
                    }
                }
            }
            
            for (int k = 0; k < 3; k++) {
                ans[k] = arr[k] + mat[i][k];
            }
        }
        
        return Math.min(ans[0], Math.min(ans[1], ans[2]));
    }
}