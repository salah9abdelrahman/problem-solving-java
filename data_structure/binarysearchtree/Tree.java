package data_structure.binarysearchtree;

public class Tree {
    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            System.out.println("***************");
            root.traverseInOrder();
            System.out.println("***************");
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            System.out.println("***************");
            root.traversePreOrder();
            System.out.println("***************");
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public TreeNode min() {
        if (root != null) {
            return root.min();
        } else {
            return null;
        }
    }

    public TreeNode max() {
        if (root != null) {
            return root.max();
        } else {
            return null;
        }
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return null;
        }
        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        } else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        } else {

            // The first two cases: 1)the node is a leaf node
            // 2)the node has one child
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            } else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }
            // The Third case: the node has 2 children
            // Replace it with minimum node in the right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min().getData());
            // or Replace it with maximum node in the left subtree
            // subtreeRoot.setData(subtreeRoot.getLeftChild().max().getData());

            // delete the replacement node
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }
        return subtreeRoot;
    }
}
