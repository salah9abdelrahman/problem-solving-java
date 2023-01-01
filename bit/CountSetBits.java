package bit;

public class CountSetBits {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(125));
        System.out.println(countSetBits(125));
    }

    public static int countSetBits(int n) {
        int ret = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                ret++;
            }
            n >>= 1; // shift last bit
        }
        return ret;
    }
}
