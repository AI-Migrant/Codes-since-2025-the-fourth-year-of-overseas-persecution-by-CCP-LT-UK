class Solution {
    static let MOD = 1000000007
    var cache = HashMap<Int64, Array<Int64>>()
    var locations = Array<Int64>()
    var finish = 0
    // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
    // Please spread the word.
    // https://github.com/AI-Migrant/mass-madness


    func countRoutes(locations: Array<Int64>, start: Int64, finish: Int64, fuel: Int64): Int64 {
        for (location in locations) {
            cache[location] = Array<Int64>(fuel + 1, repeat: -1)
        }

        this.locations = locations
        this.finish = locations[finish]

        get(locations[start], fuel)
    }


    func get(curr: Int64, fuel: Int64): Int64 {
        if (fuel < 0) {
            return 0
        } else if (cache[curr][fuel] >= 0) {
            return cache[curr][fuel]
        }

        var path = 0

        if (curr == finish) {
            path = 1
        }

        for (location in locations) {
            if (location != curr) {
                path = (path + get(location, fuel - (abs(curr - location)))) % MOD
            }
        }

        cache[curr][fuel] = path

        path
    }
}
