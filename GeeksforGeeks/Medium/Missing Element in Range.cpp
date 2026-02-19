class Solution {
  public:
    vector<int> missinRange(vector<int>& arr, int low, int high) {
        const int n = high - low + 1;
        bool p[n] = {};
        vector<int> answer;
        
        for (const int& num : arr) {
            if (num >= low & num <= high) {
                p[num - low] = true;
            }
        }
        
        int num = low;
        
        for (const bool& q : p) {
            if (!q) {
                answer.push_back(num);
            }
            
            ++num;
        }
        
        return answer;
    }
};