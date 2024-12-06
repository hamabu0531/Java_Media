import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class GameManager {
    private PlayerPanel player;
    private Image rock;
    private Image banana;

    public GameManager(PlayerPanel player) {
        this.player = player;
    }

    public boolean isCollisionWithRock() {
        int playerX = player.getX();
        int playerY = player.getY();
        int rockX = rock.getX();
        int rockY = rock.getY();
        if (playerX == rockX && playerY == rockY) return true;
        else return false;
    }

    public boolean isCollisionWithBanana() {
        int playerX = player.getX();
        int playerY = player.getY();
        int bananaX = banana.getX();
        int bananaY = banana.getY();
        if (playerX == bananaX && playerY == bananaY) return true;
        else return false;
    }
}
