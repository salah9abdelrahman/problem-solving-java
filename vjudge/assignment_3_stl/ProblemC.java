package vjudge.assignment_3_stl;

import java.util.Scanner;
import java.util.TreeSet;

public class ProblemC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        boolean solvable = true;
        for (int i = 0; i < n; i++) {
            int ni = sc.nextInt();
            set.add(ni);
            if (set.size() > 3) {
                System.out.println("NO");
                solvable = false;
                break;
            }
        }
        if (set.size() <= 2) {
            System.out.println("YES");

        } else if (solvable) {
            Integer[] array = set.toArray(new Integer[set.size()]);
            if (array[2] - array[1] == array[1] - array[0]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
