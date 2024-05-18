package algorithms.sort;

public class RadixSort {
    public static void main(String[] args) {

//        int[] arr = {4725, 4586, 1330, 8792, 1594, 5729};
        String[] strings = {"bcdef", "dbaqc", "abcde", "bbbbb", "scada"};
//        radixSort(arr, 10, 4);
        radixSortForStrings(strings, 26, 5);

        for (String s : strings
        ) {
            System.out.print(s + " ");
        }
    }

    public static void radixSort(int[] input, int radix, int width) {
        for (int position = 0; position < width; position++) {
            radixSingleSort(input, position, radix);
        }
    }

    public static void radixSortForStrings(String[] input, int radix, int width) {
        for (int position = width - 1; position >= 0; position--) {
            radixSingleSortForStrings(input, position, radix);
        }
    }


    private static void radixSingleSortForStrings(String[] input, int position, int radix) {
        int[] countArray = new int[radix];

        //normal count array
        for (int i = input.length - 1; i >= 0; i--) {
            countArray[getDigit(position, input[i])]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        String[] temp = new String[input.length];

        for (int tempIndex = input.length - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex])]] = input[tempIndex];
        }
        System.arraycopy(temp, 0, input, 0, input.length);
    }

    private static void radixSingleSort(int[] input, int position, int radix) {
        int[] countArray = new int[radix];

        //normal count array
        for (int i = 0; i < input.length; i++) {
            countArray[getDigit(position, input[i], radix)]++;
        }

        /*
        adjust the count array to achieve stability  by count how many elements has a value or less
        e.g: how many elements have the value 3 or less than 3.
         */
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] temp = new int[input.length];

        for (int tempIndex = input.length - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        System.arraycopy(temp, 0, input, 0, input.length);

    }

    private static int getDigit(int position, int itemValue, int radix) {
        return (itemValue / (int) Math.pow(radix, position)) % radix;
    }

    private static int getDigit(int position, String itemValue) {
        return itemValue.charAt(position) - 'a';
    }
}

