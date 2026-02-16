class Solution {
    canAttend(arr) {
        const n = arr.length;
        arr.sort((x, y) => x[0] - y[0]);
        let prev = [ 0, 0 ];
        
        for (const curr of arr) {
            if (curr[0] < prev[1]) {
                return false;
            }
            
            prev = curr;
        }
        
        return true;
    }
}