package com.noveogroup.tree;

import com.noveogroup.exception.AlreadyExistException;
import com.noveogroup.exception.NonExistentElementExeption;

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
        add(root, key, element);
    }

    private void add(Node<K,V> node,K key,V value) throws AlreadyExistException {
        if(node == null) {
            node = new Node<K, V>(key,value);
        }
        int comp = key.compareTo(node.key);
        if(comp == 0)
            throw new AlreadyExistException();
        if(comp < 0)
            add(node.left,key,value);
        if(comp > 0)
            add(node.right,key,value);
    }

    @Override
    public void removeElement(K key) throws NonExistentElementExeption {
        if(root != null)
            root = remove(root,key);
        else throw new NonExistentElementExeption();
    }

    private Node<K, V> remove(Node<K, V> node, K key) throws NonExistentElementExeption {
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
                throw new NonExistentElementExeption();
            }
            else {
                node.left = remove(node.left, key);
            }
            return node;
        }
        else {
            if (node.right == null) {
                throw new NonExistentElementExeption();
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
