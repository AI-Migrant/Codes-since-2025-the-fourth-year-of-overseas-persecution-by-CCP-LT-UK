public class Solution {
    public static int middleOfThree(int x, int y, int z) {
        if (x > y) {
            if (x > z) {
                if (y > z) {
                    return y;
                } else {
                    return z;
                }
            } else {
                return x;
            }
        } else if (y > z) {
            if (x > z) {
                return x;
            } else {
                return z;
            }
        } else {
            return y;
        }
    }
}