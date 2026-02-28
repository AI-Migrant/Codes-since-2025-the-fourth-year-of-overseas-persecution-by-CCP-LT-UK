class Solution {
    public int[] makeParityAlternating(int[] nums) {
        if (nums.length == 1) {
            return new int[2];
        }

        int max = nums[0];
        int min = nums[0];

        for (final int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        final int[] answer1 = solve(nums.clone(), max, min, 0);
        final int[] answer2 = solve(nums.clone(), max, min, 1);

        if (answer1[0] < answer2[0] || (answer1[0] == answer2[0] && answer1[1] < answer2[1])) {
            return answer1;
        } else {
            return answer2;
        }
    }


    private int[] solve(final int[] nums, final int MAX, final int MIN, final int p) {
        final int n = nums.length;
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (((nums[i] ^ i) & 1) == p) {
                c++;
                
                if (nums[i] == MAX) {
                    nums[i]--;
                } else if (nums[i] == MIN) {
                    nums[i]++;
                }
            }
        }

        int max = nums[0];
        int min = nums[0];

        for (final int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return new int[] { c, max - min };
    }
}