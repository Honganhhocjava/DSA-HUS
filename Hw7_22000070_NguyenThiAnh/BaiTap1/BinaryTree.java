package Hw7_22000070_NguyenThiAnh.BaiTap1;

public class BinaryTree {
    ArrayBinaryTree<String, Integer> arrayBinaryTree = new ArrayBinaryTree<>();
    LinkedBinaryTree<String, Integer> linkedBinaryTree = new LinkedBinaryTree<>();

    public void createArrayBinaryTree() {
        arrayBinaryTree.setRoot("A");
        arrayBinaryTree.setLeft(0, "B");
        arrayBinaryTree.setRight(0, "C");
        arrayBinaryTree.setLeft(1, "D");
        arrayBinaryTree.setRight(1, "E");
        arrayBinaryTree.setLeft(2, "F");
        arrayBinaryTree.setRight(2, "G");
    }

    public void createLinkedBinaryTree() {
        LinkedBinaryTree.Node<String> root = linkedBinaryTree.addRoot("A");
        LinkedBinaryTree.Node<String> nodeB = linkedBinaryTree.addLeft(root, "B");
        LinkedBinaryTree.Node<String> nodeC = linkedBinaryTree.addRight(root, "C");
        LinkedBinaryTree.Node<String> nodeD = linkedBinaryTree.addLeft(nodeB, "D");
        LinkedBinaryTree.Node<String> nodeE = linkedBinaryTree.addRight(nodeB, "E");
        LinkedBinaryTree.Node<String> nodeF = linkedBinaryTree.addLeft(nodeC, "F");
        LinkedBinaryTree.Node<String> nodeG = linkedBinaryTree.addRight(nodeC, "G");
    }

    private void printTree(ArrayBinaryTree<String, Integer> tree, int index, int level) {
        if (index < tree.size()) {

            printTree(tree, 2 * index + 2, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }

            System.out.println(tree.get(index));

            printTree(tree, 2 * index + 1, level + 1);
        }
    }

    private void printLinkedTree(LinkedBinaryTree.Node<String> node, int level) {
        if (node == null) {
            return;
        }


        printLinkedTree(node.getRight(), level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.println(node.getElement());

        printLinkedTree(node.getLeft(), level + 1);
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createArrayBinaryTree();
        binaryTree.createLinkedBinaryTree();

        System.out.println("ArrayBinaryTree:");
        binaryTree.printTree(binaryTree.arrayBinaryTree, 0, 0);

        System.out.println("LinkedBinaryTree:");
        binaryTree.printLinkedTree(binaryTree.linkedBinaryTree.getRoot(), 0);
    }
}
