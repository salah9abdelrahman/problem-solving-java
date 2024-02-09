package vjudge.first_package_intro;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int lower = 0;
        int upper = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 97) {
                upper++;
            } else {
                lower++;
            }
        }

        if (lower >= upper) {
            System.out.println(word.toLowerCase());
        } else {
            System.out.println(word.toUpperCase());
        }
    }
}
