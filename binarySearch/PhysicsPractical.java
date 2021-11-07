package binarySearch;

import java.io.*;
import java.util.*;

/*
http://codeforces.com/contest/253/problem/B
 */
public class PhysicsPractical {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        final BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int n = Integer.parseInt(br.readLine());
        final int[] arr = readArray(br, n);
        Arrays.sort(arr);
        int ans = Integer.MIN_VALUE;
        Set<Integer> tested = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (!tested.contains(val)) {
                int max = val * 2;
                int maxBs = bsLastAppearance(arr, max);
                int result = maxBs - i + 1;
                ans = Math.max(ans, result);
                tested.add(val);
            }
        }

        bw.write(arr.length - ans + "\n");
        bw.flush();
        bw.close();
    }


    static int bsLastAppearance(int[] arr, int val) {
        int start = 0, end = arr.length - 1, result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > val) {
                end = mid - 1;
            } else if (arr[mid] < val) {
                start = mid + 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        return result == -1 ? start - 1 : result;
    }


    private static int[] readArray(BufferedReader br, int n) throws IOException {
        int[] arr = new int[n];
        final StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

}
