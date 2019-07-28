package com.company;

import java.lang.annotation.Target;

/**
 * TreeNode 堆排序
 *
 * @author apple
 * @date 2019-07-22
 */
public class TreeNode {
    public int data;
    private TreeNode leftNode;
    private TreeNode rightNode;
    // 注意：在堆排序的时候，需要对父节点进行交换
    private TreeNode parentNode;

    public TreeNode(int data) {
        this.data = data;
    }
    public TreeNode(TreeNode node) {
        if (node == null) {
            return;
        }
        this.data = node.data;
        this.leftNode = node.leftNode;
        this.rightNode = node.rightNode;
        this.parentNode = node.parentNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("该结点的值为:").append(data).append("地址是：").append(super.toString()).toString();
    }

    public static int[] sort(int[] arr) {
        var result = new int[arr.length];
        var queue = new TreeNode[arr.length];
        var indexArr = 0;
        var treeNode = new TreeNode(arr[indexArr]);
        indexArr++;
        // 新建队列的下标，当没个树节点当中的都有左右结点时，该下标 +1
        var indexQueue = 0;
        queue[indexQueue] = treeNode;
        for (var i = 1; i < arr.length; i++) {
            // 1. 建立两结点之间的联系
            var node = new TreeNode(arr[i]);
            node.parentNode = queue[indexQueue];
            if (node.parentNode.leftNode == null) {
                node.parentNode.leftNode = node;
            } else {
                node.parentNode.rightNode = node;
                indexQueue++;
            }
            queue[i] = node;
            match(node);
        }
        for (TreeNode node : queue) {
            System.out.println(node);
        }
        return result;
    }
    public static void match(TreeNode node) {
        while (node.data > node.parentNode.data) {

        }
    }
    public static void main(String[] args) {
        var values = new int[]{2, 4, 3, 14, 1};
        values = sort(values);
    }
}

class ExchangeClass<T extends TreeNode> {
    // 父节点
    private T a;
    // 子节点
    private T b;
    ExchangeClass(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public void swap() {
        var temp = a;
        a = b;
        b = temp;
        String a = "fd";
    }
    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }
}

class Value {
    public int a;
    public int b;
    Value(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void swap() {
        var temp = a;
        a = b;
        b = temp;
    }
}