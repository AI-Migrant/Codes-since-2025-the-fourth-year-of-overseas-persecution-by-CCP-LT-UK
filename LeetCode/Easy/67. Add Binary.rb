# @param {String} a
# @param {String} b
# @return {String}
def add_binary(a, b)
  a.reverse!
  b.reverse!
  n = [ a.size, b.size ].max
  s = Array.new(n, 0)
  c = 0

  n.times do |i|
    s[i] += 1 if a[i] == "1"
    s[i] += 1 if b[i] == "1"

    if c == 0
      if s[i] == 2
        s[i] -= 2
        c += 1
      end
    else
      case s[i]
      when 0
        s[i] = 1
        c = 0
      else
        s[i] -= 1
      end
    end
  end

  s << 1 if c == 1

  s.reverse.join
end