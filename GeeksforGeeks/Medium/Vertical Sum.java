class Solution {
    HashMap<Integer, Integer> hm;
    
    
    public ArrayList<Integer> verticalSum(Node root) {
        hm = new HashMap<>();
        solve(root, 0);
        ArrayList<Integer> keys = new ArrayList<>(hm.keySet());
        keys.sort(Comparator.naturalOrder());
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (Integer key : keys) {
            ans.add(hm.get(key));
        }
        
        return ans;
    }
    
    
    void solve(Node root, int i) {
        if (root == null) {
            return;
        }
        
        solve(root.left, i - 1);;
        solve(root.right, i + 1);
        hm.put(i, hm.getOrDefault(i, 0) + root.data);
    }
}