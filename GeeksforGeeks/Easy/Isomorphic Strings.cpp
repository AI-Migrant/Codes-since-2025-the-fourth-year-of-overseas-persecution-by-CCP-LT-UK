class Solution {
  public:
    bool areIsomorphic(string &s1, string &s2) {
        const int n = s1.length();
        char a1[26] = {};
        char a2[26] = {};
        
        for (int i = 0; i < n; ++i) {
            const int i1 = s1[i] - 'a';
            const int i2 = s2[i] - 'a';
            
            if (a1[i1] == 0) {
                if (a2[i2] == 0) {
                    a1[i1] = s2[i];
                    a2[i2] = s1[i];
                } else {
                    return false;
                }
            } else if (a2[i2] == 0 || a1[i1] != s2[i] || a2[i2] != s1[i]) {
                return false;
            }
        }
        
        return true;
    }
};