package com.noveogroup.main;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.model.TreeElem;
import com.noveogroup.model.TreeElem;
import com.noveogroup.model.TreeElement;
import com.noveogroup.tree.BinaryTree;
import com.noveogroup.tree.BinaryTreeImpl;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //create BinaryTree
        BinaryTree<Integer, TreeElem> tree = new BinaryTreeImpl<Integer, TreeElem>();
        try {
            //add element
            tree.addElement(10, new TreeElem(1));
            tree.addElement(11, new TreeElem(2));
            show(tree);
            //remove element
            tree.removeElement(10);
            show(tree);
        } catch (BinaryTreeException e) {
            System.out.println(e);
        }
    }

    private static void show(BinaryTree tree) {
        //get iterator
        Iterator<TreeElem> iterator = tree.getIterator();
        while (iterator.hasNext()) {
            TreeElement next = iterator.next();
            System.out.println(next.getId());
        }
    }
}
