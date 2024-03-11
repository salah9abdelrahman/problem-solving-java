package patterns.two_pointers;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] colors = new int[] { 0, 1, 0 };
        int white = 0;
        int red = 0;
        int blue = colors.length - 1;

        while (white < blue + 1) {
            if (colors[white] == 0) {
                int temp = colors[white];
                colors[white] = colors[red];
                colors[red] = temp;
                white++;
                red++;
            } else if (colors[white] == 1) {
                white++;
            } else {
                int temp = colors[white];
                colors[white] = colors[blue];
                colors[blue] = temp;
                blue--;
            }

        }

        System.out.println(Arrays.toString(colors));

    }
}
