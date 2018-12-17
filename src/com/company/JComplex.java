package com.company;

import javax.swing.*;
import java.awt.*;

public class JComplex extends JFrame {
    private JTextField textField1, textField2;
    private JLabel label1, label2;
    private Complex complex1, complex2;

    public JComplex() {
        super("复数表达式计算");
        this.setBounds(200, 200, 300, 300);
        Container container = this.getContentPane();
        this.setData();
        this.setFrame();
        JComponent[] arr = {this.textField1, this.textField2, this.label1, this.label2};
        for (JComponent component : arr) {
            container.add(component);
            component.setVisible(true);
        }
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void setFrame() {
        int margin = 10;
        int textField1X = 50;
        int textField1Y = margin;
        int textField1H = 20;
        int textField1W = 50;
        Rectangle text1Frame = new Rectangle(textField1X, textField1Y, textField1W, textField1H);
        this.textField1.setBounds(text1Frame);

        int label1W = 10;
        int label1H = textField1H;
        int label1X = (int) text1Frame.getMaxX() + margin;
        int label1Y = textField1Y;
        Rectangle label1Frame = new Rectangle(label1X, label1Y, label1W, label1H);
        this.label1.setBounds(label1Frame);

        int textField2W = textField1W;
        int textField2H = textField1H;
        int textField2X = (int) label1Frame.getMaxX() + margin;
        int textField2Y = textField1Y;
        var textField2Frame = new Rectangle(textField2X, textField2Y, textField2W, textField2H);
        this.textField2.setBounds(textField2Frame);

        int label2W = label1W;
        int label2H = label1H;
        int label2X = (int) textField2Frame.getMaxX() + margin;
        int label2Y = textField2Y;
        this.label2.setBounds(label2X, label2Y, label2W, label2H);
    }

    private void setData() {
        this.textField1 = new JTextField();
        this.textField2 = new JTextField();
        this.label1 = new JLabel("+");
        this.label2 = new JLabel("i", SwingConstants.CENTER);
    }

    public static void main(String[] args) {
        new JComplex();
    }
}