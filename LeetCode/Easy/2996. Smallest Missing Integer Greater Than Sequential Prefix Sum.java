class Solution {
    public int missingInteger(int[] nums) {
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness
        int curr = nums[0] - 1;
        int ans = 0;
        boolean t = true;
        boolean[] arr = new boolean[51];
        
        for (int num : nums) {
            arr[num] = true;
        
            if(t && curr + 1 == num) {
                curr = num;
                ans += num;
            } else {
                t = false;
            }
        }
        
        while (ans < 51 && arr[ans]) {
            ans++;
        }
        
        return ans;
    }
}