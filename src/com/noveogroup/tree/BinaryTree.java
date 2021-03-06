package com.noveogroup.tree;

import com.noveogroup.exception.AlreadyExistException;
import com.noveogroup.exception.NonExistentElementException;

import java.io.Serializable;
import java.util.Iterator;

public interface BinaryTree <K,V> extends Serializable {
    void addElement(K key, V element) throws AlreadyExistException;
    void removeElement(K key) throws NonExistentElementException;
    Iterator<V> getIterator();
}
