class Solution {
  public:
    int overlapInt(vector<vector<int>> &arr) {
        const int n = arr.size();
        int start = 4000000;
        int end = 1;
        
        for (const vector<int>& interval : arr) {
            start = min(start, interval.front());
            end = max(end, interval.back());
        }
        
        const int base = start - 1;
        int a[end - base] = {};
        int c = 0;
        int answer = 1;
        
        for (const vector<int>& interval : arr) {
            ++a[interval.front() - start];
            --a[interval.back() - base];
        }
        
        for (const int& e : a) {
            c += e;
            answer = max(answer, c);
        }
        
        return answer;
    }
};