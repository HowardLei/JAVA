package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class ContentJFrame extends JFrame implements ActionListener {

    private JComplex complex1, complex2, complex3, complex4;
    private JComboBox<String> box1, box2;
    private JButton button;
    private static String choices[] = {"+", "-", "*", "/"};

    private ContentJFrame() {
        super("复数表达式计算");
        var container = this.getContentPane();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBounds(100, 100, 280, 300);
        this.box1 = new JComboBox<>(choices);
        container.add(box1);
        this.box2 = new JComboBox<>(choices);
        container.add(box2);
        this.setComplexData(container);
        this.button = new JButton("=");
        container.add(this.button);
        this.button.addActionListener(this);
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
        this.setComboBoxData(this.box1);

        this.complex3 = new JComplex();
        this.complex3.setVisible(true);
        container.add(complex3);

        container.add(this.box2);
        this.setComboBoxData(this.box2);

        this.complex4 = new JComplex();
        this.complex4.setVisible(true);
        container.add(complex4);
    }

    private void setComboBoxData(JComboBox<String> box) {
        this.getContentPane().add(box);
        box.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 当点击按钮的时候，执行下边的方法
        if (e.getSource().equals(this.button)) {
            // 1、先获得转化数据
            final var num1 = new Complex(Double.parseDouble(this.complex1.getTextField1().getText()), Double.parseDouble(this.complex1.getTextField2().getText()));
            final var num2 = new Complex(Double.parseDouble(this.complex2.getTextField1().getText()), Double.parseDouble(this.complex2.getTextField2().getText()));
            final var num3 = new Complex(Double.parseDouble(this.complex3.getTextField1().getText()), Double.parseDouble(this.complex3.getTextField2().getText()));
            var numberFormat = new DecimalFormat("0.000");
            // 2、根据选项的按钮进行计算
            var res = this.calculate(num1, num2, num3);
            // 3、将答案返回回来
            this.complex4.getTextField1().setText("" + numberFormat.format(res.getRealNumber()));
            this.complex4.getTextField2().setText("" + numberFormat.format(res.getImaginaryNumber()));
        }
    }

    private Complex calculate(Complex complex1, Complex complex2, Complex complex3) throws NumberFormatException {
        Complex num1;
        switch (this.box1.getSelectedIndex()) {
            case 0:
                num1 = complex1.add(complex2);
                num1 = getSelectedOptions(num1, complex3);
                break;
            case 1:
                num1 = complex1.delete(complex2);
                num1 = getSelectedOptions(num1, complex3);
                break;
            case 2:
                num1 = complex1.multiple(complex2);
                num1 = getSelectedOptions(num1, complex3);
                break;
            case 3:
                num1 = complex1.divide(complex2);
                num1 = getSelectedOptions(num1, complex3);
                break;
            default:
                throw new NumberFormatException("输入格式异常");
        }
        return num1;
    }

    private Complex getSelectedOptions(Complex num1, Complex complex3) throws NumberFormatException {
        switch (this.box2.getSelectedIndex()) {
            case 0:
                return num1.add(complex3);
            case 1:
                return num1.delete(complex3);
            case 2:
                return num1.multiple(complex3);
            case 3:
                return num1.divide(complex3);
            default:
                throw new NumberFormatException("输入数据异常");
        }
    }

    public static void main(String[] args) {
        new ContentJFrame();
    }

}
