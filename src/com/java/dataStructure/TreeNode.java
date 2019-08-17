package com.java.dataStructure;

/**
 * TreeNode class
 * 二叉树结点
 *
 * @author apple
 * @date 2019-08-09
 */
public class TreeNode<T extends Number> {
    // 左子树
    public TreeNode<T> leftNode;
    // 右子树
    public TreeNode<T> rightNode;
    // 存储的数据
    public T data;

    @Override
    public String toString() {
        return "TreeNode{data=" + data + ", leftNode=" + leftNode + ", rightNode=" + rightNode + '}';
    }

    public void add(T data) {
        if (this.data == null || this.data.equals(data)) {
            this.data = data;
        } else if (data.intValue() > this.data.intValue()){
            if (rightNode == null) {
                rightNode = new TreeNode<>();
            }
            rightNode.add(data);
        } else {
            if (leftNode == null) {
                leftNode = new TreeNode<>();
            }
            leftNode.add(data);
        }
    }
    public void add(TreeNode<T> node) {

    }
    public void update(T data) {
        delete(data);
        add(data);
    }
    public void delete(T data) {
        var deleteNode = search(data);
        var parentNode = searchParent(data);
        if (deleteNode == null) {
            System.out.println("要删除的数据不在本二叉树当中");
        } else {
            if (deleteNode.leftNode == null && deleteNode.rightNode == null) {
                if (parentNode == null) {
                    deleteNode.data = null;
                } else {
                    if (parentNode.leftNode != null && parentNode.leftNode.data.equals(data)) {
                        parentNode.leftNode = null;
                    } else {
                        parentNode.rightNode = null;
                    }
                }
            } else {
                if (parentNode == null) {
                }
            }
        }
    }
    private TreeNode<T> searchParent(T data) {
        if (this.leftNode.data.equals(data) || this.rightNode.data.equals(data)) {
            return this;
        } else if (this.data.intValue() > data.intValue()) {
            if (leftNode == null) {
                return null;
            }
            return leftNode.searchParent(data);
        } else {
            if (rightNode == null) {
                return null;
            }
            return rightNode.searchParent(data);
        }
    }
    public TreeNode<T> search(T data) {
        if (this.data.equals(data)) {
            return this;
        } else if (this.data.intValue() > data.intValue()) {
            if (leftNode == null) {
                return null;
            }
            return leftNode.search(data);
        } else {
            if (rightNode == null) {
                return null;
            }
            return rightNode.search(data);
        }
    }
    public static void main(String[] args) {
        var node = new TreeNode<Integer>();
        node.add(4);
        node.add(45);
        node.add(-14);
        node.add(24);
        node.add(-4);
        System.out.println(node);
    }
}
