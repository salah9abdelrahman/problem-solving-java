package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/pascals-triangle
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    /*
    O (n 2)
     */

    static public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>(i + 1);
            List<Integer> prevList = res.get(i - 1);
            for (int j = 0; j <= i; j++) {
                innerList.add(getElement(j - 1, prevList) + getElement(j, prevList));
            }
            res.add(innerList);
        }
        return res;
    }

    static private int getElement(int indx, List<Integer> arr) {
        if (indx < 0 || indx >= arr.size()) {
            return 0;
        }
        return arr.get(indx);
    }
}
