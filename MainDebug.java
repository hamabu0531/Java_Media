import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


class MainFrame extends JFrame implements KeyListener{
    // グローバル変数
    PlayerPanel p;

    public MainFrame(){
        // Frameの設定
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Title");
        this.setSize(600, 600);

        // Playerの描画
        p = new PlayerPanel();
        this.add(p);

        // Listener関連
        this.addKeyListener(this);

        // デフォルトでwindow自体をfocusする
        this.setFocusable(true);
        this.requestFocusInWindow();

        // 描画
        this.setVisible(true);
    }

    

    // キー入力関連
    public void keyPressed(KeyEvent e){
        if(e.getKeyChar()=='d'){
            p.moveImage(1, 0);
        }else if(e.getKeyChar()=='a'){
            p.moveImage(-1, 0);
        }
    }
    public void keyReleased(KeyEvent e){

    }
    public void keyTyped(KeyEvent e){

    }

    

    public static void main(String[] args) {
        new MainFrame();
    }
}
