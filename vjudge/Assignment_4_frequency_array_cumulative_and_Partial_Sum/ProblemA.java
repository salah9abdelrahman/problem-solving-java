package vjudge.Assignment_4_frequency_array_cumulative_and_Partial_Sum;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Set<Character> set = new HashSet<>();

        String alpha = "qwertyuiopasdfghjklzxcvbnm";

        for (int i = 0; i < input.length(); i++) {
            if (alpha.indexOf(input.charAt(i)) != -1) {
                set.add(input.charAt(i));
            }
        }

        System.out.println(set.size());

    }
}
