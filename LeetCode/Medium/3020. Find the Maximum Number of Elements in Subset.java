class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        
        while (i < n && nums[i] == 1) {
            i++;
        }
        
        int ans = i;
        
        if (i++ % 2 == 0) {
            ans = Math.max(1, ans - 1);
        }
        
        while (i < n) {
            int num = nums[i];
            
            if (nums[i++ - 1] == num) {
                hm.put(num * num, hm.getOrDefault(num, 1) + 2);
                
                while (i < n && nums[i] == num) {
                    i++;
                }
            } else {
                ans = Math.max(ans,  hm.getOrDefault(num, 1));
            }
        }
        
        return ans;
    }
}
