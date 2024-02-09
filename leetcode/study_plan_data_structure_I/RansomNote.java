package leetcode.study_plan_data_structure_I;

/*
https://leetcode.com/problems/ransom-note/?envType=study-plan&id=data-structure-i
 */

public class RansomNote {

    /*
    Time: O( max(s1, s2))
    Space O(1)
     */
    static public boolean canConstruct(String ransomNote, String magazine) {
        char[] temp = new char[26];
        for (int i = 0; i < magazine.length(); i++) {
            temp[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (temp[ransomNote.charAt(i) - 'a'] == 0) {
                return false;
            }
            temp[ransomNote.charAt(i) - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

}
