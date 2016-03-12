package alienshooter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Initializes board and manages all visible actions happening on it.
 * @author Otso
 */
public class Board extends JPanel implements ActionListener {
    private final int INITIAL_PLAYER_POS_X = 400;
    private final int INITIAL_PLAYER_POS_Y = 550;
    private final int BOARDWIDTH = 800;
    private final int BOARDHEIGHT = 600;
    private final int DELAY = 15;
    private final Craft craft;
    private Player player;
    private ArrayList<Alien> aliens;
    private boolean ingame;
    private boolean paused;
    private Highscore highscore;
    private int level;
    protected Timer timer;
    
    public Board(int level) {
        this.level = level;
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        initAliens();
        setPreferredSize(new Dimension(BOARDWIDTH, BOARDHEIGHT));
        highscore = new Highscore();
        craft = new Craft(INITIAL_PLAYER_POS_X, INITIAL_PLAYER_POS_Y);
        ingame = true;
        player = new Player();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    //GETTERS & SETTERS
    
    /**
     * Returns level of board.
     * @return 1..3 
     */
    public int getLevel() { return level; }
    
    /**
     * Sets new highscore if current player score is higher than one saved in 
     * highscore.xd file.
     * @throws IOException 
     */
    public void setNewHighscore() throws IOException {
        if(player.getScore() > highscore.readHighscoreFromDisk()) {
            highscore.writeHighscoreToDisk(player.getScore());
        }
    }
    
    
    //REST OF METHODS
    
    /**
     * Initializes thirty aliens randomly with start point at top quarter.
     * 
     */
    public void initAliens() {
        //@TODO prevent aliens being in same space
        Random rnd = new Random();
        aliens = new ArrayList<>();
        if(level == 1) {
            for(int i=0; i < 30; i++) {
            aliens.add(new Deme(rnd.nextInt(775)+5, rnd.nextInt(195)+5));
            }
        } 
        if(level == 2) {
            for(int i=0; i < 30; i++) {
            aliens.add(new Goro(rnd.nextInt(750)+10, rnd.nextInt(195)+5));
            }
        }
        if(level == 3) {
            for(int i=0; i < 30; i++) {
            aliens.add(new Xeno(rnd.nextInt(750)+10, rnd.nextInt(195)+5));
            }
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

    /**
     * Handles drawing of all graphic objects on board and their visibility.
     * @param g 
     */
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
        g.drawString("LEVEL " + this.getLevel(), 5, 15);
        g.drawString("Aliens left: " + aliens.size(), 5, 30);
        g.drawString("Hitpoints left: " + craft.getHitpoints(), 5, 45);
        g.drawString("Player score: " + player.getScore(), 5, 60);
        g.drawString("Current weapon: " + craft.getWeapon(), 300, 15);
        g.drawString("X: " + craft.getX(), 300, 30);
        g.drawString("Y: " + craft.getY(), 300, 45);
        g.drawString("High Score: " + highscore.getHighscore(), 600, 15);
    }
    
    /**
     * Redraws board as game over screen.
     * @param g 
     */
    private void drawGameOver(Graphics g) {
        String msg = "GAME OVER";
        Font small = new Font("Helvetica", Font.BOLD, 28);
        FontMetrics fm = getFontMetrics(small);
        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(msg, (BOARDWIDTH - fm.stringWidth(msg)) / 2,
                BOARDHEIGHT / 2);
    }
    
    /**
     * Redraws board as pause screen.
     * @param g 
     */
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
        try {
            checkCollisions();
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }
    
    /**
     * Stops thread timer if in game condition is false.
     */
    private void inGame() {      
        if (!ingame) timer.stop();
    }

    /**
     * Updates position of player craft.
     */
    private void updateCraft() {
        if (craft.isVisible()) craft.move();
    }
    
    /**
     * Updates position and visibility of missiles.
     */
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
    
    /**
     * Updates position of aliens. If no aliens exist on board, sets ingame flag
     * to false which ends the game.
     */
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
    
    /**
     * Checks collisions of all graphic objects on board.
     * @throws IOException 
     */
    public void checkCollisions() throws IOException {
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
                    setNewHighscore();
                    ingame = false;
                }
            }
        }

        for (Missile m : ms) {
            Rectangle r1 = m.getBounds();
            for (Alien alien : aliens) {
                Rectangle r2 = alien.getBounds();
                if (r1.intersects(r2)) {
                    alien.hit(10); //TODO NullPointerException fail
                                   //when attempting m.getDamage()
                    m.setVisible(false);
                    
                    if (alien.isDead()) {
                        alien.setVisible(false);
                        player.increaseScore(10);
                        if(player.getScore() > highscore.getHighscore()) {
                            highscore.setHighscore(player.getScore());
                        }
                    }
                    
                }
            }
        }
    }
    
    /**
     * Pauses game with player input.
     */
    private void pause() { }

    /**
     * Compulsory keyadapter reimplementation.
     */
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
