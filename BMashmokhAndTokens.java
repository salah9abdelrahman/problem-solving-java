import java.util.Scanner;

/*
1 135360 718513035
261734062
B. Mashmokh and Tokens
https://codeforces.com/contest/415/problem/B
 */
public class BMashmokhAndTokens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();
        for (long i = 0; i < n; i++) {
            long x = sc.nextInt();
            long res = ((x * a) % b) / a;
            System.out.print(res + " ");
        }

    }

    public static void main_binary_search(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();

        for (long i = 0; i < n; i++) {
            long x = sc.nextInt();
            double val = (double) x * a / b;
            if (val < 1) {
                System.out.print(x);
            } else if (val % 1 == 0) {
                System.out.print(0);
            } else {
                long res = bs_first_appearance(x, (long) val, a, b);
                System.out.print(res);
            }
            System.out.print(" ");

        }

    }

    static long bs_first_appearance(long original, long val, long a, long b) {
        long start = 1;
        long end = original;
        long ind = -1;
        while (start <= end) {
            long mid = (start + end) / 2;
            long res = mid * a / b;
            if (res > val) {
                end = mid - 1;
            } else if (res < val) {
                start = mid + 1;
            } else {
                ind = mid;
                end = mid - 1;
            }
        }
        return original - ind;
    }
}
