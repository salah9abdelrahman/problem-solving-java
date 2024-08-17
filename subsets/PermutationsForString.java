package subsets;

import java.util.*;

public class PermutationsForString {
    public static void main(String[] args) {
        System.out.println(new PermutationsForStringSolution().permuteWord("abcd"));
    }
}

class PermutationsForStringSolution {

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
