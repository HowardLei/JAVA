package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JComplex extends JComponent implements Action {

    private JTextField textField1, textField2;
    private JLabel label1, label2;
    private Complex complex1, complex2;

    public JComplex() {
        this.setFrame();
        this.setData();
    }

    private void setFrame() {
        int margin = 10;
        int textField1X = 0;
        int textField1Y = 0;
        int textField1H = 50;
        int textField1W = 100;
        this.textField1.setBounds(textField1X, textField1Y, textField1W, textField1H);

        int label1W = 30;
        int label1H = textField1H;
        int label1X = textField1W + margin;
        int label1Y = textField1Y;
        this.label1.setBounds(label1X, label1Y, label1W, label1H);

        int textField2W = textField1W;
        int textField2H = textField1H;
        int textField2X = label1X + margin;
        int textField2Y = textField1Y;
        this.textField2.setBounds(textField2X, textField2Y, textField2W, textField2H);

        int label2W = label1W;
        int label2H = label1H;
        int label2X = textField2X + margin;
        int label2Y = textField2Y;
        this.label2.setBounds(label2X, label2Y, label2W, label2H);
    }

    private void setData() {
        canSee(textField1);
        canSee(textField2);
        canSee(label1);
        canSee(label2);
    }

    private static void canSee(JComponent component) {
        component.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}