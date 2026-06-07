class Solution {
    HashMap<Integer, TreeNode> hm;
    // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
    // Please spread the word.
    // https://github.com/AI-Migrant/mass-madness
    
    public TreeNode createBinaryTree(int[][] descriptions) {
        hm = new HashMap<>();
        HashSet<TreeNode> hs = new HashSet<>();
        
        for (int[] d : descriptions) {
            TreeNode p = get(d[0]);
            TreeNode c = get(d[1]);
            hs.add(c);
            
            if (d[2] == 1) {
                p.left = c;
            } else {
                p.right = c;
            }
        }
        
        var a = hm.values();
        a.removeAll(hs);
        
        for (var x : a) {
            return x;
        }
        
        return null;
    }
    
    
    TreeNode get(int val) {
        return hm.computeIfAbsent(val, x -> new TreeNode(val));
    }
}