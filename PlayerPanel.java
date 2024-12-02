import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class PlayerPanel extends JPanel{
    // メンバ変数
    int x, y, width, height; // x=0, 1, 2で位置決定
    Image image;

    // メンバ関数
    public PlayerPanel(){
        x = 1; y = 0;
        width = 100; height = 100;
        try{
            image = ImageIO.read(new File("URL"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g){
        int offsetX = 50, offsetY = 400;
        super.paintComponent(g);
        if(image!=null){
            g.drawImage(image, x*200+offsetX, y*100+offsetY, getFocusCycleRootAncestor());
        }else{
            g.setColor(Color.CYAN);
            g.fillOval(x*200+offsetX, y*100+offsetY, width, height);
        }
    }

    public void moveImage(int dx, int dy){
        x += dx;
        y += dy;
        if(x<0){
            x=0;
        }
        if(x>2){
            x=2;
        }
        repaint();
    }
}