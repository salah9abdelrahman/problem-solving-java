package bit;

public class CountNumberOfBits {
    public static void main(String[] args) {
        System.out.println(bitShifting(125));
    }

    public static int bitShifting(int n) {
        int count = 0;
        while (n > 0) {
            ++count;
            n >>= 1; // this is equivalent to (n = n >> 1) OR (n = n/2);
        }
        return count;
    }
}
