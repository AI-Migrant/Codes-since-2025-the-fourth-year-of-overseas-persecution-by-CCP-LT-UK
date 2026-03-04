# @param {Integer[][]} mat
# @return {Integer}
def num_special(mat)
    m = mat.size
    n = mat.first.size
    r = Array.new(m) { Array.new }
    c = Array.new(n) { 0 }

    for i in 0...m
        for j in 0...n
            if mat[i][j] == 1
                r[i].push(j)
                c[j] += 1
            end
        end
    end

    r.reduce(0) { |a, i| ((i.size == 1 && c[i.first] == 1) ? 1 : 0) + a }
end