import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

class MainFrame extends JFrame implements KeyListener {
    // グローバル変数
    PlayerPanel p;
    Rock r1;

    public MainFrame() {
        // Frameの設定
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Title");
        this.setSize(600, 600);
        this.setLayout(null);

        // Playerの描画
        p = new PlayerPanel();
        p.setBounds(0, 0, 600, 600);  // Playerの位置とサイズを設定
        this.add(p);

        // Rockの描画
        r1 = new Rock();
        r1.setBounds(50, 50, 100, 100);  // 岩の位置とサイズを設定
        this.add(r1);

        // Listener関連
        this.addKeyListener(this);

        // デフォルトでwindow自体をfocusする
        this.setFocusable(true);
        this.requestFocusInWindow();

        // 描画
        this.setVisible(true);
    }

    // キー入力関連
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'd') {
            p.moveImage(1, 0);
        } else if (e.getKeyChar() == 'a') {
            p.moveImage(-1, 0);
        }
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new MainFrame();
    }
}

class Rock extends JPanel {
    int r, x, y;
    Image rockImage;

    public Rock() {
        r = 100;
        x = 10;  // 初期位置
        y = 10;  // 初期位置
        try {
            rockImage = ImageIO.read(new File("./rock.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setOpaque(false);  // 背景を透明に設定
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // 背景を描画しないように
        g.drawImage(rockImage, x, y, r, r, null);  // 岩を描画
    }

    public void moveImage(int speed) {
        y += speed;  // y方向にspeed分動かす
        repaint();   // 描画を更新
    }
}
