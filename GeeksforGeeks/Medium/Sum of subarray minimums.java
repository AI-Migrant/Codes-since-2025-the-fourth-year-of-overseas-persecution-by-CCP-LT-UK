class Solution {
    public int sumSubMins(int[] arr) {
        final int n = arr.length;
        final Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for (int i = 0, j; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                j = stack.pop();
                answer += arr[j] * (j - (stack.isEmpty() ? -1 : stack.peek())) * (i - j);
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            final int i = stack.pop();
            answer += arr[i] * (i - (stack.isEmpty() ? -1 : stack.peek())) * (n - i);
        }
        
        return answer;
    }
}