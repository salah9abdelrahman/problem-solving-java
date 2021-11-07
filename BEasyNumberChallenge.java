import java.util.Scanner;

/*
http://codeforces.com/contest/236/problem/B
 */
public class BEasyNumberChallenge {
    static long[] arr = new long[100_00_01];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        long ans = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    ans += divisorNum(i * j * k);
                }
            }
        }
        System.out.println(ans % 1073741824);
    }

    static long divisorNum(int num) {
        if (arr[num] != 0) {
            return arr[num];
        }
        long divisors = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i != num) {
                    divisors++;
                }
                divisors++;
            }
        }
        arr[num] = divisors;
        return divisors;
    }
}