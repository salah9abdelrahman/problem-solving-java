package vjudge.assignment_3_stl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(Character.toLowerCase(s.charAt(i)));
        }

        if(set.size() == 26){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
