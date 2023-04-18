package leetcode.study_plan_data_structure_I;

/*
https://leetcode.com/problems/valid-anagram/?envType=study-plan&id=data-structure-i
 */
public class ValidAnagram {
    /*
    Time O(n)
    Space O(1)
     */
    static public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int temp[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;

        }

        for (int i = 0; i < t.length(); i++) {
            if (temp[t.charAt(i) - 'a'] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
