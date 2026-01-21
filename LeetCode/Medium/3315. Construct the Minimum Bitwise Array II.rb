# @param {Integer[]} nums
# @return {Integer[]}
def min_bitwise_array(nums)
    nums.map do |num|
        p = 1

        while p <= num and (num & p) != 0 do
            p <<= 1
        end

        if p > 1
            num ^ (p >> 1)
        else
            -1
        end
    end
end