class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        arr.sort(Comparator.naturalOrder());
        final int n = arr.size();
        int answer = Integer.MAX_VALUE;
        
        for (int i = m - 1, j = 0; i < n; i++, j++) {
            answer = Math.min(answer, arr.get(i) - arr.get(j));
        }
        
        return answer;
    }
}