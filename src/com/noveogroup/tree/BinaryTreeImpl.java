package com.noveogroup.tree;

import com.noveogroup.exception.AlreadyExistException;
import com.noveogroup.exception.NonExistentElementException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeImpl<K extends Comparable<K>, V> implements BinaryTree<K,V> {

    private Node<K,V> root;

    public BinaryTreeImpl() {
        root = null;
    }

    @Override
    public void addElement(K key, V element) throws AlreadyExistException {
        Node<K,V> node = new Node<K, V>(key,element);
        if(root == null)
            root = node;
        else {
            Node<K,V> cur = root;
            while(true) {
                int comp = key.compareTo(cur.key);
                if(comp < 0) {
                    if(cur.left != null) {
                        cur = cur.left;
                        continue;
                    }
                    else {
                        cur.left = node;
                        break;
                    }
                }
                if(comp > 0) {
                    if(cur.right != null) {
                        cur = cur.right;
                        continue;
                    }
                    else {
                        cur.right = node;
                        break;
                    }
                }
                if(comp == 0)
                    throw new AlreadyExistException(key.toString(),element.toString());
            }
        }
    }

    @Override
    public void removeElement(K key) throws NonExistentElementException {
        if(root != null)
            root = remove(root,key);
        else throw new NonExistentElementException(key.toString());
    }

    private Node<K, V> remove(Node<K, V> node, K key) throws NonExistentElementException {
        int comp = key.compareTo(node.key);
        if (comp == 0) {
            if ((node.left == null) && (node.right == null)) {
                return null;
            }
            if ((node.left == null) || (node.right == null)) {
                if (node.left == null)
                    return node.right;
                else
                    return node.left;
            }
            else {
                if (node.right.left == null) {
                    node.right.left = node.left;
                    return node.right;
                }
                else {
                    Node<K, V> cur = node.right;
                    while (cur.left.left != null)
                        cur = cur.left;
                    node.key = cur.left.key;
                    node.value = cur.left.value;
                    cur.left = null;
                    return node;
                }
            }
        }
        else
        if (comp < 0) {
            if (node.left == null) {
                throw new NonExistentElementException(key.toString());
            }
            else {
                node.left = remove(node.left, key);
            }
            return node;
        }
        else {
            if (node.right == null) {
                throw new NonExistentElementException(key.toString());
            }
            else {
                node.right = remove(node.right, key);
            }
            return node;
        }
    }

    @Override
    public Iterator<V> getIterator() {
        List<V> list = new LinkedList<V>();
        if(root != null)
            getListOfValues(list,root);
        return list.iterator();
    }

    private void getListOfValues(List<V> list, Node<K,V> node) {
        if(node.left != null)
            getListOfValues(list,node.left);
        list.add(node.value);
        if(node.right != null)
            getListOfValues(list, node.right);
    }

    //Inner class
    private class Node<K,V> {
        K key;
        V value;
        Node<K,V> left;
        Node<K,V> right;

        Node(K key,V value) {
            this.key = key;
            this.value = value;
        }
    }
}
