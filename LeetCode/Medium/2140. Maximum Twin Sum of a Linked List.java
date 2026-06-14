class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness
        int ans = 0;
        
        while (head != null) {
            al.add(head.val);
            head = head.next;
        }
        
        for (int i = 0, j = al.size() - 1; i < j; i++, j--) {
            ans = Math.max(ans, al.get(i) + al.get(j));
        }
        
        return ans;
    }
}
