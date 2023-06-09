package patterns.sliding_window;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class RepeatedDnaSequences {
    public static void main(String[] args) {
//        findRepeatedSequences("AAAAACCCCCAAAAACCCCCC", 8).forEach(System.out::println);
        findRepeatedSequences("AAAAAAAAAAA").forEach(System.out::println);

    }

    public static List<String> findRepeatedSequences(String s) {
        Set<String> hash = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String subString = s.substring(i, 10 + i);
            if (hash.contains(subString)) {
                result.add(subString);
            }else {
                hash.add(subString);
            }
        }
        return new ArrayList<>(result);
    }
}
