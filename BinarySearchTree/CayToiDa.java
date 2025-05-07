package BST;

public class CayToiDa {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }



    public Node constructMaximumBinaryTree(int[] nums) {
            return construct(nums, 0, nums.length);
        }

        private Node construct(int[] nums, int left, int right) {
            if (left == right) {
                return null;
            }

            // Tìm giá trị lớn nhất và chỉ số của nó
            int maxIndex = maxIndex(nums, left, right);
            Node root = new Node(nums[maxIndex]);

            // Đệ quy xây dựng cây con bên trái và bên phải
            root.left = construct(nums, left, maxIndex);
            root.right = construct(nums, maxIndex + 1, right);

            return root;
        }

        private int maxIndex(int[] nums, int left, int right) {
            int maxIndex = left;
            for (int i = left; i < right; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

        // Phương thức in cây nhị phân
        public void printTree(Node node) {
            if (node == null) {
                return;
            }
            System.out.print(node.data + " ");
            printTree(node.left);
            printTree(node.right);
        }

        public static void main(String[] args) {
            CayToiDa tree = new CayToiDa();
            int[] nums = {3, 2, 1, 6, 0, 5};
            Node root = tree.constructMaximumBinaryTree(nums);
            tree.printTree(root);
        }
}
