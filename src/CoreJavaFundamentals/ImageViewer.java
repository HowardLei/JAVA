package CoreJavaFundamentals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ImageViewer {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImageViewerFrame extends JFrame {

    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WiDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame() {
        setSize(DEFAULT_WiDTH, DEFAULT_HEIGHT);
        // 创建一个 label
        label = new JLabel();
        add(label);
        // 创建一个 fileChooser
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        // 创建一个 menuBar
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        // 创建菜单
        var menu = new JMenu("menu");
        menuBar.add(menu);
        // 向 menu 当中添加项目
        var openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener((ActionEvent event) -> {
            var result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                var name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });
        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
            System.out.println();
        });
    }

}