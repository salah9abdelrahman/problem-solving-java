package vjudge.first_assignment_intro;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        if (n % 2 == 0 && n != 2) {
            System.out.println("YES");
        } else {

            System.out.println("NO");
        }
    }
}
