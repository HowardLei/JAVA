package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContentJFrame extends JFrame implements ActionListener {
    private JComplex complex1, complex2, complex3, complex4;
    private JComboBox<String> box1, box2;
    private JButton button;

    public ContentJFrame() {
        super("复数表达式计算");
        Container container = this.getContentPane();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBounds(100, 100, 300, 300);
        this.box1 = new JComboBox<String>();
        container.add(box1);
        this.box2 = new JComboBox<String>();
        container.add(box2);
        this.setComplexData(container);
        this.button = new JButton("=");
        container.add(this.button);
        this.button.addActionListener(this);
    }

    private void setFrame() {
        int margin = 10;
        this.complex1.setBounds(30, 0, 250, margin);
        this.complex2.setBounds(30, margin , 250, margin);
        this.complex3.setBounds(30, margin * 3, 250, margin);
        this.complex4.setBounds(30, margin * 5, 250, margin);
    }
    /**
     * 设置复数框中的数据
     * @param container 需要存储数据的容器
     * */
    private void setComplexData(Container container) {
        this.complex1 = new JComplex();
        this.complex1.setVisible(true);
        container.add(complex1);

        this.complex2 = new JComplex();
        this.complex2.setVisible(true);
        container.add(complex2);

        container.add(this.box1);
        this.setButtonData(box1);

        this.complex3 = new JComplex();
        this.complex3.setVisible(true);
        container.add(complex3);

        container.add(this.box2);
        this.setButtonData(box2);

        this.complex4 = new JComplex();
        this.complex4.setVisible(true);
        container.add(complex4);
    }

    private void setButtonData(JComboBox<String> box) {
        String[] arr = {"+", "-", "*", "/"};
        for (String s : arr) {
            box.addItem(s);
        }
        this.getContentPane().add(box);
        box.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.button)) {
            // 1、先获得转化数据
            var num1 = new Complex(Integer.parseInt(this.complex1.getTextField1().getText()), Integer.parseInt(this.complex1.getTextField2().getText()));
            var num2 = new Complex(Integer.parseInt(this.complex2.getTextField1().getText()), Integer.parseInt(this.complex2.getTextField2().getText()));
            var num3 = new Complex(Integer.parseInt(this.complex3.getTextField1().getText()), Integer.parseInt(this.complex3.getTextField2().getText()));
            // 2、根据选项的按钮进行计算
            // 3、将答案返回回来
        }
    }

    public static void main(String[] args) {
        new ContentJFrame();
    }
}
