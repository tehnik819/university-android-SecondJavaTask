package com.noveogroup.tree;

import com.noveogroup.exception.AlreadyExistException;
import com.noveogroup.exception.NonExistentElementExeption;

import java.util.Iterator;

public interface BinaryTree <K,V> {
    void addElement(K key, V element) throws AlreadyExistException;
    void removeElement(K key) throws NonExistentElementExeption;
    Iterator<V> getIterator();
}
