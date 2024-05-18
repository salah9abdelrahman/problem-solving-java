package data_structure.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(17);

//        tree.traverseInOrder();
//
//        System.out.println(tree.get(27));
//        System.out.println(tree.get(32));
//        System.out.println(tree.get(80));
//
//        System.out.println(tree.min());
//        System.out.println(tree.max());
//
//        tree.delete(27);
//        tree.delete(25);
//        tree.traverseInOrder();

        tree.traversePreOrder();

    }
}
