# @param {Integer} poured
# @param {Integer} query_row
# @param {Integer} query_glass
# @return {Float}
def champagne_tower(poured, query_row, query_glass)
  a = [poured]

  (1..query_row).each do |r|
    a = Array.new(r + 1) do |i|
      (i < r ? [a[i] - 1, 0].max.fdiv(2) : 0) + (i > 0 ? [a[i -\
 1] - 1, 0].max.fdiv(2) : 0)
    end
  end

  [a[query_glass], 1].min
end


# Solution 2
def champagne_tower(poured, query_row, query_glass)
  [(1..query_row).reduce([poured]) { |a, r| Array.new(r + 1) { \
|i| (i > 0 ? [a[i - 1] - 1, 0].max.fdiv(2) : 0) + (i < r ? [a[i\
] - 1, 0].max.fdiv(2) : 0) } }[query_glass], 1].min
end