class Solution {
    func minimumAbsDifference(arr: Array<Int64>): ArrayList<ArrayList<Int64>> {
        sort(arr)
        var minDiff = Int64.Max
        let answer = ArrayList<ArrayList<Int64>>()

        for (i in 1..arr.size) {
            minDiff = min(minDiff, arr[i] - arr[i - 1])
        }

        for (i in 1..arr.size) {
            if (arr[i] - arr[i - 1] == minDiff) {
                answer.add(ArrayList([arr[i - 1], arr[i]]))
            }
        }

        answer
    }
}