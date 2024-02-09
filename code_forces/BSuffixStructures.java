package code_forces;

import java.util.*;

/*
https://codeforces.com/contest/448/problem/B
 */
public class BSuffixStructures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();
        int[] first_arr = new int[26];
        int[] second_arr = new int[26];
        for (int i = 0; i < first.length(); i++) {
            first_arr[first.charAt(i) - 'a']++;
        }
        for (int i = 0; i < second.length(); i++) {
            second_arr[second.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (first_arr[i] < second_arr[i]) {
                System.out.println("need tree");
                return;
            }
        }
        if (first.length() == second.length()) {
            System.out.println("array");
            return;
        }
        int j = 0;
        for (int i = 0; i < first.length(); i++) {
            if (j == second.length()) {
                break;
            }
            if (first.charAt(i) == second.charAt(j)) {
                j++;
            }

        }

        if (j == second.length()) {
            System.out.println("automaton");
        } else {
            System.out.println("both");
        }

    }
}
