package com.company;

import java.util.Objects;

/**
 * TreeBigRoot class
 *
 * @author apple
 * @date 2019-07-23
 */
public class TreeBigRoot<T extends Comparable<T>> {
    private Node<T> root = null;

    class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T value) {
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
        }

        public boolean contains(T value) {
            var searchNode = this;
            if (Objects.equals(this.value, value)) {
                return true;
            } else {
                if (this.value.compareTo(value) > 0) {
                    if (Objects.nonNull(this.rightNode)) {
                        searchNode = this.rightNode;
                        searchNode.contains(value);
                    } else {
                        return false;
                    }
                } else if (this.value.compareTo(value) < 0) {
                    if (Objects.nonNull(this.leftNode)) {
                        searchNode = this.leftNode;
                        searchNode.contains(value);
                    } else {
                        return false;
                    }
                }
            }
            return false;
        }

        public void add(T value) {
        }
    }

    public void add(T value) {
        Objects.requireNonNull(value);
        if (root == null) {
            root = new Node<>(value);
        } else {
            if (value.compareTo(root.value) > 0) {

            } else if (value.compareTo(root.value) < 0) {

            }
        }
    }

    public boolean contains(T value) {
        if (Objects.nonNull(root)) {
            return root.contains(value);
        } else {
            return false;
        }
    }

    public boolean deleteValue(T value) {
        return false;
    }

    public void initTree(T value) {
        root = new Node<>(value);
    }

    public static void main(String[] args) {

    }
}
