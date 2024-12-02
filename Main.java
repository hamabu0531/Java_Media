import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

class MainFrame extends JFrame{
    public MainFrame(){
        // Frameの設定
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Title");
        this.setSize(600, 600);

        // デフォルトでwindow自体をfocusする
        this.setFocusable(true);
        this.requestFocusInWindow();

        // 描画
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}