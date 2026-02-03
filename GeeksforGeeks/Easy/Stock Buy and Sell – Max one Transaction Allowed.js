/**
 * @param {number[]} prices
 * @returns {number}
 */

class Solution {
    maxProfit(prices) {
        let bought = 100001
        let answer = 0
        
        for (const price of prices) {
            if (price <= bought) {
                bought = price
            } else {
                answer = Math.max(answer, price - bought)
            }
        }
        
        return answer
    }
}