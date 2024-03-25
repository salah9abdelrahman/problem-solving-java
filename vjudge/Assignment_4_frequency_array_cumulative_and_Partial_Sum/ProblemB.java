package vjudge.Assignment_4_frequency_array_cumulative_and_Partial_Sum;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int[] prefixSum = new int[input.length() + 1];

        int counter = 0;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                counter++;
            }
            prefixSum[i + 1] = counter;
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(prefixSum[r] - prefixSum[l]);
        }
    }

}
