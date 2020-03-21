package com.company;

/**
 * LinkedNode class
 *
 * @author apple
 * @date 2019-07-22
 */
public class LinkedNode {

    private LinkedNode next = null;
    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public LinkedNode getNext() {
        return next;
    }

    public static void main(String[] args) {
        var value = new int[]{2, 3, 324,32, 321};
        var linkedNode = new LinkedNode();
        // 注意：在链表当中添加元素一定要有一个标记结点。否则之前的结点会被自动回收。
        var flag = linkedNode;
        for (var i = 0; i < value.length; i++) {
            flag.setValue(value[i]);
            flag.setNext(new LinkedNode());
            flag = flag.getNext();
        }
    }
}
