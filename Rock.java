import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


class Rock extends JPanel implements ActionListener {
    int r, x, y;
    Image rockImage;
    Timer timer;
    MainFrame mainFrame;

    public Rock(MainFrame main) {
        mainFrame = main;
        r = 100;  // 岩のサイズ
        x = 50;   // 初期位置
        y = 50;   // 初期位置
        try {
            rockImage = ImageIO.read(new File("./rock.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setOpaque(false);  // 背景を透明に設定(重ねて表示するために必須)
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // 背景をクリア
        g.drawImage(rockImage, x, y, r, r, null);  // 新しい位置に岩を描画
    }

    public void moveImage(int speed) {
        y += speed;  // 岩を下に動かす
        if (y > 600) {  // 画面外に出たら位置をリセット
            mainFrame.remove(this);
            timer.stop();
        }
        repaint();  // 再描画
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveImage(1);  // 定期的に岩を移動させる
    }
}
