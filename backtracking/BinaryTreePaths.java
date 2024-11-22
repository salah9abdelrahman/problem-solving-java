// https://leetcode.com/problems/binary-tree-paths/description/
package backtracking;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(new BinaryTreePathsSolution().binaryTreePaths(root));
    }
}

class BinaryTreePathsSolution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> output = new ArrayList<>();
        backtracking(root, output, new ArrayList<Integer>());
        return output;
    }

    void backtracking(TreeNode root, List<String> output, ArrayList<Integer> curr) {
        if (root.left == null && root.right == null) {
            curr.add(root.val);
            StringBuilder c = new StringBuilder();
            for (int i = 0; i < curr.size(); i++) {
                c.append(curr.get(i));
                if(i != curr.size() -1){
                    c.append("->");
                }
            }
            output.add(c.toString());
            curr.remove(curr.size() - 1);
            return;
        }

        if (root.left != null) {
            curr.add(root.val);

            backtracking(root.left, output, curr);

            curr.remove(curr.size() - 1);

        }

        if (root.right != null) {
            curr.add(root.val);

            backtracking(root.right, output, curr);

            curr.remove(curr.size() - 1);

        }

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}