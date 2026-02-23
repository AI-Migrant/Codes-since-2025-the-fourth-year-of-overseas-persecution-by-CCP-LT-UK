class Solution {
  public:
    vector<int> findUnion(vector<int>& a, vector<int>& b) {
        unordered_set<int> s(a.begin(), a.end());
        s.insert(b.begin(), b.end());

        return vector<int>(s.begin(), s.end());
    }
};