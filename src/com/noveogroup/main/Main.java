package com.noveogroup.main;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.model.TreeElem;
import com.noveogroup.model.TreeElement;
import com.noveogroup.tree.BinaryTree;
import com.noveogroup.tree.BinaryTreeImpl;

import java.io.*;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer, TreeElem> tree = new BinaryTreeImpl<Integer, TreeElem>();
        try {
            //add elements
            tree.addElement(10, new TreeElem(1));
            tree.addElement(11, new TreeElem(2));
            for(int i = 0;i < 10;i++) {
                tree.addElement(i, new TreeElem(i % 5));
            }
            System.out.println("Tree before remove elements");
            show(tree);
            //remove elements
            for(int i = 3;i < 7;i++)
                tree.removeElement(i);
            System.out.println("Tree after remove elements");
            show(tree);
        } catch (BinaryTreeException e) {
            System.out.println(e);
        }

        //Serialize tree
        try {
            FileOutputStream fos = new FileOutputStream("tree.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tree);
            oos.flush();
            oos.close();
            System.out.println("Serialize tree complete");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Deserialize tree from tree.out
        System.out.println("Deserialize tree looks:");
        try {
            FileInputStream fis = new FileInputStream("tree.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
            BinaryTree<Integer, TreeElem> dTree = (BinaryTree) ois.readObject();
            show(dTree);
        } catch (ClassNotFoundException |IOException e) {
            e.printStackTrace();
        }

    }

    private static void show(BinaryTree tree) {
        //get iterator
        Iterator<TreeElem> iterator = tree.getIterator();
        while (iterator.hasNext()) {
            TreeElement next = iterator.next();
            System.out.print(next.getId() + " ");
        }
        System.out.println();
    }
}
