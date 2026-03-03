# @param {Integer} n
# @param {Integer} k
# @return {Character}
def find_kth_bit(n, k)
    solve(n, k).chr
end


def solve(n, k)
    return 48 if k == 1

    m = 1 << (n - 1)
    
    case
    when k == m then 49    
    when k < m then solve(n - 1, k)
    else 97 - solve(n - 1, m + m - k)
    end
end
