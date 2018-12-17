package com.company;

import javax.swing.*;

public class ContentJFrame extends JFrame {
    private JComplex complex1, complex2;
    public ContentJFrame() {
        super("复数表达式计算");
        var container = this.getContentPane();
        this.setBounds(300, 300, 300, 300);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new ContentJFrame();
    }

}
