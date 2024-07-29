// 278. First Bad Version https://leetcode.com/problems/first-bad-version/description/
package modified_binary_search;

public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(new FirstBadVersionSolution().firstBadVersion(8));
    }


}

/**
 * Time O(log n)
 * Space O(1)
 */

class FirstBadVersionSolution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

class VersionControl {
    protected boolean isBadVersion(int i) {
        return i >= 7;
    }
}

