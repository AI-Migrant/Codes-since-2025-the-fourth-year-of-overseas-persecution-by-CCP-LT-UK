class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        final List<List<Integer>> answer = new ArrayList<>();
        final int N = arr.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        
        for (int i = 1; i < N; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }

        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[i - 1] == min) {
                answer.add(List.of(arr[i - 1], arr[i]));
            }
        }

        return answer;
    }
}