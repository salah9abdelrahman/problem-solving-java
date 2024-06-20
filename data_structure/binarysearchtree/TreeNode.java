package data_structure.binarysearchtree;

public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public void insert(int value) {
        // not allowing duplicate values
        if (value == data) {
            return;
        }

        if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(this.data + ", ");

        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        System.out.println(this);
        if (leftChild != null) {
            leftChild.traversePreOrder();

        }
        if (rightChild != null) {
            rightChild.traversePreOrder();
        }
    }

    public TreeNode get(int value) {
        if (data == value) {
            return this;
        }
        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }
        return null;
    }


    public TreeNode min() {
        if (leftChild == null) {
            return new TreeNode(data);
        }
        return leftChild.min();
    }

    public TreeNode max() {
        if (rightChild == null) {
            return new TreeNode(data);
        }
        return rightChild.max();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
