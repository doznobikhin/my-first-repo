package com.sbt.jscool.lesson04;

import java.util.*;

/**
 * Необходимо написать свой LinkedList
 * Методы:
 * add(E e)
 * add(int index, E element)
 * E get(int index)
 * E remove(int index)
 * Iterator<E> iterator()
 * <p>
 * с использованием wildcards:
 * boolean addAll(Collection c)
 * boolean copy(Collection c)
 *
 * @param <E> the type of elements held in this collection
 */

public class MyLinkedList<E> implements Iterable<E> {
    private Node<E> header;
    private int size = 0;

    public MyLinkedList() {
        this.header = new Node<>(null, null, null);
        this.header.next = header;
        this.header.previous = header;
    }

    public void add(E e) {
        addBeforeNode(header, e);
    }

    private void addBeforeNode(Node<E> node, E e) {
          Node<E> prevNode = node.previous;
            Node<E> newNode = new Node<>(e, prevNode, node);
            prevNode.next = newNode;
            node.previous = newNode;
            size++;
    }

    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == size) {
            addBeforeNode(header, e);
            return;
        }

        Node<E> node = header.next;
        int count = 0;

        while (node != header) {
            if (count == index) {
                addBeforeNode(node, e);
                return;
            }
            node = node.next;
            count++;
        }
    }

    public E get(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node<E> node = header.next;
        int count = 0;

        while (node != header) {
            if (count == index) {
                return node.value;
            }
            node = node.next;
            count++;
        }
        return null;
    }

    public E remove(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node<E> node = header.next;
        int count = 0;

        while (node != header) {
            if (count == index) {
                Node<E> nodePrev = node.previous;
                Node<E> nodeNext = node.next;
                nodePrev.next = nodeNext;
                nodeNext.previous = nodePrev;
                size--;
                return node.value;
            }
            node = node.next;
            count++;
        }
        return null;
    }

    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (E obj : c) {
            add(obj);
            size++;
        }
        return true;
    }

    public boolean copy(Collection<? super E> c) {
        if (c == null) {
            return false;
        }
        Node<E> node = header.next;

        while (node != header) {
            E value = node.value;
            c.add(value);
            node = node.next;
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        Node<E> node = header;

        /*public MyIterator() {
            this.node = (Node<E>) header;
        }*/

        @Override
        public boolean hasNext() {
            return node.next != header;
        }

        @Override
        public E next() {
            node = node.next;
            return node.value;
        }
    }

    private static class Node<E> {
        private E value;
        private Node<E> previous;
        private Node<E> next;

        public Node(E value, Node<E> previous, Node<E> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
}