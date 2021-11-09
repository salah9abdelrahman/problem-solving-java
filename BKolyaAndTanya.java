import java.util.Scanner;

/*
https://codeforces.com/contest/584/problem/B
 */
public class BKolyaAndTanya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long mod = 1000000007;
        long probs = 1;
        long notSat = 1;
        for (int i = 1; i <= 3 * n; i++) {
            probs = (probs * 3) % mod;
            if (i % 3 == 0) {
                notSat = (notSat * 7) % mod;
            }
        }

        long sat = (probs - notSat + mod) % mod;
        System.out.println(sat);
    }
}
