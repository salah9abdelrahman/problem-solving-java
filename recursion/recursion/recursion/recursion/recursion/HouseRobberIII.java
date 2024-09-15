// https://leetcode.com/problems/house-robber-iii/
package recursion.recursion.recursion.recursion.recursion;

/**
 * @time O(n)
 * @space O(n)
 */
class HouseRobberIII_Recursion_Solution {
    public int rob(TreeNode_HouseRobberIII root) {
        int[] answer = helper(root);
        return Math.max(answer[0], answer[1]);
    }

    private int[] helper(TreeNode_HouseRobberIII root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int robWithRoot = root.val + left[1] + right[1];
        int robWithoutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robWithRoot, robWithoutRoot};
    }
}

public class HouseRobberIII {
    public static void main(String[] args) {
        TreeNode_HouseRobberIII root = new TreeNode_HouseRobberIII(3,
                new TreeNode_HouseRobberIII(2,
                        null,
                        new TreeNode_HouseRobberIII(3)
                ),
                new TreeNode_HouseRobberIII(3,
                        null,
                        new TreeNode_HouseRobberIII(1))
        );

        System.out.println(new HouseRobberIII_Recursion_Solution().rob(root));
    }


}


class TreeNode_HouseRobberIII {
    int val;
    TreeNode_HouseRobberIII left;
    TreeNode_HouseRobberIII right;

    TreeNode_HouseRobberIII() {
    }

    TreeNode_HouseRobberIII(int val) {
        this.val = val;
    }

    TreeNode_HouseRobberIII(int val, TreeNode_HouseRobberIII left, TreeNode_HouseRobberIII right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
