package subsets;

import java.util.*;

public class PermutationsOfString {
    public static void main(String[] args) {
        System.out.println(new PermutationsOfStringSolution().permuteWord("abcd"));
        System.out.println(new PermutationsOfStringBacktrackingSolution().permuteWord("abcd"));
    }
}

class PermutationsOfStringBacktrackingSolution {
    public ArrayList<String> permuteWord(String word) {
        ArrayList<String> output = new ArrayList<String>();
        backtracking(word, output, new StringBuilder(), new HashSet<Character>());
        return output;
    }

    private void backtracking(String word, ArrayList<String> output, StringBuilder curr, HashSet<Character> added) {
        if (curr.length() == word.length()) {
            output.add(curr.toString());
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            if (!added.contains(word.charAt(i))) {
                curr.append(word.charAt(i));
                added.add(word.charAt(i));

                backtracking(word, output, curr, added);

                curr.deleteCharAt(curr.length() - 1);
                added.remove(word.charAt(i));
            }
        }
    }
}

class PermutationsOfStringSolution {

    public ArrayList<String> permuteWord(String word) {
        ArrayList<String> results = new ArrayList<String>();
        permuteStringRec(word, 0, results);
        return results;
    }

    private void permuteStringRec(String word, int currentIndex, ArrayList<String> results) {
        // Prevents adding duplicate permutations
        if (currentIndex == word.length() - 1) {
            results.add(word);
            return;
        }
        for (int index = currentIndex; index < word.length(); index++) {
            // swaps character for each permutation
            String swappedStr = swapChar(word, currentIndex, index);

            // recursively calls itself to find each permutation
            permuteStringRec(swappedStr, currentIndex + 1, results);
        }
    }

    private String swapChar(String word, int i, int j) {
        char[] swapIndex = word.toCharArray();
        char temp = swapIndex[i];
        swapIndex[i] = swapIndex[j];
        swapIndex[j] = temp;

        return new String(swapIndex);
    }
}
