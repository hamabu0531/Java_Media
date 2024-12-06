import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class PlayerPanel extends JPanel {
    int x, y, width, height;
    Image image;

    public PlayerPanel() {
        x = 1; y = 0;  // 初期位置
        width = 100; height = 100;
        try {
            image = ImageIO.read(new File("URL"));  // プレイヤーの画像を読み込む（URLを実際の画像パスに置き換え）
        } catch (IOException e) {
            e.printStackTrace();
        }
        setOpaque(false);  // 背景を透明に設定
    }

    @Override
    public void paintComponent(Graphics g) {
        int offsetX = 50, offsetY = 400;
        super.paintComponent(g);  // 背景をクリア
        if (image != null) {
            g.drawImage(image, x * 200 + offsetX, y * 100 + offsetY, width, height, null);
        } else {
            g.setColor(Color.CYAN);
            g.fillOval(x * 200 + offsetX, y * 100 + offsetY, width, height);
        }
    }

    public void moveImage(int dx, int dy) {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;  // x座標が0未満にならないように制限
        }
        if (x > 2) {
            x = 2;  // x座標が2を超えないように制限
        }
        repaint();  // 再描画
    }
}
