package sliding_window;


import java.util.*;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class RepeatedDnaSequences {
    public static void main(String[] args) {
//        findRepeatedSequences("AAAAACCCCCAAAAACCCCCC", 8).forEach(System.out::println);
        findRepeatedSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").forEach(System.out::println);
        System.out.println("------");
        findRepeatedSequences_RabinKarp("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").forEach(System.out::println);

    }

    /**
     * Linear-time Slice Using Substring + HashSet
     * Time O(N) // O((N - L)L)
     * Space O(N)  // O((N - L)L)
     */
    public static List<String> findRepeatedSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> output = new HashSet<>();
        int L = 10;
        for (int i = 0; i <= s.length() - L; i++) {
            String subString = s.substring(i, L + i);
            if (seen.contains(subString)) {
                output.add(subString);
            } else {
                seen.add(subString);
            }
        }
        return new ArrayList<>(output);
    }

    /**
     * Rabin-Karp : Constant-time Slice Using Rolling Hash
     */
    public static List<String> findRepeatedSequences_RabinKarp(String s) {
        int L = 10, n = s.length();
        if (n <= L) {
            return new ArrayList<>();
        }

        // rolling hash parameters: base a
        // aL = 1048576
        int a = 4, aL = (int) Math.pow(a, L);

        // convert string to array of integers
        Map<Character, Integer> toInt = new HashMap() {{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = toInt.get(s.charAt(i));
        }

        int h = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int i = 0; i <= n - L; i++) {
            // compute hash of the current sequence in O(1) time
            if (i != 0) {
                h = h * a - nums[i - 1] * aL + nums[i + L - 1];
            }
            // compute hash of the first sequence in O(L) time
            else {
                for (int j = 0; j < L; j++) {
                    h = h * a + nums[j];
                }

            }

            if (seen.contains(h)) {
                output.add(s.substring(i, i + L));
            } else {
                seen.add(h);
            }
        }

        return new ArrayList<>(output);
    }
}
