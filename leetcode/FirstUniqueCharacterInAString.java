package leetcode;

/*
https://leetcode.com/problems/first-unique-character-in-a-string/?envType=study-plan&id=data-structure-i
 */
public class FirstUniqueCharacterInAString {

    /*
    Time O(n)
    Space O(1)
     */
    static public int firstUniqChar(String s) {
        char[] alpha = new char[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (alpha[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabb"));
    }


}
