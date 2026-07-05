import java.util.*;


class Main {
    static HashMap<Integer, Integer> cache = new HashMap<>();


    static {
        cache.put(1, 1);
    }


    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
		

        while (read.hasNext()) {
            int i = read.nextInt();
            int j = read.nextInt();
            int max = 0;
            int p, q;

            if (i > j) {
                p = j;
                q = i;
            } else {
                p = i;
                q = j;
            }


            for (int n = p; n <= q; n++) {
                max = Math.max(max, solve(n));
            }


            System.out.println(i + " " + j + " " + max);
        }


        read.close();
    }


    static int solve(int n) {
        if (!cache.containsKey(n)) {
            if (n % 2 > 0) {
                cache.put(n, 1 + solve(n * 3 + 1));
            } else {
                cache.put(n, 1 + solve(n / 2));
            }
        }
        
        return cache.get(n);
    }
}
