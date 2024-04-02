package vjudge.Assignment_4_frequency_array_cumulative_and_Partial_Sum;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt() + arr[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int sol = -1;

        for (int i = k; i < n + 1; i++) {
            int idx = i - k;
            int val = arr[i] - arr[idx];
            if (val < min) {
                min = val;
                sol = idx + 1;
            }

        }
        System.out.println(sol);
    }

}
