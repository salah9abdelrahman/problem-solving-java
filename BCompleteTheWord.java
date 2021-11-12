import java.util.*;
import java.util.stream.Collectors;

/*
 https://codeforces.com/contest/716/problem/B
 */
public class BCompleteTheWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        if (word.length() < 26) {
            System.out.println("-1");
            return;
        }
        boolean solvable = true;
        for (int o = 0; o < word.length(); o++) {
            if (o + 25 >= word.length()) {
                break;
            }
            solvable = true;
            StringBuilder new_word = new StringBuilder(word.substring(o, o + 26));
            Set<Character> existing = new HashSet<>();
            List<Integer> missing_indexes = new ArrayList<>();

            for (int i = 0; i < 26; i++) {
                Character c = new_word.charAt(i);
                if (c.equals('?')) {
                    missing_indexes.add(i);
                } else {
                    if (existing.contains(c)) {
                        solvable = false;
                        break;
                    }

                    existing.add(c);
                }
            }
            if (solvable) {
                Set<Character> missing_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                        .chars().mapToObj(e -> (char) e)
                        .collect(Collectors.toSet());
                missing_letters.removeAll(existing);
                List<Character> missing_letters_list = new ArrayList<>(missing_letters);
                for (int j = 0; j < missing_letters.size(); j++) {
                    new_word.replace(missing_indexes.get(j), missing_indexes.get(j) + 1, String.valueOf(missing_letters_list.get(j)));
                }
                word = word.replace('?', 'A');
                System.out.println(word.substring(0, o) + new_word + word.substring(o + 26));
                break;
            }


        }
        if (!solvable) {
            System.out.println("-1");
        }
    }


}
