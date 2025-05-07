package Hw7_22000070_NguyenThiAnh.BaiTap2;
import java.util.Stack;

import Hw7_22000070_NguyenThiAnh.BaiTap1.LinkedBinaryTree;

public class ExpressionTree<E> extends LinkedBinaryTree {
    public void preorderPrint ( Node <E > p){
        if(p!=null) {
            System.out.println(p.getElement());
            preorderPrint(p.getLeft());
            preorderPrint(p.getRight());
        }
    }
    public void postorderPrint ( Node <E > p ) {
        if(p!=null) {
            postorderPrint(p.getLeft());
            postorderPrint(p.getRight());
            System.out.println(p.getElement());
        }

    }

    public void inorderPrint ( Node <E > p ) {
        if(p!=null) {
            inorderPrint(p.getLeft());
            System.out.println(p.getElement());
            inorderPrint(p.getRight());
        }

    }

}
