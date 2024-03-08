package vjudge.assignment_3_stl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (hashMap.containsKey(s)) {
                System.out.println(s + hashMap.get(s));
                hashMap.put(s, hashMap.get(s) + 1);
            } else {
                System.out.println("OK");
                hashMap.put(s, 1);
            }
        }
    }
}
