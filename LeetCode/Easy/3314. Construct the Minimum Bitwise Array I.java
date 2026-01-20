class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        final int[] answer = new int[nums.size()];


        for (int i = 0, j = 1; i < answer.length; i++, j = 1) {
            while ((nums.get( i ) & j) != 0) {
                j++;
            }

            if (j == 1) {
                answer[i] = -1;
            } else {
                answer[i] = nums.get( i ) ^ (j >> 1);
            }
        }

        return answer;
    }
}