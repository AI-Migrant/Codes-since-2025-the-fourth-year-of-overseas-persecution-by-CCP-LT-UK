class Solution {
    public boolean hasAllCodes(String s, int k) {
        final OZ oz = new OZ();
        final int o = k - 1;
        
        return IntStream.range(0, s.length() - o).reduce(0, (a, i) -> a + oz.add(s, i, i + o)) == (int) Math.pow(2, k);
    }
    
    
    private class OZ {
        private OZ O;
        private OZ Z;

        
        private int add(final String s, int i, final int j) {
            OZ curr = this;
            
            while (i < j) {
                if (s.charAt(i) == '0') {
                    if (curr.Z == null) {
                        curr.Z = new OZ();
                    }

                    curr = curr.Z;
                } else {
                    if (curr.O == null) {
                        curr.O = new OZ();
                    }

                    curr = curr.O;
                }

                i++;
            }

            if (s.charAt(i) == '0') {
                if (curr.Z == null) {
                    curr.Z = new OZ();

                    return 1;
                }
            } else if (curr.O == null) {
                curr.O = new OZ();

                return 1;
            }
            
            return 0;
        }
    }
}