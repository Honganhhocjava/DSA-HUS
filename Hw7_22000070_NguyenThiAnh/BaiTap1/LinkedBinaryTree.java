package Hw7_22000070_NguyenThiAnh.BaiTap1;
public class LinkedBinaryTree<E,T> implements BinaryTreeInterface<T> {
    protected static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    protected Node<E> root;
    protected int n = 0;

    public LinkedBinaryTree() {
        root = null;
    }

    @Override
    public T root() {
        if (root == null) {
            return null;
        }
        return (T) root.getElement();
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(T p) {
        Node<E> node = (Node<E>) p;
        int count = 0;
        if (node.getLeft() != null) {
            count++;
        }
        if (node.getRight() != null) {
            count++;
        }
        return count;
    }

    @Override
    public T parent(T p) {
        Node<E> node = (Node<E>) p;
        if (node.getParent() != null) {
            return (T) node.getParent().getElement();
        }
        return null;
    }

    @Override
    public T left(T p) {
        Node<E> node = (Node<E>) p;
        if (node.getLeft() != null) {
            return (T) node.getLeft().getElement();
        }
        return null;
    }

    @Override
    public T right(T p) {
        Node<E> node = (Node<E>) p;
        if (node.getRight() != null) {
            return (T) node.getRight().getElement();
        }
        return null;
    }

    @Override
    public T sibling(T p) {
        if (p == null) {
            return null;
        }

        Node<E> node = (Node<E>) p;

        if (node.getParent() == null) {
            return null;
        }

        if (node.getParent().getLeft() == node) {
            return node.getParent().getRight() != null ? (T) node.getParent().getRight().getElement() : null;
        }

        return node.getParent().getLeft() != null ? (T) node.getParent().getLeft().getElement() : null;
    }

    public Node<E> addRoot(E element) {
        if (root != null) {
            throw new IllegalStateException("Tree already has a root.");
        }

        root = new Node<>(element, null, null, null);
        n = 1;
        return root;
    }

    public Node<E> addLeft(Node p, E element) {
        Node<E> node = new Node<>(element, p, null, null);
        if (p.getLeft() == null) {
            p.setLeft(node);
            n++;
        }
        return node;
    }

    public Node<E> addRight(Node p, E element) {
        Node<E> node = new Node<>(element, p, null, null);
        if (p.getRight() == null) {
            p.setRight(node);
            n++;
        }
        return node;
    }

    public void set(Node p, E element) {
        if (p != null) {
            p.setElement(element);
        }
    }
    public Node<E> getRoot() { return root; }
}
