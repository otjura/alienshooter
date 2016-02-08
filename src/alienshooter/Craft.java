package alienshooter;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Craft extends Sprite {
    private int dx;
    private int dy;
    protected int hitpoints;
    private final int SPEED = 2;
    private ArrayList<Missile> missiles;

    public Craft(int x, int y) {
        super(x, y);
        hitpoints = 100;
        missiles = new ArrayList<>();
        loadImage("images/craft.png");
        getImageDimensions();
    }

    public void move() {
        x += dx;
        y += dy;
        if (x < 1) { x = 1; }
        if (y < 1) { y = 1; }
    }

    public ArrayList getMissiles() { return missiles; }
    public int getHitpoints() { return hitpoints; }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_Z) { fire(); }
        if (key == KeyEvent.VK_LEFT) { dx = -SPEED; }
        if (key == KeyEvent.VK_RIGHT) { dx = SPEED; }
        if (key == KeyEvent.VK_UP) { dy = -SPEED; }
        if (key == KeyEvent.VK_DOWN) { dy = SPEED; }
        if (key == KeyEvent.VK_ENTER) { pause(); }
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) { dx = 0; }
        if (key == KeyEvent.VK_RIGHT) { dx = 0; }
        if (key == KeyEvent.VK_UP) { dy = 0; }
        if (key == KeyEvent.VK_DOWN) { dy = 0; }
    }

    public void fire() {
        //do {
        missiles.add(new Missile(x + width, y + height / 2));
        //Thread.sleep(200);
        //} while(true);
    } 
    
    protected void pause() { 
        
    }
}
