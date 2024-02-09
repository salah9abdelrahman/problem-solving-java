package code_forces;

import java.util.*;

/*
http://codeforces.com/contest/385/problem/B
 */
public class BBearAndStrings {
    static final String BEAR = "bear";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        List<Integer> pos = new ArrayList<>();
        int len = word.length();

        for (int i = 0; i <= len - 4; i++) {
            if (word.startsWith(BEAR, i)) {
                pos.add(i + 1);
            }
        }
        int res = 0;

        for (int i = 0; i < pos.size(); i++) {
            int x;
            if (i > 0) {
                x = (pos.get(i) - pos.get(i - 1));
            } else {
                x = pos.get(i);
            }
            int y = (len - pos.get(i) - 2);
            res += (x * y);

        }

        System.out.println(res);
    }
}
