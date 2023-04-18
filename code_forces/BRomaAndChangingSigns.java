package code_forces;

import java.util.*;

/*
https://codeforces.com/contest/262/problem/B
 */
public class BRomaAndChangingSigns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), mini = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();

            if (e <= 0 && k > 0) {
                e *= -1;
                res += e;
                k--;
            } else {
                res += e;
            }

            mini = Math.min(mini, e);
        }
        if (k % 2 == 1) {
            res -= (2 * mini);
        }
        System.out.println(res);
    }
}
