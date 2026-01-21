class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        final Stack<Integer> stack = new Stack<>();
        final ArrayList<Integer> answer = new ArrayList<>(arr.length);
        
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            
            answer.add(stack.isEmpty() ? i + 1 : i - stack.peek());
            stack.push(i);
        }
        
        return answer;
    }
}