class Solution:
    def isTrionic(self, nums: List[int]) -> bool:
        p = 1
        q = len(nums) - 1

        while p < q and nums[p] > nums[p - 1]:
            p += 1

        while q > p and nums[q] > nums[q - 1]:
            q -= 1

        if p == 1 or q == n - 1 or p == q:
            return False

        return all(nums[o] < nums[o - 1] for o in range(p, q + 1))