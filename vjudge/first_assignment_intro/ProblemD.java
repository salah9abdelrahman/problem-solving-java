package vjudge.first_assignment_intro;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int v1 = sc.nextInt();
        int x2 = sc.nextInt();
        int v2 = sc.nextInt();
        boolean still = true;

        if (v1 <= v2) {
            System.out.println("NO");
            still = false;

        }
        while (still) {
            if (x1 == x2) {
                System.out.println("YES");
                break;
            }
            if (x1 > x2) {
                System.out.println("NO");
                break;
            }
            x1 += v1;
            x2 += v2;
        }
    }
}
