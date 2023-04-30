package patterns.two_pointers;

public class ReverseWordInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("Hello friend"));

    }


    /*
     * Time O(n)
     * space O(n)
     */
    public static String reverseWords(String s) {
        // trim spaces and convert string to string builder
        char[] s1 = s.toCharArray();
        String s2 = cleanSpaces(s1, s1.length);
        StringBuilder builder = new StringBuilder(s2);

        // reverse the whole string using the strRev() function
        strRev(builder, 0, builder.length() - 1);

        // reverse every word
        int n = builder.length();
        int start = 0, end = 0;
        // Find the start index of each word by detecting spaces.
        while (start < n) {
            // Find the end index of the word.
            while (end < n && builder.charAt(end) != ' ')
                ++end;
            // Let's call our helper function to reverse the word in-place.
            strRev(builder, start, end - 1);
            // moving to the next word
            start = end + 1;
            ++end;
        }
        return builder.toString();

    }

    static String cleanSpaces(char[] a, int n) {
        // Convert character array to string
        String str = new String(a, 0, n);

        // Trim extra spaces at the beginning and end of the string
        // And replace multiple spaces with a single space
        str = str.replaceAll("\\s+", " ").trim();

        return str;
    }

    public static void strRev(StringBuilder sb, int startRev, int endRev) {
        // Starting from the two ends of the list, and moving
        // in towards the centre of the string, swap the characters
        while (startRev < endRev) {
            char temp = sb.charAt(startRev); // temp store for swapping
            sb.setCharAt(startRev++, sb.charAt(endRev));
            sb.setCharAt(endRev--, temp);
        }
    }
}
