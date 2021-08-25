/*
http://codeforces.com/contest/186/problem/B
 */

import java.util.*;

public class BGrowingMushrooms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Participant> participants = new ArrayList<>();
        int n = sc.nextInt();
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            double reduceT1 = s1 * t1 - ((double) s1 * t1 * k / 100) + t2 * s2;
            double reduceT2 = s2 * t1 - ((double) s2 * t1 * k / 100) + t2 * s1;
            Participant participant = new Participant(i, Math.max(reduceT1, reduceT2));
            participants.add(participant);
        }

        Collections.sort(participants);
        for (Participant p : participants
        ) {
            System.out.println(p.num + " " + String.format("%.2f", p.maxVal));
        }

    }

    static class Participant implements Comparable<Participant> {
        public Participant(int num, double maxVal) {
            this.maxVal = maxVal;
            this.num = num;
        }

        public double maxVal;
        public int num;

        public int compareTo(Participant o) {
            if (this.maxVal > o.maxVal) {
                return -1;
            } else if (this.maxVal < o.maxVal) {
                return 1;
            }
            return 0;
        }
    }
}
