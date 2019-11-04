package com.company;

import javax.swing.*;

public class JComplex extends JPanel {
    private JTextField textField1, textField2;
    private JLabel label1, label2;

    public JComplex() {
        this.setBounds(200, 200, 300, 300);
        this.setData();
    }

    private void setData() {
        this.textField1 = new JTextField(5);
        this.label1 = new JLabel("+");
        this.textField2 = new JTextField(5);
        this.label2 = new JLabel("i", SwingConstants.LEFT);
        this.add(textField1);
        this.add(label1);
        this.add(textField2);
        this.add(label2);
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }
}
