package com.alex.datastructure;

import java.util.Arrays;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    @SafeVarargs
    public LinkedList(T...data) {
        Arrays.stream(data).forEach(this::add);
    }

    public LinkedList(Node<T> head) {
        this.head = head;

        do {
            this.tail = head;
            head = head.getNext();
        } while (head != null && head != this.head);
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public boolean remove(T data) {
        if (head == null) {
            return false;
        }

        if (head.getData().equals(data)) {
            if (head.getNext() == null) {
                //there is just one element in the list
                head = null;
                tail = null;
            } else {
                //move head one element further
                head = head.getNext();
            }

            return true;
        }

        Node<T> prev = head;
        while (prev != null) {
            if (prev != tail && prev.getNext().getData().equals(data)) {
                break;
            }

            prev = prev.getNext();
        }

        if (prev != null) {
            //node to remove is tail - just update tail reference
            if (prev.getNext() == tail) {
                tail = prev;
                tail.setNext(null);
            } else {
                prev.setNext(prev.getNext().getNext());
            }

            return true;
        }

        return false;
    }

    public boolean contains(T data) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.getData().equals(data)) {
                return true;
            }
            curr = curr.getNext();
        }

        return false;
    }

    public Node<T> getNode(T data) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.getData().equals(data)) {
                return curr;
            }
            curr = curr.getNext();
        }

        return null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getSize() {
        int size = 0;
        Node<T> curr = head;
        while (curr != null) {
            size++;
            curr = curr.getNext();
        }
        return size;
    }

    public void print() {
        if (head == null) {
            System.out.println(">> empty list");
        } else if (head == tail) {
            System.out.println(">> " + head.getData());
        } else {
            Node<T> current = head;
            System.out.print(">> ");
            while (current != null) {
                System.out.print(current.getData());
                if (current != tail) {
                    System.out.print(" -> ");
                }
                current = current.getNext();
            }
            System.out.println();
        }
    }

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
