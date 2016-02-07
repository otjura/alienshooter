package alienshooter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Random;

public class Board extends JPanel implements ActionListener {
    protected Timer timer;
    private Craft craft;
    private Player player;
    private ArrayList<Alien> aliens;
    private boolean ingame;
    protected boolean paused;
    private final int INITIAL_PLAYER_POS_X = 400;
    private final int INITIAL_PLAYER_POS_Y = 550;
    private final int BOARDWIDTH = 800;
    private final int BOARDHEIGHT = 600;
    private final int DELAY = 15;
    //private Image background = Toolkit.getDefaultToolkit()
    //            .createImage("images/space.png");
            
    
    /*private int[][] alienpositions = {
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
    };*/

    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        initAliens();
        setPreferredSize(new Dimension(BOARDWIDTH, BOARDHEIGHT));
        craft = new Craft(INITIAL_PLAYER_POS_X, INITIAL_PLAYER_POS_Y);
        ingame = true;
        player = new Player();
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    /*@Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }*/

    public void initAliens() {
        Random rnd = new Random();
        aliens = new ArrayList<>();
        for(int i=0; i < 30; i++) {
            aliens.add(new Alien(rnd.nextInt(750)+10, 5));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (ingame) {
            drawObjects(g);
        } else {
            drawGameOver(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {
        
        ArrayList<Missile> ms = craft.getMissiles();

        if (craft.isVisible()) {
            g.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        }

        for (Missile m : ms) {
            if (m.isVisible()) {
                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
        }

        for (Alien a : aliens) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
        g.drawString("Aliens left: " + aliens.size(), 5, 15);
        g.drawString("Hitpoints left: " + craft.getHitpoints(), 5, 35);
        g.drawString("Player score: " + player.getScore(), 5, 55);
    }

    private void drawGameOver(Graphics g) {
        String msg = "GAME OVER";
        Font small = new Font("Helvetica", Font.BOLD, 26);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(msg, (BOARDWIDTH - fm.stringWidth(msg)) / 2,
                BOARDHEIGHT / 2);
    }
    
    protected void drawPauseScreen(Graphics g) {
        String msg = "PAUSED";
        Font small = new Font("Helvetica", Font.BOLD, 26);
        FontMetrics fm = getFontMetrics(small);
        g.setColor(Color.YELLOW);
        g.setFont(small);
        g.drawString(msg, (BOARDWIDTH - fm.stringWidth(msg)) / 2,
                BOARDHEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inGame();
        updateCraft();
        updateMissiles();
        updateAliens();
        checkCollisions();
        repaint();
    }

    private void inGame() {      
        if (!ingame) {
            timer.stop();
        }
    }

    private void updateCraft() {
        if (craft.isVisible()) {
            craft.move();
        }
    }

    private void updateMissiles() {
        ArrayList<Missile> ms = craft.getMissiles();
        for (int i = 0; i < ms.size(); i++) {
            Missile m = ms.get(i);
            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }

    private void updateAliens() {
        if (aliens.isEmpty()) {
            ingame = false;
            return;
        }

        for (int i = 0; i < aliens.size(); i++) {
            Alien a = aliens.get(i);
            if (a.isVisible()) {
                a.move();
            } else {
                aliens.remove(i);
            }
        }
    }

    public void checkCollisions() {
        Rectangle craftbound = craft.getBounds();
        ArrayList<Missile> ms = craft.getMissiles();
        
        for (Alien alien : aliens) {
            Rectangle alienbound = alien.getBounds();
            if (craftbound.intersects(alienbound)) {
                alien.setVisible(false);
                craft.hitpoints -= 20;
                if (craft.hitpoints <= 0) {
                    craft.setVisible(false);
                    setBackground(Color.RED);
                    ingame = false;
                }
            }
        }

        for (Missile m : ms) {
            Rectangle r1 = m.getBounds();
            for (Alien alien : aliens) {
                Rectangle r2 = alien.getBounds();
                if (r1.intersects(r2)) {
                    m.setVisible(false);
                    alien.setVisible(false);
                    player.increaseScore(10);
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }
}
