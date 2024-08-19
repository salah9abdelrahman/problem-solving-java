// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumberSolution().letterCombinations("234"));
    }
}

class LetterCombinationsOfAPhoneNumberSolution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        HashMap<Character, String> keyboard = new HashMap<>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            strings.add(keyboard.get(digits.charAt(i)));
        }

        List<String> result = new ArrayList<>();

        backtracking(strings, new StringBuilder(), result, 0);

        return result;
    }

    private void backtracking(List<String> strings, StringBuilder curr, List<String> result, int first) {
        if (curr.length() == strings.size()) {
            result.add(curr.toString());
            return;
        }

        for (int j = 0; j < strings.get(first).length(); j++) {

            curr.append(strings.get(first).charAt(j));

            backtracking(strings, curr, result, first + 1);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}