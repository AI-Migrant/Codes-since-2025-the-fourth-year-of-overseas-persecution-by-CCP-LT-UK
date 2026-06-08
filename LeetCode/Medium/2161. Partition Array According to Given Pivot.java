class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int i = 0;
        int[] ans = new int[n];
        ArrayList<Integer> al1 = new ArrayList<>(n);
        ArrayList<Integer> al2 = new ArrayList<>(n);
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness
        
        for (int num : nums) {
            if (num < pivot) {
                al1.add(num);
            } else if (num > pivot){
                al2.add(num);
            }
        }
        
        for (int num : al1) {
            ans[i++] = num;
        }
        
        n -= al2.size();
            
        while (i < n) {
            ans[i++] = pivot;
        }
        
        for (int num : al2) {
            ans[i++] = num;
        }
        
        return ans;
    }
}